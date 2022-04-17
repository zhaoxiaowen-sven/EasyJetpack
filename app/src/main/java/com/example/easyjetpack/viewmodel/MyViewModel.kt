package com.example.easyjetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel(val age: Int) : ViewModel() {
    val nameLiveData = MutableLiveData<String>()
}
