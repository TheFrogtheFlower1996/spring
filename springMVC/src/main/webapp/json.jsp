<%--
  Created by IntelliJ IDEA.
  User: 13717
  Date: 2022/4/8
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--引用百度在线jqery依赖包--%>
    <script src="https://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
        $.ajax({
            type:"get",
            url:"json/index",
            data:{},
            success:function (data){
                console.log(data)
            }
        })

        $.ajax({
            type:"set",
            url:"json/index02",
            // 设置服务器请求类型为JSON格式
            connectType:"application/json;charset=utf-8",
            // 如果控制器方法设置了 @RequestBody ，参数必须是JSON格式的字符串
            data:'{"id":"123","name":"张三","password":"abc123"}',
            success:function (data){
                console.log(data)
            }
        })
    </script>
</body>
</html>
