<%@page import="org.foodbot.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<% String cp = request.getContextPath(); %>
<% HttpSession session = request.getSession(); %>
<% MemberVO memberVO = (MemberVO)session.getAttribute("login"); %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>FoodBot</title>
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
.login {
	position: absolute;
	top: 200px;
	left: 35%;
	width: 700px;
	height: 550px;
}

.well {
	width: 30%;
	height: 500px;
}
.board {
  position:relative;
  left:-15%;
  width : 130%;
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
				<a class="navbar-brand page-scroll" href="#page-top">Food Bot</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
				  <% if(session.getAttribute("login") != null) { %>
				    <li><a class="page-scroll" href="member/logout">LogOut</a></li>
				  <%} %>
					<li><a class="page-scroll" href="#about">About</a></li>
					<li><a class="page-scroll" href="#services">채팅</a></li>
					<li><a class="" href="/myinfo/info">내정보</a></li>
					<li><a class="page-scroll" href="#contact">문의</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>


	<ul class="bxslider">
		<li><img src="<%=cp%>/resources/img/header4.jpg" />
			<h2>채팅</h2></li>
		<li><img src="<%=cp%>/resources/img/header4.jpg" />
			<h2>내정보</h2></li>
		<li><img src="<%=cp%>/resources/img/header4.jpg" /></li>
	</ul>


<% if(session.getAttribute("login") == null) { %>
	<div class="login">
		<section class="logincontainer">
			<article class="half">
				<h1>Food Bot</h1>
				<div class="tabs">
					<span class="tab signin active"><a href="#signin">Sign
							in</a></span>
				</div>
				<div class="content">
					<form action="member/login" method="post">
						<input type="email" name="uid" id="login__email" class="inpt"
							required="required" placeholder="Your email"> <label
							for="email">Your email</label> <input type="password"
							name="password" id="login__password" class="inpt"
							required="required" placeholder="Your password"> <label
							for="password">Your password</label>

						<div class="submit-wrap">
							<input type="submit" value="Sign in" class="submit">
						</div>

						<p class="text--center">
							Not a member? <a
								class="initialism fadeandscale_open btn btn-success"
								href="#fadeandscale"> Sign up now</a>
						</p>
					</form>
				</div>
			</article>
		</section>
	</div>

	<div id="fadeandscale" class="well">
		<h1>Sign Up!</h1>

		<form action="/member/regist" method="post" class="form form--registration">

			<div class="form__field1">
				<label class="fontawesome-envelope-alt" for="login__username"><span
					class="hidden">Email</span></label> <input id="Register_email"
					name="uid" type="text" class="form__input" placeholder="Email"
					required> <span id="mail_check" class="check_image"></span>
			</div>
			<div class="form__field1">
				<label class="fontawesome-user" for="login__username"><span
					class="hidden">name</span></label> <input id="Register_name" name="uname"
					type="text" class="form__input" placeholder="이름" required>
				<span id="name_check" class="check_image"></span>
			</div>
			<div class="form__field1">
				<label class="fontawesome-lock" for="login__username"><span
					class="hidden">Password</span></label> <input id="Register_password"
					name="password" type="password" class="form__input"
					placeholder="비밀번호" required> <span id="pass_check"
					class="check_image"></span>
			</div>

			<div class="form__field1">
				<label class="fontawesome-lock" for="login__username"><span
					class="hidden">Password</span></label> <input id="Register_password1"
					name="password1" type="password" class="form__input"
					placeholder="비밀번호 확인" required> <span id="pass1_check"
					class="check_image"></span>
			</div>

			성별 <select name="sex" class="styled">
				<option value="man">남성</option>
				<option value="woman">여성</option>

			</select> <br>
			<button class="btn btn-default" onclick="valid_check()">회원가입</button>
			<button class="fadeandscale_close btn btn-default">취소</button>

		</form>

	</div>
	<%} %>
	
	<!-- 
	<section class="bg-primary" id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 text-center">
					<h2 class="section-heading">We've got what you need!</h2>
					<hr class="light">
					<p class="text-faded">Start Bootstrap has everything you need
						to get your new website up and running in no time! All of the
						templates and themes on Start Bootstrap are open source, free to
						download, and easy to use. No strings attached!</p>
					<a href="#services"
						class="page-scroll btn btn-default btn-xl sr-button">Get
						Started!</a>
				</div>
			</div>
		</div>
	</section>

	<section id="services">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">At Your Service</h2>
					<hr class="primary">
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box">
						<i class="fa fa-4x fa-diamond text-primary sr-icons"></i>
						<h3>Sturdy Templates</h3>
						<p class="text-muted">Our templates are updated regularly so
							they don't break.</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box">
						<i class="fa fa-4x fa-paper-plane text-primary sr-icons"></i>
						<h3>Ready to Ship</h3>
						<p class="text-muted">You can use this theme as is, or you can
							make changes!</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box">
						<i class="fa fa-4x fa-newspaper-o text-primary sr-icons"></i>
						<h3>Up to Date</h3>
						<p class="text-muted">We update dependencies to keep things
							fresh.</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box">
						<i class="fa fa-4x fa-heart text-primary sr-icons"></i>
						<h3>Made with Love</h3>
						<p class="text-muted">You have to make your websites with love
							these days!</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	
	 <section class="no-padding" id="portfolio">
        <div class="container-fluid">
            <div class="row no-gutter popup-gallery">
                <div class="col-lg-4 col-sm-6">
                    <a href="img/portfolio/fullsize/1.jpg" class="portfolio-box">
                        <img src="img/portfolio/thumbnails/1.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="img/portfolio/fullsize/2.jpg" class="portfolio-box">
                        <img src="img/portfolio/thumbnails/2.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="img/portfolio/fullsize/3.jpg" class="portfolio-box">
                        <img src="img/portfolio/thumbnails/3.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="<%=cp%>/resources/img/portfolio/fullsize/4.jpg" class="portfolio-box">
                        <img src="<%=cp%>/resources/img/portfolio/thumbnails/4.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="<%=cp%>/resources/img/portfolio/fullsize/5.jpg" class="portfolio-box">
                        <img src="<%=cp%>/resources/img/portfolio/thumbnails/5.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="img/portfolio/fullsize/6.jpg" class="portfolio-box">
                        <img src="img/portfolio/thumbnails/6.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </section>


    <aside class="bg-dark">
        <div class="container text-center">
            <div class="call-to-action">
                <h2>Free Download at Start Bootstrap!</h2>
                <a href="http://startbootstrap.com/template-overviews/creative/" class="btn btn-default btn-xl sr-button">Download Now!</a>
            </div>
        </div>
    </aside>

 
-->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">Let's Get In Touch!</h2>
                    <hr class="primary">
                    <p>Ready to start your next project with us? That's great! Give us a call or send us an email and we will get back to you as soon as possible!</p>
                </div>
                <div class="col-lg-4 col-lg-offset-2 text-center">
                    <i class="fa fa-phone fa-3x sr-contact"></i>
                    <p>123-456-6789</p>
                    
                </div>
                <div class="col-lg-4 text-center">
                    <i class="fa fa-envelope-o fa-3x sr-contact"></i>
                    <p><a href="mailto:your-email@your-domain.com">feedback@startbootstrap.com</a></p>
                </div>
                
            </div>
            <div class="board"></div>
            <div class="chat"></div>
            <div class="chat2"></div>
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
  
  
    var windowWidth = $( window ).width();
    var windowHeight = $( window ).height();
    $( window ).resize(function() {
        windowWidth = $( window ).width();
        windowHeight = $( window ).height();
    });
    
    
    var height = $(document).scrollTop();
    if(height < 50) {
      $("body").css({'top':'0px'});
    } else {
      $("body").css({'top':'-160px'});
    } 
    $(window).scroll(function() {
        var height = $(document).scrollTop();
        console.log(height);
        if(height < 50) {
          $("body").css({'top':'0px'});
        } else {
          $("body").css({'top':'-160px'});
        }
    });
    
  </script>
	<script>
   

        
   $(document).ready(function(){
    $('.bxslider').bxSlider({
    	  auto: true,
    	  autoControls: true
    });
    
    
    
    $.ajax({
        url:'sboard/simpleList',
        success:function(result){
          $('.board').html(result);
      }
    });
  
    // 채팅 로드
    $.ajax({
        url:'chat/chat-ws',
        success:function(result){
          console.log("result: " + result);
          $('.chat').html(result);
      }
    });
   /*
    // 채팅 로드
    $.ajax({
        url:'chat/chatting',
        success:function(result){
          console.log("result: " + result);
          $('.chat2').html(result);
      }
    });
    */
    	  $.fn.popup.defaults.pagecontainer = '.logincontainer';

    	    $('#basic').popup();

    	  $('#fadeandscale').popup({
    	    height:1000, 
    	    width:800,
    	    pagecontainer: '.logincontainer',
    	    transition: 'all 0.5s'

    	  });


    	  $("#Register_email").keyup(function(){

    	    var email = $("#Register_email").val();

    	    if(email != 0)
    	    {
    	      if(isValidEmailAddress(email)) {  
    	        $("#mail_check").css({"background": "url('<%=cp%>/resources/image/ok.png') no-repeat center", "backgroundSize":"30px"});
    	      } else {
    	        $("#mail_check").css({"background": "url('<%=cp%>/resources/image/no.png') no-repeat center", "backgroundSize":"30px"});
    	      }
    	    } else {
    	      $("#mail_check").css({
    	        "background-image": "none"
    	      });     
    	    }

    	  });

    	  $("#Register_password").keyup(function(){

    	    var pass = $("#Register_password").val();
    	    var reg_pwd = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;

    	    if(pass != 0)
    	    {
    	      if(reg_pwd.test(pass)) {  
    	        $("#pass_check").css({"background": "url('<%=cp%>/resources/image/ok.png') no-repeat center", "backgroundSize":"30px"});
    	      } else {
    	        $("#pass_check").css({"background": "url('<%=cp%>/resources/image/no.png') no-repeat center", "backgroundSize":"30px"});
    	      }
    	    } else {
    	      $("#pass_check").css({
    	        "background-image": "none"
    	      });     
    	    }

    	  });

    	  $("#Register_password1").keyup(function(){

    	    var pass = $("#Register_password").val();
    	    var pass1 = $("#Register_password1").val();

    	    if(pass != 0)
    	    {
    	      if(pass == pass1) { 
    	        $("#pass1_check").css({"background": "url('<%=cp%>/resources/image/ok.png') no-repeat center", "backgroundSize":"30px"});
    	      } else {
    	        $("#pass1_check").css({"background": "url('<%=cp%>/resources/image/no.png') no-repeat center", "backgroundSize":"30px"});
    	      }
    	    } else {
    	      $("#pass1_check").css({
    	        "background-image": "none"
    	      });     
    	    }

    	  });

    	  $("#Register_num").keyup(function(){

    	    var num = $("#Register_num").val();
    	    var num_check = /^[0-9]+$/;

    	    if(num != 0)
    	    {
    	      if(num_check.test(num)) { 
    	        $("#num_check").css({"background": "url('<%=cp%>/resources/image/ok.png') no-repeat center", "backgroundSize":"30px"});
    	      } else {
    	        $("#num_check").css({"background": "url('<%=cp%>/resources/image/no.png') no-repeat center", "backgroundSize":"30px"});
    	      }
    	    } else {
    	      $("#num_check").css({
    	        "background-image": "none"
    	      });     
    	    }

    	  });


    	  function isValidEmailAddress(emailAddress) {
    	    var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
    	    return pattern.test(emailAddress);
    	  }

    	
});
    </script>
    
    
</body>

</html>
