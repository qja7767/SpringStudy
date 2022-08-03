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
	<button type="button" onclick='location.href="<c:url value='/pages/add_category'/>"'>최상위 메뉴 추가</button><br>
	<button type="button" onclick='location.href="<c:url value='/pages/add_category2'/>"'>하위 메뉴 추가</button><br>		
	<button type="button" onclick='location.href="<c:url value='/pages/add_menu_item'/>"'>상품 추가</button><br>
	<button type="button" onclick='location.href="<c:url value='/pages/add_img'/>"'>이미지 업로드 TEST</button><br>
	<form action="find_all_category" method="post">			
    <button type="submit" class="btn btn-outline-secondary" type="button">모든 등록 카테고리 찾기</button>
	</form>
	<form action="find_all_menu_item" method="post">
    <button type="submit" class="btn btn-outline-secondary" type="button">모든 등록 상품 찾기</button>
    </form>
    <form action="find_all_menu_image" method="post">
    <button type="submit" class="btn btn-outline-secondary" type="button">모든 등록 상품 이미지 코드 찾기</button>
    </form>
   	<p><img src="<c:url value='/resources/upload_img/01b49a8f.jpg'/>" style="width:200px; height:200px;" ></p>   	
</body>
</html>