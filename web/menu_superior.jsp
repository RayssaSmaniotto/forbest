<%@ page import="model.UsuarioModel" %>
<% UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("usuario");
if(usuarioModel != null){ %>


<div class="menu-superior">
    <div class="logo">
        <a href="feed.jsp"><img id="logo" src="assets/image/Logo-For-Best-60x72.png"></a>
    </div>
    <div class="icons">
        <a class="icones-topright" href="lista_amigos.jsp"><i class="fa fa-user-plus" aria-hidden="true"></i></a>
        <a class="icones-topright" href="perfil.jsp?id=<%=usuarioModel.getCodigo()%>"><i class="fa fa-user" aria-hidden="true"></i></a>
        <a class="icones-topright" href="feed.jsp"><i class="fa fa-bars" aria-hidden="true"></i></a>
        <a class="icones-topright" href="index.jsp"><i class="fa fa-sign-out" aria-hidden="true"></i></a>
    </div>
    <div class="campo">
        <form action="lista_amigos.jsp?id=<%=usuarioModel.getCodigo()%>" method="post">
            <input class="procura" type="text" placeholder="Procurar Amigos" name="procura-amigo">
            <a class="lupa" type="submit"><i class="fa fa-search" aria-hidden="true"></i></a>
        </form>
    </div>
</div>
<% }%>