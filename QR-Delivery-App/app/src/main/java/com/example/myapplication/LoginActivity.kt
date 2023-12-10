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
import com.example.myapplication.utils.Login
import com.example.myapplication.utils.HTTPCallback
import com.example.myapplication.utils.UserManager

class LoginActivity : AppCompatActivity() {
    var imageView: ImageView? = null
    var textView: TextView? = null
    var count = 0
    private lateinit var phont_et:EditText
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

        phont_et = findViewById(R.id.phone_et)
        phont_et?.hint = "电话"
        phont_et?.setOnFocusChangeListener{ view, hasFocus ->
            if(hasFocus){
                phont_et?.hint=""
            }
            else{
                phont_et?.hint="电话"
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
            val phone: String = phont_et.getText().toString()
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
        // 假设LoginManager是包含login函数的类
        val loginManager = Login()
        loginManager.login(username, password, object : HTTPCallback {
            override fun onSuccess() {
                runOnUiThread {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    UserManager.getInstance(this@LoginActivity)?.saveUserCredentials(username,username,password)
                    startActivity(intent)
                    finish()
                }
            }

            override fun onFailure(errorMessage: String?) {
                runOnUiThread {
                    Toast.makeText(this@LoginActivity, errorMessage, Toast.LENGTH_SHORT).show()
                    password_et.setText("")
                }
            }
        })
    }
}