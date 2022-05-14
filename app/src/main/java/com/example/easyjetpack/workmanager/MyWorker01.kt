package com.example.easyjetpack.workmanager


import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * Created by zhaoxiaowen on 2022/5/9
 */
class MyWorker01 (private val name:String, appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams){
    override fun doWork(): Result {
        Log.i("zxw", "MyWorker01 = $name")
        return Result.success()
    }
}