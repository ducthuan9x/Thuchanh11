<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HELLO
  Date: 20/05/2022
  Time: 4:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Danh sách sản phẩm </h1>
<a href="/Products?action=create">Tạo mới sản phẩm</a>
<c:forEach items="${danhSach}" var="sanPham">
    <h3> ${sanPham.id},${sanPham.name},${sanPham.price} ,<a href="/Products?action=edit&id=${sanPham.id}">edit</a>,
        <a href="/Products?action=delete&id=${sanPham.id}">delete</a></h3>
</c:forEach>
</body>
</html>
