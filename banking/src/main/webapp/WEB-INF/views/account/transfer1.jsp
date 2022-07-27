<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>" />
</head>
<body>
	${userId}님
	
	<form action="transfer2" method="post">
		<label>나의 계좌번호</label><input type="text" name="accountNum" required="required"><br>
		<label>상대의 계좌번호</label><input type="text" name="accountNum1" required="required"><br>
		<input type="submit" value="확인"/>	
	</form>
		
</body>
</html>