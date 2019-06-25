<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="view/css/login_style.css">
		<link rel="stylesheet" type="text/css" href="view/css/button_style.css">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<script type="text/javascript" src="../../jQuery/jquery-3.4.1.min.js"></script>
		<title>Cinguetter - Home</title>
	</head>
	<body>
		<c:set var="pageType" scope="request" value="login"/>
		<c:set var="logged" scope="request" value="${true}"/>
		<jsp:include page="nav_bar.jsp"></jsp:include>
		
		<div id="form"  class="border border-light p-5 rounded" >
	 		<h1>Login</h1>
			<form action="home.html" method="post">
				<div>
				  	<label for="cinguett">My Cinguett</label>
				  	<input type="text" id="cinguett" name="cinguett" class="form-control mb-4"/> 
				</div>
				<button type="submit" class="rounded btn-sample sign">Post</button>
			</form>
			<form action="home.html" method="post">
				<div>
				  	<label for="comment">Write a Comment</label>
				  	<input type="text" id="comment" name="comment" class="form-control mb-4"/>
			  	</div>
			  	<button type="submit" class="rounded btn-sample sign">Send</button>
			</form>	
		</div>
	</body>
</html>