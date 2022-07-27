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
	<form action="transfer3" method="post">
		보내는이 : ${withdrawCustomerName}<br>
		보내는이 계좌 : ${withdrawAccNum}<br>
		
		받는이 : ${depositCustomerName}<br>
		받는이 계좌 : ${depositAccNum}<br>
		
		금액 : ${money}<br>
		
		승인 하려면 비밀번호를 입력하세요
		<input type="password" name="passwd" required="required"/>
		<button type="submit">승인</button>
		<button type="button" onclick='location.href="<c:url value='/account/transfer1'/>"'>취소</button>
	</form>
</body>
</html>