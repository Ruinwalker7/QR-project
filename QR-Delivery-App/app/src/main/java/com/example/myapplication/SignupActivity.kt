package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.utils.HTTPCallback
import com.example.myapplication.utils.Login


class SignupActivity : AppCompatActivity() {
    var imageView: ImageView? = null
    var textView: TextView? = null
    var count = 0
    var phont_et:EditText? = null
    var password_et:EditText? =null
    var id_et:EditText ?= null
    var username_et:EditText?= null

    @SuppressLint("ClickableViewAccessibility", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar!!.hide()

        setContentView(R.layout.signup_main)
        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)

        findViewById<TextView>(R.id.rtlogin).setOnClickListener{
            super.onBackPressed()
        }

        phont_et = findViewById(R.id.phone_register)
        password_et = findViewById(R.id.psd_register)
        id_et = findViewById(R.id.idCard_register)
        username_et = findViewById(R.id.name_register)

        var login_bte = findViewById<Button>(R.id.sign_btn)
        login_bte.setOnClickListener{
            val phone: String = phont_et?.getText().toString()
            val psd: String = password_et?.getText().toString()
            val name = username_et?.text.toString()
            val id = id_et?.text.toString()
            if(phone == ""){
                Toast.makeText(this, "请输入电话", Toast.LENGTH_SHORT).show()
            }else if (psd==""){
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show()
            }else if (id==""){
                Toast.makeText(this, "请输入身份证号码", Toast.LENGTH_SHORT).show()
            }else if (name==""){
                Toast.makeText(this, "请输入名字", Toast.LENGTH_SHORT).show()
            }
            else
                attemptRegister(name, phone, psd ,id)
        }
    }

    private fun attemptRegister(username: String, phone:String, password:String ,id:String) {
        // 假设LoginManager是包含login函数的类
        val loginManager = Login()
        loginManager.registe(username, phone, password,id , object : HTTPCallback {
            override fun onSuccess() {
                runOnUiThread {
                    Toast.makeText(this@SignupActivity, "注册成功", Toast.LENGTH_SHORT).show()
                    onBackPressed()
                    finish()
                }
            }

            override fun onFailure(errorMessage: String?) {
                runOnUiThread {
                    Toast.makeText(this@SignupActivity, errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}