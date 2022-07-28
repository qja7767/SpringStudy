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
${userId}님 계좌타입을 선택해 주세요.
<form action="add_account" method="post">
	<input type="text" name="accType"/>
	<input type="submit" value="신청"/>
</form>

<br>
이메일로 계좌찾기
<form action="find_account" method="post">
	<input type="submit" value="조회"/>
</form>

<br>
모든 가입유저 계좌찾기(관리자)
<form action="find_all_account" method="post">
	<input type="submit" value="조회"/>
</form>

<br>
송금 시스템(transfer)
<form action="transfer1" method="get">
	<input type="submit" value="송금"/>
</form>

<br>
입금
<form action="withdraw" method="get">
	<input type="submit" value="입금"/>
</form>

<br>
출금
<form action="deposit" method="get">
	<input type="submit" value="출금"/>
</form>

</body>
</html>