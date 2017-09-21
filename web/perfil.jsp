<%@ page import="model.UsuarioModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="dados_usuario.jsp">
    <link rel="stylesheet" href="perfil.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

<% try{ UsuarioModel usuarioModel = UsuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("id"))); %>

<div class="pai-de-todos">
    <div class="menu-superior">
        <div class="logo">
            <a class="color-logo" href="index.jsp"><img id="logo" src="Logo-For-Best-60x72.png"></a>
        </div>
        <div class="campo">
            <input class="procura" type="text" placeholder="Procurar Amigos">
            <a class="lupa" href="#"><i class="fa fa-search" aria-hidden="true"></i></a>
            <div class="icons">
                <a class="icones-topright" href="amigos.jsp"><i class="fa fa-users" aria-hidden="true" ></i></a>
                <a class="icones-topright" href="notificacoes.jsp"><i class="fa fa-bell" aria-hidden="true"></i></a>
                <a class="icones-topright" href="configuracoes.jsp"><i class="fa fa-cog" aria-hidden="true"></i></a>
            </div>
        </div>
    </div>
<<<<<<< HEAD
    <div class="campos-margin-top">
=======

    <form method="post" action="usuario-acao-cadastrar.jsp">
>>>>>>> 9e1df73692b303240e78f4eddc446bd30fdf3656
        <div class="campos">
            <div class="biografia">
                <label id="bio-usuario">Bio</label>
                <div id="descricao-bio">
                    <label><%= usuarioModel.getBiografia() %></label>
                </div>
            </div>
            <div class="perfil-imagem-nome-usuario">
                <div class="perfil-imagem-usuario">
                    <a class="fotoperfil" href="perfil.jsp"><img id="perfil-perfil" src="usuario-ruan.jpg"></a>
                </div>
                <div class="perfil-usuario-nome">
                    <a class="perfil-usuario-nome" href="perfil.jsp"><%= usuarioModel.getNome()%> <%= usuarioModel.getSobrenome()%></a>
                </div>
            </div>
            <div class="alterar-dados">
                <a class="alterar" href="#"><i class="fa fa-pencil" aria-hidden="true"></i></a>
            </div>
            <div class="sobre">
                <div>
                    <label class="icones-sobre"><i class="fa fa-birthday-cake" aria-hidden="true"></i> </label>
                    <label class="dados-sobre"><%= usuarioModel.getDataNascimento() %> </label>
                </div>
                <div>
                    <label class="icones-sobre"><i class="fa fa-envelope" aria-hidden="true"></i></label>
                    <label class="dados-sobre"><%= usuarioModel.getEmail() %>
                    </label>
                </div>
                <div>
                    <label class="icones-sobre-local"><i class="fa fa-map-marker" aria-hidden="true"></i></label>
                    <label class="dados-sobre"><%= usuarioModel.getEstado() %></label>

                </div>
                <div>
                    <label class="icones-sobre-celular"><i class="fa fa-mobile" aria-hidden="true"></i></label>
                    <label class="dados-sobre"><%= usuarioModel.getCelular() %> </label>
                </div>
            </div>
        </div>
    </div>


    <div class="tabela-posts-feed">
        <div class="post-usuario">

            <div class="conteudo">
                <div class="assunto-post-tabela">
                    <p class="assunto-e-texto"> Assunto aqui!</p>
                </div>
                <div class="texto-post-tabela">
                    <p class="assunto-e-texto"> Texto aqui!</p>
                </div>
                <div class="icones-post-tabela">
                    <a class="icones-post-apoiar" href="#"><i class="fa fa-handshake-o fa-lg" aria-hidden="true"><label class="apoiar">Apoiar</label></i></a>

                    <a class="icones-post-doar" href="#"><i class="fa fa-credit-card-alt fa-lg" aria-hidden="true"><label class="apoiar">Doar</label></i></a>
                </div>
            </div>
            <div class="imagem-nome-usuario">
                <div class="imagem-usuario">
                    <a class="fotoperfil" href="perfil.jsp"><img class="perfil" src="usuario-ruan.jpg"></a>
                </div>
                <div class="usuario-nome">
                    <a class="usuario-nome" href="perfil.jsp"><%= usuarioModel.getNome() %> <%= usuarioModel.getSobrenome() %></a>
                </div>
            </div>
        </div>
        <div class="post-usuario">

            <div class="conteudo">
                <div class="assunto-post-tabela">
                    <p class="assunto-e-texto"> Assunto aqui!</p>
                </div>
                <div class="texto-post-tabela">
                    <p class="assunto-e-texto"> Texto aqui!</p>
                </div>
                <div class="icones-post-tabela">
                    <a class="icones-post-apoiar" href="#"><i class="fa fa-handshake-o fa-lg" aria-hidden="true"><label class="apoiar">Apoiar</label></i></a>

                    <label class="apoiar">
                        <a class="icones-post-doar" href="#"><i class="fa fa-credit-card-alt fa-lg" aria-hidden="true" >Doar</i></a> </label>
                </div>
            </div>
            <div class="imagem-nome-usuario">
                <div class="imagem-usuario">
                    <a class="fotoperfil" href="perfil.jsp"><img id="perfil" src="usuario-ruan.jpg"></a>
                </div>
                <div class="usuario-nome">
                    <a class="usuario-nome" href="perfil.jsp?"><%= usuarioModel.getNome() %> <%= usuarioModel.getSobrenome() %></a>
                </div>
            </div>
        </div>
    </div>


</div>
<%}catch (NumberFormatException num){
}%>

</body>

</html>
