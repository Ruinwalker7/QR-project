package com.example.myapplication.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.myapplication.config.ResConfig
import com.example.myapplication.entity.Deliveryman
import com.google.gson.Gson
import org.json.JSONObject
import java.io.DataOutputStream
import java.net.HttpURLConnection
import java.net.URL
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime


class Login {

    data class LoginRequest(val phone: String, val password: String)
    //登录函数
    fun login(phone:String, password: String, callback: HTTPCallback)  {
        val urlString = "http://192.168.3.26:8080/app/login"
        val loginRequest = LoginRequest(phone, password)

        runBlocking {
            Fuel.post(urlString).jsonBody(Gson().toJson(loginRequest))
                .responseString { _, response, result ->
                    when(result){
                        is Result.Success -> {
                            val data = result.get() // 获取返回的字符串数据
                            if (response.statusCode == 200) {
                                // HTTP 状态码为 200 表示成功
                                println("Request successful. Response data: $data")
                                val jsonObject = JSONObject(data)
                                when(jsonObject.getInt("code")){
                                    ResConfig.Code.OK ->{
                                        try {
                                            println(jsonObject.getString("data"))
                                            // 使用 Gson 解析 JSON 数据到数据类
                                            val gson = Gson().newBuilder()
                                                .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeTypeAdapter())
                                                .create()

                                            val deliveryman: Deliveryman = gson.fromJson(jsonObject.getString("data"), Deliveryman::class.java)
                                            callback.onSuccess(deliveryman);
                                            println("Parsed JSON data: $deliveryman")
                                        } catch (e: JsonSyntaxException) {
                                            // JSON 解析异常
                                            println("Error parsing JSON: ${e.message}")
                                        }
                                    }
                                    else ->{
                                        callback.onFailure("用户名密码错误")
                                    }
                                }
                            } else {
                                // 请求成功，但 HTTP 状态码表示失败
                                println("Request failed. HTTP Status Code: ${response.statusCode}, Response data: $data")
                                when(response.statusCode){
                                    HttpURLConnection.HTTP_INTERNAL_ERROR -> callback.onFailure("服务器错误")
                                    HttpURLConnection.HTTP_UNAUTHORIZED -> callback.onFailure("用户名密码错误")
                                    else ->  callback.onFailure("服务器错误");
                                }
                            }
                        }
                        is Result.Failure -> {
                            val error = result.error
                            println("Request failed. Error: $error")
                            callback.onFailure("无法连接到服务器")
                        }
                    }
                }
        }
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
                    callback.onSuccess(null);
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

