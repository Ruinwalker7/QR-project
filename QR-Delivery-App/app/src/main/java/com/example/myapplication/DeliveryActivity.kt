package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.utils.GetDeliverys
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
        val receivedData = getSerializable(this, "detail",  GetDeliverys.DeliveryDetail::class.java)

        println(receivedData)
        textView.setLineSpacing(1F,1.6F)
        textView.gravity = Gravity.CENTER_VERTICAL
        var contentS:String? = "";

        if(!receivedData.status.isNullOrBlank()){
            contentS += "状态："+ receivedData.status +"\n"

        }
        if(!receivedData.id.isNullOrBlank()){
            contentS += "订单号："+ receivedData.id +"\n"
        }
        if(!receivedData.srcName.isNullOrBlank()){
            contentS += "发件人："+ receivedData.srcName +"\n"
            contentS += "发件手机："+ receivedData.srcPhone +"\n"
            contentS += "发件地址："+ receivedData.srcAddress +"\n"
        }
        if(!receivedData.dstName.isNullOrBlank()){
            contentS += "收件人："+ receivedData.dstName +"\n"
            contentS += "收件手机："+ receivedData.dstPhone +"\n"
            contentS += "收件地址："+ receivedData.dstAddress +"\n"
        }
        if (!receivedData.createTime.isNullOrBlank()){
            contentS += "发货时间："+ receivedData.createTime +"\n"
        }
        textView.setText(contentS)

    }


    fun <T : Serializable?> getSerializable(activity: Activity, name: String, clazz: Class<T>): T
    {
        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            activity.intent.getSerializableExtra(name, clazz)!!
        else
            activity.intent.getSerializableExtra(name) as T
    }
}