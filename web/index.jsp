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
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
</head>
<body>

<div class="layui-container" style="width: 1000px;height: 600px;margin-top: 0px;padding-top: 60px;">
    <div style="margin-left: 660px; width: 200px;">
        欢迎回来！<a href="reader_borrowed.jsp">${sessionScope.reader.name}</a>
        <a href="account.do?method=logout">
            <button class="layui-btn layui-btn-warm layui-btn-radius">注销</button>
        </a>
    </div>

    <table class="layui-hide" id="test" lay-filter="borrow"></table>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="borrow">借阅</a>
    </script>

</div>

<script src="layui/layui.js" charset="utf-8"></script>

<script>
    layui.use('table', function () {
        var table = layui.table;

        table.render({
            elem: '#test'
            , url: 'book.do'
            , title: '图书列表'
            , cols: [[
                {field: 'id', width: 100, title: '图书编号', sort: true}
                , {field: 'name', width: 150, title: '图书名称'}
                , {field: 'author', width: 100, title: '作者'}
                , {field: 'publish', width: 180, title: '出版社'}
                , {field: 'pages', width: 100, title: '图书页数', sort: true}
                , {field: 'price', width: 100, title: '价格', sort: true}
                , {field: 'bookCaseName', width: 170, title: '分类'}
                , {fixed: 'right', title: '操作', event: 'borrow', toolbar: '#barDemo', width: 100}
            ]]
            , page: true
        });

        table.on('tool(borrow)', function (obj) {
            var data = obj.data;

            if (obj.event === 'borrow') {
                window.location.href = "book.do?method=borrow&bookid=" + data.id;
            }

        });
    });
</script>
</body>
</html>
