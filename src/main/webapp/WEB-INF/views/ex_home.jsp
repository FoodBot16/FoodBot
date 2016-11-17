<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<% String cp = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<link href="<%=cp%>/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=cp%>/resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">

<title>Title</title>


<style>
div {
	border: 1px solid red;
}

body {
	position:relative;
	height : 2000px;
}
.brand {
    position:absolute;
    left:45%;
    }

.navbar-inner   {
  height:150px;
  border: 5px solid blue;
  background-color:white;
}
.navbar-inverse {
  background-color:white;
}
.navbar {
background-color:white;
}
</style>
<title>Main</title>
</head>
<body>

 
	<div class="navbar navbar-inverse ">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#/"><h1>Food Bot</h1></a>
			</div>
		</div>
	</div>


	<div class="container-fluid">

		<div class="row-fluid hero-unit">
			<h2>1조를 벌자</h2>
		</div>

		<div class="row-fluid">
			<div class="span3">채팅하는곳</div>
			<div class="span7">

				<script>result();</script>
			</div>
			<div class="row-fluid">
				<div class="span12 offset3 result">
		

				</div>
			</div>
		</div>
		
        <div class=" hero-unit navbar-fixed-bottom">
            <p>문의번호 : 010-123-4567</p>
        </div>
            
	</div>
	<script src="<%=cp%>/resources/js/jquery.js"></script>
	<script src="<%=cp%>/resources/bootstrap/js/bootstrap.min.js"></script>
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
    $(".brand").click(function() {
      $.ajax({
        url:'./home.html',
        success:function(data) {
        $(".span7").html(data);
        $(".result").html("");
        }
        })
    });
    $(".home").click(function() {
      $.ajax({
        url:'./home.jsp',
        success:function(data) {
        $(".span7").html(data);
        $(".result").html("");
        }
        })
    });
    $(".faq").click(function() {
      $.ajax({
        url:'./ex2.html',
        success:function(data) {
        $(".span7").html(data);
        }
        })
      });
    $(".ml").click(function() {
      $.ajax({
        url:'./ml.html',
        success:function(data) {
        $(".span7").html(data);
        }
        })
      });
  
  </script>
</body>
</html>