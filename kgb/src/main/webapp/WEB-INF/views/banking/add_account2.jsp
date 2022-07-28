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
		<h3>유효 고객확인, 계좌 개설을 위한 추가정보를 기입바랍니다.</h3>
		<label>E-mail : </label><input type="text" name="email" value="${customer.email}" readonly><br>
		<label>cid : </label><input type="text" name="customerId" value="${customer.cid}"><br>
		<form action="add_account2" method="post">		
		<label>계좌번호(ex.000-00-0000)</label><input type="text" name="accountNum"><br>
		<label>타입(ex.SavingsAccount(S) or CheckingAccount(C))</label><input type="text" name="accType"><br>
		<label>잔액</label><input type="text" name="balance"><br>
		<input type="submit" value="계좌신청"/>
	</form>
</body>
</html>