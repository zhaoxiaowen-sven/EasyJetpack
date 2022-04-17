package com.example.easyjetpack.viewmodel

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.easyjetpack.R

class ViewModelActivity : FragmentActivity() {
    private lateinit var bt02 : Button
    private lateinit var bt03 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)
        bt02 = findViewById(R.id.bt02)
        bt03 = findViewById(R.id.bt03)
        // viewModel
        val userModel: UserModel = ViewModelProvider(this)[UserModel::class.java]
        userModel.mUserLiveData.observe(this){
            bt02.text = it.toString()
        }

        bt02.setOnClickListener{
            userModel.doSomething()
            bt03.text = User(99, "zxw").toString()
        }
    }
}