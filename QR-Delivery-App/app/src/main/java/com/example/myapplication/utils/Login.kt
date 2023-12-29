package com.example.myapplication.utils

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
    data class RegisteRequest(val username:String, val phone:String,val password: String, val id_card:String)
    companion object{
        //登录函数
//        fun login(phone:String, password: String, callback: HTTPCallback)  {
//            val urlString = "http://192.168.3.26:8080/app/login"
//            val loginRequest = LoginRequest(phone, password)
//            runBlocking {
//                Fuel.post(urlString).jsonBody(Gson().toJson(loginRequest))
//                    .responseString { _, response, result ->
//                        when(result){
//                            is Result.Success -> {
//                                val data = result.get() // 获取返回的字符串数据
//                                    // HTTP 状态码为 200 表示成功
//                                    println("Request successful. Response data: $data")
//                                    val jsonObject = JSONObject(data)
//                                    when(jsonObject.getInt("code")){
//                                        ResConfig.Code.OK ->{
//                                            try {
//                                                println(jsonObject.getString("data"))
//                                                val gson = Gson().newBuilder()
//                                                    .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeTypeAdapter())
//                                                    .create()
//                                                val deliveryman: Deliveryman = gson.fromJson(jsonObject.getString("data"), Deliveryman::class.java)
//                                                callback.onSuccess(deliveryman);
//                                                println("Parsed JSON data: $deliveryman")
//                                            } catch (e: JsonSyntaxException) {
//                                                // JSON 解析异常
//                                                println("Error parsing JSON: ${e.message}")
//                                            }
//                                        }
//                                        else ->{
//                                            callback.onFailure("用户名密码错误")
//                                        }
//                                    }
//                                }
//                            is Result.Failure -> {
//                                callback.onFailure("无法连接到服务器");
//                            }
//                        }
//                    }
//            }
//        }

        fun login(phone:String, password: String, callback: (Deliveryman?, msg:String?) -> Unit)  {
            val urlString = "http://notebook.szkxy.net/app/login"
            val loginRequest = LoginRequest(phone, password)
            runBlocking {
                Fuel.post(urlString).jsonBody(Gson().toJson(loginRequest))
                    .responseString { _, response, result ->
                        when(result){
                            is Result.Success -> {
                                val data = result.get() // 获取返回的字符串数据
                                // HTTP 状态码为 200 表示成功
                                println("Request successful. Response data: $data")
                                val jsonObject = JSONObject(data)
                                when(jsonObject.getInt("code")){
                                    ResConfig.Code.OK ->{
                                        try {
                                            println(jsonObject.getString("data"))
                                            val gson = Gson().newBuilder()
                                                .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeTypeAdapter())
                                                .create()
                                            val deliveryman: Deliveryman = gson.fromJson(jsonObject.getString("data"), Deliveryman::class.java)
                                            callback(deliveryman,null);
                                            println("Parsed JSON data: $deliveryman")
                                        } catch (e: JsonSyntaxException) {
                                            // JSON 解析异常
                                            println("Error parsing JSON: ${e.message}")
                                        }
                                    }
                                    else ->{
                                        callback(null,"用户名密码错误")
                                    }
                                }
                            }
                            is Result.Failure -> {
                                callback(null,"无法连接到服务器");
                            }
                        }
                    }
            }
        }

    fun register(username:String, phone:String, password: String, id: String,  callback: (msg:String?) -> Unit){
        val urlString = "http://192.168.3.26:8080/app/registe"
        val registeRequest = RegisteRequest(username , phone, password, id)
        runBlocking {
            Fuel.post(urlString).jsonBody(Gson().toJson(registeRequest))
                .responseString { _, response, result ->
                    when(result){
                        is Result.Success -> {
                            val data = result.get() // 获取返回的字符串数据
                            // Code 为 200 表示成功
                            println("Request successful. Response data: $data")
                            val jsonObject = JSONObject(data)
                            when(jsonObject.getInt("code")){
                                ResConfig.Code.OK ->{
                                    try {
                                        callback(null)
                                    } catch (e: JsonSyntaxException) {
                                        println("Error parsing JSON: ${e.message}")
                                    }
                                }
                                else ->{
                                    callback("当前手机号已被注册")
                                }
                            }
                        }
                        is Result.Failure -> {
                            val error = result.error
                            println("Request failed. Error: $error")
                            when(response.statusCode){
                                HttpURLConnection.HTTP_INTERNAL_ERROR ->callback("服务器错误")
                                else ->  callback("无法连接到服务器");
                            }
                        }
                    }
                }
            }
        }
    }

}

