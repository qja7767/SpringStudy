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
	${userId}님 안녕하세요<br>
	<button type="button" onclick='location.href="<c:url value='/account/add_account'/>"'>계좌 신청/조회 시스템</button><br>
	
	<form action="logout" method="get"><br>
		<input type="submit" value="로그아웃"/>
	</form>
	
	<form action="login/view_myinfo" method="post"><br>
		<input type="submit" value="내정보"/>
	</form>
	
</body>
</html>