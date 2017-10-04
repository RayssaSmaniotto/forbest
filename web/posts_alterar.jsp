<%@ page import="model.UsuarioModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.PostModel" %>
<%@ page import="dao.PostDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/posts_alterar.css">
    <link rel="stylesheet" href="css/menu_superior.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="menu_superior.jsp"></jsp:include>

<%-- <% try {UsuarioModel usuarioModel = UsuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("id"))); %> --%>

<% PostModel post = PostDAO.buscarPostPorId(Integer.parseInt(request.getParameter("id"))); %>

<%if(((UsuarioModel) session.getAttribute("usuario")).getCodigo() != post.getUsuario().getCodigo()){
 response.sendRedirect("feed.jsp");
}%>
<div class="post-usuario">

  <%--  <div class="conteudo">
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

            <a class="icones-post-doar" href="#"><i class="fa fa-credit-card-alt fa-lg"
                                                    aria-hidden="true"><label
                    class="apoiar">Doar</label></i></a>
            <div class="alterar-excluir">
                <a type="button" onclick="Mudarestadopost('div-alterar-post')" href="#"><i
                        class="fa fa-pencil"></i></a>
                <a class="icon-excluir" href="post_acao_excluir.jsp?id=<%=post.getCodigo()%>"><i
                        class="fa fa-trash"></i></a>
            </div>
        </div>

    <div class="imagem-nome-usuario">
        <div class="imagem-usuario">
            <a class="fotoperfil" href="perfil.jsp"><img id="perfil" src="usuario-ruan.jpg"></a>
        </div>
        <div class="usuario-nome">
            <a class="usuario-nome"
               href="perfil.jsp?id=<%= post.getUsuario().getCodigo()%>"><%= post.getUsuario().getNome()%>
            </a>
        </div>
    </div>--%>
        <div class="conteudo">
    <div class="div-alterar-post">
        <form action="post_acao_alterar.jsp?id=<%=post.getCodigo()%>" method="post">
            <% if(post.getTitulo() != null){ %>
            <input class="assunto-e-texto" type="text" name="titulo" placeholder="Assunto" value="<%=post.getTitulo()%>">
            <% } else{ %>
            <input type="text" name="titulo" placeholder="Assunto">
            <% } %>

            <% if(post.getDescricao() != null){ %>
            <input class="texto-post-tabela" type="text" name="descricao" placeholder="Descrição"
                   value="<%=post.getDescricao()%>">
            <% } else{ %>
            <input type="text" name="descricao" placeholder="Descrição">
            <% } %>

           <%-- <% if(post.getDataCriacao() != null){ %>
            <input type="date" name="criacao" placeholder="Data Criação"
                   value="<%=post.getDataCriacao()%>">
            <% } else{ %>
            <input type="date" name="criacao" placeholder="Data Criação">
            <% } %>

            <% if(post.getDataEvento() != null){ %>
            <input type="date" name="date-evento" placeholder="Data Evento"
                   value="<%=post.getDataEvento()%>">
            <% } else{ %>
            <input type="date" name="data-evento" placeholder="Data Evento">
            <% } %>

            <% if(post.getStatus() != null){ %>
            <input type="text" name="status" placeholder="Status"
                   value="<%=post.getStatus()%>">
            <% } else { %>
            <input type="text" name="status" placeholder="Status">
            <% } %>

            <% if(post.getApoios() != 0){ %>
            <input type="text" name="apoios" placeholder="Apoios"
                   value="<%=post.getApoios()%>">
            <% } else { %>
            <input type="text" name="apoios" placeholder="Apoios">
            <% } %>
            --%>


            <input class="botao-salvar" type="submit" value="Salvar">

            <div class="imagem-nome-usuario">
                <div class="imagem-usuario">
                    <a class="fotoperfil" href="perfil.jsp?=<%=post.getCodigo()%>"><img id="perfil" src="usuario_get_imagem.jsp?id=<%=post.getUsuario().getCodigo()%>"></a>
                </div>
                <div class="usuario-nome">
                    <a class="usuario-nome" href="perfil.jsp?id=<%= post.getUsuario().getCodigo()%>"> <%= post.getUsuario().getNome()%></a>
                </div>
            </div>
        </form>
    </div>
        </div>
</div>
</body>
</html>