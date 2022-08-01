<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button type="button" onclick='location.href="<c:url value='/pages/add_category'/>"'>최상위 메뉴분류</button><br>
	<button type="button" onclick='location.href="<c:url value='/pages/add_category2'/>"'>하위 메뉴분류</button><br>	
	
	<form action="find_all_category" method="post">			
    <button type="submit" class="btn btn-outline-secondary" type="button">찾기</button>
	</form>
</body>
</html>