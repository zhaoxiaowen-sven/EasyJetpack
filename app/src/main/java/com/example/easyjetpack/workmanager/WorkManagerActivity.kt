package com.example.easyjetpack.workmanager

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.easyjetpack.R

class WorkManagerActivity : AppCompatActivity() {
    companion object {
        const val TAG = "WorkManagerActivity"
    }

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
//            val constraints: Constraints = Constraints.Builder()
//                .setRequiresCharging(true)
//                .setRequiredNetworkType(NetworkType.UNMETERED)
//                .setRequiresBatteryNotLow(true)
//                .build()
//
//            val request0: WorkRequest =
//                OneTimeWorkRequestBuilder<UploadWorker>()
//                    .addTag("UploadWorker0")
//                    .build()
//            workManager.getWorkInfoByIdLiveData(request0.id).observe(this) {
//                Log.i(TAG, "data = ${it.outputData} + ${it.progress.getInt("progress", 0)}")
//            }
//            workManager.enqueue(request0)
//            Thread.sleep(1000)
//            workManager.cancelWorkById(request0.id)

//            workManager.getWorkInfosByTag("UploadWorker0").let {
//                it.addListener(Runnable {
//                    Log.i("zxw", "listening")
//                }, Executors.newSingleThreadExecutor())
//                Log.d("zxw", " " + it.get()[0].outputData)
//            }

//            val workQuery = WorkQuery.Builder
//                .fromTags(listOf("syncTag"))
//                .addStates(listOf(WorkInfo.State.FAILED, WorkInfo.State.CANCELLED))
//                .addUniqueWorkNames(
//                    listOf("preProcess", "sync")
//                )
//                .build()

//            val expeditedRequest01 = OneTimeWorkRequestBuilder<ExpeditedWorker>()
//                .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
//                .build()
//            workManager.enqueue(expeditedRequest01)

//            val expeditedRequest02 = OneTimeWorkRequestBuilder<ExpeditedNotifyWorker>()
//                .build()
//            workManager.enqueue(expeditedRequest02)

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
//            val request3 = PeriodicWorkRequestBuilder<UploadWorker>(4, TimeUnit.HOURS).build()
//
//            val request4 = PeriodicWorkRequestBuilder<UploadWorker>(1, TimeUnit.MINUTES,
//                10, TimeUnit.SECONDS)
//                .build()
//            workManager.enqueue(request4)
//            val request5 = PeriodicWorkRequestBuilder<UploadWorker>(1, TimeUnit.MINUTES, 10, TimeUnit.SECONDS).build()
//            workManager.enqueueUniquePeriodicWork("upload",  ExistingPeriodicWorkPolicy.KEEP, request5)


//            val requestA = OneTimeWorkRequestBuilder<WorkerA>().build()
//            val requestB = OneTimeWorkRequestBuilder<WorkerB>().build()
//            val requestC = OneTimeWorkRequestBuilder<WorkerC>().build()
//            workManager.beginWith(listOf(requestA, requestB))
//                .then(requestC)
//                .then(requestC)
//                .enqueue()

            // 自定义WorkerManager
            val request11 = OneTimeWorkRequestBuilder<MyWorker01>().build()
            workManager.enqueue(request11)

//            val request12 = OneTimeWorkRequestBuilder<UploadWorker>().build()
//            workManager.enqueue(request12)

//            val request6 = OneTimeWorkRequestBuilder<CallBackWorker>().build()
//            workManager.enqueue(request6)
        }

    }
}