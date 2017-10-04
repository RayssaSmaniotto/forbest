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
    <link rel="stylesheet" href="css/menu_superior.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
</head>

<body>


<script>
    function Mudarestadopost(e1) {
        var display = document.getElementById(el).style.display;
        console.log(display);
        if (display == "block")
            document.getElementById(el).style.display = 'none';
        else
            document.getElementById(el).style.display = 'block';
    }
</script>

<% UsuarioModel usuarioModel = (UsuarioModel) session.getAttribute("usuario"); %>


<div class="pai-de-todos">
    <jsp:include page="menu_superior.jsp"></jsp:include>
    <div class="feed-geral">

        <div class="posts-criar">
            <div class="criar-post">
                <% if (session.getAttribute("usuario") != null) {%>
                <div class="imagem-usuario">
                    <a class="fotoperfil" href="perfil.jsp?id=<%=usuarioModel.getCodigo()%>"><img class="perfil" src="usuario_get_imagem.jsp?id=<%=usuarioModel.getCodigo()%>">
                    </a>
                </div>
                <%}%>
                <form action="post_acao_postar.jsp?id=<%=usuarioModel.getCodigo()%>" method="post">

                    <div>
                        <input class="post-titulo-criar" type="text" name="post-assunto" placeholder="Assunto">
                    </div>

                    <div class="descricao-post-div">
                        <input class="post-descricao-criar" type="text" name="post-descricao"
                               placeholder="Escreva aqui sua postagem"></div>

                    <div class="coluna-criar-post">
                        <input class="post-criar" type="submit" value="Publicar" name="criar-post">

                        <a class="icones-imagem" href="#"><label
                                class="foto-video">Foto/Vídeo </label><i
                                class="fa fa-picture-o" aria-hidden="true"></i></a>
                    </div>
                </form>
            </div>
        </div>

        <div class="tabela-posts-feed">

            <% ArrayList<PostModel> posts = (ArrayList<PostModel>) PostDAO.retornarPosts(0); %>
            <% for (PostModel post : posts) { %>
            <div class="post-usuario">

                <div class="conteudo">
                    <div class="assunto-post-tabela">
                        <p class="assunto-e-texto"><%=post.getTitulo()%>
                        </p>
                    </div>
                    <div class="texto-post-tabela">
                        <p class="assunto-e-texto"><%=post.getDescricao()%></p>
                    </div>
                    <div class="icones-post-tabela">
                        <a><%=post.getApoios()%></a>
                        <label class="apoiar"> <a type="button" class="icones-post-apoiar" href="post_acao_apoiar.jsp?id=<%=post.getCodigo()%>"> <i class="fa fa-handshake-o fa-lg" aria-hidden="true">Apoiar</i></a></label>
                        <a class="icones-post-doar" href="#"><i class="fa fa-credit-card-alt fa-lg" aria-hidden="true"><label class="apoiar">Doar</label></i></a>
                        <% if (usuarioModel.getCodigo() == post.getUsuario().getCodigo()) { %>
                            <div class="alterar-excluir">
                                <a type="button" href="posts_alterar.jsp?id=<%=post.getCodigo()%>"><i class="fa fa-pencil"></i></a>
                                <a class="icon-excluir" href="post_acao_excluir.jsp?id=<%=post.getCodigo()%>"><i class="fa fa-trash"></i></a>
                            </div>
                        <% } %>
                    </div>
                </div>
                <div class="imagem-nome-usuario">
                    <div class="imagem-usuario">
                        <a class="fotoperfil" href="perfil.jsp?id=<%= post.getUsuario().getCodigo()%>"><img class="perfil" src="usuario_get_imagem.jsp?id=<%=post.getUsuario().getCodigo()%>"></a>
                    </div>
                    <div class="usuario-nome">
                        <a class="usuario-nome"
                           href="perfil.jsp?id=<%= post.getUsuario().getCodigo()%>"><%= post.getUsuario().getNome()%>
                        </a>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    </div>
</div>
</body>
</html>