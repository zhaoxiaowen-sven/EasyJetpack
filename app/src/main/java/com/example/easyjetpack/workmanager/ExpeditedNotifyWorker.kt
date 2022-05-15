package com.example.easyjetpack.workmanager

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.work.ForegroundInfo
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.impl.utils.futures.SettableFuture
import com.example.easyjetpack.R
import com.google.common.util.concurrent.ListenableFuture


class ExpeditedNotifyWorker(context: Context, workerParams: WorkerParameters) : Worker(
    context,
    workerParams
) {
    companion object {
        const val TAG = "ExpeditedNotifyWorker"
    }
    override fun doWork(): Result {
        Log.i(TAG, "doWork start")
        setForegroundAsync(ForegroundInfo(1002, createNotification()))
        Thread.sleep(3000)
        Log.i(TAG, "doWork end")
        return Result.success()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotification(): Notification {
        var channelId: String? = null
        // 8.0 以上需要特殊处理
        // 8.0 以上需要特殊处理
        channelId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel("ExpeditedWorker", "ExpeditedWorker01")
        } else {
            ""
        }

        return Notification.Builder(applicationContext, channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("ExpeditedWorker")
            .setContentText("ExpeditedWorker content")
            .build()
    }

    // 创建通知通道
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(channelId: String, channelName: String): String? {
        val channel = NotificationChannel(
            channelId,
            channelName, NotificationManager.IMPORTANCE_NONE
        )
        channel.lightColor = Color.BLUE
        channel.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val service =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        service!!.createNotificationChannel(channel)
        return channelId
    }
}