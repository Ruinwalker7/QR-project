package com.example.myapplication.ui.home

import androidx.lifecycle.ViewModel
import com.example.myapplication.service.DeliveryService

class HomeViewModel : ViewModel() {

    private var myDelivery: List<DeliveryService.Delivery>? = null

    var sendDelivery: List<DeliveryService.Delivery>? = null

    var receiveDelivery: List<DeliveryService.Delivery>? = null

    // 提供公共方法以获取数据
    fun getData(): List<DeliveryService.Delivery>? {
        return myDelivery
    }

    // 提供公共方法以设置数据
    fun setData(newData: List<DeliveryService.Delivery>) {
        myDelivery = newData
    }
}