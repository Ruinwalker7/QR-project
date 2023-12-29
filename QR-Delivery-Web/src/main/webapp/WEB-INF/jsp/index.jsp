<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

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
    <link href="https://cdn.staticfile.org/layui/2.9.0/css/layui.css" rel="stylesheet">
    <script href="reference" src="${pageContext.request.contextPath}/static/script.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/style.css">
    <link rel="icon" type="/static/" href="favicon.ico">
</head>
<body>

<script src="https://cdn.staticfile.org/layui/2.9.0/layui.js"></script>

<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" style="font-size: large">Security Code</div>
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">

>
            <li class="layui-nav-item" lay-unselect="">
                <a ><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>
            </li>
            <li class="layui-nav-item" lay-unselect="">
                <a href="${pageContext.request.contextPath}/exit">退出</a>
            </li>
        </ul>
    </div>



    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="main_left" data-src="/man">人员管理</a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="main_left"  data-src="/delivery">快递管理</a>
                </li>

                <li class="layui-nav-item layui-nav-itemed">
                    <a class="main_left"  data-src="/customer">用户管理</a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="main_left"  data-src="/address">地址管理</a>
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

</div>
</body>

</html>

