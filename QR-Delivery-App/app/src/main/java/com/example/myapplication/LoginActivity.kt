package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.entity.Deliveryman
import com.example.myapplication.utils.Login
import com.example.myapplication.utils.HTTPCallback
import com.example.myapplication.utils.UserManager

class LoginActivity : AppCompatActivity() {
    var imageView: ImageView? = null
    var textView: TextView? = null
    var count = 0
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
        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)

        imageView?.setOnTouchListener(object : OnSwipeTouchListener(applicationContext) {
            override fun onSwipeTop() {}
            override fun onSwipeRight() {
                count = if (count == 0) {
                    imageView?.setImageResource(R.drawable.good_night_img)
                    textView?.setText("Night")
                    1
                } else {
                    imageView?.setImageResource(R.drawable.good_morning_img)
                    textView?.setText("Morning")
                    0
                }
            }

            override fun onSwipeLeft() {
                count = if (count == 0) {
                    imageView?.setImageResource(R.drawable.good_night_img)
                    textView?.setText("Night")
                    1
                } else {
                    imageView?.setImageResource(R.drawable.good_morning_img)
                    textView?.setText("Morning")
                    0
                }
            }

            override fun onSwipeBottom() {}
        })

        phone_et = findViewById(R.id.phone_et)
        phone_et?.hint = "电话"
        phone_et?.setOnFocusChangeListener{ view, hasFocus ->
            if(hasFocus){
                phone_et?.hint=""
            }
            else{
                phone_et?.hint="电话"
            }
        }

        password_et = findViewById(R.id.pwd_et)
        password_et?.hint = "密码"
        password_et?.setOnFocusChangeListener{ view, hasFocus ->
            if(hasFocus){
                password_et?.hint=""
            }
            else{
                password_et?.hint="密码"
            }
        }

        val savedPhone = UserManager.getInstance(this)?.phoneNumber
        val savedPassword = UserManager.getInstance(this)?.password

        if(!savedPhone.isNullOrBlank() && !savedPassword.isNullOrBlank()) {
            attemptLogin(savedPhone,savedPassword)
        }

        var login_bte = findViewById<Button>(R.id.login_btn)
        login_bte.setOnClickListener{
            val phone: String = phone_et.getText().toString()
            val psd: String = password_et.getText().toString()
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
        Login.login(username, password){
            deliveryman, msg ->
                runOnUiThread{
                    if (deliveryman != null){
                        println("登录成功：$deliveryman")
                        UserManager.getInstance(this@LoginActivity)?.saveUserCredentials(deliveryman?.username,deliveryman?.password,deliveryman?.phone,deliveryman?.workAddress)
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
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