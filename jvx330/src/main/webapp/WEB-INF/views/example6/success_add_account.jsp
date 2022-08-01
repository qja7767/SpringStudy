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
<h3>계좌 신청 완료되었습니다.</h3>

<label>계좌번호</label> : ${account.accountNum}<br>
<label>계좌타입</label> : ${account.accType}<br>
<label>고객정보</label> : ${account.customer.email}<br>
<label>계좌잔액</label> : ${account.balance}<br>

</body>
</html>