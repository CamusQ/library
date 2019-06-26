<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/6/26
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
</head>
<body>

<div class="layui-container" style="width: 1000px;height: 600px;margin-top: 0px;padding-top: 60px;">
    <div style="margin-left: 660px; width: 200px;">
        欢迎回来！<a href="reader_borrowed.jsp">${sessionScope.reader.name}</a>
        <a href="account.do?method=logout">
            <button class="layui-btn layui-btn-warm layui-btn-radius">注销</button>
        </a>
    </div>
</div>

<script src="layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function(){
        var form = layui.form;


    });
</script>
</body>
</html>
