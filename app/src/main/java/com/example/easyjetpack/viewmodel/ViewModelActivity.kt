package com.example.easyjetpack.viewmodel

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.easyjetpack.R

class ViewModelActivity : FragmentActivity() {
    companion object {
        const val TAG = "ViewModelActivity01"
    }

    private lateinit var bt02: Button
    private lateinit var bt03: Button

    //创建myViewModelA
    private val myViewModelA by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MyViewModel(1) as T
            }
        }).get(
            MyViewModel::class.java
        ).apply {
            nameLiveData.observe(this@ViewModelActivity, {
            })
        }
    }

    //创建myViewModelB
    private val myViewModelB by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MyViewModel(2) as T
            }
        }).get(
            MyViewModel::class.java
        ).apply {
            nameLiveData.observe(this@ViewModelActivity, {
            })
        }
    }

    private val myViewModelC by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MyViewModel(3) as T
            }
        }).get("keyA", MyViewModel::class.java)
            .apply {
            nameLiveData.observe(this@ViewModelActivity, {
            })
        }
    }

    private val myViewModelD by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MyViewModel(4) as T
            }
        }).get("keyB", MyViewModel::class.java)
            .apply {
                nameLiveData.observe(this@ViewModelActivity, {
                })
            }
    }

    private val aViewModel by lazy {
        ViewModelProvider(this).get(
            "myKey", AViewModel::class.java
        )
    }

    private val bViewModel by lazy {
        ViewModelProvider(this).get(
            "myKey", BViewMode::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)
        bt02 = findViewById(R.id.bt02)
        bt03 = findViewById(R.id.bt03)
        // viewModel
        val userModel: UserModel = ViewModelProvider(this)[UserModel::class.java]
        userModel.mUserLiveData.observe(this) {
            bt02.text = it.toString()
        }

        bt02.setOnClickListener {
            userModel.doSomething()
            bt03.text = User(99, "zxw").toString()
        }

        Log.i(TAG, myViewModelA.toString() + " age: " + myViewModelA.age)
        Log.i(TAG, myViewModelB.toString() + " age: " + myViewModelB.age)
        Log.i(TAG, myViewModelC.toString() + " age: " + myViewModelC.age)
        Log.i(TAG, myViewModelD.toString() + " age: " + myViewModelD.age)

        Log.i(TAG, aViewModel.toString())
        Log.i(TAG, bViewModel.toString())
    }

    class AViewModel : ViewModel() {
        override fun onCleared() {
            super.onCleared()
            Log.i(TAG, "AViewModel onCleared")
        }
    }

    class BViewMode : ViewModel() {
        override fun onCleared() {
            super.onCleared()
            Log.i(TAG, "BViewMode onCleared ")
        }
    }


}