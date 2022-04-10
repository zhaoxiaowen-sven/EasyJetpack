package com.example.easyjetpack

import android.util.Log
import androidx.lifecycle.*

class MyObserver: DefaultLifecycleObserver, LifecycleEventObserver {
    companion object{
        const val TAG = "MyObserver"
    }

    override fun onCreate(owner: LifecycleOwner) {
        Log.d(TAG, "onCreate")
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.d(TAG, "onResume")
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d(TAG, "onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d(TAG, "onDestroy")
    }
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.d(TAG, "onStateChanged = $event")
    }
}
