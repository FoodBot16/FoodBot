<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ include file='../include/header.jsp' %>  --%>
<%@ page session="false"%>
<% String cp = request.getContextPath(); %>
<% HttpSession session = request.getSession(); %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>내 정보</title>
<!-- Bootstrap Core CSS -->
<link href="<%=cp%>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=cp%>/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- Plugin CSS -->
<link href="<%=cp%>/resources/vendor/magnific-popup/magnific-popup.css"
	rel="stylesheet">

<!-- Theme CSS -->
<link href="<%=cp%>/resources/css/creative.min.css" rel="stylesheet">

<!-- bxSlider CSS file -->
<link href="<%=cp%>/resources/css/jquery.bxslider.css" rel="stylesheet" />

<link href="<%=cp%>/resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<%=cp%>/resources/css/login-form.css" />
<link rel="stylesheet" href="<%=cp%>/resources/css/login.css" />
<link rel="stylesheet" href="<%=cp%>/resources/css/bootstrap.min.css" />


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style>

.infotitle {
	position: absolute;
	left : 47%;
	color: white;
	top: 100px;  
}
</style>
</head>

<body id="page-top">

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
					<% if(session.getAttribute("login") != null) { %>
					<li><a class="page-scroll" href="member/logout">LogOut</a></li>
					<%} %>
					<li><a class="" href="/about/intro">About</a></li>
					<li><a class="" href="">채팅</a></li>
					<li><a class="" href="/myinfo/info">내정보</a></li>
					<li><a class="" href="/help/qna">문의</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<img src="<%=cp%>/resources/img/header4.jpg" width="100%" height="70%" />
	<div class="infotitle">
		<section>
			<h1>내 정보</h1>
		</section>
	</div>
	

  <nav id="mainNav" class="navbar">
    <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed"
          data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
          <span class="sr-only">Toggle navigation</span> Menu <i
            class="fa fa-bars"></i>
        </button>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse"
        id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          
          <li><a  href="#about">내 정보</a></li>
          <li><a  href="#services">차트</a></li>
          <li><a  href="/myinfo/info">설문1</a></li>
          <li><a  href="#contact">설문2</a></li>
        </ul>
      </div>
      <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
  </nav>




	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 text-center">
					<h2 class="section-heading">Let's Get In Touch!</h2>
					<hr class="primary">
					<p>Ready to start your next project with us? That's great! Give
						us a call or send us an email and we will get back to you as soon
						as possible!</p>
				</div>
				<div class="col-lg-4 col-lg-offset-2 text-center">
					<i class="fa fa-phone fa-3x sr-contact"></i>
					<p>123-456-6789</p>

				</div>
				<div class="col-lg-4 text-center">
					<i class="fa fa-envelope-o fa-3x sr-contact"></i>
					<p>
						<a href="mailto:your-email@your-domain.com">feedback@startbootstrap.com</a>
					</p>
				</div>

			</div>
			<div class="board"></div>

		</div>
	</section>



	<!-- jQuery -->
	<script src="<%=cp%>/resources/vendor/jquery/jquery.min.js"></script>

	<script src="<%=cp%>/resources/js/jquery-1.11.3.min.js"></script>
	<script src="<%=cp%>/resources/js/jquery-ui.min.js"></script>
	<!-- <script src="<%=cp%>/resources/js/login.js"></script> -->
	<script src="<%=cp%>/resources/js/check.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<%=cp%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="<%=cp%>/resources/vendor/scrollreveal/scrollreveal.min.js"></script>
	<script
		src="<%=cp%>/resources/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

	<!-- Theme JavaScript -->
	<script src="<%=cp%>/resources/js/creative.min.js"></script>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<!-- bxSlider Javascript file -->
	<script src="<%=cp%>/resources/js/jquery.bxslider.min.js"></script>
	<script src="<%=cp%>/resources/js/jquery.bxslider.js"></script>

	<script src="<%=cp%>/resources/js/jquery.popupoverlay.js"></script>



	<script>
   

        
   $(document).ready(function(){


      
});
    </script>
</body>

</html>
