package com.example.easyjetpack.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.easyjetpack.R

class DetailFragment: Fragment(){
    private var model:SharedViewModel? = null
    private var bt : Button ?= null
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        //获取依附的Activity的ViewModel
        model = activity?.let { ViewModelProvider(it)[SharedViewModel::class.java] }
        model?.get()?.observe(this,{
            //更新UI
            bt?.setText("新的值是 " + it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false);
        bt = view.findViewById(R.id.detailButton)
        bt?.setOnClickListener {
            model?.add()
        }
        return view
    }
}
