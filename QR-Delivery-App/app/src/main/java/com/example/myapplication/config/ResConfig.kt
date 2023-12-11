package com.example.myapplication.config

class ResConfig {
    /**
     * 响应码常量类
     *
     */
    object Code {
        /**
         * 请求成功
         */
        const val SUCCESS = 0

        /**
         * 请求失败
         */
        const val FAILURE = 1001

        /**
         * 静态化失败
         */
        const val STATICS_ERROR = 1002

        /**
         * 已存在
         */
        const val EXISTS = 1003

        /**
         * 服务器端异常
         */
        const val SERVER_ERROR = 5000

        /**
         * OK
         */
        const val OK = 0
        const val USER_ERROR = 2000
        const val PASS_ERROR = 2001
        const val CODE_ERROR = 2002
        const val NO_AUTH = 3000
    }

    /**
     *
     * 响应消息常量类
     *
     */
    object Msg {
        /**
         * 服务器端异常提示消息
         */
        const val SERVER_ERROR = "服务器端发生异常...."
        const val LOGIN_ERROR = "用户名或密码错误"
    }
}

