package com.example.easyjetpack.workmanager

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.example.easyjetpack.R
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class WorkManagerActivity : AppCompatActivity() {
    lateinit var workManager: WorkManager

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workmanager)
        workManager = WorkManager.getInstance(this)
        Log.i("zxw", "onCreate")
        findViewById<Button>(R.id.bt01).setOnClickListener {
//            workManager.enqueue(uploadWorkRequest)
            // 约束条件
            val constraints: Constraints = Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.UNMETERED)
                .setRequiresBatteryNotLow(true)
                .build()

            val request0: WorkRequest =
                OneTimeWorkRequestBuilder<UploadWorker>()
                    // 失败重试策略
                    .setBackoffCriteria(BackoffPolicy.LINEAR, 15, TimeUnit.MINUTES)
                    // 加急工作
                    .setExpedited(OutOfQuotaPolicy.DROP_WORK_REQUEST)
                    // 延迟启动
                    .setInitialDelay(3, TimeUnit.SECONDS)
                    .setConstraints(constraints)
                    .addTag("11")
                    .addTag("222")
                    .build()

            workManager.enqueue(request0)
//            val request1 = OneTimeWorkRequestBuilder<CheckWorker>()
//                .setConstraints(constraints)
//                .addTag("update")
//                .setInputData(workDataOf("zxw" to "origin url"))
//                .build()
//
//            val request2 = OneTimeWorkRequest.from(DownloadWorker::class.java)
//
////            workManager.beginWith(request1).then(request2).enqueue()
//            workManager.beginWith(listOf(request1, request2)).enqueue()

//            val request3 = OneTimeWorkRequestBuilder<UploadWorker>()
//                .setBackoffCriteria(BackoffPolicy.LINEAR, 10, TimeUnit.SECONDS)
//                .setInitialDelay(2, TimeUnit.SECONDS)
////                .setInputMerger()
//                .build()
////                .setPeriodStartTime(5, TimeUnit.SECONDS)
//            workManager.enqueue(request3)
            val request3 = PeriodicWorkRequestBuilder<UploadWorker>(4, TimeUnit.HOURS).build()

            val request4 = PeriodicWorkRequestBuilder<UploadWorker>(1, TimeUnit.MINUTES,
                10, TimeUnit.SECONDS)
                .build()
//            workManager.enqueue(request4)
//            val request5 = PeriodicWorkRequestBuilder<UploadWorker>(1, TimeUnit.MINUTES, 10, TimeUnit.SECONDS).build()
//            workManager.enqueueUniquePeriodicWork("upload",  ExistingPeriodicWorkPolicy.KEEP, request5)
            val request6 = OneTimeWorkRequestBuilder<CallBackWorker>()
                .addTag("callbacktest")
                .build()
            workManager.enqueue(request6)

//            val request7 = OneTimeWorkRequestBuilder<CheckWorker>().build()
//            val request8 = OneTimeWorkRequestBuilder<UploadWorker>().build()
//            val request9 = OneTimeWorkRequestBuilder<DownloadWorker>().setInputMerger(ArrayCreatingInputMerger::class.java).build()
//            workManager.beginWith(listOf(request7, request8)).then(request9).enqueue()
//            val request10 = OneTimeWorkRequestBuilder<CheckWorker>()

            val request11 = OneTimeWorkRequestBuilder<MyWorker01>().build()
            workManager.enqueue(request11)
        }
        workManager.getWorkInfosByTag("zxw").addListener(Runnable {

        }, Executors.newSingleThreadExecutor())
    }
}