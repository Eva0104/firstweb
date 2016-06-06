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
	background-color: #986986;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}
</style>
</head>

<body>
	<%@ include file="nav.jsp"%>
	<a type="button" class="btn btn-primary" href="/cardadd" style="float: right">新增借书卡</a>
	<div class="bs-example" data-example-id="hoverable-table">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>编号</th>
					<th>卡号</th>
					<th>姓名</th>
					<th>电话</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="card" items="${requestScope.list}">
				<tr>
					<th>${card.id}</th>
					<td>${card.code}</td>
					<td>${card.name}</td>
					<td>${card.tel}</td>
					<td>
					<button data="${card.id}" type="button" class="btn btn-danger btn-xs">删除</button>
					<button data="${card.id}" type="button" class="btn btn-success btn-xs">修改</button>
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
			$("#cardhome").addClass("active");
			$("td>button.btn-danger").click(function(){
				if(confirm("确认删除吗？")){
					var id = $(this).attr("data");
					location.href="/cardel?id=" + id;
				}	
			});
			$("td>button.btn-success").click(function(){
					var id = $(this).attr("data");
					location.href="/cardup?id=" + id;
			});
		});
	</script>
</body>
</html>