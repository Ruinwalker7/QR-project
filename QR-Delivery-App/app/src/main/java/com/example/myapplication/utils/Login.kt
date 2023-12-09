package com.example.myapplication.utils

import org.json.JSONObject
import java.io.DataOutputStream
import java.net.HttpURLConnection
import java.net.URL


class Login {

    //登录函数
    fun login(phone:String, password: String,callback: HTTPCallback)  {
        val urlString = "http://192.168.3.26:8080/app/login"
        val thread = Thread {
            try {
                val url = URL(urlString)
                val conn = url.openConnection() as HttpURLConnection
                conn.requestMethod = "POST"
                conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8")
                conn.doOutput = true
                conn.doInput = true
                val jsonParam = JSONObject()
                jsonParam.put("phone", phone)
                jsonParam.put("password", password)
                val os = DataOutputStream(conn.outputStream)
                os.writeBytes(jsonParam.toString())
                os.flush()
                os.close()
                val responseCode = conn.responseCode
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    callback.onSuccess();
                } else {
                    when (responseCode){
                        HttpURLConnection.HTTP_INTERNAL_ERROR -> callback.onFailure("服务器错误");
                        HttpURLConnection.HTTP_UNAUTHORIZED -> callback.onFailure("用户名密码错误");
                        else ->  callback.onFailure("用户名密码错误");
                    }
                }
                conn.disconnect()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        thread.start()
    }

    //注册函数
    fun registe(username:String, phone:String, password: String, id: String, callback: HTTPCallback){
        val urlString = "http://192.168.3.26:8080/app/registe"
        val thread = Thread {
            try {
                val url = URL(urlString)
                val conn = url.openConnection() as HttpURLConnection
                conn.requestMethod = "POST"
                conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8")
                conn.doOutput = true
                conn.doInput = true
                val jsonParam = JSONObject()
                jsonParam.put("phone", phone)
                jsonParam.put("password", password)
                jsonParam.put("username", username)
                jsonParam.put("idCard", id)
                val os = DataOutputStream(conn.outputStream)
                os.writeBytes(jsonParam.toString())
                os.flush()
                os.close()
                val responseCode = conn.responseCode
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    callback.onSuccess();
                } else {
                    when (responseCode){
                        HttpURLConnection.HTTP_INTERNAL_ERROR -> callback.onFailure("服务器错误");
                        HttpURLConnection.HTTP_UNAUTHORIZED -> callback.onFailure("注册失败");
                        else -> callback.onFailure("服务器错误");
                    }

                }
                conn.disconnect()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        thread.start()
    }
}

