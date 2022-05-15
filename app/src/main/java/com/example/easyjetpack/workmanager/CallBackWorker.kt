package com.example.easyjetpack.workmanager

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.concurrent.futures.CallbackToFutureAdapter
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import com.google.common.util.concurrent.ListenableFuture
import java.util.concurrent.Executors

/**
 * Created by zhaoxiaowen on 2022/5/9
 */
class CallBackWorker(
    context: Context,
    params: WorkerParameters
) : ListenableWorker(context, params) {
    override fun startWork(): ListenableFuture<Result> {
        Log.i("zxw", "startWork")
        return CallbackToFutureAdapter.getFuture { completer ->
            val callback = object : Callback {
                @Volatile
                var successes = 0
                override fun onFailure() {
                    Log.i("zxw", "onFailure")
                    completer.set(Result.failure())
                }

                override fun onSuccess() {
                    successes++
                    if (successes == 100) {
                        Log.i("zxw", "onSuccess + ${Thread.currentThread().name}")
                        completer.set(Result.success())
                    }
                }
            }

            downloadAsynchronously("https://example.com", callback)
            completer.addCancellationListener({
                Log.i("zxw", "run cancel")
            }, Executors.newSingleThreadExecutor())

            callback
        }
    }

    @SuppressLint("RestrictedApi")
    private fun downloadAsynchronously(s: String, callback: Callback) {
        Thread {
            Log.i("zxw", "backgroundExecutor execute")
            repeat(100) {
                callback.onSuccess()
            }
        }.start()

//        taskExecutor.executeOnBackgroundThread {
////            for (i in  1..10000) {
////                //            Thread.sleep(100)
//            repeat(100) {
//                Log.i("zxw", "downloadAsynchronously + ${Thread.currentThread().name}")
//                Thread.sleep(100)
//                callback.onSuccess()
//            }
//        }
    }
}

interface Callback {
    fun onFailure()

    fun onSuccess()
}