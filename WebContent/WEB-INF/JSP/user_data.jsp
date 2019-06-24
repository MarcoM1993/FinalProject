<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="view/css/login_style.css">
	<link rel="stylesheet" type="text/css" href="view/css/button_style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<script type="text/javascript" src="../../jQuery/jquery-3.4.1.min.js"></script>
	<title>Cinguetter - UserManager</title>
</head>
<body>
				<%-- Imposto le variabili che servono alla navbar per essere visualizzata nel modo corretto --%>
		<c:set var="pageType" scope="request" value="userData"/> <%-- Se sto generando questo jsp sono per forza nella pagina userData --%>
		<%-- Se sto richiamando questa jsp non sono per forza loggato e quindi devo verificarlo --%>
		<c:choose>
			<c:when test= "${not empty user}"> 
				<c:set var="logged" scope="request" value="${true}"/><%-- Se esiste un utente imposto la variabile logged a true --%>
			</c:when>
			<c:otherwise>
				<c:set var="logged" scope="request" value="${false}"/><%-- Se non esiste un utente imposto la variabile logged a false --%>
			</c:otherwise>
		</c:choose>
				
		
		<jsp:include page="nav_bar.jsp"></jsp:include>
		<div class="row col-lg-12 col-md-12 col-sm-12">
			
			<div class="col-lg-3 col-md-3 col-sm-3">
			</div>
			
			<div class="col-lg-6 col-md-6 col-sm-6">
			
				<div id="form" class="border border-light p-5 rounded">
		 			<h1>My Profile</h1>
		 			
					<form action="usermanager.html" method="post">
					
						<div>
					  	<label for="name">Name</label>
					  	<input type="text" class="form-control mb-4" id="name" name="name" <c:if test= "${not empty user}">value="${user.name}"</c:if>/>
					    </div>
					    <div>
					    <label for="surname">Surname</label>
				  		<input type="text" class="form-control mb-4" id="surname" name="surname" <c:if test= "${not empty user}">value="${user.surname}"</c:if>/> 
				  		</div>
					    <div>
				  		<label for="email">Email</label>
					  	<input type="email" class="form-control mb-4" id="email" name="email" <c:if test= "${not empty user}">value="${user.email}"</c:if>/> 
					  	</div>
					    <div>
					  	<label for="password">Password</label>
					  	<input type="password" class="form-control mb-4" id="password" name="password" />
					  	</div>
					    <div>
					  	<label for="urlImageProfile">URL Image Profile</label>
						<input type="text" class="form-control mb-4" id="urlImageProfile" name="urlImageProfile" <c:if test= "${not empty user}">value="${user.urlImageProfile}"</c:if>/> 
					  	</div>
					    <div>
					  	<label for="birthday">Birthday</label>
					  	<input type="date" class="form-control mb-4" id="birthday" name="birthday" <c:if test= "${not empty user}">value="${user.birthdayString}"</c:if>/> 
						</div>
					
			 			<c:if test="${not empty error}">
		 				<div  class="alert alert-danger" role="alert">
		 					${error}
		 				</div>
		 				</c:if>
					
						<button type="submit" class="rounded btn-sample btn-block btn-lg"><c:choose><c:when test="${not empty user}">Modify</c:when><c:otherwise>Register</c:otherwise></c:choose></button>
					
		 			</form>
	 			</div>
			</div>
			
			<div class="col-lg-3 col-md-3 col-sm-3">
			</div>
			</div>
</body>
</html>