package com.example.easyjetpack.workmanager


import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

/**
 * Created by zhaoxiaowen on 2022/5/9
 */
class CheckWorker(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {
    override fun doWork(): Result {
        val url = inputData.getString("zxw")

        url?.let {
            Log.i("zxw", "CheckWorker start url = $it")
            Thread.sleep(2000)
            Log.i("zxw", "CheckWorker end ${Thread.currentThread().name}")
            return Result.success(workDataOf("zxw" to "downloadUrl + ${Thread.currentThread().name}"))
        }
        return Result.success(workDataOf("zxw" to "downloadUrl"))
    }
}