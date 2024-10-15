<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>메모 상세보기</h3>
	<form action="update" method="post">
		<input type="text" name="id" value="${memo.id}" hidden="hidden" />
		메모아이디<input type="text" name="id" value="${memo.id}" disabled="disabled"/>
		메모내용 <input type="text" name="memo" value="${memo.content}"/>
		<input type="submit" value="수정" />
	</form>
</body>
</html>