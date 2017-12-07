<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<title>footer</title>
	<style >
		body {
			padding-top: 10px;
	}
	</style>
</head>
<body>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">	</script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

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
	
		
</body>
</html>