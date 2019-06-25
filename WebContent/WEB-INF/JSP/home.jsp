<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="view/css/page_style.css">
		<link rel="stylesheet" type="text/css" href="view/css/button_style.css">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<script type="text/javascript" src="../../jQuery/jquery-3.4.1.min.js"></script>
		<title>Cinguetter - Home</title>
	</head>
	<body>
		<c:set var="pageType" scope="request" value="HOME"/> <%-- Questa variabile ci serve per capire in che opagina siamo per evidenziare nel menu la pagina corrispondente  --%>
		<c:set var="logged" scope="request" value="${true}"/> <%-- Se siamo nella pagina di Home, siamo già loggati quindi per forza true --%>
		<jsp:include page="nav_bar.jsp"></jsp:include>
		
		<%-- Aggiungere la funzionalità responsive con bootstrap: vedi login --%>
		
		<form action="home.html" method="post">
			<h1 for="cinguett_text"> Add Cinguett </h1>
			<textarea name="cinguett_text" rows="4" cols="50"></textarea>
			<button type="submit" class="rounded btn-sample sign">Send</button>
		</form>
		
	</body>
</html>