package com.example.myapplication

import android.R.attr.value
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.utils.Login


class LoginActivity : AppCompatActivity() {
    var imageView: ImageView? = null
    var textView: TextView? = null
    var count = 0
    var phont_et:EditText? = null
    var password_et:EditText? =null


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

        var login_bte = findViewById<Button>(R.id.login_btn)
        login_bte.setOnClickListener{
            if(Login().login()){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }


        findViewById<Button>(R.id.signup_btn).setOnClickListener{
            if(Login().login()){
                val intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)
            }
        }
    }
}