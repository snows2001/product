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
	<h3>Product List</h3>
	<c:if test="${!empty products }">
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>가격</th>
			<th>내용</th>
		</tr>
	<c:forEach var="product" items="${products}">
		<tr>
			<td>${product.id}</td>
			<td>${product.name}</td>
			<td>${product.price}</td>
			<td>${product.content}</td>
			<td><a href="Product/findbyid?id=${product.id}">상세보기</a></td>
		</tr>	
	</c:forEach>
	</table>
</c:if>
<c:if test="${empty products }">메모가 없습니다.</c:if>
</body>
</html>