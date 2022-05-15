package com.example.easyjetpack.workmanager


import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * Created by zhaoxiaowen on 2022/5/9
 */
class WorkerC ( appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams){
    override fun doWork(): Result {
        Log.i("zxw", "WorkerC = ${Thread.currentThread().name}")
        return Result.success()
    }
}