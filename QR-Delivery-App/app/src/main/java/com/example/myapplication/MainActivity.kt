package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.home.HomeFragment
import com.example.myapplication.ui.home.HomeViewModel
import com.example.myapplication.ui.notifications.NotificationsFragment
import com.example.myapplication.utils.UserManager
import com.example.myapplication.utils.getDelivery
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.zxing.integration.android.IntentIntegrator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var doubleBackToExitPressedOnce = false
    private val homeFragment = HomeFragment()
    private val authFragment = NotificationsFragment()
    private val FragmentList = arrayListOf(homeFragment, authFragment)
    private lateinit var viewPager:ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        navView.selectedItemId = R.id.navigation_home

        getDelivery().getDelivery(UserManager.getInstance(this)?.phoneNumber){
                list,msg->
            if(!list.isNullOrEmpty()){
               HomeViewModel().setData(list)
            }else{
                println(msg)
            }
        }

        viewPager=findViewById(R.id.view_pager)
        viewPager.adapter = object : FragmentStateAdapter(this){
            override fun getItemCount() =  FragmentList.size
            override fun createFragment(position: Int)= FragmentList[position]
        }

        // 唤起扫一扫页面
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.QR_scan_capture -> IntentIntegrator(this)
                    .setCaptureActivity(CaptureActivity::class.java)// 自定义Activity
                    .setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)// 扫码的类型,可选：一维码，二维码，一/二维码
                    .setPrompt("请对准需要扫描的二维码")// 设置提示语
                    .setCameraId(0)// 选择摄像头,可使用前置或者后置
                    .setBeepEnabled(true)// 是否开启声音,扫完码之后会"哔"的一声
                    .initiateScan();// 初始化扫码
                R.id.navigation_home -> viewPager.setCurrentItem(0, true)
                R.id.navigation_notifications -> viewPager.setCurrentItem(1, true)
            }
            true
        }


        viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                navView.selectedItemId = getMenuItemId(position)
            }
        })


    }

    private fun getMenuItemId(position: Int): Int {
        // 根据页面索引返回对应的 BottomNavigationView 的 MenuItem ID
        return when (position) {
            0 -> R.id.navigation_home
            1 -> R.id.navigation_notifications
            else -> 0
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce ) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show()
        Handler(Looper.getMainLooper()).postDelayed({ doubleBackToExitPressedOnce = false }, 2000) // 2秒内再次按返回键生效
    }

    // 处理扫描二维码的回调函数
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}