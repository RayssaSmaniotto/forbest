<%@ page import="model.UsuarioModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="empresa_cadastrar.jsp">
    <link rel="stylesheet" href="css/perfil_empresa.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

<% UsuarioModel usuarioModel = UsuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("id"))); %>

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

    <form method="post" action="empresa_acao_cadastrar.jsp">
        <div class="campos">
            <div>
                <label><%=usuarioModel.getNome()%></label>
            </div>
            <div>
                <label><%=usuarioModel.getCnpj()%></label>
            </div>
            <div>
                <label><%=usuarioModel.getEmail()%></label>
            </div>
            <div>
                <label><%=usuarioModel.getSenha()%></label>
            </div>
        </div>
    </form>
</div>

</body>

</html>




