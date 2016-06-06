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
	<div class="panel panel-default">
	
		<div class="panel-heading" style="text-align: center;">
			<h3 class="panel-title">修改借书卡信息</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" id="signupForm" action="/cardup"
				method="post" novalidate="novalidate">
				<input name="id" value="${card.id}" type="hidden">
				<div class="form-group">
					<label class="col-sm-4 control-label" for="code">卡号</label>
					<div class="col-sm-5">
						<input name="code" class="form-control" id="code"
							type="text" placeholder="请输入卡号" value="${card.code}">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label" for="name">姓名</label>
					<div class="col-sm-5">
						<input name="name" class="form-control" id="name" type="text"
							placeholder="请输入姓名" value="${card.name}">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label" for="tel">电话</label>
					<div class="col-sm-5">
						<input name="tel" class="form-control" id="tel" type="text"
							placeholder="请输入电话" value="${card.tel}">
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