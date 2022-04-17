package com.example.easyjetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    private val selected: MutableLiveData<Int> = MutableLiveData(1)
    fun add(){
        selected.value = selected.value?.plus(1)
    }

    fun get(): LiveData<Int> {
        return selected
    }
}
