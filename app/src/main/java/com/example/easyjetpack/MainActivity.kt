package com.example.easyjetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.easyjetpack.livedata.LiveDataActivity
import com.example.easyjetpack.viewmodel.User
import com.example.easyjetpack.viewmodel.UserModel
import com.example.easyjetpack.viewmodel.ViewModelActivity

class MainActivity : AppCompatActivity(){

    private lateinit var bt01 : Button
    private lateinit var toViewModel : Button
    private lateinit var toLiveData : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 1、继承自DefaultLifecycleObserver 方式监听
        lifecycle.addObserver(MyObserver())
        // 2、使用注解方式监听
        // lifecycle.addObserver(MyAptObserver())

        bt01 = findViewById<Button>(R.id.bt01)
        toViewModel = findViewById<Button>(R.id.bt02)
        bt01.setOnClickListener {
            val intent = Intent(MainActivity@this, MyLifecycleOwnerActivity::class.java);
            startActivity(intent)
        }

        toViewModel.setOnClickListener{
            val intent = Intent(MainActivity@this, ViewModelActivity::class.java);
            startActivity(intent)
        }

        toLiveData = findViewById(R.id.bt03)
        toLiveData.setOnClickListener {
            val intent = Intent(MainActivity@this, LiveDataActivity::class.java)
            startActivity(intent)
        }
    }
}