package com.example.myapplication.ui

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.service.DeliveryService
import java.io.Serializable

class DeliveryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar!!.hide()
        setContentView(R.layout.activity_delivery)
        val textView = findViewById<TextView>(R.id.deliveryDetail)
        val receivedData = getSerializable(this,  DeliveryService.DeliveryDetail::class.java)
        textView.setLineSpacing(1F,1.6F)
        textView.gravity = Gravity.CENTER_VERTICAL
        var contentS:String? = "";

        if(receivedData.status.isNotBlank()){
            contentS += "状态："+ receivedData.status +"\n"

        }
        if(receivedData.id.isNotBlank()){
            contentS += "订单号："+ receivedData.id +"\n"
        }
        if(receivedData.srcName.isNotBlank()){
            contentS += "发件人："+ receivedData.srcName +"\n"
            contentS += "发件人手机："+ receivedData.srcPhone +"\n"
            contentS += "发件人地址："+ receivedData.srcAddress +"\n"
        }
        if(receivedData.dstName.isNotBlank()){
            contentS += "收件人："+ receivedData.dstName +"\n"
            contentS += "收件人手机："+ receivedData.dstPhone +"\n"
            contentS += "收件人地址："+ receivedData.dstAddress +"\n"
        }
        if (receivedData.createTime.isNotBlank()){
            contentS += "发货时间："+ receivedData.createTime +"\n"
        }
        if (receivedData.type.isNotBlank()){
            contentS += "快递类型："+ receivedData.type +"\n"
        }
        textView.setText(contentS)
    }

    private fun <T : Serializable?> getSerializable(activity: Activity,clazz: Class<T>): T
    {
        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            activity.intent.getSerializableExtra("detail", clazz)!!
        else
            activity.intent.getSerializableExtra("detail") as T
    }
}