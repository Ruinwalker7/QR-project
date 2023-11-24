package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.View.OnFocusChangeListener
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


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
//
//    var onFocusChangeListener:OnFocusChangeListener? = OnFocusChangeListener(){
//
//    }
//
//    private fun OnFocusChangeListener(function: () -> Unit): View.OnFocusChangeListener {
//
//    }
//
//
//    /**
//     * 下面的OnFocusChangeListener的作用主要是
//     * 点击EditText时获取焦点并隐藏hint值
//     * */
//    fun onFocusChangeListener()
//    onFocusChangeListener
//    private OnFocusChangeListener onFocusChangeListener = new OnFocusChangeListener() {
//
//        @Override
//        public void onFocusChange(View v, boolean hasFocus) {
//            // TODO Auto-generated method stub
//
//            switch (v.getId()) {
//                case R.id.phonenum_et:
//                setHintEt(phonenum_et,hasFocus);
//
//                break;
//                case R.id.putems_et:
//                setHintEt(putems_et,hasFocus);
//                break;
//                case R.id.pwd_et:
//                setHintEt(pwd_et, hasFocus);
//                break;
//                default:
//                break;
//            }
//        }
//    };
//    private void setHintEt(EditText et,boolean hasFocus){
//        String hint;
//        if(hasFocus){
//            hint = et.getHint().toString();
//            et.setTag(hint);
//            et.setHint("");
//        }else{
//            hint = et.getTag().toString();
//            et.setHint(hint);
//        }
//    }
//}
}}