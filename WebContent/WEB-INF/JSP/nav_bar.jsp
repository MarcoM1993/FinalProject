<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; pageEncoding=UTF-8"%><!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/layout.css">
	<title></title>
</head>
<body>
	<nav>
	<%--INSERIRE IL LOGO A SINISTRA DELLA NAVBAR --%>
	<c:choose>
		<c:when test="${pageType=='HOME'}">
				<a class="">Home</a>
		</c:when>
		<c:otherwise><a>Home</a></c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${logged==true}">
			<c:choose>
				<c:when test="${pageType=='MYPROFILE'}">
					<a class="">My Profile</a>
				</c:when>
				<c:otherwise><a>My Profile</a></c:otherwise>
			</c:choose>
		</c:when>
			<c:when test="${logged==false}">
			<c:choose>
				<c:when test="${pageType=='MYPROFILE'}">
					<a class="">Sign Up</a>
				</c:when>
				<c:otherwise><a>Sign Up</a></c:otherwise>
			</c:choose>
		</c:when>
		</c:choose>
	<c:choose>
		<c:when test="${logged==false}">
				<a><button class="">Login</button></a>
		</c:when>
		<c:when test="${logged==true}">
				<a><button class="">Logout</button></a>
		</c:when>	
	</c:choose>
	</nav>
</body>
</html>