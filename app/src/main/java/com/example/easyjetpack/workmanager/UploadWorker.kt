package com.example.easyjetpack.workmanager

import android.content.Context
import android.util.Log
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
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

        // Do the work here--in this case, upload the images.
        uploadImages()


        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }

    private fun uploadImages() {
        Log.i(TAG, "uploadImages start")
        Thread.sleep(3 * 1000L)
        Log.i(TAG, "uploadImages end")
    }
}