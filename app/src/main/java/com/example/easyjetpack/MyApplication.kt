package com.example.easyjetpack

import android.app.Application
import android.util.Log
import androidx.lifecycle.*

class MyApplication : Application() {
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
}
