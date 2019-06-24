<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; pageEncoding=UTF-8"%><!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/layout.css">
	<title></title>
</head>
<body>
	<nav class="row">
	<div>
		<img id="logo" src="view/Resources/logo.png" width="40" alt="logo Cinguetter" title="logoCinguetter">
		<h4 id="title"> Cinguetter</h4>
		</div>
	<div>
	<%--INSERIRE IL LOGO A SINISTRA DELLA NAVBAR --%>
	<c:choose>
		<c:when test="${pageType=='HOME'}">
				<a class="navlink">Home</a>
		</c:when>
		<c:otherwise><a  class="navlink">Home</a></c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${logged==true}">
			<c:choose>
				<c:when test="${pageType=='MYPROFILE'}">
					<a class="navlink">My Profile</a>
				</c:when>
				<c:otherwise><a  class="navlink">My Profile</a></c:otherwise>
			</c:choose>
		</c:when>
			<c:when test="${logged==false}">
			<c:choose>
				<c:when test="${pageType=='MYPROFILE'}">
										<a href="usermanager.html" class="">Sign Up</a>

				</c:when>
								<c:otherwise><a href="usermanager.html">Sign Up</a></c:otherwise>

			</c:choose>
		</c:when>
		</c:choose>
	<c:choose>
		<c:when test="${logged==false}">
				<a href="index.html" class="navlink"><button class="">Login</button></a>
		</c:when>
		<c:when test="${logged==true}">
				<a href="index.html" class="navlink"><button class="">Logout</button></a>
		</c:when>	
	</c:choose>
	</div>
	</nav>
</body>
</html>