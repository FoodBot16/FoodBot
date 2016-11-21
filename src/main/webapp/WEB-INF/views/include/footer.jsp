<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.main-footer {
	background: #E4E4E4;
	margin-left: none;
	z-index: 990;
}

.footer {
	padding: 2%;
}

.footer ul {
	list-style-type: none;
}

.footer li {
	padding: 1%;
	display: inline-block;
}

.container a {
	color: #806468;
}

.bottom {
	padding-top: 1%;
	padding-bottom: 4%;
	padding-left: 25%;
	color: "#788396";
}

@media only screen and (max-width: 480px) {
	.bottom {
		padding-left: 0;
	}
	#img {
		display: block;
		padding-bottom: 10px;
		margin: 0 auto;
	}
	.bottom-ul li {
		display: list-item;
	}
}

span:lang(en) {
	font-family: "Arial Black", Gadget, sans-serif;
}

</style>
<footer class="main-footer">
	<div class="footer">
		<div class="container-ul" align="center">
			<ul>
				<li><a href="">뭐라할까</a></li>
				<li><a href="">이메일무단수집 거부</a></li>
				<li><a href="">팀 소개</a></li>
				<li><a href="/etc/privacy">개인정보취급방침</a></li>
			</ul>
		</div>
		<div class="bottom">
			<ul class="bottom-ul">
				<li><img id="img" alt=""
					src="/resources/img/banner/logo.png" width="150px" height="50px"></li>
				<li>회사명 : 1조를벌자<br> 주소: 서울특별시 성북구 삼선교로 16길 116 <br>
				<strong><span lang="en">Copyright </span> &copy; 2016 1조를벌자. <br> <span lang="en">All rights reserved.</span>
				</strong>
				</li>
			</ul>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(window).resize(function() {
			var width = window.innerWidth;
			if(width <= 583){
				$('.container-ul').css("font-size", '13px');
				
			} else {
				$('.container-ul').css("font-size", '18px');
			}
		});
	</script>

</footer>
