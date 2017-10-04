<%@ page import="model.PostModel" %>
<%@ page import="dao.PostDAO" %><%--
  Created by IntelliJ IDEA.
  User: Henrique Gioppo Roman Ross
  Date: 15/09/2017
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link> rel="stylesheet" href="css/usuario-postar.css">
</head>

<body>
<form method="post" action="post_acao_postar.jsp">

    <div class="titulo">
        <label for="post-titulo">Titulo</label>
        <input type="text" required="required" name="post-titulo" id="post-titulo">
    </div>

    <div class="texto">
        <label for="post-texto">Descrição</label>
        <input type="text" required="required" name="post-texto" id="post-texto">
    </div>

    <div class="data">
        <label for="post-data">Data do evento</label>
        <input type="date" required="required" name="post-data" id="post-data">
    </div>

    <input class="postar-botao" type="submit" value="Postar">
</form>

</body>
</html>