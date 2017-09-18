<%@ page import="model.PostModel" %>
<%@ page import="dao.PostDAO" %><%--
  Created by IntelliJ IDEA.
  User: Henrique Gioppo Roman Ross
  Date: 18/09/2017
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link> rel="stylesheet" href="css/usuario-postar.css">
</head>
<body>

<form method="post" action="post_acao_alterar.jsp">
    <% PostModel post = PostDAO.buscarPostPorId(Integer.parseInt(request.getParameter("id"))); %>

    <div class="titulo">
        <label <%= post.getTitulo() %> for="post-titulo"> </label>
        <input type="text" required="required" name="post-titulo" id="post-titulo">
    </div>

    <div class="descricao">
        <label <%= post.getDescricao() %> for="post-descricao"> </label>
        <input type="text" required="required" name="post-descricao" id="post-descricao">
    </div>

    <div class="data">
        <label <%= post.getDataEvento() %> for="post-data"> </label>
        <input type="date" required="required" name="post-data" id="post-data">
    </div>

    <input class="alterar-botao" type="submit" value="Alterar">
</form>

</body>
</html>