<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<title>Giới thiệu</title>
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
	<li><a href="Home"><span class="glyphicon glyphicon-home"></span> TRANG CHỦ</a></li>
	<li class="active"><a href="Introduce"><span class="glyphicon glyphicon-book"></span> GIỚI THIỆU</a></li>
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
					<div>&nbsp</div>
					<span style="color:blue"><h3><b>QUÁ TRÌNH PHÁT TRIỂN</b></h3></span>
					<div style="text-align:center;"><span style="color :blue"><b>Vài nét về lịch sử</b></div>
					<div style="text-align: justify">Trường đại học Sư phạm Kỹ thuật Tp. Hồ Chí Minh được hình thành và phát triển trên cơ sở Ban Cao đẳng Sư phạm Kỹ thuật 
					- thành lập ngày 05.10.1962. Ngày 21.9.1972, Trường được đổi tên thành Trung tâm Cao đẳng Sư phạm Kỹ thuật Nguyễn Trường Tộ Thủ Đức 
					và được nâng cấp thành Trường đại học Giáo dục Thủ Đức vào năm 1974.
					Ngày 27.10.1976, Thủ tướng Chính phủ đã ký quyết định thành lập Trường đại học Sư phạm Kỹ thuật Thủ Đức
					trên cơ sở Trường đại học Giáo dục Thủ Đức. Năm 1984, Trường đại học Sư phạm Kỹ thuật Thủ Đức hợp nhất với
					Trường trung học Công nghiệp Thủ Đức và đổi tên thành Trường đại học Sư phạm Kỹ thuật Tp. Hồ Chí Minh. 
					Năm 1991, Trường đại học Sư phạm Kỹ thuật Tp. Hồ Chí Minh sát nhập thêm Trường Sư phạm Kỹ thuật 5 và phát triển cho đến ngày nay.
					Nằm ở cửa ngõ phía bắc Tp. Hồ Chí Minh, cách trung tâm thành phố khoảng 10 km, tọa lạc tại số 1 Võ Văn Ngân, quận Thủ Đức, 
					Trường đại học Sư phạm Kỹ thuật Tp. Hồ Chí Minh tập hợp được các ưu điểm của một cơ sở học tập rộng rãi, 
					khang trang, an toàn, nằm ở ngoại ô nhưng giao thông bằng xe bus vào các khu vực của thành phố, 
					đến sân bay và các vùng lân cận rất thuận tiện.</div>
					<div>&nbsp</div>
					
					<div style="text-align:center;"><span style="color :blue"><b>Chức năng, nhiệm vụ</b></span></div>
					<div style="text-align: justify">Đào tạo và bồi dưỡng giáo viên kỹ thuật cho các trường đại học, cao đẳng, trung cấp chuyên nghiệp và dạy nghề, 
					các trường phổ thông trung học.</div>
					<br/>• Đào tạo đội ngũ kỹ sư công nghệ và bồi dưỡng nguồn nhân lực lao động kỹ thuật thích ứng với thị trường lao động.
					<br/>• Nghiên cứu khoa học và phục vụ sản xuất trên các lĩnh vực giáo dục chuyên nghiệp và khoa học công nghệ.
					<br/>• Quan hệ hợp tác với các cơ sở khoa học và đào tạo giáo viên kỹ thuật ở nước ngoài.
					<div>&nbsp</div>
					
					<div style="text-align:center;"><span style="color :blue"><b>Chính sách chất lượng</b></span></div>
					<div style="text-align: justify">Không ngừng nâng cao chất lượng dạy, học, nghiên cứu khoa học nhằm cung cấp cho người học những điều kiện tốt nhất để 
					phát triển toàn diện các năng lực, đáp ứng nhu cầu phát triển kinh tế, xã hội của đất nước và hội nhập quốc tế.</div>
					<div>&nbsp</div>
					
					<div style="text-align:center;"><span style="color :blue"><b>Thành tích của trường</b></span></div>
					<div style="text-align: justify">Với những nỗ lực to lớn của nhiều thế hệ, Trường Đại học Sư phạm Kỹ thuật Tp. Hồ Chí Minh 
					đã vững bước phát triển về mọi mặt. Trường đã được Đảng và Nhà nước dành cho những phần thưởng cao quý:
					Nhà trường được Chủ tịch nước tặng thưởng Huân chương Độc lập hạng ba (năm 2007), 
					Huân chương Lao động hạng Nhất (năm 2001), Huân chương Lao động hạng Nhì (năm 1996), 
					Huân chương Lao động hạng Ba (năm 1985).
					Đảng bộ trường được công nhận là “Đảng bộ Trong sạch - Vững mạnh - Xuất sắc” 13 năm liền (1995-2008).
					Công đoàn trường được Chủ tịch nước tặng thưởng Huân chương Lao động hạng Nhì (năm 2005), 
					Huân chương Lao động hạng Ba (năm 2000); Công đoàn ngành Giáo dục Việt Nam và 
					Liên đoàn Lao động thành phố Hồ Chí Minh tặng cờ “Công đoàn cơ sở Vững mạnh Xuất sắc” trong 12 năm liên tục.
					Đoàn Thanh niên được Chủ tịch nước tặng Huân chương Lao động hạng Ba năm 2004. 
					Đoàn Thanh niên và Hội sinh viên là đơn vị xuất sắc trong khối các trường ĐH, CĐ khu vực thành phố Hồ Chí Minh nhiều năm liền.
					Nhiều đơn vị và các nhân của trường được Chính phủ và Bộ Giáo dục và Đào tạo tặng bằng khen; 
					có 13 giáo viên được phong tặng danh hiệu Nhà giáo ưu tú và nhiều cán bộ, 
					viên chức được tặng Huy chương vì sự nghiệp Giáo dục.</div>
				</div>


	<%@include file="wa_slidebar.jsp" %>
</div>
</div>
</div>

<%@include file="wa_footer.jsp" %>


</body>
</html>