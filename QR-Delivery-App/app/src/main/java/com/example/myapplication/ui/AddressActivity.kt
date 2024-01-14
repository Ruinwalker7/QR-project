package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.entity.Address
import com.example.myapplication.service.AddressService
import com.example.myapplication.utils.UserManager

class AddressActivity: AppCompatActivity()  {
    var name_et: TextView? = null
    var phone_et: EditText? = null
    var province_et: EditText? =null
    var city_et: EditText?= null
    var distinct_et: EditText?= null
    var detail_et: EditText?= null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar!!.hide()
        setContentView(R.layout.address_enter_activity)
        val button = findViewById<Button>(R.id.save_address)

        name_et = findViewById(R.id.address_name_et)
        phone_et = findViewById(R.id.address_phone_et)
        province_et = findViewById(R.id.address_province_et)
        city_et = findViewById(R.id.address_city_et)
        distinct_et = findViewById(R.id.address_distinct_et)
        detail_et = findViewById(R.id.address_detail_et)


        button.setOnClickListener {
            val name: String = name_et?.text.toString()
            val phone: String = phone_et?.text.toString()
            val province: String = province_et?.text.toString()
            val city: String = city_et?.text.toString()
            val county: String = distinct_et?.text.toString()
            val detail: String = detail_et?.text.toString()
            println(name)
            if(name == ""){
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show()
            }else if (phone==""){
                Toast.makeText(this, "请输入电话", Toast.LENGTH_SHORT).show()
            }else if (province==""){
                Toast.makeText(this, "请输入省", Toast.LENGTH_SHORT).show()
            }else if (city==""){
                Toast.makeText(this, "请输入市", Toast.LENGTH_SHORT).show()
            }else if (county==""){
                Toast.makeText(this, "请输入县", Toast.LENGTH_SHORT).show()
            }else if (detail==""){
                Toast.makeText(this, "请输入详细地址", Toast.LENGTH_SHORT).show()
            }
            val address: Address = Address(null,name, phone, province, city,county,detail,
                UserManager.getInstance(this)?.id)
            saveAddress(address)
        }
    }
    fun saveAddress(address: Address){
        AddressService.saveAddress(address){
            msg -> runOnUiThread(){
            if (!msg.isNullOrEmpty())
            {
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show()
                onBackPressed()
                finish()
            }
        }
        }
    }
}