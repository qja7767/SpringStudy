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
	<style>
	.container {
		width: 100%;
		height: 100%;		
	}
	.content {
		justify-content: center;
		text-align: center;
		margin-top: 100px;
	}
	
	btn {
		margin-bottom: 10px; 
	}	
	</style>
	<jsp:include page="/resources/css/incl/header.jsp"/>
	<link rel="stylesheet" href="<c:url value='/resources/css/custom/custom.css'/>">
	<div class="container">
		<div class="content">
		
	<h3>관리시스템(Admin)</h3>
	<button class="btn" type="button" onclick='location.href="<c:url value='/pages/add_category'/>"'>최상위 메뉴 추가</button><br>
	<button class="btn" type="button" onclick='location.href="<c:url value='/pages/add_category2'/>"'>하위 메뉴 추가</button><br>		
	<button class="btn" type="button" onclick='location.href="<c:url value='/pages/add_menu_item'/>"'>상품 추가</button><br>
	<button class="btn" type="button" onclick='location.href="<c:url value='/pages/add_img'/>"'>상품 이미지 등록</button><br>
	<form action="find_all_category" method="post">			
    <button class="btn" type="submit" class="btn btn-outline-secondary">모든 등록 카테고리 찾기</button>
	</form>
	<form action="find_all_menu_item" method="post">
    <button class="btn" type="submit" class="btn btn-outline-secondary">모든 등록 상품 찾기</button>
    </form>
    <form action="find_all_menu_image" method="post">
    <button class="btn" type="submit" class="btn btn-outline-secondary">모든 등록 상품 이미지 코드 찾기</button>
    </form>   	
		</div>
	</div>	   	   	
</body>
</html>