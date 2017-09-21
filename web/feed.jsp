<<<<<<< HEAD
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.PostModel" %>

<%@ page import="dao.PostDAO" %>
<%@ page import="model.UsuarioModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Feed</title>
    <link rel="stylesheet" href="css/feed.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
=======
<%@ page import="model.UsuarioModel" %>
<html>

<head>
    <link rel="stylesheet" href="css/feed.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
    <title>Feed</title>
    <link rel="stylesheet" href="css/perfil.css">
>>>>>>> 9e1df73692b303240e78f4eddc446bd30fdf3656
</head>


<<<<<<< HEAD
<% UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("usuario"); %>


=======
<%UsuarioModel usuarioModel = new UsuarioModel();%>

<title>Feed</title>
<link rel="stylesheet" href="css/perfil.css">

</head>

<body>
>>>>>>> 9e1df73692b303240e78f4eddc446bd30fdf3656
<div class="pai-de-todos">
    <div class="menu-superior">
        <div class="logo">
            <img id="logo" src="assets/image/Logo-For-Best-60x72.png">

        </div>
        <div class="campo">
            <input class="procura" type="text" placeholder="Procurar Amigos">
            <a class="lupa" href="#"><i class="fa fa-search" aria-hidden="true"></i></a>
            <div class="icons">

<<<<<<< HEAD
                <a class="icones-topright" href="perfil.jsp?id=?"><i class="fa fa-users"
                                                                 aria-hidden="true"></i></a>
=======
                <a class="icones-topright" href="amigos.html"><i class="fa fa-users" aria-hidden="true"></i></a>
>>>>>>> 9e1df73692b303240e78f4eddc446bd30fdf3656
                <a class="icones-topright" href="notificacoes.html"><i class="fa fa-bell"
                                                                       aria-hidden="true"></i></a>
                <a class="icones-topright" href="configuracoes.html"><i class="fa fa-cog"
                                                                        aria-hidden="true"></i></a>
            </div>
        </div>
    </div>
    <div class="feed-geral">
        <h1>Bem Vindo <%usuarioModel.getNome();%></h1>
        <div class="posts-criar">
            <div class="criar-post">
                <% if(session.getAttribute("usuario") != null){%>
                <div class="imagem-usuario">
<<<<<<< HEAD
                    <a class="fotoperfil" href="perfil.jsp?id=<%=usuarioModel.getCodigo()%>"><img class="perfil"
                                                                 src="assets/image/usuario-ruan.jpg">
                    </a>
=======
                    <a class="fotoperfil" href="perfil.html"><img class="perfil"
                                                                  src="assets/image/usuario-ruan.jpg"></a>

>>>>>>> 9e1df73692b303240e78f4eddc446bd30fdf3656
                </div>
                <%}%>
                <form action="post_acao_postar.jsp" method="POST">

                    <div>
                        <input class="post-titulo-criar" type="text" name="post-assunto"
                               placeholder="Assunto">
                    </div>

                    <div class="descricao-post-div">
<<<<<<< HEAD
                        <input class="post-descricao-criar" type="text" name="post-descricao"
=======
                        <input class="post-descricao-criar" type="text" name="descricao-post"
>>>>>>> 9e1df73692b303240e78f4eddc446bd30fdf3656
                               placeholder="Escreva aqui sua postagem"></div>

                    <div class="coluna-criar-post">
                        <input class="post-criar" type="submit" value="Publicar" name="criar-post">

<<<<<<< HEAD
                        <a class="icones-imagem" href="#"><label
                                class="foto-video">Foto/Vídeo </label><i
=======
                        <a class="icones-imagem" href="#"><label class="foto-video">Foto/Vídeo </label><i
>>>>>>> 9e1df73692b303240e78f4eddc446bd30fdf3656
                                class="fa fa-picture-o" aria-hidden="true"></i></a>
                    </div>
                </form>

            </div>
        </div>
        <div class="tabela-posts-feed">

<<<<<<< HEAD
            <% ArrayList<PostModel> posts = (ArrayList<PostModel>) PostDAO.retornarPosts(); %>
            <% for (PostModel post : posts) { %>
=======
                <div class="conteudo">
                    <div class="assunto-post-tabela">
                        <p class="assunto-e-texto"> Assunto aqui!</p>
                    </div>
                    <div class="texto-post-tabela">
                        <p0 class="assunto-e-texto"> Texto aqui!</p0>
                    </div>
                    <div class="icones-post-tabela">
                        <a class="icones-post-apoiar" href="#"><i class="fa fa-handshake-o fa-lg"
                                                                  aria-hidden="true"><label
                                class="apoiar">Apoiar</label></i></a>

                        <a class="icones-post-doar" href="#"><i class="fa fa-credit-card-alt fa-lg"
                                                                aria-hidden="true"><label
                                class="apoiar">Doar</label></i></a>
                    </div>
                </div>
                <div class="imagem-nome-usuario">
                    <div class="imagem-usuario">
                        <a class="fotoperfil" href="perfil.html"><img class="perfil"
                                                                      src="assets/image/usuario-ruan.jpg"></a>
                    </div>
                    <div class="usuario-nome">
                        <a class="usuario-nome" href="perfil.html">Ruan Pasta</a>
                    </div>
                </div>
            </div>
>>>>>>> 9e1df73692b303240e78f4eddc446bd30fdf3656
            <div class="post-usuario">

                <div class="conteudo">
                    <div class="assunto-post-tabela">
                        <p class="assunto-e-texto"><%=post.getTitulo()%>
                        </p>
                    </div>
                    <div class="texto-post-tabela">
                        <p class="assunto-e-texto"><%=post.getDescricao()%>
                        </p>
                    </div>
                    <div class="icones-post-tabela">
                        <a class="icones-post-apoiar" href="#"><i class="fa fa-handshake-o fa-lg"
                                                                  aria-hidden="true"><label
                                class="apoiar">Apoiar</label></i></a>

<<<<<<< HEAD
                        <a class="icones-post-doar" href="#"><i class="fa fa-credit-card-alt fa-lg"
                                                                aria-hidden="true"><label
                                class="apoiar">Doar</label></i></a>
=======
                        <label class="apoiar"><a class="icones-post-doar" href="#"><i
                                class="fa fa-credit-card-alt fa-lg" aria-hidden="true">Doar</i></a> </label>
>>>>>>> 9e1df73692b303240e78f4eddc446bd30fdf3656
                    </div>
                </div>
                <div class="imagem-nome-usuario">
                    <div class="imagem-usuario">
<<<<<<< HEAD
                        <a class="fotoperfil" href="perfil.jsp"><img id="perfil" src="usuario-ruan.jpg"></a>
=======
                        <a class="fotoperfil" href="perfil.html"><img class="perfil"
                                                                      src="assets/image/usuario-ruan.jpg"></a>
>>>>>>> 9e1df73692b303240e78f4eddc446bd30fdf3656
                    </div>
                    <div class="usuario-nome">
                        <a class="usuario-nome" href="perfil.jsp?id=3<%= post.getUsuario().getCodigo()%>"> <%= post.getUsuario().getNome()%></a>
                    </div>
                </div>
            </div>
            <% } %>

<<<<<<< HEAD
        </div>
    </div>
</div>


=======
                <div class="conteudo">
                    <div class="assunto-post-tabela">
                        <p class="assunto-e-texto"> Assunto aqui!</p>
                    </div>
                    <div class="texto-post-tabela">
                        <p class="assunto-e-texto"> Texto aqui!</p>
                    </div>
                    <div class="icones-post-tabela">
                        <a class="icones-post-apoiar" href="#"><i class="fa fa-handshake-o fa-lg"
                                                                  aria-hidden="true"><label
                                class="apoiar">Apoiar</label></i></a>

                        <a class="icones-post-doar" href="#"><i class="fa fa-credit-card-alt fa-lg"
                                                                aria-hidden="true"><label
                                class="apoiar">Doar</label></i></a>
                    </div>
                </div>
                <div class="imagem-nome-usuario">
                    <div class="imagem-usuario">
                        <a class="fotoperfil" href="perfil.html"><img class="perfil"
                                                                      src="assets/image/usuario-ruan.jpg"></a>
                    </div>
                    <div class="usuario-nome">
                        <a class="usuario-nome" href="perfil.html">Ruan Pasta</a>
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
                        <a class="icones-post-apoiar" href="#"><i class="fa fa-handshake-o fa-lg"
                                                                  aria-hidden="true"><label
                                class="apoiar">Apoiar</label></i></a>

                        <a class="icones-post-doar" href="#"><i class="fa fa-credit-card-alt fa-lg"
                                                                aria-hidden="true"><label
                                class="apoiar">Doar</label></i></a>
                    </div>
                </div>
                <div class="imagem-nome-usuario">
                    <div class="imagem-usuario">
                        <a class="fotoperfil" href="perfil.html"><img class="perfil"
                                                                      src="assets/image/usuario-ruan.jpg"></a>
                    </div>
                    <div class="usuario-nome">
                        <a class="usuario-nome" href="perfil.html">Ruan Pasta</a>
                    </div>
                </div>
                <i class="fa fa-bars" aria-hidden="true"></i>
                <i class="fa fa-bell" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
    </div>

</div>
>>>>>>> 9e1df73692b303240e78f4eddc446bd30fdf3656
</body>

</html>