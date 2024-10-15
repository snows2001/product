<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<h3>	${message}	</h3>
	
	<h3>메모내용</h3>
	<p>
	${product.id} <br>
	{product.name} <br>
	{product.price} <br> 
	${product.content}
	</p>
	
	<h3>메모리스트</h3>
	
<ul>
	<c:forEach var="product" items="${products}">
		<li>${product.id} - ${product.content}</li>	
	</c:forEach>
</ul>
</body>
</html>