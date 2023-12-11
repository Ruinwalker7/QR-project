package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.utils.getDelivery

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private var myDelivery:List<getDelivery.delivery>? = null

    // 提供公共方法以获取数据
    fun getData(): List<getDelivery.delivery>?? {
        return myDelivery
    }

    // 提供公共方法以设置数据
    fun setData(newData: List<getDelivery.delivery>) {
        myDelivery = newData
    }
}