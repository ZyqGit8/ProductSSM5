<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link href="a/css/index1.css" type="text/css" rel="stylesheet">
</head>
<body>
<table border="1px">
<tr>
<td>商品编号</td>
<td>商品名称</td>
<td>商品价格</td>
<td>入库时间</td>
<td>商品描述</td>
<td>操作&nbsp;&nbsp;&nbsp;<a href="insertInfo.do">添加</a></td>
</tr>
<c:forEach items="${products}" var="product">
<tr>
<td>${product.id}</td>
<td>${product.name}</td>
<td>${product.price}</td>
<td>${product.createtime}</td>
<td>${product.detail}</td>
<td><a href="deleteProduct.do?id=${product.id}">删除</a>&nbsp;&nbsp;<a href="updateProduct.do?id=${product.id}">修改</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>