<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FoodBot</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap Core CSS -->
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- Plugin CSS -->
<link href="/resources/vendor/magnific-popup/magnific-popup.css"
	rel="stylesheet">

<!-- Theme CSS -->
<link href="/resources/css/creative.min.css" rel="stylesheet">

<link rel="stylesheet" href="/resources/css/login-form.css" />
<link rel="stylesheet" href="/resources/css/login.css" />
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />



<style>
#mainNav {
	color: black;
}

</style>
</head>
<!-- jQuery 2.1.4 -->
<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>

<body>

	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> Menu <i
						class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand page-scroll" href="/">Food Bot</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<%
						if (session.getAttribute("login") != null) {
					%>
					<li><a class="page-scroll" href="/member/logout">LogOut</a></li>
					<%
						}
					%>
					<li><a class="" href="/about/intro">About</a></li>
					<li><a class="" href="/">채팅</a></li>
					<li><a class="" href="/myinfo/info">내정보</a></li>
					<li><a class="" href="/help/qna">문의</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
		<!-- jQuery -->
	<script src="/resources/vendor/jquery/jquery.min.js"></script>

	<script src="/resources/js/jquery-1.11.3.min.js"></script>
	<script src="/resources/js/jquery-ui.min.js"></script>
	<script src="/resources/js/check.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="/resources/vendor/scrollreveal/scrollreveal.min.js"></script>
	<script
		src="/resources/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

	<!-- Theme JavaScript -->
	<script src="/resources/js/creative.min.js"></script>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	
</body>