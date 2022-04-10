package com.example.easyjetpack

import android.app.Activity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class MyLifecycleOwnerActivity : Activity(), LifecycleOwner {

    private lateinit var mLifecycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main01)
        mLifecycleRegistry = LifecycleRegistry(this)
        lifecycle.addObserver(MyObserver())
        mLifecycleRegistry.currentState = Lifecycle.State.CREATED
        // markstate 废弃， 使用setCurrentState替代
        // mLifecycleRegistry.markState(Lifecycle.State.STARTED)
    }

    override fun onStart() {
        super.onStart()
        mLifecycleRegistry.currentState = Lifecycle.State.STARTED
    }

    override fun onPause() {
        super.onPause()
        mLifecycleRegistry.currentState = Lifecycle.State.STARTED
    }

    override fun onDestroy() {
        super.onDestroy()
        mLifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }

    override fun getLifecycle(): Lifecycle {
        return mLifecycleRegistry
    }
}
