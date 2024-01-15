package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.allen.library.SuperTextView
import com.example.myapplication.R
import com.example.myapplication.entity.Address
import com.example.myapplication.entity.Delivery
import com.example.myapplication.service.DeliveryService
import com.google.gson.Gson


class SendDeliveryActivity  : AppCompatActivity() {

    var supertext1:SuperTextView? = null
    var supertext2:SuperTextView? = null
    var sendAddress:Address? = null
    var receiveAddress:Address? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar!!.hide()

        setContentView(R.layout.send_delivery)

        supertext1  = findViewById(R.id.super1)
        supertext2  = findViewById(R.id.super2)
        supertext1?.setOnSuperTextViewClickListener {

            val intent = Intent(this, SelectAddressActivity::class.java)
            startActivityForResult(intent, 11);

        }
        supertext2?.setOnSuperTextViewClickListener {
            val intent = Intent(this, SelectAddressActivity::class.java)
            startActivityForResult(intent, 12);
        }

        val button = findViewById<Button>(R.id.send_delivery_bottom)
        button.setOnClickListener {
            if (sendAddress != null && receiveAddress != null){
                var delivery = Delivery(null,sendAddress?.id,receiveAddress?.id,"待揽件","12312312",null,null,null )
                DeliveryService.addDelivery(delivery){
                    msg ->
                    if(msg==null){
                        Toast.makeText(this, "发送成功！", Toast.LENGTH_SHORT).show()


                        finish()
                    }else{
                        Toast.makeText(this, "服务器错误！", Toast.LENGTH_SHORT).show()
                    }

                }
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        println("132131")
        if (requestCode == 11 && resultCode == Activity.RESULT_OK) {
            data?.let {
                val result = it.getStringExtra("item")
                sendAddress = Gson().fromJson(result,Address::class.java)
                supertext1?.setCenterTopTextIsBold(true)
                supertext1?.setLeftTopString(sendAddress?.name+" "+sendAddress?.phone)
                supertext1?.setLeftBottomString(sendAddress?.address)
            }
        }else  if (requestCode == 12 && resultCode == Activity.RESULT_OK) {
            data?.let {
                val result = it.getStringExtra("item")
                receiveAddress = Gson().fromJson(result,Address::class.java)
                supertext2?.setCenterTopTextIsBold(true)
                supertext2?.setLeftTopString(receiveAddress?.name+" "+receiveAddress?.phone)
                supertext2?.setLeftBottomString(receiveAddress?.address)
            }
        }
    }


}