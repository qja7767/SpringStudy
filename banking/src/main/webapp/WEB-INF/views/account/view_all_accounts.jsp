<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="view" items="${accountList}">
		<li>=========================</li>
		<li>계좌코드(aid) : ${view.aid}</li>
		<li>계좌 번호 : ${view.accountNum}</li>
		<li>계좌 타입 : ${view.accType}</li>
		<li>계좌 잔액 : ${view.balance}</li>
		<li>계좌 개설일 : ${view.regDate}</li>
	</c:forEach>
</body>
</html>