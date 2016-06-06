<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">图书管理系统</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li id="home"><a href="/home">首页</a></li>
				<li id="cardhome"><a href="/cardhome">借书卡管理</a></li>
				<li id="bookhome"><a href="/bookhome">图书管理</a></li>
				<li id="borrow"><a href="/borrow">借书/还书管理</a></li>
				<li><a href="#contact">其他</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">${sessionScope.userName}登录<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">个人信息</a></li>
						<li><a href="#">修改密码</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="/userexit">安全退出</a></li>
					</ul></li>
						<li><a href="#">当前在线人数:${applicationScope.count}</a></li>
			</ul>
		</div>
	</div>
</nav>