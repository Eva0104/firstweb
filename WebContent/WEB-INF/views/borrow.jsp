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
	padding-top: 50px;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}
</style>
</head>

<body>
	<%@ include file="nav.jsp"%>
		<div class="bs-example" data-example-id="hoverable-table">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>编号</th>
					<th>书籍编号</th>
					<th>借书卡编号</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="borrow" items="${requestScope.list}">
				<tr>
					<th>${borrow.id}</th>
					<td>${borrow.bid}</td>
					<td>${borrow.cid}</td>
					<td>
					<button data="${borrow.id}" type="button" class="btn btn-danger btn-xs">删除</button>
					<button data="${borrow.id}" type="button" class="btn btn-success btn-xs">修改</button>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="panel panel-default">
		<div class="panel-heading" style="text-align: center;">
			<h3 class="panel-title">借书</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" id="signupForm" action="/borrow"
				method="post" novalidate="novalidate">
				<div class="form-group">
					<label class="col-sm-4 control-label" for="code">卡号</label>
					<div class="col-sm-5">
						<input name="code" class="form-control" id="code"
							type="text" placeholder="请输入卡号">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label" for="name">书籍编号</label>
					<div class="col-sm-5">
						<input name="name" class="form-control" id="name" type="text"
							placeholder="请输入书籍编号">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-9 col-sm-offset-4">
						<button name="signup" class="btn btn-primary" type="submit"
							value="借阅">借阅</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$("#borrow").addClass("active");
		})
	</script>
</body>
</html>