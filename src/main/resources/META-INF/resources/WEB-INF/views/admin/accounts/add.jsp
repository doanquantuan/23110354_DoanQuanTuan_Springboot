<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<form action ="/admin/accounts/save" method="post">
	<input type="hidden" value="${user.isEdit}" name="isEdit">
	<input type="hidden" value="${user.userId}" name="userId">
	<label>User name</label><br>
	<input type="text" name="username" value="${user.username}" ><br>
	<label>Password</label><br>
	<input type="text" name="password" value="${user.password }"><br>
	<label>Full name</label><br>
	<input type="text" name="fullname" value="${user.fullName }" ><br>
	<label>Email</label><br>
	<input type="text" name="email" value="${user.email }" ><br>
	<label>Role ID</label><br>
	<input type="number" name="roleid" value="${user.roleId }" ><br>
	<label>Phone</label><br>
	<input type="text" name="phone" value="${user.phone }" ><br>
	<c:if test="${user.isEdit }">
		<input type="submit" value="Update">
	</c:if>
	<c:if test="${!user.isEdit }">
		<input type="submit" value="Insert">
	</c:if>
</form>