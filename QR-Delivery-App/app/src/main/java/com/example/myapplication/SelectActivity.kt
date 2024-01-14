package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.ui.CustomerLoginActivity
import com.example.myapplication.ui.LoginActivity

class SelectActivity : AppCompatActivity() {
    var customerButton: Button? = null
    var deliveryButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        supportActionBar!!.hide()

        setContentView(R.layout.activity_select)

        // 选择何种身份登录
        customerButton = findViewById(R.id.customerLgoin)
        deliveryButton = findViewById(R.id.deliverymanLogin)
        deliveryButton?.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        customerButton?.setOnClickListener {
            val intent = Intent(this, CustomerLoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}