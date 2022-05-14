package com.example.easyjetpack.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

/**
 * Created by zhaoxiaowen on 2022/5/9
 */
class DownloadWorker (appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    override fun doWork(): Result {
        // 数据结构发生了变化。
        val url = inputData.getString("zxw")
        Log.i("DownloadWorker", "Thread = ${Thread.currentThread().name}")
        url?.let {
            Log.i("zxw", "DownloadWorker url $it")
            Thread.sleep(3 * 1000L)
            Log.i("zxw", "DownloadWorker")
            return Result.success(workDataOf("zxw" to "download success"))
        }
        return Result.failure()
    }
}