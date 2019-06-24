<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; pageEncoding=UTF-8"%><!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="shortcut icon" href="view/Resources/favicon.ico" type="image/ico" /> 
	<link rel="stylesheet" type="text/css" href="view/css/nav_style.css">
	<link rel="stylesheet" type="text/css" href="view/css/button_style.css">
	<link rel="stylesheet" type="text/css" href="view/css/login_style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script type="text/javascript" src="../../jQuery/jquery-3.4.1.min.js"></script>
	<title></title>
</head>
<body>
	<nav class="navbar navbar-inverse mynav">
	<div class="container-fluid mynav">
		<div class="navbar-header myheader">
			<img class="navbar-brand" id="logo" src="view/Resources/logo.png" width="45" alt="logo Cinguetter" title="logoCinguetter">
			<h4 class="navbar-brand" id="title"> Cinguetter</h4>
		</div>
	<%--INSERIRE IL LOGO A SINISTRA DELLA NAVBAR --%>
		<ul class="nav navbar-right row" id="mylinks">
		<li>
			<a href="home.html" class="mynavlink <c:if test="$pageType == 'HOME'} "> active </c:if>  ">Home</a>
		</li>
		<li>
			<a href="usermanager.html" class="mynavlink <c:if test="$pageType == 'HOME'} "> active </c:if>"> 
																<c:choose> 
																<c:when test="${logged==true}">  My Profile</c:when>
																<c:otherwise> Sign Up</c:otherwise>
																</c:choose>
			</a>
		</li>
		<li >
				<a href="index.html" class="mynavlink <c:if test="$pageType == 'HOME'} "> active </c:if>"><button class="btn-sample rounded" id="loginButton"> 
																<c:choose>
																<c:when test="${logged==false}">Login</c:when>
																<c:otherwise>Logut</c:otherwise>
																</c:choose></button></a>
		</li>
	</ul>
	</div>
	</nav>
</body>
</html>