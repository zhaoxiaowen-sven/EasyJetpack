package com.example.easyjetpack.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataVModel () : ViewModel(){
    val lvData = MutableLiveData<Int>()
    val unFlowLiveData = UnFlowLiveData<Int>()
}