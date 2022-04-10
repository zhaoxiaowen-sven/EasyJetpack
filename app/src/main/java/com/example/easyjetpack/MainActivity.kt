package com.example.easyjetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(),  {

    private lateinit var bt : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 1、继承自DefaultLifecycleObserver 方式监听
        lifecycle.addObserver(MyObserver())
        // 2、使用注解方式监听
        // lifecycle.addObserver(MyAptObserver())

        bt = findViewById<Button>(R.id.bt01)
        bt.setOnClickListener {
            val intent = Intent(MainActivity@this, MyLifecycleOwnerActivity::class.java);
            startActivity(intent)
        }
    }



}