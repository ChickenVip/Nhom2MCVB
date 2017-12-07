<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<title>Đổi mật khẩu</title>
<style>
body {
	padding-top: 10px;
}
</style>
</head>

<body>
	<script type="text/javascript"	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">	</script>
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
<a class="navbar-brand" href="#">ADMIN</a>
</div>

<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
<ul class="nav navbar-nav">
	<li><a href="Home"><span class="glyphicon glyphicon-home"></span> TRANG CHỦ</a></li>
	<li><a href="Introduce"><span class="glyphicon glyphicon-book"></span> GIỚI THIỆU</a></li>
	<li><a href="News"><span class="glyphicon glyphicon-signal"></span> TIN TỨC</a></li>
	<li><a href="Document"><span class="glyphicon glyphicon-list-alt"></span> MINH CHỨNG</a></li>
</ul>
<ul class="nav navbar-nav navbar-right">
	<li><img src="${info.avartar}" alt="No avatar" height= "43" width="43" class="img-thumbnail" /></li>
	<li><a href="admin"> ${info.name}</a></li>
	<li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Thoát</a></li>
</ul>
</div>
</nav>
</div>
</div>
</div>
</div>

<div id="wrapper">
	<div class="container">
	<div class="row">
	
	<div class="col-xs-6 col-sm-3 sidebar-offcanvas"  role="navigation">
	<nav class="navbar">
    <div class="sidebar-nav">
        <ul class="nav">
            <li><a href="admin">Thông tin cá nhân</a></li>
            <li><a href="admincp">Đổi mật khẩu</a></li>
            <li class="nav-divider"></li>
            <li><a href="adminmc">Danh sách minh chứng</a></li>
            <li><a href="adminadddoc">Thêm minh chứng</a></li> 
            <li class="nav-divider"></li>
            <li><a href="admintt">Danh sách tin tức</a></li>
            <li><a href="adminadd">Viết bài mới</a></li>
            <c:if test="${account.role > 5 }">
            <li class="nav-divider"></li>
            <li><a href="adminac">Danh sách tài khoản</a></li>
            <li><a href="adminaddac">Thêm tài khoản</a></li>
            </c:if>
        </ul>
    </div>
	</nav>
    </div>

	<div class="col-sm-9 col-md-9 col-xs-12">
	<div class="row">
	<br />

		<div class="panel panel-primary">
	  <div class="panel-heading">
	    <h3 class="panel-title"></h3><center>DANH SÁCH TÀI KHOẢN</center></h3>
	  </div>
	  </div>
	  
	<%
	String err = request.getParameter("err");
	if ("1".equals(err)) {
		out.print("<center><b><h5 style=\"color: red;\"><b>Lỗi rồi </b><span class=\"glyphicon glyphicon-remove\"></span></h5></b></center>");
	}
	else if("0".equals(err)){
		out.print("<center><b><h5 style=\"color: green;\"><b>ResetPass thành công </b><span class=\"glyphicon glyphicon-ok\"></span></h5></b></center>");
	}
	%>
	
	<table class="table table-bordered">
	<thread>	
		<tr>
			<th>Tài khoản</th>
			<th>Quyền</th>
			<th>Reset Pass</th>
		</tr>
	</thread>	
	<tbody>
		<c:forEach items="${acco}" var="row">			
			<tr>	
				<td><c:out value="${row.user}"></c:out></td>
				<td><c:out value="${row.role}"></c:out></a></td>
				<td>
					<center>
					<form method="post" action="adminac">
					<input class="hide" name="userid" value="${row.user }"></input>
					<button type="submit" name="btnEdit" class="btn btn-default">
				 	<span class="glyphicon glyphicon-repeat">
					</button>
					</form>
					</center>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	 		 
	</table>
	
	</div>
	</div>
	</div>	
	</div>
</div>

<%@ include file="wa_footer.jsp"%>
</body>
</html>