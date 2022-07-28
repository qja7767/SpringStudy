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
	
	<form action="transfer1" method="post">
		<p>${userId}님</p>
		<p>${userId}님의 현재 보유 계좌목록</p> 
	
	<c:forEach var="view" items="${accountList}">
		<li>=========================</li>
		<li>계좌코드(aid) : ${view.aid}</li>
		<li>계좌 번호 : ${view.accountNum}</li>
		<li>계좌 타입 : ${view.accType}</li>
		<li>계좌 잔액 : ${view.balance}</li>
		<li>계좌 개설일 : ${view.regDate}</li>
		<li>=========================</li>
	</c:forEach>
	
		<label>출금계좌</label><input type="text" name="withdrawAccNum" required="required"><br>
		<label>입금계좌</label><input type="text" name="depositAccNum" required="required"><br>
		<label>금액</label><input type="text" name="money" required="required"><br>
		<input type="submit" value="확인"/>
	</form>
			
</body>
</html>