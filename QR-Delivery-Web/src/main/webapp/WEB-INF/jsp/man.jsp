<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

<!DOCTYPE html>
<html lang="en">
<head>
    <title>人员管理</title>
    <link href="//cdn.staticfile.org/layui/2.9.0/css/layui.css" rel="stylesheet">
</head>

<body>
<div class="layui-padding-3">
    <h2 style="padding-bottom: 20px">
        人员管理
    </h2>

    <form class="layui-form layui-row layui-col-space16">
        <div class="layui-col-md4">
            <div class="layui-input-wrap">
                <div class="layui-input-prefix">
                    <i class="layui-icon layui-icon-username"></i>
                </div>
                <input type="text" name="ID" value="" placeholder="工号" class="layui-input" lay-affix="clear">
            </div>
        </div>
        <div class="layui-col-md4">
            <div class="layui-input-wrap">
                <div class="layui-input-prefix">
                    <i class="layui-icon layui-icon-username"></i>
                </div>
                <input type="text" name="username" placeholder="姓名" lay-affix="clear" class="layui-input">
            </div>
        </div>
        <div class="layui-col-md4">
            <div class="layui-input-wrap">
                <div class="layui-input-prefix">
                    <i class="layui-icon layui-icon-date"></i>
                </div>
                <input type="text" name="ID_card" placeholder="身份证号" class="layui-input demo-table-search-date">
            </div>
        </div>
        <div class="layui-btn-container layui-col-xs12">
            <button class="layui-btn" lay-submit lay-filter="demo-table-search">搜索</button>
            <button type="reset" class="layui-btn layui-btn-primary">清除</button>
        </div>
    </form>
    <table class="layui-table" lay-skin="line" id="test" lay-filter="test"></table>
</div>


<script type="text/html" id="ID-table-demo-templet-switch1">
    <input type="checkbox" name="src"  title="开启|关闭" lay-skin="switch" value="{{= d.id }}"
           lay-filter="demo-templet-status" {{= d.visitSrc == 1 ? "checked": ""}}>
</script>

<script type="text/html" id="ID-table-demo-templet-switch2">
    <input type="checkbox" name="dst" value="{{= d.id }}" title="开启|关闭" lay-skin="switch"
           lay-filter="demo-templet-status"  {{= d.visitDst == 1 ? "checked": ""}}>
</script>
<script type="text/html" id="ID-table-demo-templet-switch3">
    <input type="checkbox" name="delivery" value="{{= d.id }}" title="开启|关闭" lay-skin="switch"
           lay-filter="demo-templet-status" {{= d.visitDelivery == 1 ? "checked": ""}}>
</script>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
        <button class="layui-btn layui-btn-sm" lay-event="getData">获取当前页数据</button>
<%--        <button class="layui-btn layui-btn-sm" id="dropdownButton">--%>
<%--            下拉按钮--%>
<%--            <i class="layui-icon layui-icon-down layui-font-12"></i>--%>
<%--        </button>--%>
    </div>
</script>

<script type="text/html" id="barDemo">
    <div class="layui-clear-space">
<%--        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>--%>
        <a class="layui-btn layui-btn-xs" lay-event="delete">删除</a>
    </div>
</script>



<script src="//cdn.staticfile.org/layui/2.9.0/layui.js"></script>
<script>
    layui.use(['table', 'dropdown'], function(){
        var table = layui.table;
        var dropdown = layui.dropdown;
        var form = layui.form;

        // 创建渲染实例
        table.render({
            elem: '#test',
            url: '/api/man/all', // 此处为静态模拟数据，实际使用时需换成真实接口
            toolbar: '#toolbarDemo',
            height: '550', // 最大高度减去其他容器已占有的高度差
            css: [ // 重设当前表格样式
                '.layui-table-tool-temp{padding-right: 1000px;}'
            ].join(''),
            cellMinWidth: 80,
            totalRow: false, // 开启合计行
            page: true,
            cols: [[
                {type: 'checkbox', fixed: 'left'},
                {field:'id', fixed: 'left', width:120, title: '工号'},
                {field:'username', width:120, title: '姓名',edit: 'textarea'},
                {field:'phone', title:'电话', fieldTitle: '邮箱', hide: 0, width:150, expandedMode: 'tips', edit: 'phone'},
                {field:'idCard', title: '身份证号', edit: 'textarea', minWidth: 200, expandedWidth: 260},
                {field:'workAddress',  title: '工作地址',edit: 'textarea',minWidth: 150, expandedWidth: 300},
                {field:'createTime', width:300, title: '加入时间', sort: true},
                {title: '收件人权限', width:105, templet: '#ID-table-demo-templet-switch1'},
                {title: '寄件人权限', width:105, templet: '#ID-table-demo-templet-switch2'},
                {title: '物品权限', width:105, templet: '#ID-table-demo-templet-switch3'},
                {fixed: 'right', title:'操作', width: 80, minWidth: 80, toolbar: '#barDemo'}
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
            },
            error: function(res, msg){
                console.log(res, msg)
            }
        });

        // 状态 - 开关操作
        form.on('switch(demo-templet-status)', function(obj){
            var value = this.checked ? 1:0
            var id = this.value;
            var name = this.name;
            var url1
            console.log(name)
            switch (name){
                case 'src':
                    url1 = '/api/man/update/src'
                    break
                case 'dst':
                    url1 = '/api/man/update/dst'
                    break
                case 'delivery':
                    url1 = '/api/man/update/delivery'
                    break;
            }

            console.log(url1)
            url1 += '?id='+id+'&value='+value

            console.log(url1)

            fetch(url1, {
                method: 'GET'
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response;
                })
                .then(data => {
                    console.log('Success:', data);
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        });

        // 工具栏事件
        table.on('toolbar(test)', function(obj){
            var id = obj.config.id;
            var checkStatus = table.checkStatus(id);
            var othis = lay(this);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    console.log(data)
                    if(data.length!=0)
                        layer.alert(layui.util.escape(JSON.stringify(data)));
                    else
                        layer.msg('请选择行', {icon: 0});
                    break;
                case 'getData':
                    var getData = table.getData(id);
                    console.log(getData);
                    layer.alert(layui.util.escape(JSON.stringify(getData)));
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
            }else if(obj.event === 'delete'){
                layer.confirm('真的删除行 [id: '+ data.id +'] 么', function(index){
                    const url1 = "/api/man/delete?id=" + data.id;
                    // 使用 Fetch API 发起 DELETE 请求
                    fetch(url1, {
                        method: 'DELETE',
                    })
                        .then(response => {
                            if (!response.ok) {
                                throw new Error('Network response was not ok');
                            }
                            return;
                        })
                        .then(data => {
                            obj.del(); // 删除对应行（tr）的DOM结构
                        })
                        .catch(error => {
                            // 请求失败时的处理
                            console.error('There has been a problem with your fetch operation:', error);
                        });


                    layer.close(index);
                    // 向服务端发送删除指令
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
            obj.setRowChecked({
                type: 'checkbox' // radio 单选模式；checkbox 复选模式
            });

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

            // 使用 Fetch API 发起 POST 请求
            fetch('/api/man/update', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json', // 设置请求头，告知后端发送的是 JSON 数据
                },
                body: JSON.stringify(data),
            })
                .then(response => {
                    if (!response.ok) {
                        layer.msg('编辑失败', {icon: 3});
                        throw new Error('Network response was not ok');
                    }
                    return;
                })
                .then(data => {
                    // 请求成功后的操作，根据后端返回的数据进行处理
                    console.log('Response:', data);
                    layer.msg('编辑成功', {icon: 1});
                    // 其他更新操作
                    var update = {};
                    update[field] = value;
                    obj.update(update);
                })
                .catch(error => {
                    console.error('There has been a problem with your fetch operation:', error);
                });
        });

        // 搜索提交
        form.on('submit(demo-table-search)', function(data){
            var field = data.field; // 获得表单字段
            // 执行搜索重载
            table.reload('test', {
                page: {
                    curr: 1 // 重新从第 1 页开始
                },
                where: field // 搜索的字段
            });
            // layer.msg('搜索成功<br>此处为静态模拟数据，实际使用时换成真实接口即可');
            return false; // 阻止默认 form 跳转
        });
    });
</script>

</body>
</html>