package com.example.myapplication.ui.home

import androidx.lifecycle.ViewModel
import com.example.myapplication.utils.GetDeliverys

class HomeViewModel : ViewModel() {

    private var myDelivery:List<GetDeliverys.Delivery>? = null

    // 提供公共方法以获取数据
    fun getData(): List<GetDeliverys.Delivery>?? {
        return myDelivery
    }

    // 提供公共方法以设置数据
    fun setData(newData: List<GetDeliverys.Delivery>) {
        myDelivery = newData
    }
}