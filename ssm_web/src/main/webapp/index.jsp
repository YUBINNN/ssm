<%--
  Created by IntelliJ IDEA.
  User: 93534
  Date: 2019/9/6
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>

    <img src="img/center.jpg" alt="图片">
    <a href="product/findAll.do">查询所有产品</a><br>
    <a href="orders/findAll.do">查询所有订单</a><br>

    <a href="${pageContext.request.contextPath}/logout.do"
       class="btn btn-default btn-flat">注销</a>


</body>
</html>
