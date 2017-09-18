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
    <title>Title</title>
</head>
<body>
<h1>Bem Vindo <%= usuarioModel.getNome() %></h1>
</body>
</html>
