<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>

        <!-- adicionar essas duas tags sempre -->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>URL</title>

        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
        %>
        <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
        <script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet"href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" />
        <link rel="stylesheet" href="/webjars/font-awesome/5.12.0/css/all.css" />

    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">

                    <h3 class="text-center jumbotron">Encurtador de URL</h3>
        
                    <div class="alert alert-info">
                        <a href="#" class="close" data-dismiss="alert">x</a>
                        <i class="fas fa-info-circle mr-2"></i>${msg}
                    </div>
                    
                    <form
                        method="post"
                        action="/gravar"
                        id="formUrl"
                        class="py-4"
                    >
                        <div class="row">
                            <div class="col-sm-6 p-2">
                                <label class="w-100">
                                    <span>
                                        Digite a URL: 
                                    </span>
                                    <input
                                        id="url"
                                        name="url"
                                        type="text"
                                        required
                                        class="form-control"
                                        placeholder="http://...."
                                    />
                                </label>
                            </div>
                            <div class="col-sm-6 p-2">
                                <span>
                                    URL Encurtada:
                                </span>
                                <div>
                                    <span id="shortUrl"></span>
                                    <input type="hidden" id="shorturl_hidden" name="shorturl_hidden" required>
                                </div>
                            </div>
                
                            <div class="d-flex justify-content-center my-3">
                                <div class="px-2">
                                    <button onClick="getShortUrl()" class="btn btn-info mt-2">Encurtar</button>
                                </div>
                                <div class="px-2">
                                    <button id="btnSubmit" class="btn btn-info mt-2">Gravar</button>
                                </div>
                            </div>
                        </div>
                        
                    </form>

                </div>
            </div>
            
            
            <div class="row py-5">
                <div class="col-12">

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
                                    <td>
                                        <a href="/excluir/${item.idurl}">Excluir</a>
                                    </td>
                                    <td>
                                        <a href="/editar/${item.idurl}">Editar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <th><li class="my-1 mx-auto p-1">
                        <a href="https://github.com/raphaelbenevides18" target="_blank" class="d-flex btn btn-secondary btn-block">
                            <i class="fab fa-github my-auto border-right pr-2"></i>
                            <span class="m-auto">
                                /raphaelbenevides18
                            </span>
                        </a>
                    </li></th>
                    

                </div>
            </div>

        </div>

        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
        <script src="/js/main.js"></script>
    </body>


</html>