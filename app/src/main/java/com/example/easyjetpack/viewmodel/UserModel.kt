package com.example.easyjetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserModel : ViewModel() {
    val mUserLiveData: MutableLiveData<User> = MutableLiveData()

    init {
        // 初始化
        mUserLiveData.postValue(User(1, "name1"))
    }

    fun doSomething() {
        val user = mUserLiveData.value
        if (user != null) {
            user.age = 15
            user.name = "name15"
            mUserLiveData.value = user
        }
    }
}