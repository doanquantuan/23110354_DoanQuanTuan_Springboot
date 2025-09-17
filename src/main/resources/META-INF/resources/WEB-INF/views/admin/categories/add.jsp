<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<form action ="/admin/categories/save" method="post">
	<input type="hidden" value="${category.isEdit}" name="isEdit">
	<input type="hidden" value="${category.categoryId }" name="categoryId">
	
	<label>Category name</label><br>
	<input type="text" name="categoryName" value="${category.categoryName }" ><br>
	
	<label>Images</label><br>
	<input type="text" name="images" value="${category.images }"><br>
	
	<label>User ID</label><br>
	<input type="text" name="userid" value="${category.userId }" ><br>
    
	<label>Status</label><br>
	<input type="text" name="status" value="${category.status }" ><br>
	
	<c:if test="${category.isEdit }">
		<input type="submit" value="Update">
	</c:if>
	<c:if test="${!category.isEdit }">
		<input type="submit" value="Insert">
	</c:if>
</form>