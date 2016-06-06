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
	<div class="panel panel-default">

		<div class="panel-heading" style="text-align: center;">
			<h3 class="panel-title">修改书籍信息</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" id="signupForm" action="/bookup"
				method="post" novalidate="novalidate">
				<input name="id" value="${book.id}" type="hidden">
				<div class="form-group">
					<label class="col-sm-4 control-label" for="code">书号</label>
					<div class="col-sm-5">
						<input name="code" class="form-control" id="code" type="text"
							placeholder="请输入卡号" value="${book.code}">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label" for="title">书名</label>
					<div class="col-sm-5">
						<input name="title" class="form-control" id="title" type="text"
							placeholder="请输入书名" value="${book.title}">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label" for="author">作者</label>
					<div class="col-sm-5">
						<input name="author" class="form-control" id="author" type="text"
							placeholder="请输入作者" value="${book.author}">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label" for="pb">出版社</label>
					<div class="col-sm-5">
						<input name="pb" class="form-control" id="pb" type="text"
							placeholder="请输入出版社" value="${book.publishing}">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="total">总量</label>
					<div class="col-sm-5">
						<input name="total" class="form-control" id="total" type="text"
							placeholder="请输入总量" value="${book.total}">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label" for="count">余量</label>
					<div class="col-sm-5">
						<input name="count" class="form-control" id="count" type="text"
							placeholder="请输入余量" value="${book.count}">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-9 col-sm-offset-4">
						<button name="signup" class="btn btn-primary" type="submit"
							value="保存">保存</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$("#cardhome").addClass("active");
		})
	</script>
</body>
</html>