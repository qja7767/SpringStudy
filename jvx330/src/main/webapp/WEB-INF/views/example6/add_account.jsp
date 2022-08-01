<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>계좌신청</h3>
<form:form method="post" modelAttribute="account">
	<label>계좌 타입</label>	
		
		

		<input type="radio" name="accType" value="C"/>checkingAccount
		<input type="radio" name="accType" value="S"/>savingsAccount<br>
	
	<label>초기금액</label>
	<form:input path="balance"/><br>
	
	<input type="submit" value="계좌등록">		
	
</form:form>
	
</body>
</html>