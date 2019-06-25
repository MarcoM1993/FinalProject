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
		<div class="row col-lg-12 col-md-12 col-sm-12">
			
			<div class="col-lg-3 col-md-3 col-sm-3">
			</div>
			
			<div class="col-lg-6 col-md-6 col-sm-6 ">
				
		
		<%-- Aggiungere la funzionalità responsive con bootstrap: vedi login --%>
		
		
		<div id="form" class="border border-light p-5 rounded">
			<form action="home.html" method="post" style="display:inline">
				<h3 id="label_add_text" for="cinguett_text">Add Cinguett:</h3>
				<textarea name="cinguett_text" rows="4" cols="50" class="form-control mb-4"></textarea>   <%-- Regola CSS: resize: none; --%>
				<button type="submit" class="rounded btn-sample sign">Post</button>
			</form>
		</div>
		
			<c:forEach var="cinguett" items="${cinguettList}">  <%-- --%>
			
		
		<div class="cinguett border border-light p-5 rounded">
			<div id="user_info">
			    <img src="${userMap.get(cinguett.userId).urlImageProfile}"> 
				<label id="label_user_name"> ${userMap.get(cinguett.userId).name} ${userMap.get(cinguett.userId).surname} </label>
			</div>
			<div id="cinguett_text">
				<p> ${cinguett.text} </p>
			</div>
			<div id="comments">
				<h6>Comments:</h6>
					
						<c:forEach var="comment" items="${commentsMap.get(cinguett.id)}">
							<div>
								<img src="${userMap.get(comment.userId).urlImageProfile}"> 
								<p> ${comment.text}</p>
							</div>
						</c:forEach>
			</div>
	        <form action="home.html" method="post">
	        	<label id="label_add_comment" for="comment_text">Add comment:</label>
	        	<input type="hidden" name="cinguettId" value="${cinguett.id}"/>
				<textarea name="comment_text" rows="2" cols="30" class="form-control mb-4"></textarea>
				<button type="submit" class="rounded btn-sample sign comment">Send</button>	
			</form>
		</div>
		</c:forEach>
		
			</div>
			
			<div class="col-lg-3 col-md-3 col-sm-3">
			</div>
		</div>
		
		
	</body>
</html>