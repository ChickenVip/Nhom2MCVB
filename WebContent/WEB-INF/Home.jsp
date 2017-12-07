<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<title>Trang chủ</title>
<style>
body {
	padding-top: 10px;
}
</style>
</head>

<body>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<header> 

<div class="container">
<div class="row">
<div class="logo col-md-6 col-sm-6 col-xs-12">
	<a href="Home"  title="Trang chủ"><img src="./img/logo-news.png" class="img-responsive" alt="Responsive image"></img></a>
</div> 
<div class="search col-md-6 col-sm-6 col-xs-12 text-right">
<form method="get" action="#">
	<p>&nbsp</p>
	<input type="text" placeholder="Nhập vào từ khóa" id="q" name="q" value=""> <input type="submit" value="Tìm kiếm">
</form>
</div>
<div class="clearfix"></div>
</div>
</div>

<div class="container">
<div class="row">
<div class="logo col-md-12 col-sm-12 col-xs-12">
<div class="header-menu">
<nav class="navbar navbar-inverse">
<div class="navbar-header">
<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
<span class="sr-only">Toggle navigation</span>
<span class="icon-bar"></span> 
<span class="icon-bar"></span> 
<span class="icon-bar"></span>
</button>
<a class="navbar-brand" href="#">NHÓM 2</a>
</div>

<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
<ul class="nav navbar-nav">
	<li class="active"><a href="Home"><span class="glyphicon glyphicon-home"></span> TRANG CHỦ</a></li>
	<li><a href="Introduce"><span class="glyphicon glyphicon-book"></span> GIỚI THIỆU</a></li>
	<li><a href="News"><span class="glyphicon glyphicon-signal"></span> TIN TỨC</a></li>
	<li><a href="Document"><span class="glyphicon glyphicon-list-alt"></span> MINH CHỨNG</a></li>
</ul>
<ul class="nav navbar-nav navbar-right">
<c:if test="${empty sessionScope.info }">
	<li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
</c:if>
<c:if test="${not empty sessionScope.info }">
	<li><img src="${info.avartar}" alt="No avatar" height= "43" width="43" class="img-thumbnail" /></li>
	<li><a href="admin"> ${info.name}</a></li>
	<li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Thoát</a></li>
</c:if>
</ul>
</div>
</nav>
</div>
</div>
</div>
</div>

</header>


<div id="wrapper">
<div class="container">
<div class="row">
<div class="content col-md-9 col-sm-9 col-xs-12">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>


<div class="carousel-inner" role="listbox">	
	<c:forEach  items="${titHome }" var="tn" varStatus="count">
	<c:choose>
	<c:when test="${count.index == 0}">
	<div class="item active">
	</c:when>
	<c:otherwise>
	<div class="item">
	</c:otherwise>
	</c:choose>
	
	<center>
	<a href="Content?id=${tn.id}"><img src="${tn.coimg }" alt="Responsive image" width="850" height="500"></a>
	</center>
	<div class="carousel-caption"> 
	<center><h4>${tn.title }</h4></center> 
	</div>
	</div>
	</c:forEach>
</div>


	<a class="left carousel-control" href="#myCarousel"	data-slide="prev"> 
	<span class="glyphicon glyphicon-chevron-left"></span> <span class="sr-only">Previous</span>
	</a> <a class="right carousel-control" href="#myCarousel" data-slide="next"> 
	<span class="glyphicon glyphicon-chevron-right"></span> <span class="sr-only">Next</span>
	</a>
</div>
			
<hr>
<div class="row">
<div class="col-sm-6 col-md-6">
<div class="thumbnail">
<div class="caption">
<div class="alert alert-success" role="alert"><a href="News" class="alert-link"><center><b>TIN TỨC - SỰ KIỆN</b></center></a></div>
</div>
<img  src="./img/HomeTTSK.jpg" class="img-thumbnail" alt="Responsive image">
<hr>
<ul class="tinkhac">
	<c:forEach items ="${titNew}" var ="titn">			
		<li><span style="color: black"><a href="Content?id=${titn.id}">${titn.title} <span style="color: gray"><small><i>${titn.date}</i></small></span></a></span></li>	
	</c:forEach>
</ul>
<p>	<a href="News" class="btn btn-primary" role="button">Xem thêm >></a></p>
</div>
</div>

<div class="col-sm-6 col-md-6">
<div class="thumbnail">
<div class="caption">
<div class="alert alert-danger" role="alert"><a href="Document" class="alert-link"><center><b>MINH CHỨNG - VĂN BẢN</b></center></a></div>
</div>
<img  src="./img/HomeMCVB.jpg" width="340" class="img-thumbnail" alt="Responsive image">
<hr>
<ul class="tinkhac">
	<c:forEach items ="${titDoc}" var ="titd">			
		<li><span style="color: black"><a href="Content?id=${titd.id}">${titd.title} <span style="color: gray"><small><i>${titd.date}</i></small></span></span></a></span></li>	
	</c:forEach>
</ul>
<p>	<a href="Document" class="btn btn-primary" role="button">Xem thêm >></a></p>
</div>
</div>
</div>	
</hr>
</div>
	<%@ include file="wa_slidebar.jsp"%>
</div>
</div>
</div>

<%@include file="wa_footer.jsp" %>

</body>

</html>