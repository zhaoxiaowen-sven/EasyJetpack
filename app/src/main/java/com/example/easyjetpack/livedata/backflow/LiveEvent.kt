package com.example.easyjetpack.livedata.backflow

import android.util.ArraySet
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

/**
 * Created by zhaoxiaowen on 2022/5/18
 */
open class LiveEvent<T> : MediatorLiveData<T>() {
    // 持有多个中间观察者
    private val observers = ArraySet<ObserverWrapper<in T>>()

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        observers.find { it.observer === observer }?.let { _ ->
            return
        }
        // 构建中间观察者
        val wrapper = ObserverWrapper(observer)
        observers.add(wrapper)
        super.observe(owner, wrapper)
    }

    @MainThread
    override fun observeForever(observer: Observer<in T>) {
        observers.find { it.observer === observer }?.let { _ ->
            return
        }
        val wrapper = ObserverWrapper(observer)
        observers.add(wrapper)
        super.observeForever(wrapper)
    }

    @MainThread
    override fun removeObserver(observer: Observer<in T>) {
        if (observer is ObserverWrapper && observers.remove(observer)) {
            super.removeObserver(observer)
            return
        }
        val iterator = observers.iterator()
        while (iterator.hasNext()) {
            val wrapper = iterator.next()
            if (wrapper.observer == observer) {
                iterator.remove()
                super.removeObserver(wrapper)
                break
            }
        }
    }

    @MainThread
    override fun setValue(t: T?) {
        // 通知所有中间观察者，有新数据
        observers.forEach { it.newValue() }
        super.setValue(t)
    }

    // 中间观察者
    private class ObserverWrapper<T>(val observer: Observer<T>) : Observer<T> {
        // 标记当前观察者是否消费了数据
        private var pending = false

        override fun onChanged(t: T?) {
            // 保证只向下游观察者分发一次数据
            if (pending) {
                pending = false
                observer.onChanged(t)
            }
        }

        fun newValue() {
            pending = true
        }
    }
}