<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<form action ="/admin/videos/save" method="post">
	<input type="hidden" value="${video.isEdit}" name="isEdit">
	<input type="hidden" value="${video.videoId}" name="videoId">
	<label>Title</label><br>
	<input type="text" name="title" value="${video.title}" ><br>
	<label>Description</label><br>
	<input type="text" name="description" value="${video.description }"><br>
	<label>URL</label><br>
	<input type="text" name="url" value="${video.url }" ><br>
	<label>Status</label><br>
	<input type="text" name="status" value="${video.status }" ><br>

	<c:if test="${video.isEdit }">
		<input type="submit" value="Update">
	</c:if>
	<c:if test="${!video.isEdit }">
		<input type="submit" value="Insert">
	</c:if>
</form>