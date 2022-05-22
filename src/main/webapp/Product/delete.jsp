<%--
  Created by IntelliJ IDEA.
  User: HELLO
  Date: 22/05/2022
  Time: 3:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="number" name="id" value="${spCanXoa.id}">
    <input type="text" name="name" value="${spCanXoa.name}">
    <input type="number" name="price" value="${spCanXoa.price}">
    <button>xoá</button>
</form>
</body>
</html>
