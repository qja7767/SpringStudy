<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/resources/css/assets/dist/css/bootstrap.min.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/css_header/headers.css'/>">
</head>

<body>
	<jsp:include page="/resources/css/incl/header.jsp"/>
	${userId}님 안녕하세요<br>
	<button type="button" onclick='location.href="<c:url value='/account/add_account'/>"'>계좌 신청/조회 시스템</button><br>
	<button type="button" onclick='location.href="<c:url value='/login/logout'/>"'>로그아웃</button><br>
	<form action="account/view_account" method="post"><br>
		<input type="submit" value="TEST"/>
	</form>
</body>
</html>