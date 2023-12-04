<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<%@ page import="java.io.*,java.util.*" %>
<%
    HttpSession session1 = (HttpSession) request.getSession(false); // 获取当前会话，如果不存在则不创建新会话

    // 检查会话是否存在以及其中的字段值
    if (session1 != null && session1.getAttribute("loggedIn") != null && (boolean)session1.getAttribute("loggedIn")) {
        // loggedIn 字段为 true，用户已登录，继续显示当前页面
%>
<%
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
                    人员管理
                </button>
            </div>

            <div class="baritem">
                <button >
                    <img src="/static/images/医院查询.png" >
                    快递管理
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
                <button id="exitbut" onclick="exit()" style="padding-right: 20px;">
                    退出
                </button>
            </div>
        </div>

        <!--
        本「综合演示」包含：自定义头部工具栏、获取表格数据、表格重载、自定义模板、单双行显示、单元格编辑、自定义底部分页栏、表格相关事件与操作、与其他组件的结合等相对常用的功能，以便快速掌握 table 组件的使用。
        -->
        <div style="padding: 16px;">
            <table class="layui-hide" id="test" lay-filter="test"></table>
        </div>
        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
                <button class="layui-btn layui-btn-sm" lay-event="getData">获取当前页数据</button>
                <button class="layui-btn layui-btn-sm" id="dropdownButton">
                    下拉按钮
                    <i class="layui-icon layui-icon-down layui-font-12"></i>
                </button>
                <button class="layui-btn layui-btn-sm layui-bg-blue" id="reloadTest">
                    重载测试
                    <i class="layui-icon layui-icon-down layui-font-12"></i>
                </button>
                <button class="layui-btn layui-btn-sm layui-btn-primary" id="rowMode">
                    <span>{{= d.lineStyle ? '多行' : '单行' }}模式</span>
                    <i class="layui-icon layui-icon-down layui-font-12"></i>
                </button>
            </div>
        </script>
        <script type="text/html" id="barDemo">
            <div class="layui-clear-space">
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-xs" lay-event="more">
                    更多
                    <i class="layui-icon layui-icon-down"></i>
                </a>
            </div>
        </script>
        <script src="//cdn.staticfile.org/layui/2.9.0/layui.js"></script>
        <script>
            layui.use(['table', 'dropdown'], function(){
                var table = layui.table;
                var dropdown = layui.dropdown;

                // 创建渲染实例
                table.render({
                    elem: '#test',
                    url: '/static/json/2/table/demo1.json', // 此处为静态模拟数据，实际使用时需换成真实接口
                    toolbar: '#toolbarDemo',
                    defaultToolbar: ['filter', 'exports', 'print', {
                        title: '提示',
                        layEvent: 'LAYTABLE_TIPS',
                        icon: 'layui-icon-tips'
                    }],
                    height: 'full-35', // 最大高度减去其他容器已占有的高度差
                    css: [ // 重设当前表格样式
                        '.layui-table-tool-temp{padding-right: 145px;}'
                    ].join(''),
                    cellMinWidth: 80,
                    totalRow: true, // 开启合计行
                    page: true,
                    cols: [[
                        {type: 'checkbox', fixed: 'left'},
                        {field:'id', fixed: 'left', width:80, title: 'ID', sort: true, totalRowText: '合计：'},
                        {field:'username', width:80, title: '用户'},
                        {field:'email', title:'邮箱 <i class="layui-icon layui-icon-tips layui-font-14" lay-event="email-tips" title="该字段开启了编辑功能" style="margin-left: 5px;"></i>', fieldTitle: '邮箱', hide: 0, width:150, expandedMode: 'tips', edit: 'text'},
                        {field:'sex', width:80, title: '性别', sort: true},
                        {field:'sign', title: '签名', edit: 'textarea', minWidth: 260, expandedWidth: 260, totalRow: '人物：<span class="layui-badge-rim">唐代：{{= d.TOTAL_ROW.era.tang }} </span> <span class="layui-badge-rim">宋代：{{= d.TOTAL_ROW.era.song }}</span> <span class="layui-badge-rim">现代：{{= d.TOTAL_ROW.era.xian }}</span>'},
                        {field:'experience', width: 100, title: '积分', sort: true, totalRow: '{{= d.TOTAL_NUMS }} 😊'},
                        {field:'checkin', title:'打卡', width: 100, sort: true, totalRow: '{{= parseInt(d.TOTAL_NUMS) }} 次'},
                        {field:'ip', title:'IP', width: 120},
                        {field:'joinTime', title:'加入时间', width: 120},
                        {fixed: 'right', title:'操作', width: 134, minWidth: 125, toolbar: '#barDemo'}
                    ]],
                    done: function(){
                        var id = this.id;
                        // 下拉按钮测试
                        dropdown.render({
                            elem: '#dropdownButton', // 可绑定在任意元素中，此处以上述按钮为例
                            data: [{
                                id: 'add',
                                title: '添加'
                            },{
                                id: 'update',
                                title: '编辑'
                            },{
                                id: 'delete',
                                title: '删除'
                            }],
                            // 菜单被点击的事件
                            click: function(obj){
                                var checkStatus = table.checkStatus(id)
                                var data = checkStatus.data; // 获取选中的数据
                                switch(obj.id){
                                    case 'add':
                                        layer.open({
                                            title: '添加',
                                            type: 1,
                                            area: ['80%','80%'],
                                            content: '<div style="padding: 16px;">自定义表单元素</div>'
                                        });
                                        break;
                                    case 'update':
                                        if(data.length !== 1) return layer.msg('请选择一行');
                                        layer.open({
                                            title: '编辑',
                                            type: 1,
                                            area: ['80%','80%'],
                                            content: '<div style="padding: 16px;">自定义表单元素</div>'
                                        });
                                        break;
                                    case 'delete':
                                        if(data.length === 0){
                                            return layer.msg('请选择一行');
                                        }
                                        layer.msg('delete event');
                                        break;
                                }
                            }
                        });

                        // 重载测试
                        dropdown.render({
                            elem: '#reloadTest', // 可绑定在任意元素中，此处以上述按钮为例
                            data: [{
                                id: 'reload',
                                title: '重载'
                            },{
                                id: 'reload-deep',
                                title: '重载 - 参数叠加'
                            },{
                                id: 'reloadData',
                                title: '仅重载数据'
                            },{
                                id: 'reloadData-deep',
                                title: '仅重载数据 - 参数叠加'
                            }],
                            // 菜单被点击的事件
                            click: function(obj){
                                switch(obj.id){
                                    case 'reload':
                                        // 重载 - 默认（参数重置）
                                        table.reload('test', {
                                            where: {
                                                abc: '123456',
                                                //test: '新的 test2',
                                                //token: '新的 token2'
                                            },
                                            /*
                                            cols: [[ // 重置表头
                                              {type: 'checkbox', fixed: 'left'},
                                              {field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true, totalRowText: '合计：'},
                                              {field:'sex', title:'性别', width:80, edit: 'text', sort: true},
                                              {field:'experience', title:'积分', width:80, sort: true, totalRow: true, templet: '<div>{{= d.experience }} 分</div>'},
                                              {field:'logins', title:'登入次数', width:100, sort: true, totalRow: true},
                                              {field:'joinTime', title:'加入时间', width:120}
                                            ]]
                                            */
                                        });
                                        break;
                                    case 'reload-deep':
                                        // 重载 - 深度（参数叠加）
                                        table.reload('test', {
                                            where: {
                                                abc: 123,
                                                test: '新的 test1'
                                            },
                                            //defaultToolbar: ['print'], // 重载头部工具栏右侧图标
                                            //cols: ins1.config.cols
                                        }, true);
                                        break;
                                    case 'reloadData':
                                        // 数据重载 - 参数重置
                                        table.reloadData('test', {
                                            where: {
                                                abc: '123456',
                                                //test: '新的 test2',
                                                //token: '新的 token2'
                                            },
                                            scrollPos: 'fixed',  // 保持滚动条位置不变 - v2.7.3 新增
                                            height: 2000, // 测试无效参数（即与数据无关的参数设置无效，此处以 height 设置无效为例）
                                            //url: '404',
                                            //page: {curr: 1, limit: 30} // 重新指向分页
                                        });
                                        break;
                                    case 'reloadData-deep':
                                        // 数据重载 - 参数叠加
                                        table.reloadData('test', {
                                            where: {
                                                abc: 123,
                                                test: '新的 test1'
                                            }
                                        }, true);
                                        break;
                                }
                                layer.msg('可观察 Network 请求参数的变化');
                            }
                        });

                        // 行模式
                        dropdown.render({
                            elem: '#rowMode',
                            data: [{
                                id: 'default-row',
                                title: '单行模式（默认）'
                            },{
                                id: 'multi-row',
                                title: '多行模式'
                            }],
                            // 菜单被点击的事件
                            click: function(obj){
                                var checkStatus = table.checkStatus(id)
                                var data = checkStatus.data; // 获取选中的数据
                                switch(obj.id){
                                    case 'default-row':
                                        table.reload('test', {
                                            lineStyle: null // 恢复单行
                                        });
                                        layer.msg('已设为单行');
                                        break;
                                    case 'multi-row':
                                        table.reload('test', {
                                            // 设置行样式，此处以设置多行高度为例。若为单行，则没必要设置改参数 - 注：v2.7.0 新增
                                            lineStyle: 'height: 95px;'
                                        });
                                        layer.msg('即通过设置 lineStyle 参数可开启多行');
                                        break;
                                }
                            }
                        });
                    },
                    error: function(res, msg){
                        console.log(res, msg)
                    }
                });

                // 工具栏事件
                table.on('toolbar(test)', function(obj){
                    var id = obj.config.id;
                    var checkStatus = table.checkStatus(id);
                    var othis = lay(this);
                    switch(obj.event){
                        case 'getCheckData':
                            var data = checkStatus.data;
                            layer.alert(layui.util.escape(JSON.stringify(data)));
                            break;
                        case 'getData':
                            var getData = table.getData(id);
                            console.log(getData);
                            layer.alert(layui.util.escape(JSON.stringify(getData)));
                            break;
                        case 'LAYTABLE_TIPS':
                            layer.alert('自定义工具栏图标按钮');
                            break;
                    };
                });
                // 表头自定义元素工具事件 --- 2.8.8+
                table.on('colTool(test)', function(obj){
                    var event = obj.event;
                    console.log(obj);
                    if(event === 'email-tips'){
                        layer.alert(layui.util.escape(JSON.stringify(obj.col)), {
                            title: '当前列属性配置项'
                        });
                    }
                });

                // 触发单元格工具事件
                table.on('tool(test)', function(obj){ // 双击 toolDouble
                    var data = obj.data; // 获得当前行数据
                    // console.log(obj)
                    if(obj.event === 'edit'){
                        layer.open({
                            title: '编辑 - id:'+ data.id,
                            type: 1,
                            area: ['80%','80%'],
                            content: '<div style="padding: 16px;">自定义表单元素</div>'
                        });
                    } else if(obj.event === 'more'){
                        // 更多 - 下拉菜单
                        dropdown.render({
                            elem: this, // 触发事件的 DOM 对象
                            show: true, // 外部事件触发即显示
                            data: [{
                                title: '查看',
                                id: 'detail'
                            },{
                                title: '删除',
                                id: 'del'
                            }],
                            click: function(menudata){
                                if(menudata.id === 'detail'){
                                    layer.msg('查看操作，当前行 ID:'+ data.id);
                                } else if(menudata.id === 'del'){
                                    layer.confirm('真的删除行 [id: '+ data.id +'] 么', function(index){
                                        obj.del(); // 删除对应行（tr）的DOM结构
                                        layer.close(index);
                                        // 向服务端发送删除指令
                                    });
                                }
                            },
                            align: 'right', // 右对齐弹出
                            style: 'box-shadow: 1px 1px 10px rgb(0 0 0 / 12%);' // 设置额外样式
                        })
                    }
                });

                // 触发表格复选框选择
                table.on('checkbox(test)', function(obj){
                    console.log(obj)
                });

                // 触发表格单选框选择
                table.on('radio(test)', function(obj){
                    console.log(obj)
                });

                // 行单击事件
                table.on('row(test)', function(obj){
                    //console.log(obj);
                    //layer.closeAll('tips');
                });
                // 行双击事件
                table.on('rowDouble(test)', function(obj){
                    console.log(obj);
                });

                // 单元格编辑事件
                table.on('edit(test)', function(obj){
                    var field = obj.field; // 得到字段
                    var value = obj.value; // 得到修改后的值
                    var data = obj.data; // 得到所在行所有键值
                    // 值的校验
                    if(field === 'email'){
                        if(!/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(obj.value)){
                            layer.tips('输入的邮箱格式不正确，请重新编辑', this, {tips: 1});
                            return obj.reedit(); // 重新编辑 -- v2.8.0 新增
                        }
                    }
                    // 编辑后续操作，如提交更新请求，以完成真实的数据更新
                    // …
                    layer.msg('编辑成功', {icon: 1});

                    // 其他更新操作
                    var update = {};
                    update[field] = value;
                    obj.update(update);
                });
            });
        </script>

    <%--        <!-- 下面作为一个整体 -->--%>
<%--        <div class="content">--%>
<%--            <!-- 第二个bar -->--%>
<%--            <div class="topbar-2nd">--%>
<%--                <div class="headitem2">--%>
<%--                    <button class="topbtn2"> 基本信息设置--%>
<%--                        <div class="line"></div>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--                <div class="headitem2">--%>
<%--                    <button class="topbtn2"> SEO设置<div class="line"></div> </button>--%>

<%--                </div>--%>
<%--                <div class="headitem2">--%>
<%--                    <button class="topbtn2"> 栏目设置<div class="line"></div> </button>--%>
<%--                </div>--%>
<%--                <div class="headitem2">--%>
<%--                    <button class="topbtn2"> 管理员设置--%>
<%--                        <div class="line"></div>--%>

<%--                    </button>--%>
<%--                </div>--%>
<%--                <div class="headitem2">--%>
<%--                    <button class="topbtn2"> 在线客服设置--%>
<%--                        <div class="line"></div>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--                <div class="headitem2">--%>
<%--                    <button class="topbtn2"> 接口设置--%>
<%--                        <div class="line"></div>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="maincontent">--%>
<%--                <form class="form" method="post">--%>
<%--                    <div class="formitem">--%>
<%--                        <div class="formtext">用户名：</div> <input name="name" type="text"> </div>--%>
<%--                    <div class="formitem">--%>
<%--                        <div class="formtext">密码：</div><input name="pass" type="password">--%>
<%--                        <div style="color: #b0b0b0; padding: 10px; font-size: small; font-weight: normal;">*密码为6位以上的数字加字母组合</div>--%>
<%--                    </div>--%>

<%--                    <div class="formitem">--%>
<%--                        <div class="formtext">姓名：</div><input name="name" type="text"> </div>--%>
<%--                    <div class="formitem">--%>
<%--                        <div class="formtext">联系方式：</div><input name="pass" type="text"> </div>--%>
<%--                    <div class="formitem">--%>
<%--                        <div class="formtext">邮箱地址：</div><input name="name" type="email"> </div>--%>
<%--                    <div class="formitem">--%>
<%--                        <div class="formtext">添加时间：</div>--%>
<%--                        <select id="years" onchange="doChange()">--%>
<%--                            <option value="">年</option></select>--%>

<%--                        <select id="months" onchange="doChange()">--%>
<%--                            <option value="">月</option> </select>--%>

<%--                        <select id="dates">--%>
<%--                            <option value="">日</option>--%>
<%--                        </select>--%>
<%--                    </div>--%>

<%--                    <div class="formitem3" style="align-items: normal;">--%>
<%--                        <div class="formtext">开放权限：</div>--%>
<%--                        <div class="mutiselectdiv">--%>
<%--                            <div class="cb">--%>
<%--                                <input type="checkbox" />全部--%>
<%--                            </div>--%>
<%--                            <div class="cb">--%>
<%--                                <input type="checkbox" />内容管理--%>
<%--                            </div>--%>
<%--                            <div class="cb">--%>
<%--                                <input type="checkbox" />资讯管理--%>
<%--                            </div>--%>
<%--                            <div class="cb">--%>
<%--                                <input type="checkbox" />产品管理--%>
<%--                            </div>--%>
<%--                            <div class="cb">--%>
<%--                                <input type="checkbox" />图库--%>
<%--                            </div>--%>
<%--                            <div class="cb">--%>
<%--                                <input type="checkbox" />广告管理--%>
<%--                            </div>--%>
<%--                            <div class="cb">--%>
<%--                                <input type="checkbox" />留言管理--%>
<%--                            </div>--%>
<%--                            <div class="cb">--%>
<%--                                <input type="checkbox" />设置--%>
<%--                            </div>--%>
<%--                        </div>--%>


<%--                    </div>--%>

<%--                    <div class="formitem2">--%>
<%--                        <input type="submit" name="Button" value="保存" style="background-color: #057effb2;color: white; box-shadow: 0px 0px 5px 0px #057dff;" />--%>
<%--                        <input type="reset" name="Reset" value="取消" style="border: 1px solid #e2e2e2; background-color: #ffffff;" />--%>
<%--                    </div>--%>

<%--                </form>--%>
<%--            </div>--%>

<%--        </div>--%>
    </div>
</div>
</body>

</html>

