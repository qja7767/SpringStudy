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
<h3>신규 품목 추가</h3>
<form:form method="post" modelAttribute="menuItem">
	
	
	<label>카테고리 분류(대)</label><select name="cateCodeRef">
	<c:forEach var="view" items="${menuCategoryList}">
	<option value="${view.cateCodeRef}">${view.cateCodeRef}</option>							
	</c:forEach>
	</select><br>
	
	<label>카테고리 분류(소)</label><select name="cateCode">
	<c:forEach var="view" items="${menuCategoryList}">
	<option value="${view.cateCode}">${view.cateCode}</option>							
	</c:forEach>
	</select><br>
	
	<label>상품 이름</label>
	<form:input path="menuName"/><br>
	
	<label>상품 가격</label>
	<form:input path="menuPrice"/><br>
	
	<label>상품 번호(고유식별)</label>
	<form:input path="menuNum"/><br>
	
	<label>상품 재고</label>
	<form:input path="menuStock"/><br>
	
	<label>상품 정보</label>
	<form:input path="menuInfo"/><br>
	
	<label>상품 이미지 정보</label>
	<form:input type="file" path="menuImg"/><br>	
	
	<input type="submit" value="완료">
	<%=request.getRealPath("/") %>
</form:form>


</body>
</html>