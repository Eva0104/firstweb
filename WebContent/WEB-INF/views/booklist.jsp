<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>Starter Template for Bootstrap</title>

<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	padding-top: 60px;
	padding-left: 20px;
	padding-right: 20px;
	background-color: lightblue;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}
</style>
</head>

<body>
	<%@ include file="nav.jsp"%>
	<h3>共${list.size()}种书</h3>
	<form class="navbar-form navbar-left" role="search" method="get">
		<div class="form-group">
			<input class="form-control" type="text" placeholder="Search" name="wd">
		</div>
		<button class="btn btn-default" type="submit">查找</button>
	</form>
	<a type="button" class="btn btn-primary" href="/bookadd"
		style="float: right">新增书籍</a>
	<div class="bs-example" data-example-id="hoverable-table">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>编号</th>
					<th>书号</th>
					<th>书名</th>
					<th>作者</th>
					<th>出版社</th>
					<th>总量</th>
					<th>余量</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${requestScope.list}">
					<tr>
						<th>${book.id}</th>
						<td>${book.code}</td>
						<td>${book.title}</td>
						<td>${book.author}</td>
						<td>${book.publishing}</td>
						<td>${book.total}</td>
						<td>${book.count}</td>
						<td>
							<button data="${book.id}" type="button"
								class="btn btn-danger btn-xs">删除</button>
							<button data="${book.id}" type="button"
								class="btn btn-success btn-xs">修改</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script>
		$(function() {
			$("#bookhome").addClass("active");
			$("td>button.btn-danger").click(function() {
				if (confirm("确认删除吗？")) {
					var id = $(this).attr("data");
					location.href = "/bookdel?id=" + id;
				}
			});
			$("td>button.btn-success").click(function() {
				var id = $(this).attr("data");
				location.href = "/bookup?id=" + id;
			});
		});
	</script>
</body>
</html>