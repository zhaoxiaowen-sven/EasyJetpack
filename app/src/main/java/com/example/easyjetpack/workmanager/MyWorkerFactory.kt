package com.example.easyjetpack.workmanager

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters

/**
 * Created by zhaoxiaowen on 2022/5/9
 */
class MyWorkerFactory(private val name: String = "MyWorkerFactory-") : WorkerFactory() {
    @SuppressLint("RestrictedApi")
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        Log.i("zxw", "workerClassName = $workerClassName")

        return when (workerClassName) {
            MyWorker01::class.java.name -> MyWorker01(name, appContext, workerParameters)
            MyWorker02::class.java.name -> MyWorker02(name, appContext, workerParameters)
            else -> {
                null
                // 返回null 让其他factory 进行处理，如果没有任何自定义工厂处理某个类，将使用默认的反射工厂
//                getDefaultWorkerFactory().createWorker(
//                    appContext,
//                    workerClassName,
//                    workerParameters
//                )
            }
        }
    }
}