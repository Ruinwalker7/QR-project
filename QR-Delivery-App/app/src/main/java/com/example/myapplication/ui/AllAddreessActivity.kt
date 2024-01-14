package com.example.myapplication.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.entity.Address
import com.example.myapplication.service.AddressService
import com.example.myapplication.utils.UserManager

class AllAddreessActivity : AppCompatActivity() {

    private var linearLayout: LinearLayout? = null
    private val layoutParams1 = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        400
    )
    private val layoutParams2 = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        100
    )
    private val layoutParams3 = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        200
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar!!.hide()
        setContentView(R.layout.address_activity)
        linearLayout = findViewById(R.id.deliveryLayout)

        val button = findViewById<Button>(R.id.create_address)
        button.setOnClickListener {
            val intent = Intent(this, AddressActivity::class.java)
            startActivity(intent)
        }
        AddressService.getAddress(UserManager.getInstance(this)?.id) { list, _ ->
            this.runOnUiThread{
                run {
                    addAddress(list)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        AddressService.getAddress(UserManager.getInstance(this)?.id) { list, _ ->
            this.runOnUiThread {
                run {
                    addAddress(list)
                }
            }
        }
    }

    // 动态添加快递信息到主页
    private fun addAddress(list: List<Address>?) {
        linearLayout?.removeAllViews()
        if (list != null) {
            for (item in list) {
                println(item)
                // 创建新的 TextView
                val textView = TextView(this)
                val s: String =
                    "\t\t\t" + item.name + "\t\t\t\t" + item.phone + "\n\n\t" + item.address
                textView.text = s
                textView.setLineSpacing(1F, 1F)
                // 设置文本颜色
                textView.setTextColor(Color.WHITE)

                // 创建一个自定义的背景
                val gradientDrawable = GradientDrawable()
                gradientDrawable.shape = GradientDrawable.RECTANGLE
                gradientDrawable.cornerRadius = 20f // 圆角半径
                gradientDrawable.setColor(Color.rgb(230, 230, 250)) // 背景颜色
                gradientDrawable.setStroke(4, Color.rgb(230, 230, 250)) // 边框宽度和颜色

                // 设置背景
                textView.background = gradientDrawable
                textView.gravity = Gravity.CENTER_VERTICAL
                textView.textSize = 20.0F
                textView.tag = item.id
                textView.setTextColor(Color.BLACK)

                val view = View(this)
                // 添加 TextView 到 LinearLayout

                linearLayout?.addView(textView, layoutParams1)
                linearLayout?.addView(view, layoutParams2)
            }
        } else {
            val textView = TextView(this)
            val s = "没有地址"
            textView.text = s

            // 设置文本颜色
            textView.setTextColor(Color.WHITE)

            // 创建一个自定义的背景
            val gradientDrawable = GradientDrawable()
            gradientDrawable.shape = GradientDrawable.RECTANGLE
            gradientDrawable.cornerRadius = 20f // 圆角半径
            gradientDrawable.setColor(Color.BLUE) // 背景颜色
            gradientDrawable.setStroke(4, Color.WHITE) // 边框宽度和颜色

            // 设置背景
            textView.background = gradientDrawable
            textView.gravity = Gravity.CENTER
            textView.textSize = 20.0F
            // 设置布局参数
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                200
            )

            val view: View = View(this)
            val layoutParams1 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                120
            )
            // 添加 TextView 到 LinearLayout
            linearLayout?.addView(textView, layoutParams)
            linearLayout?.addView(view, layoutParams1)
        }
    }
}