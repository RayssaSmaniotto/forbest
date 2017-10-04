<%@ page import="model.UsuarioModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page import="model.AmigoModel" %>
<%@ page import="dao.AmigoDAO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Ruan Pasta
  Date: 24/09/2017
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/lista_amigos.css">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/menu_superior.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
    <title>4Best</title>
</head>
<body>
<% UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("usuario"); %>

<jsp:include page="menu_superior.jsp"></jsp:include>
<div class="div-amigos">
    <div class="solicitacoes">
        <h1 class="texto-shadow">Solicitações</h1>

        <% ArrayList<UsuarioModel> solicitantes = (ArrayList<UsuarioModel>) AmigoDAO.buscarSolicitacoes(usuarioModel.getCodigo()); %>
        <% for (UsuarioModel solicitante : solicitantes) { %>
        <div class="div-dos-usuarios">

            <div class="perfil-imagem-nome-usuario">
                <div class="perfil-imagem-usuario">
                    <a class="fotoperfil" href="perfil.jsp?id=<%=solicitante.getCodigo()%>">
                        <div> <a href="perfil.jsp?=<%= solicitante.getCodigo()%>"><img class="perfil-perfil" src="usuario_get_imagem.jsp?id=<%=solicitante.getCodigo()%>"></a></div>
                    </a>
                </div>
                <div class="perfil-usuario-nome">
                    <a class="perfil-usuario-nome" href="perfil.jsp?id=<%=solicitante.getCodigo()%>"> <%=solicitante.getNome()%></a>
                </div>
            </div>

            <div class="confirmar-recusar">
                <a type="button" href="amigo_confirmar.jsp?id=<%=usuarioModel.getCodigo()%>&solicitante=<%=solicitante.getCodigo()%>&situacao=2"> <i class="fa fa-check fa-2x" aria-hidden="true"></i></a>
                <a type="button" href="amigo_confirmar.jsp?id=<%=usuarioModel.getCodigo()%>&solicitante=<%=solicitante.getCodigo()%>&situacao=3"> <i class="fa fa-times fa-2x" aria-hidden="true"></i></a>
                <%--<button type="submit"> <i class="fa fa-check fa-2x" aria-hidden="true"></i></button> --%>
                <%--<button type="submit"> <i class="fa fa-times fa-2x" aria-hidden="true"></i></button> --%>
            </div>
        </div>
        <% } %>
    </div>

    <div class="sugestoes">
        <h1 class="texto-shadow">Sugestões</h1>
        <% ArrayList<UsuarioModel> amigos = (ArrayList<UsuarioModel>) AmigoDAO.encontrarAmigos(request.getParameter("procura-amigo"),usuarioModel.getCodigo()); %>
        <% for (UsuarioModel amigo : amigos) { %>
        <div class="div-dos-usuarios">
            <div class="perfil-imagem-nome-usuario">
                <div class="perfil-imagem-usuario">
                    <a class="fotoperfil" href="perfil.jsp?id=<%=amigo.getCodigo()%>">
                        <div> <a href="perfil.jsp?=<%= amigo.getCodigo()%>"><img class="perfil-perfil" src="usuario_get_imagem.jsp?id=<%=amigo.getCodigo()%>"></a></div>
                    </a>
                </div>
                <div class="perfil-usuario-nome">
                    <a class="perfil-usuario-nome" href="perfil.jsp?id=<%=amigo.getCodigo()%>"><%=amigo.getNome()%></a>
                </div>
            </div>

            <div class="confirmar-recusar">
              <a type="button" href="amigo_solicitar.jsp?id=<%=usuarioModel.getCodigo()%>&solicitado=<%=amigo.getCodigo()%>"> <i class="fa fa-user-plus fa-lg" aria-hidden="true"></i></a>
            </div>
        </div>
        <% } %>
    </div>
</div>
</body>
</html>