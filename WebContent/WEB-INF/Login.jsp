<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<%-- <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/webdevelopment" user="root" password="1234"/>

<c:if test="${not empty param.login}">
	<sql:query var="rs" dataSource="${db}" sql="select * from account where username='${param.username}' and pass='${param.password}'" />
	<c:if test="${rs.rowCount > 0}">
		<c:set var="user" value="${param.username}" scope="session" />
		<c:redirect url="admin" />
	</c:if>
</c:if>	 --%>


	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<title>Đăng nhập</title>

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
<a class="navbar-brand" href="#">NHÓM 2</a>
</div>

<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
<ul class="nav navbar-nav">
	<li><a href="Home"><span class="glyphicon glyphicon-home"></span> TRANG CHỦ</a></li>
	<li><a href="Introduce"><span class="glyphicon glyphicon-book"></span> GIỚI THIỆU</a></li>
	<li><a href="News"><span class="glyphicon glyphicon-signal"></span> TIN TỨC</a></li>
	<li><a href="Document"><span class="glyphicon glyphicon-list-alt"></span> MINH CHỨNG</a></li>
</ul>
<ul class="nav navbar-nav navbar-right">
	<li class="active"><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
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
<div class="content col-md-9 col-sm-9 col-xs-12">
	
	<p>&nbsp</p>
	<p>&nbsp</p>
	<div class="main-container">
	<div class="col-md-7 col-md-offset-2">
		<div class="panel panel-default">
		<div class="panel-heading">Đăng nhập</div>
		<div class="panel-body">
			<form class="form-horizontal" action="Login" method="post">
			
			<div class="form-group">
			<label for="inputEmail3" class="col-md-3 control-label ">Email</label>
			<div class="col-md-9">
			<input  type="email" class="form-control" placeholder="Email" name="username" />
			</div>
			</div>
			
			<div class="form-group">
			<label for="inputPassword3" class="col-md-3 control-label">Mật khẩu</label>
			<div class="col-md-9">
			<input  type="password" class="form-control" placeholder="Password" name="password" />
			</div>
			</div> 
				<%
				String err = request.getParameter("err");
				if ("1".equals(err)) {
					out.print("<center><b><h5 style=\"color: red;\"><b> Đăng nhập thất bại. Kiểm tra lại tài khoản và mật khẩu </b><span class=\"glyphicon glyphicon-remove\"></span></h5></b></center>");
				}
				%>
			<div class="form-group">
			<div class="col-md-offset-5 col-md-10">
			<input type="submit" class="btn btn-default" name="login" value="Đăng nhập" />
			</div>
			</div>
			
			</form>
		</div>
		</div>
	</div>
	</div>
</div>
		
	<%@include file="wa_slidebar.jsp"%>
</div>
</div>
</div>
	
<%@include file="wa_footer.jsp"%>


</body>
</html>