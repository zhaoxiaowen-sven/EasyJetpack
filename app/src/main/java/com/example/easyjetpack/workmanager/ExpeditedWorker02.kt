//package com.example.easyjetpack.workmanager
//
//import android.annotation.SuppressLint
//import android.app.Notification
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.content.Context
//import android.graphics.Color
//import android.os.Build
//import android.util.Log
//import androidx.annotation.RequiresApi
//import androidx.work.CoroutineWorker
//import androidx.work.ForegroundInfo
//import androidx.work.Worker
//import androidx.work.WorkerParameters
//import androidx.work.impl.utils.futures.SettableFuture
//import com.example.easyjetpack.R
//import com.google.common.util.concurrent.ListenableFuture
//
//
//class ExpeditedWorker02(appContext: Context, workerParams: WorkerParameters):
//    CoroutineWorker(appContext, workerParams) {
//
//    override suspend fun getForegroundInfo(): ForegroundInfo {
//        val NOTIFICATION_ID = 100
//        return ForegroundInfo(
//            NOTIFICATION_ID, createNotification()
//        )
//    }
//
//
//    override suspend fun doWork(): Result {
////        TODO()
//    }
//
//    private fun createNotification() : Notification {
////        TODO()
//    }
//
//}