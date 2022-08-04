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
	
	<c:forEach var="view" items="${menuItemList}">
		메뉴 리스트
		<li>=========================</li>
		<li>상위 카테고리 : ${view.cateCodeRef}</li>
		<li>하위카테고리 : ${view.cateCode}</li>
		<li>상품 이름 : ${view.menuName}</li>
		<li>상품 가격 : ${view.menuPrice}</li>
		<li>상품 정보 : ${view.menuInfo}</li>
		<li>이미지 이름 : ${view.imgName}</li>
		<li>이미지 소스 : ${view.imgSource}</li>
		<li>이미지 유알엘 : ${view.imgUrl}</li>
		<li>이미지 코드 : ${view.imgCode}</li>		
		<a href="update_menu_item?menuName=${view.menuName}">수정하기</a>
		<li><img style="width: 300px; height: 300px;" alt="img_area"
		 src="<c:url value='/resources/upload_img/${view.imgSource}.jpg'/>">		 
		 </li>
	</c:forEach>
</body>
</html>