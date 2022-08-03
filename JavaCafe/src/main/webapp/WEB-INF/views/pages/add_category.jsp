<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>신규 카테고리 추가</h3>
<form:form method="post" modelAttribute="menuCategory">
	<label>카테고리 이름</label>
	<form:input path="cateName"/><br>
	<label>카테고리 분류 코드1</label>
	<form:input path="cateCode"/><br>
	<input type="submit" value="완료">
</form:form>


</body>
</html>