<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="view" items="${accountList}">
		<li>=========================</li>
		<li>이메일(이메일아이디) : ${view.emailid}</li>
		<li>비밀번호 : ${view.accountNum}</li>
		<li>이름 : ${view.accType}</li>
		<li>주민등록번호 : ${view.balance}</li>
		<li>전화번호 : ${view.regDate}</li>
	</c:forEach>
</body>
</html>