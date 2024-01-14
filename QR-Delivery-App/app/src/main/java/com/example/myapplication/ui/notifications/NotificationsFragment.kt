package com.example.myapplication.ui.notifications

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.ui.AllAddreessActivity
import com.example.myapplication.SelectActivity
import com.example.myapplication.databinding.FragmentNotificationsBinding
import com.example.myapplication.utils.UserManager

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    private val binding get() = _binding!!

    var status: Int? = null

    private var exit_button: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val context: Context = requireContext()

        // 设置用户名电话地址
        val textView1: TextView = binding.ntfAddress
        textView1.text = UserManager.getInstance(context)?.address

        if (status == 1) {
            val layout1 = binding.addressLayout
            layout1.removeAllViews()
            val layoutParams3 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                200
            )
            // 设置布局参数
            var button = Button(context)
            button.text = "我的地址薄"
            button.textSize = 20f
            // 创建一个自定义的背景
            val gradientDrawable = GradientDrawable()
            gradientDrawable.shape = GradientDrawable.RECTANGLE
            gradientDrawable.cornerRadius = 20f // 圆角半径
            gradientDrawable.setColor(Color.rgb(171, 229, 245)) // 背景颜色
            gradientDrawable.setStroke(4, Color.rgb(230, 230, 250)) // 边框宽度和颜色
            button.background = gradientDrawable
            button.setOnClickListener {
                val intent = Intent(context, AllAddreessActivity::class.java)
                startActivity(intent)
            }
            layout1.addView(button, layoutParams3)
        }

        val textView2: TextView = binding.ntfName

        textView2.text = UserManager.getInstance(context)?.username


        val textView3: TextView = binding.ntfPhone
        textView3.text = UserManager.getInstance(context)?.phoneNumber

        exit_button = binding.exitBtn;
        exit_button?.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(requireContext())

            // 设置对话框标题
            alertDialogBuilder.setTitle("确认操作")

            // 设置对话框消息
            alertDialogBuilder.setMessage("确定要退出登录吗？")

            // 设置确认按钮及其点击事件
            alertDialogBuilder.setPositiveButton("确认") { dialog, which ->
                UserManager.getInstance(context)?.clearSharedPreferences(context);
                val intent = Intent(context, SelectActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }

            // 创建并显示对话框
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
        return root
    }

    fun setStatus(i: Int) {
        status = i;
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}