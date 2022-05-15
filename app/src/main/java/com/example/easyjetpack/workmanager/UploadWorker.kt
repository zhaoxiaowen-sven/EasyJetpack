package com.example.easyjetpack.workmanager

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.work.*
import com.example.easyjetpack.R
import java.util.logging.LogRecord

/**
 * Created by zhaoxiaowen on 2022/5/9
 */

class UploadWorker(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {
    companion object {
        const val TAG = "UploadWorker"
    }

    override fun doWork(): Result {
        Log.i(TAG, "Thread = ${Thread.currentThread().name}")
        setProgressAsync(workDataOf("progress" to 0))
        if (isStopped) {
            Log.i(TAG, "work stopped")
            return Result.failure(workDataOf("success" to "false"))
        }
        Thread.sleep(100)
        setProgressAsync(workDataOf("progress" to 10))

        // Do the work here--in this case, upload the images.
        uploadImages()
        setProgressAsync(workDataOf("progress" to 100))
        // Indicate whether the work finished successfully with the Result
        return Result.success(workDataOf("success" to "true"))
    }

    private fun uploadImages() {
        Log.i(TAG, "uploadImages start")
        Thread.sleep(2 * 1000L)
        Log.i(TAG, "uploadImages end")
    }

    override fun onStopped() {
        // release resource
        Log.i(TAG, "onStopped ...")
    }
}