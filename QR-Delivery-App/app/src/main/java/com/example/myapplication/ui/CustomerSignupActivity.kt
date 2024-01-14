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
import com.example.myapplication.service.LoginService
class CustomerSignupActivity : AppCompatActivity() {
    private var textView: TextView? = null
    private var phone_et: EditText? = null
    private  var password_et: EditText? = null
    private var id_et: EditText? = null
    private var username_et: EditText? = null
    // 定义手机号的正则表达式
    private val phone_regex = Regex("^1[3-9]\\d{9}$")
    private val psd_regex = Regex("^(?=.*[A-Za-z])(?=.*\\d).{6,}$")

    @SuppressLint("ClickableViewAccessibility", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar!!.hide()

        setContentView(R.layout.customer_signup_main)
        textView = findViewById(R.id.textView)

        findViewById<TextView>(R.id.rtlogin).setOnClickListener{
            super.onBackPressed()
        }

        phone_et = findViewById(R.id.phone_register)
        password_et = findViewById(R.id.psd_register)
        id_et = findViewById(R.id.idCard_register)
        username_et = findViewById(R.id.name_register)

        val login_bte = findViewById<Button>(R.id.sign_btn)
        login_bte.setOnClickListener{
            val phone: String = phone_et?.text.toString()
            val psd: String = password_et?.text.toString()
            val name = username_et?.text.toString()
            println(name)
            if(phone == ""){
                Toast.makeText(this, "请输入电话", Toast.LENGTH_SHORT).show()
            }else if (psd==""){
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show()
            }else if (name==""){
                Toast.makeText(this, "请输入名字", Toast.LENGTH_SHORT).show()
            }
            // 打印结果
            if (!phone_regex.matches(phone)){
                Toast.makeText(this, "手机号格式不正确", Toast.LENGTH_SHORT).show()
                println("手机号格式不正确")
            }
            else if(!psd_regex.matches(psd)){
                Toast.makeText(this, "密码需要长于6个字符且至少包含中英文", android.widget.Toast.LENGTH_SHORT).show()
                println("密码格式不正确")
            }
            else
                attemptRegister(name, phone, psd)
        }
    }

    private fun attemptRegister(username: String, phone:String, password:String) {
        LoginService.register(username, phone, password){
            msg:String? -> runOnUiThread{
                if (!msg.isNullOrEmpty())
                {
                    Toast.makeText(this@CustomerSignupActivity, msg, Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@CustomerSignupActivity, "注册成功", Toast.LENGTH_SHORT).show()
                    onBackPressed()
                    finish()
                }
            }
        }
    }
}