<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<title>Minh chứng</title>
<style>

body {
	padding-top: 10px;
}
</style>
</head>
<body>
<script type="text/javascript"	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">	</script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

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
	<li><a href="Home"><span class="glyphicon glyphicon-home"></span> TRANG CHỦ</a></li>
	<li><a href="Introduce"><span class="glyphicon glyphicon-book"></span> GIỚI THIỆU</a></li>
	<li><a href="News"><span class="glyphicon glyphicon-signal"></span> TIN TỨC</a></li>
	<li class="active"><a href="Document"><span class="glyphicon glyphicon-list-alt"></span> MINH CHỨNG</a></li>
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
			<ul class="child">

					
					<c:forEach items="${entries }" var="entry">
					
						<div class="panel panel-default">
						<div class="panel-body">
						<div class="col-md-2 col-sm-2 col-xs-12">
						<a href="Content?id=${entry.id }"><img src="${entry.coimg }" class="img-thumbnail" alt="Responsive image"></img></a>
						</div>
						<div class="col-md-9 col-sm-9 col-xs-12">
							<a href="Content?id=${entry.id }">
							<h5><span style="color: blue">${entry.title }</span></h5>
							<h6><i>Time: ${entry.date }</i></h6>
							</a>
						</div>
						<div class="col-md-1 col-sm-1 col-xs-12">
							<br/>
							<br/>
							<br/>
							<br/>
							<rigth>
							<form method="get" action="DownloadFile">
								<input class="hide" name="file" value="${entry.content }"></input>
								<button name="btnDown" type="submit"><span class="glyphicon glyphicon-download-alt"></span></button>
							</form>
							</right>
						</div>
						</div>
						</div>
					
					</c:forEach>
					<center>
					<nav aria-label="Page navigation">
					  <ul class="pagination">
					    <li>
						    <c:choose>
							<c:when test="${selectPage == 1}">
								<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
							</c:when>
							<c:otherwise>
								<li> <a href="Document?page=${selectPage - 1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
							</c:otherwise>
							</c:choose>		

					      </a>
					    </li>
							<c:forEach var = "i" begin="1" end="${page }">
								<c:choose>
								<c:when test="${selectPage == i}">
									<li class="active"><a href="#">${i }</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="Document?page=${i }">${i } </a></li>
								</c:otherwise>
								</c:choose>							
							</c:forEach>
					    <li>
						    <c:choose>
	   						<c:when test="${selectPage == page}">
								<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a></li>
							</c:when>
							<c:otherwise>
								 <li><a href="Document?page=${selectPage + 1}" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a></li>
							</c:otherwise>
							</c:choose>				     
					        
					      </a>
					    </li>
					  </ul>
					</nav>
					</center>

				</ul>
		</div>

		<%@ include  file ="wa_slidebar.jsp"%>
	</div>
	</div>
	</div>

	<%@include file="wa_footer.jsp" %>


</body>
</html>