<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<section class="row">
		<div class="col mt-4">
			<div class="card">
				<div class="card-header">List Videos</div>
				<a href="/admin/accounts/add">Add Video</a>
				<div class="card-body">
					<!-- Hiển thông báo -->
					<c:if test="${message != null}">
						<div class="alert alert-primary" role="alert">
							<i>${message}</i>
						</div>
					</c:if>
					<!-- Hêt thông báo -->
					<table class="table table-striped table-responsive">
						<thead class="thead-inverse">
							<tr>
								<th>Video ID</th>
								<th>Title</th>
								<th>Description</th>
								<th>URL</th>
								<th>Status</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${videos}" var="video">
								<tr>
									<td scope="row">${video.videoId}</td>
									<td>${video.title}</td>
									<td>${video.description}</td>
									<td>${video.url}</td>
									<td>${video.status}</td>
									<td><a href="/admin/videos/view/${video.videoId}"
										class="btn btn-outline-info"><i class="fa fa-info"></i></a> <a
										href="/admin/videos/edit/${video.videoId}"
										class="btn btn-outline-warning"><i class="fa fa-edit"></i></a>
										<a href="/admin/videos/delete/${video.videoId}"
										class="btn btn-outline-danger"><i class="fa fa-trash"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="card-footer text-muted">
					<nav aria-label="...">
						<ul class="pagination">
							<li class="page-item disabled"><span class="page-link">Previous</span>
							</li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item active" aria-current="page"><span
								class="page-link">2</span></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#">Next</a>
							</li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</section>
</body>
</html>

