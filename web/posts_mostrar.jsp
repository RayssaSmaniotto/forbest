<%@ page import="dao.PostDAO" %>
<%@ page import="model.PostModel" %><%--
  Created by IntelliJ IDEA.
  User: Henrique Gioppo Roman Ross
  Date: 18/09/2017
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link> rel="stylesheet" href="css/posts.css">
</head>
<body>
    <% PostModel post = PostDAO.buscarPostPorId(Integer.parseInt(request.getParameter("id"))); %>

    <div class="titulo">
        <label> <%= post.getTitulo() %> </label>
    </div>

    <div class="descricao">
        <label> <%= post.getDescricao() %> </label>
    </div>

    <div class="data">
        <label> <%= post.getDataEvento() %> </label>
    </div>

    <div class="apoios">
        <label> <%= post.getApoios() %> </label>
    </div>

    <div class="autor">
        <label> <%= post.getUsuario() %> </label>
    </div>


</body>
</html>
