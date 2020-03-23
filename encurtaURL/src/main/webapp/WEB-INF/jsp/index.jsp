<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>

        <!-- adicionar essas duas tags sempre -->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Encurtador de URL</title>

        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
        %>
        <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
        <script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet"href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" />
        <link rel="stylesheet" href="/webjars/font-awesome/5.12.0/css/all.css" />

    </head>
    <body>
     <div class="row bg-dark">
                <div class="col-12">
                    <div class="text-center text-white my-3 pb-2">
                        <h2 class="p-1 fm-merienda-one">
                            Encurtador de Url Spring-Jsp
                        </h2>
                        
                    </div>
                </div>
                </div>
        <div class="container-fluid p-5">
	<div class="alert alert-info">
	<a href="#" class="close" data-dismiss="alert">x</a>
	<i class="fas fa-info-circle mr-2"></i>${msg}
	</div>

	<form method="post" action="/gravar" id="formUrl">
		
		Digite a URL: <input id="url" name="url" type="text" value=""  required class="form-control"/>
		<br /> URL Encurtada: <span id="shortUrl"></span>
		<input type="hidden" id="shorturl_hidden" name="shorturl_hidden" required> <br />
	</form>
	
	<button onClick="getShortUrl()" class="btn btn-info mt-2">Encurtar</button>
	<button id="btnSubmit" class="btn btn-info mt-2">Gravar</button>
	
	</div>
	
	<div class="container-fluid px-md-5 p5">
	<table class="table table-striped">
<thead>
<tr>
<th>ID</th>
<th>URL</th>
<th>URL Encurtada</th>
<th>Excluir</th>
<th>Alterar</th>
</tr>
</thead>
<tbody>
<c:forEach items="${lista}" var="item">
<tr>
<td>${item.idurl}</td>
<td>${item.url}</td>
<td>${item.shorturl}</td>
<td><a href="/excluir/${item.idurl}">Excluir</a></td>
<td><a href="/editar/${item.idurl}">Editar</a></td>

</tr>
</c:forEach>
</tbody>
</table>
                    <th>
                    <div class="container">
                        <a href="https://github.com/raphaelbenevides18/fattoria" target="_blank" class="d-flex btn btn-secondary btn-block">
                            <i class="fab fa-github my-auto border-right pr-2"></i>
                            <span class="m-auto">
                                /raphaelbenevides18/fattoria
                            </span>
                        </a>
                    </div>
                    </th>
                    

                </div>
           

        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
        <script src="/js/main.js"></script>
    </body>


</html>