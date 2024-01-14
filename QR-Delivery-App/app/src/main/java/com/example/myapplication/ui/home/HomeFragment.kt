package com.example.myapplication.ui.home

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.ui.DeliveryActivity
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.service.DeliveryService
import com.example.myapplication.utils.UserManager


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var linearLayout: LinearLayout? = null;
    private var homeViewModel: HomeViewModel? = null;
    var status: Int? = null
    val layoutParams1 = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        340
    )
    val layoutParams2 = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        100
    )
    val layoutParams3 = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        200
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        linearLayout = binding.deliveryLayout

        if (status == 1) {
            buildCustomer()
        } else {
            buildDeliveryman()
        }
        return root
    }

    private fun buildCustomer() {
        val context: Context = requireContext()
        var list1 = homeViewModel?.sendDelivery
        var list2 = homeViewModel?.receiveDelivery

        DeliveryService.getSendDelivery(UserManager.getInstance(context)?.phoneNumber) { list, msg ->
            homeViewModel?.sendDelivery = list
            list1 = list;
            DeliveryService.getReceiverDelivery(UserManager.getInstance(context)?.phoneNumber) { list, msg ->
                homeViewModel?.receiveDelivery = list
                list2 = list;
                activity?.runOnUiThread(Runnable() {
                    run() {
                        addDelivery(list1, list2)
                    }
                })
            }
        }
        val button = binding.button
        button.setOnClickListener {
            DeliveryService.getSendDelivery(UserManager.getInstance(context)?.phoneNumber) { list1, msg ->
                homeViewModel?.sendDelivery = list1
                DeliveryService.getReceiverDelivery(UserManager.getInstance(context)?.phoneNumber) { list2, msg ->
                    homeViewModel?.receiveDelivery = list2
                    activity?.runOnUiThread(Runnable() {
                        Toast.makeText(context, "刷新成功！", Toast.LENGTH_LONG).show()
                        run() {
                            addDelivery(list1, list2)
                        }
                    })
                }
            }
        }
    }

    private fun buildDeliveryman() {
        val context: Context = requireContext()
        val list = homeViewModel?.getData()
        if (list.isNullOrEmpty()) {
            DeliveryService.getDelivery(UserManager.getInstance(context)?.phoneNumber) { list, msg ->
                if (!list.isNullOrEmpty()) {
                    homeViewModel?.setData(list)
                    activity?.runOnUiThread(Runnable() {
                        run() {
                            addDelivery(list)
                        }
                    })
                }
            }
        } else {
            addDelivery(list)
        }
        val button = binding.button
        button.setOnClickListener {
            DeliveryService.getDelivery(UserManager.getInstance(context)?.phoneNumber) { list, msg ->
                if (!list.isNullOrEmpty()) {
                    homeViewModel?.setData(list)
                    activity?.runOnUiThread(Runnable() {
                        Toast.makeText(context, "刷新成功！", Toast.LENGTH_LONG).show()
                        run() {
                            addDelivery(list)
                        }
                    })
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    // 动态添加快递信息到主页
    private fun addDelivery(list: List<DeliveryService.Delivery>?) {
        linearLayout?.removeAllViews()
        if (list != null) {
            for (item in list) {

                println(item)
                // 创建新的 TextView
                val textView = TextView(context)
                val s: String = "\t\t\t快递号：" + item.id + "\n\t\t\t状态：" + item.status
                textView.text = s
                textView.setLineSpacing(1F, 1.4F)
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
                textView.setOnClickListener { // 在这里编写点击事件的逻辑
                    DeliveryService.getDeliveryDetial(context?.let { it1 ->
                        UserManager.getInstance(
                            it1
                        )?.phoneNumber
                    }, it?.tag.toString()) { detail: DeliveryService.DeliveryDetail?, msg: String? ->
                        activity?.runOnUiThread {
                            if (detail == null) {
                                Toast.makeText(context, "失败: $msg", Toast.LENGTH_LONG).show()
                            } else {
                                val intent = Intent(context, DeliveryActivity::class.java)
                                intent.putExtra("detail", detail)
                                startActivity(intent)
                            }
                        }
                    }
                }
                // 设置布局参数


                val view: View = View(context)
                // 添加 TextView 到 LinearLayout
                linearLayout?.addView(textView, layoutParams1)
                linearLayout?.addView(view, layoutParams2)
            }
        } else {
            val textView = TextView(context)
            val s = "没有需要配送的快递"
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

            val view: View = View(context)
            val layoutParams1 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                120
            )
            // 添加 TextView 到 LinearLayout
            linearLayout?.addView(textView, layoutParams)
            linearLayout?.addView(view, layoutParams1)
        }
    }


    // 动态添加快递信息到主页
    private fun addDelivery(
        list: List<DeliveryService.Delivery>?,
        list1: List<DeliveryService.Delivery>?
    ) {

        linearLayout?.removeAllViews()
        // 设置布局参数
        var button = Button(context)
        button.text = "寄包裹"
        button.textSize = 20f
        // 创建一个自定义的背景
        val gradientDrawable = GradientDrawable()
        gradientDrawable.shape = GradientDrawable.RECTANGLE
        gradientDrawable.cornerRadius = 20f // 圆角半径
        gradientDrawable.setColor(Color.rgb(171, 229, 245)) // 背景颜色
        gradientDrawable.setStroke(4, Color.rgb(230, 230, 250)) // 边框宽度和颜色
        button.background = gradientDrawable
        linearLayout?.addView(button, layoutParams3)
        if (list != null) {
            val textView = TextView(context)
            val s: String = "寄件包裹："
            // 设置布局参数

            textView.text = s
            textView.textSize = 20.0F
            linearLayout?.addView(textView, layoutParams2)
            for (item in list) {
                println(item)
                // 创建新的 TextView
                val textView = TextView(context)
                val s: String =
                    "\t\t\t快递号：" + item.id + "\n\t\t\t快递类型：" + item.type + "\n\t\t\t状态：" + item.status
                textView.text = s
                textView.setLineSpacing(1F, 1.1F)
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
                textView.setOnClickListener { // 在这里编写点击事件的逻辑
                    DeliveryService.getCustomerDeliveryDetial(context?.let { it1 ->
                        UserManager.getInstance(
                            it1
                        )?.phoneNumber
                    }, it?.tag.toString()) { detail: DeliveryService.DeliveryDetail?, msg: String? ->
                        activity?.runOnUiThread {
                            if (detail == null) {
                                Toast.makeText(context, "失败: $msg", Toast.LENGTH_LONG).show()
                            } else {
                                val intent = Intent(context, DeliveryActivity::class.java)
                                intent.putExtra("detail", detail)
                                startActivity(intent)
                            }
                        }
                    }
                }
                val view = View(context)
                // 添加 TextView 到 LinearLayout
                linearLayout?.addView(textView, layoutParams1)
                linearLayout?.addView(view, layoutParams2)
            }
        }
        if (list1 != null) {
            val textView = TextView(context)
            val s: String = "收件包裹："
            // 设置布局参数
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                100
            )
            textView.text = s
            textView.textSize = 20.0F
            linearLayout?.addView(textView, layoutParams)
            for (item in list1) {
                println(item)
                // 创建新的 TextView
                val textView = TextView(context)
                val s: String =
                    "\t\t\t快递号：" + item.id + "\n\t\t\t快递类型：" + item.type + "\n\t\t\t状态：" + item.status
                textView.text = s
                textView.setLineSpacing(1F, 1.1F)
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
                textView.setOnClickListener { // 在这里编写点击事件的逻辑
                    DeliveryService.getCustomerDeliveryDetial(context?.let { it1 ->
                        UserManager.getInstance(
                            it1
                        )?.phoneNumber
                    }, it?.tag.toString()) { detail: DeliveryService.DeliveryDetail?, msg: String? ->
                        activity?.runOnUiThread {
                            if (detail == null) {
                                Toast.makeText(context, "失败: $msg", Toast.LENGTH_LONG).show()
                            } else {
                                val intent = Intent(context, DeliveryActivity::class.java)
                                intent.putExtra("detail", detail)
                                startActivity(intent)
                            }
                        }
                    }
                }

                val view = View(context)

                // 添加 TextView 到 LinearLayout
                linearLayout?.addView(textView, layoutParams1)
                linearLayout?.addView(view, layoutParams2)
            }
        }
    }

}