<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>URL</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
%>
<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="/webjars/font-awesome/5.12.0/css/all.css" />

</head>
<body>
	<div class="container-fluid p-5">
	<h3 class="text-center jumbotron">Alterar URL</h3>

	<div class="alert alert-info">
	<a href="#" class="close" data-dismiss="alert">x</a>
	<i class="fas fa-info-circle mr-2"></i>${msg}
	</div>
	
	
	<form method="post" action="/editar/alterar" id="formUrl">
		
		<br/>ID<br/>
		<input type="number" name="idurl" id="idurl" size="10"  required="required" value="${url.idurl}" readonly/>	
			
		<br/>URL<br/>
		<input id="url" name="url" type="text" value="${url.url}"  required class="form-control"/>
		<br /> URL Encurtada: <span id="shortUrl"></span>
		<input type="hidden" value="" id="shorturl_hidden" name="shorturl_hidden" required> <br />
	</form>
	
	<button onClick="getShortUrl()" class="btn btn-info mt-2">Gerar nova URL</button>
	<button id="btnSubmit" class="btn btn-sucess mt-2">Alterar</button>
	<a href="/" class="btn btn-danger mt-2">Voltar</a>
	
	
	</div>
	

	
</body>

<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="/js/main.js"></script>

</html>