<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String cp = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로그램 소개</title>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
$(function(){
	$("#header").load("/include/header");
	$("#footer").load("/include/footer");
});
</script>

</head>
<body>
	<!-- Load header -->
	<div id="header"></div>
	
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
	
	<!-- Load footer -->
	<div id="footer"></div>
	
</body>
</html>