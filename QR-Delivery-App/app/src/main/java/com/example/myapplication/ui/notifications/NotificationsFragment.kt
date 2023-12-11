package com.example.myapplication.ui.notifications

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.contentValuesOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.LoginActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.databinding.FragmentNotificationsBinding
import com.example.myapplication.utils.UserManager

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null


    private val binding get() = _binding!!

    lateinit var exit_button: Button
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

//        val textView: TextView = binding.textNotifications
//        notificationsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        val textView1: TextView = binding.ntfAddress
        textView1.text = UserManager.getInstance(context)?.address


        val textView2: TextView = binding.ntfName

        textView2.text = UserManager.getInstance(context)?.username


        val textView3: TextView = binding.ntfPhone
        textView3.text = UserManager.getInstance(context)?.phoneNumber




        exit_button = binding.exitBtn;
        exit_button.setOnClickListener{
            val alertDialogBuilder = AlertDialog.Builder(requireContext())

            // 设置对话框标题
            alertDialogBuilder.setTitle("确认操作")

            // 设置对话框消息
            alertDialogBuilder.setMessage("确定要退出登录吗？")

            // 设置确认按钮及其点击事件
            alertDialogBuilder.setPositiveButton("确认") { dialog, which ->
                UserManager.getInstance(context)?.clearSharedPreferences(context);
                val intent = Intent(context, LoginActivity::class.java)
                startActivity(intent)

                activity?.finish()
            }

            // 设置取消按钮及其点击事件
            alertDialogBuilder.setNegativeButton("取消") { dialog, which ->
                // 在这里执行取消操作
            }

            // 创建并显示对话框
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()


        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}