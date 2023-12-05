<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<%@ page import="java.io.*,java.util.*" %>
<%
    HttpSession session1 = (HttpSession) request.getSession(false); // 获取当前会话，如果不存在则不创建新会话

    // 检查会话是否存在以及其中的字段值
    if (session1 != null && session1.getAttribute("loggedIn") != null && (boolean)session1.getAttribute("loggedIn")) {
        // loggedIn 字段为 true，用户已登录，继续显示当前页面
    } else {
        // loggedIn 字段不为 true，用户未登录，进行重定向到登录页面或其他页面
        response.sendRedirect("/"); // 重定向到登录页面
    }
%>

<head>
    <title>后台管理</title>
    <link href="//cdn.staticfile.org/layui/2.9.0/css/layui.css" rel="stylesheet">
    <script ref="reference" src="/static/script.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
</head>
<body>

<script src="//cdn.staticfile.org/layui/2.9.0/layui.js"></script>

<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" style="font-size: large">Security Code</div>
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">

>
            <li class="layui-nav-item" lay-unselect="">
                <a href="javascript:;"><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>
<%--                <dl class="layui-nav-child">--%>
<%--                    <dd><a href="javascript:;">修改信息</a></dd>--%>
<%--                </dl>--%>
            </li>
            <li class="layui-nav-item" lay-unselect="">
                <a href="/exit">退出</a>
            </li>
        </ul>
    </div>



    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="main_left" href="javascript:;" data-src="/man">人员管理</a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="main_left" href="javascript:;" data-src="/delivery">快递管理</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body" id="content">
        <div class="layui-tab-content">
            <div class="layui-show">
                <iframe id="mainframe" frameborder="0" scrolling="yes" style="width: 100%" src="/man"> </iframe>
            </div>
        </div>
    </div>


<%--    <script>--%>
<%--        $(function(){--%>
<%--            //获取src值--%>
<%--            $(".main_left").on("click",function(){--%>
<%--                var address =$(this).attr("data-src");--%>
<%--                $("iframe").attr("src",address);--%>
<%--            });--%>
<%--            //一下代码是根据窗口高度在设置iframe的高度--%>
<%--            var frame = $("#aa");--%>
<%--            var frameheight = $(window).height();--%>
<%--            console.log(frameheight);--%>
<%--            frame.css("height",frameheight);--%>
<%--        });--%>
<%--    </script>--%>



<%--    <div class="article">--%>
<%--        <!-- 上方第一个bar -->--%>
<%--        <div class="topbar">--%>
<%--            <div class="headitem">--%>
<%--                <img src="/static/images/NIU_5845.png">--%>
<%--            </div>--%>
<%--            <div class="headitem">--%>
<%--                Hello ${msg}--%>
<%--            </div>--%>
<%--            <!-- 盒子嵌套搜素框 -->--%>
<%--            <div class="headitem" style="margin-left: auto;">--%>
<%--                <div class="searchdiv">--%>
<%--                    <input placeholder="搜索" class="search" style="position: relative;left: 15px;">--%>
<%--                    <button>--%>
<%--                        <img src="/static/images/搜索.png" style="position: relative;right: 5px; top:2px">--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="headitem">--%>
<%--                <button id="exitbut" onclick="exit()" style="padding-right: 20px;">--%>
<%--                    退出--%>
<%--                </button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        --%>
<%--    </div>--%>
</div>
</body>

</html>

