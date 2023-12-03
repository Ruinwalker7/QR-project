<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>后台管理</title>
    <script ref="reference" src="/static/script.js"></script>
</head>


<body>
<link rel="stylesheet" type="text/css" href="/static/style.css">
<!-- 整个web -->
<div class="layout">
    <div class="aside">
        <!-- 学校logo div+img 加了蓝色阴影 -->
        <div class="radius">
            <img src="/static/images/logo.png" width="200" height="80" style="position: relative;left: 55px;top: 115px;">
        </div>

        <!-- 弹性布局 -->
        <div class="leftbar" style="padding-top: 60px;margin-top: -120px;padding-bottom: 60px;">
            <div class="baritem">
                <button style="color: white; ">
                    <!-- 颜色反转，从白色变成灰色 -->
                    <img src="/static/images/首页.png"  style="filter: invert(0);">
                    内容管理
                </button>
            </div>

            <div class="baritem">
                <button >
                    <img src="/static/images/医院查询.png" >
                    内容管理
                </button>
            </div>




<%--            <div class="baritem">--%>
<%--                <button>--%>
<%--                    <img src="/static/images/留言.png">--%>
<%--                    留言管理 </button>--%>
<%--            </div>--%>

<%--            <div class="baritem">--%>
<%--                <button>--%>
<%--                    <img src="/static/images/设置.png">--%>

<%--                    设置--%>
<%--                </button>--%>
<%--            </div>--%>


        </div>
    </div>


    <div class="article">

        <!-- 上方第一个bar -->
        <div class="topbar">
            <div class="headitem">
                <img src="/static/images/NIU_5845.png">
            </div>

            <div class="headitem">
                Hello ${msg}
            </div>

            <!-- 盒子嵌套搜素框 -->
            <div class="headitem" style="margin-left: auto;">
                <div class="searchdiv">
                    <input placeholder="搜索" class="search" style="position: relative;left: 15px;">
                    <button>
                        <img src="/static/images/搜索.png" style="position: relative;right: 5px; top:2px">

                    </button>
                </div>

            </div>

            <div class="headitem">
                <button>
                    <img src="/static/images/帮助.png" style="position: relative;top: 2px;" >  帮助
                </button>

            </div>

            <div class="headitem">
                <button style="padding-right: 20px;">
                    退出
                </button>


            </div>
        </div>

        <!-- 下面作为一个整体 -->
        <div class="content">
            <!-- 第二个bar -->
            <div class="topbar-2nd">
                <div class="headitem2">
                    <button class="topbtn2"> 基本信息设置
                        <div class="line"></div>
                    </button>
                </div>
                <div class="headitem2">
                    <button class="topbtn2"> SEO设置<div class="line"></div> </button>

                </div>
                <div class="headitem2">
                    <button class="topbtn2"> 栏目设置<div class="line"></div> </button>
                </div>
                <div class="headitem2">
                    <button class="topbtn2"> 管理员设置
                        <div class="line"></div>

                    </button>
                </div>
                <div class="headitem2">
                    <button class="topbtn2"> 在线客服设置
                        <div class="line"></div>
                    </button>
                </div>
                <div class="headitem2">
                    <button class="topbtn2"> 接口设置
                        <div class="line"></div>
                    </button>
                </div>
            </div>
            <div class="maincontent">
                <form class="form" method="post">
                    <div class="formitem">
                        <div class="formtext">用户名：</div> <input name="name" type="text"> </div>
                    <div class="formitem">
                        <div class="formtext">密码：</div><input name="pass" type="password">
                        <div style="color: #b0b0b0; padding: 10px; font-size: small; font-weight: normal;">*密码为6位以上的数字加字母组合</div>
                    </div>

                    <div class="formitem">
                        <div class="formtext">姓名：</div><input name="name" type="text"> </div>
                    <div class="formitem">
                        <div class="formtext">联系方式：</div><input name="pass" type="text"> </div>
                    <div class="formitem">
                        <div class="formtext">邮箱地址：</div><input name="name" type="email"> </div>
                    <div class="formitem">
                        <div class="formtext">添加时间：</div>
                        <select id="years" onchange="doChange()">
                            <option value="">年</option></select>

                        <select id="months" onchange="doChange()">
                            <option value="">月</option> </select>

                        <select id="dates">
                            <option value="">日</option>
                        </select>
                    </div>

                    <div class="formitem3" style="align-items: normal;">
                        <div class="formtext">开放权限：</div>
                        <div class="mutiselectdiv">
                            <div class="cb">
                                <input type="checkbox" />全部
                            </div>
                            <div class="cb">
                                <input type="checkbox" />内容管理
                            </div>
                            <div class="cb">
                                <input type="checkbox" />资讯管理
                            </div>
                            <div class="cb">
                                <input type="checkbox" />产品管理
                            </div>
                            <div class="cb">
                                <input type="checkbox" />图库
                            </div>
                            <div class="cb">
                                <input type="checkbox" />广告管理
                            </div>
                            <div class="cb">
                                <input type="checkbox" />留言管理
                            </div>
                            <div class="cb">
                                <input type="checkbox" />设置
                            </div>
                        </div>


                    </div>

                    <div class="formitem2">
                        <input type="submit" name="Button" value="保存" style="background-color: #057effb2;color: white; box-shadow: 0px 0px 5px 0px #057dff;" />
                        <input type="reset" name="Reset" value="取消" style="border: 1px solid #e2e2e2; background-color: #ffffff;" />
                    </div>

                </form>
            </div>

        </div>
    </div>
</div>
</body>

</html>

