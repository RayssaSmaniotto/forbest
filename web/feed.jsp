<%@ page import="model.UsuarioModel" %><%--
  Created by IntelliJ IDEA.
  User: 98926
  Date: 18/09/2017
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<% if(session.getAttribute("usuario") == null){
    response.sendRedirect("entrar.jsp");
    return;
}
 UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("usuario");
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feed</title>
    <link  rel="stylesheet" href="css/perfil.css">
</head>
<body>
<form>
<div class="pai-de-todos">
    <div class="menu-superior">
        <div class="logo">
            <img id="logo" src="assets/image/Logo-For-Best-60x72.png">
        </div>
        <div class="campo">
            <input class="procura" type="text" placeholder="Procurar Amigos">
            <a class="lupa" href="#"><i class="fa fa-search" aria-hidden="true"></i></a>
            <div class="icons">
                <i class="fa fa-bars" aria-hidden="true"></i>
                <i class="fa fa-bell" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
    </div>


<h1>Bem Vindo <%= usuarioModel.getNome()%></h1>
<textarea placeholder="Digite Seu Post"></textarea>
</body>
</html>
