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
	background-color: #686686;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}
</style>
</head>

<body>
	<%@ include file="nav.jsp"%>
	<div class="panel panel-default">
		<div class="panel-heading" style="text-align: center;">
			<h3 class="panel-title">添加书籍</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" id="signupForm" action="/bookadd"
				method="post" novalidate="novalidate">
				<div class="form-group">
					<label class="col-sm-4 control-label" for="code">书号</label>
					<div class="col-sm-5">
						<input name="code" class="form-control" id="code"
							type="text" placeholder="请输入书号">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label" for="title">书名</label>
					<div class="col-sm-5">
						<input name="title" class="form-control" id="title" type="text"
							placeholder="请输入书名">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label" for="author">作者</label>
					<div class="col-sm-5">
						<input name="author" class="form-control" id="author" type="text"
							placeholder="请输入电话">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="pb">出版社</label>
					<div class="col-sm-5">
						<input name="pb" class="form-control" id="pb" type="text"
							placeholder="请输入出版社">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="total">出版社</label>
					<div class="col-sm-5">
						<input name="total" class="form-control" id="total" type="text"
							placeholder="请输入总量">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-9 col-sm-offset-4">
						<button name="signup" class="btn btn-primary" type="submit"
							value="提交">提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$("#bookhome").addClass("active");
		})
	</script>
</body>
</html>