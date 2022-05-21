package com.example.easyjetpack.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.easyjetpack.livedata.backflow.BusMutableLiveData
import com.example.easyjetpack.livedata.backflow.LiveEvent
import com.example.easyjetpack.livedata.backflow.SingleLiveEvent
import com.example.easyjetpack.livedata.backflow.UnFlowLiveData

class LiveDataVModel () : ViewModel(){
    val lvData = MutableLiveData<Int>()
    val unFlowLiveData =
        UnFlowLiveData<Int>()
    val singleEvent =
        SingleLiveEvent<Int>()
    val liveEvent = LiveEvent<Int>()
    val busevent =
        BusMutableLiveData<Int>()
}