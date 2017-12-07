<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<title>Upload Tool</title>
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
<div class="row">
	<br />
	<div class="panel panel-warning">
	  <div class="panel-heading">
	    <h3 class="panel-title"></h3><center>UPLOAD FILE TOOL</center></h3>
	  </div>
	  
	  <div class="panel-body">
	
	
        <form class="form-horizontal" method="post" action="Upload" enctype="multipart/form-data">
            <input type="file" name="uploadFile" />
          	<br />

			<div class="col-md-offset-1 col-md-9">
			<div class="input-group form-group">
				<span class="input-group-btn">
					<button type="submit" class="btn btn-primary" style="vertical-align:top;">Lấy link &emsp;<span class="glyphicon glyphicon-link" ></span></button>
				</span>
				<input id="sc" class="form-control js-copytext" type="text" value="${msg }"></input>
			</div>
			</div>
        </form>	
  
  		<span class="input-group-btn">
			<button type="submit" class="btn btn-info js-copybtn" style="vertical-align:top;">Sao chép &ensp;<span class="glyphicon glyphicon-file"></span></button>
		</span>
	
        <br />
 
	</div>
	</div>
	    <script>
	    	function copy() {
		      document.querySelector('.js-copytext').select();	  
		      document.execCommand('copy');

		    }	
		    document.querySelector('.js-copybtn').addEventListener('click',copy );    
	    </script>
	    
</div>
</div>		
</div>



</body>
</html>