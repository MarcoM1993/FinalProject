<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="view/css/style.css">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<script type="text/javascript" src="../../jQuery/jquery-3.4.1.min.js"></script>
	<title>Cinguetter - Login</title>
</head>
<body>
		<jsp:include page="nav_bar.jsp"></jsp:include>
		<div class="row col-lg-12 col-md-12 col-sm-12">
			
			<div class="col-lg-3 col-md-3 col-sm-3">
			</div>
			
			<div class="col-lg-6 col-md-6 col-sm-6">
	 			<h1>Login</h1>
	 			
	 			<c:if test="${not empty Error}">
	 				<div  class="alert alert-danger" role="alert">
	 					${Error}
	 				</div>
	 			</c:if>
	 			
				<form action="index.html" method="post">
			  	<label for="email">Email</label>
			  	<input type="text" id="email" name="email"/> 
			  	<label for="password">Password</label>
			  	<input type="password" id="password" name="password"/>
				<button type="submit">Sign In</button>
			
	 			</form>
	 		 	<a href="usermanager.html">
	 				<button>Sign Up</button>
	 			</a>
			</div>
			
			<div class="col-lg-3 col-md-3 col-sm-3">
			</div>
			</div>
</body>
</html>