<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<script type="text/javascript" src="../../jQuery/jquery-3.4.1.min.js"></script>
	<title>Cinguetter - UserManager</title>
</head>
<body>
		<jsp:include page="nav_bar.jsp"></jsp:include>
		<div class="row col-lg-12 col-md-12 col-sm-12">
			
			<div class="col-lg-3 col-md-3 col-sm-3">
			</div>
			
			<div class="col-lg-6 col-md-6 col-sm-6">
	 			<h1>My Profile</h1>
	 			
				<form action="index.html" method="post">
				
				  	<label for="name">Name</label>
				  	<input type="text" id="name" name="name" <c:if test= "${not empty user}">value="${user.name}"</c:if>/>
				    <label for="surname">Surname</label>
			  		<input type="text" id="surname" name="surname" <c:if test= "${not empty user}">value="${user.surname}"</c:if>/> 
			  		<label for="email">email</label>
				  	<input type="text" id="email" name="email" <c:if test= "${not empty user}">value="${user.email}"</c:if>/> 
				  	<label for="password">password</label>
				  	<input type="password" id="password" name="password" />
				  	<label for="urlImageProfile">URL Image Profile</label>
					<input type="text" id="urlImageProfile" name="urlImageProfile" <c:if test= "${not empty user}">value="${user.urlImageProfile}"</c:if>/> 
				  	<label for="birthday">Birthday</label>
				  	<input type="text" id="birthday" name="birthday" <c:if test= "${not empty user}">value="${user.birthday}"</c:if>/> 
					 	
					<button type="submit"><c:choose><c:when test="${not empty user}">Modify</c:when><c:otherwise>Register</c:otherwise></c:choose></button>
				
	 			</form>
	 		
			</div>
			
			<div class="col-lg-3 col-md-3 col-sm-3">
			</div>
			</div>
</body>
</html>