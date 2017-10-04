<%@ page import="model.UsuarioModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.AmigoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>amigos</title>
    <link rel="stylesheet" href="css/amigo_usuario.css">
    <link rel="stylesheet" href="css/menu_superior.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
</head>
<body>
<% try {
    UsuarioModel usuarioModel = UsuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("id"))); %>

<jsp:include page="menu_superior.jsp"></jsp:include>

<div id="div-amigos">
    <h1 class="texto-shadow">Lista de Amigos</h1>
    <%-- <% AmigoDAO amigoDAO = (AmigoDAO) session.getAttribute("usuario"); %> --%>
    <%
        ArrayList<UsuarioModel> amigos = (ArrayList<UsuarioModel>) AmigoDAO.carregarAmigos(usuarioModel.getCodigo()); %>
    <% for (UsuarioModel amigo : amigos) { %>
    <%--<% if(amigoDAO.getCo() == 2){ %>--%>
    <div class="amigos-imagem-nome-usuario">
        <div class="amigos-imagem-usuario">
            <a class="amigos-fotoperfil" href="perfil.jsp?id=<%=amigo.getCodigo()%>"><img class="perfil"
                                                                                          src="usuario_get_imagem.jsp?id=<%=amigo.getCodigo()%>"></a>
        </div>
        <div class="amigos-usuario-nome">
            <a class="amigos-usuario-nome" href="perfil.jsp?id=<%=amigo.getCodigo()%>"><%= amigo.getNome()%>
            </a>
        </div>
    </div>
    <% } %>
    <%} catch (NumberFormatException num) {
    }
    %>
</div>


</body>
</html>