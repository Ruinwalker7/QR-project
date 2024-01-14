package com.example.myapplication

import android.annotation.SuppressLint
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


class SignupActivity : AppCompatActivity() {
    private var imageView: ImageView? = null
    private var textView: TextView? = null
    private var phoneEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var idEditText: EditText? = null
    private var usernameEditText: EditText? = null

    // 定义手机号的正则表达式
    private val phoneRegex = Regex("^1[3-9]\\d{9}$")

    // 定义密码要求
    private val psdRegex = Regex("^(?=.*[A-Za-z])(?=.*\\d).{6,}$")

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

        findViewById<TextView>(R.id.rtlogin).setOnClickListener {
            super.onBackPressed()
        }

        phoneEditText = findViewById(R.id.phone_register)
        passwordEditText = findViewById(R.id.psd_register)
        idEditText = findViewById(R.id.idCard_register)
        usernameEditText = findViewById(R.id.name_register)

        val loginButton = findViewById<Button>(R.id.sign_btn)
        loginButton.setOnClickListener {
            val phone: String = phoneEditText?.text.toString()
            val psd: String = passwordEditText?.text.toString()
            val name = usernameEditText?.text.toString()
            val id = idEditText?.text.toString()
            if (phone == "") {
                Toast.makeText(this, "请输入电话", Toast.LENGTH_SHORT).show()
            } else if (psd == "") {
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show()
            } else if (id == "") {
                Toast.makeText(this, "请输入身份证号码", Toast.LENGTH_SHORT).show()
            } else if (name == "") {
                Toast.makeText(this, "请输入名字", Toast.LENGTH_SHORT).show()
            }

            // 打印结果
            if (!phoneRegex.matches(phone)) {
                Toast.makeText(this, "手机号格式不正确", Toast.LENGTH_SHORT).show()
            } else if (!psdRegex.matches(psd)) {
                Toast.makeText(this, "密码需要长于6个字符且至少包含中英文", Toast.LENGTH_SHORT)
                    .show()
            } else
                attemptRegister(name, phone, psd, id)
        }
    }

    private fun attemptRegister(username: String, phone: String, password: String, id: String) {
        Login.register(username, phone, password, id) { msg: String? ->
            runOnUiThread {
                if (!msg.isNullOrEmpty()) {
                    Toast.makeText(this@SignupActivity, msg, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@SignupActivity, "注册成功", Toast.LENGTH_SHORT).show()
                    onBackPressed()
                    finish()
                }
            }
        }
    }
}