package com.example.easyjetpack

import android.app.Application
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.work.Configuration
import androidx.work.DelegatingWorkerFactory
import com.example.easyjetpack.workmanager.MyWorkerFactory

class MyApplication : Application(), Configuration.Provider {
    companion object {
        const val TAG = "MyApplication"
    }

    override fun onCreate() {
        super.onCreate()
        //注册App生命周期观察者
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycleObserver())
    }

    class ApplicationLifecycleObserver : LifecycleEventObserver {
        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            Log.w(TAG, "ApplicationLifecycleObserver: $event")
        }
    }

    override fun getWorkManagerConfiguration(): Configuration {
        val factory = DelegatingWorkerFactory()
        factory.addFactory(MyWorkerFactory())
        return Configuration.Builder()
//            .setWorkerFactory(MyWorkerFactory())
            // 变化在这里
            .setWorkerFactory(factory)
            .setMinimumLoggingLevel(Log.INFO)
            .build()
    }
}
