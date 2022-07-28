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
		<!--		
		<label>출금계좌</label><input type="text" name="withdrawAccNum" required="required"><br>
		-->
		<label>출금계좌(보내는이)</label><select name="withdrawAccNum">
	<c:forEach var="view" items="${accountList}">
		<option value="${view.accountNum}">${view.accountNum}</option>							
	</c:forEach>
		</select>
		<label>입금계좌(받는이)</label><input type="text" name="depositAccNum" required="required"><br>
		<label>금액</label><input type="text" name="money" required="required"><br>
		<input type="submit" value="확인"/>
	</form>
			
</body>
</html>