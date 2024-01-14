package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.content.Intent
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
import com.example.myapplication.utils.UserManager

class LoginActivity : AppCompatActivity() {
    var textView: TextView? = null
    private lateinit var phone_et:EditText
    private lateinit var password_et:EditText

    @SuppressLint("ClickableViewAccessibility", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar!!.hide()

        setContentView(R.layout.login_main)
        textView = findViewById(R.id.textView)


        phone_et = findViewById(R.id.phone_et)
        phone_et.hint = "电话"
        phone_et.setOnFocusChangeListener{ _, hasFocus ->
            if(hasFocus){
                phone_et.hint=""
            }
            else{
                phone_et.hint="电话"
            }
        }

        password_et = findViewById(R.id.pwd_et)
        password_et.hint = "密码"
        password_et.setOnFocusChangeListener{ _, hasFocus ->
            if(hasFocus){
                password_et.hint=""
            }
            else{
                password_et.hint="密码"
            }
        }

        val savedPhone = UserManager.getInstance(this)?.phoneNumber
        val savedPassword = UserManager.getInstance(this)?.password

        if(!savedPhone.isNullOrBlank() && !savedPassword.isNullOrBlank()) {
            attemptLogin(savedPhone,savedPassword)
        }

        val loginButton = findViewById<Button>(R.id.login_btn)
        loginButton.setOnClickListener{
            val phone: String = phone_et.text.toString()
            val psd: String = password_et.text.toString()
            if(phone == ""){
                Toast.makeText(this, "请输入电话", Toast.LENGTH_SHORT).show()
            }else if (psd==""){
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show()
            }
            else
                attemptLogin(phone, psd)
        }

        findViewById<Button>(R.id.signup_btn).setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }


    private fun attemptLogin(username: String, password: String) {
        LoginService.login(username, password){
            deliveryman, msg ->
                runOnUiThread{
                    if (deliveryman != null){
                        println("登录成功：$deliveryman")
                        UserManager.getInstance(this@LoginActivity)?.saveUserCredentials(deliveryman.id,deliveryman.username,deliveryman.password,deliveryman.phone,deliveryman.workAddress)
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.putExtra("status", 0);
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this@LoginActivity, msg, Toast.LENGTH_SHORT).show()
                        password_et.setText("")
                    }
                }
        }
    }
}