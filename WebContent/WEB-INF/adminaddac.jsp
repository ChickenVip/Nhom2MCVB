<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<title>Thêm tài khoản</title>
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
			<%@ include file="wa_admintool.jsp" %>
    </div>
    
    <div class="col-sm-9 col-md-9 col-xs-12">
	<div class="row">
	<br />
    <div class="panel panel-primary">
	  <div class="panel-heading">
	    <h3 class="panel-title"></h3><center>THÊM TÀI KHOẢN</center></h3>
	  </div>
	 
	  <div class="panel-body">  
		<form class="form-horizontal" action="adminaddac" method="post">
		  
		  <div class="form-group">
		    <label class="col-sm-4 ">Tài khoản</label>
		    <div class="col-sm-8">
		      <input type="email" class="form-control"  name="Auser" placeholder="Nhập tên tài khoản"></input>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label class="col-sm-4 ">Cấp quyền</label>
		    <div class="col-sm-8">
		      <input type="number" class="form-control"  name="Arole" placeholder="Nhập cấp quyền"></input>
		    </div>
		  </div>

		  <div class="form-group">
		    <label class="col-sm-4 ">Mã nhân viên</label>
		    <div class="col-sm-8">
		      <input class="form-control" type="text" name="Apid" placeholder="Nhập mã nhân viên"></input>
		    </div>
		  </div>

		  <div class="form-group">
		    <label class="col-sm-4 ">Tên nhân viên</label>
		    <div class="col-sm-8">
		      <input class="form-control" type="text" name="Aname" placeholder="Nhập tên nhân viên"></input>
		    </div>
		  </div>

		  <div class="form-group">
		    <label class="col-sm-4 ">Tuổi</label>
		    <div class="col-sm-8">
		      <input class="form-control" type="number" name="Aage" placeholder="Nhập tuổi"></input>
		    </div>
		  </div>	
		  
  		  <div class="form-group">
		    <label class="col-sm-4 ">Số điện thoại</label>
		    <div class="col-sm-8">
		      <input class="form-control" type="number" name="Aphone" placeholder="Nhập số điện thoại"></input>
		    </div>
		  </div>
  		   
  		  <div class="form-group">
		    <label class="col-sm-4 ">Số CMND</label>
		    <div class="col-sm-8">
		      <input class="form-control" type="number" name="Aidc" placeholder="Nhập số CMND"></input>
		    </div>
		  </div>
  		  
  		  <div class="form-group">
		    <label class="col-sm-4 ">Địa chỉ</label>
		    <div class="col-sm-8">
		      <input class="form-control" type="text" row="3" name="Aadd" placeholder="Nhập địa chỉ"></input>
		    </div>
		  </div>
		  
		<%
		String err = request.getParameter("err");
		if ("1".equals(err)) {
			out.print("<center><b><h5 style=\"color: red;\"><b>Điền đầy đủ thông tin</b><span class=\"glyphicon glyphicon-remove\"></span></h5></b></center>");
		}
		else if ("2".equals(err)) {
			out.print("<center><b><h5 style=\"color: red;\"><b>Thêm thất bại.Lỗi rồi</b><span class=\"glyphicon glyphicon-remove\"></span></h5></b></center>");
		}
		else if ("3".equals(err)) {
			out.print("<center><b><h5 style=\"color: green;\"><b>Thêm thành công</b><span class=\"glyphicon glyphicon-ok\"></span></h5></b></center>");
		}
		%>
		<center><input class="btn btn-primary" type="submit" name="Aacc" value="Xác nhận"></input></center>
		
		</form>
	  </div>
	  
	  
	  
	</div>	
	</div>
	</div>
	</div>
	</div>
</div>

<%@ include file="wa_footer.jsp"%>
</body>
</html>