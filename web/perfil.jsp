<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.UsuarioModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.PostModel" %>
<%@ page import="dao.PostDAO" %>
<%@ page import="database.Utilitarios" %>
<%@ page import="dao.AmigoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/perfil.css">
    <link rel="stylesheet" href="css/menu_superior.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
</head>

<body>

<% try {
    UsuarioModel usuarioModel = UsuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("id"))); %>
<jsp:include page="menu_superior.jsp"/>

<div class="pai-de-todos">

    <div class="campos-margin-top">
        <div class="campos">

            <div class="biografia">
                <label id="bio-usuario">Bio</label>
                <% if (usuarioModel.getBiografia() != null) { %>
                <div id="descricao-bio">
                    <p><%= usuarioModel.getBiografia() %>
                    </p>
                </div>
                <% } %>
            </div>
            <div class="perfil-imagem-nome-usuario">
                <div class="perfil-imagem-usuario">
                    <a class="fotoperfil" href="perfil.jsp?id=<%=usuarioModel.getCodigo()%>">
                        <div><img id="perfil-perfil" src="usuario_get_imagem.jsp?id=<%=usuarioModel.getCodigo()%>">
                        </div>
                    </a>
                </div>
                <div class="perfil-usuario-nome">
                    <a class="perfil-usuario-nome"
                       href="perfil.jsp?id=<%=usuarioModel.getCodigo()%>"><%= usuarioModel.getNome()%> <%= usuarioModel.getSobrenome()%>
                    </a>
                </div>
            </div>

            <%
                UsuarioModel usuarioLogado = (UsuarioModel) session.getAttribute("usuario");
                if (usuarioLogado.getCodigo() == usuarioModel.getCodigo()) {
            %>

            <div class="alterar-dados">

                <a href="editar_usuario.jsp?id=<%=usuarioModel.getCodigo()%>"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                <%--<button type="button" onclick="Mudarestado('minha-div')"><i class="fa fa-pencil" aria-hidden="true"></i>
                </button>--%>
                <a href="amigo_usuario.jsp?id=<%=usuarioModel.getCodigo()%>"><i class="fa fa-users" aria-hidden="true"></i></a>

                <%-- <button type="button" onclick="Mostrar('div-amigos')"><i class="fa fa-users" aria-hidden="true"></i>
                 </button>--%>
                 <%--<a type="button" onclick="Mudarestado('minha-div')"><i class="fa fa-pencil"></i></a>--%>
            </div>

            <% } %>
            <div class="sobre">
                <div class="lista-icones">
                    <div>
                        <% if (usuarioModel.getDataNascimento() != null) { %>
                        <label class="icones-sobre"><i class="fa fa-birthday-cake" aria-hidden="true"></i> </label>
                        <label class="dados-sobre">


                            <%= Utilitarios.retornarPadraoBR(usuarioModel.getDataNascimento()) %>
                            <% } %>
                        </label>
                        <%--<label class="dados-sobre"><%= Utilitarios.retornarPadraoBR(usuarioModel.getDataNascimento()) %>
                         </label>--%>
                    </div>
                    <% if (usuarioModel.getEmail() != null) { %>
                    <div>
                        <label class="icones-sobre"><i class="fa fa-envelope" aria-hidden="true"></i></label>
                        <label class="dados-sobre"><%= usuarioModel.getEmail() %>
                        </label>
                    </div>
                    <% } %>
                    <% if (usuarioModel.getEstado() != null) { %>
                    <div>
                        <label class="icones-sobre-local"><i class="fa fa-map-marker" aria-hidden="true"></i></label>
                        <label class="dados-sobre"><%= usuarioModel.getEstado() %>
                        </label>


                    </div>
                    <%}%>
                    <% if (usuarioModel.getCelular() != null) { %>
                    <div>
                        <label class="icones-sobre-celular"><i class="fa fa-mobile" aria-hidden="true"></i></label>
                        <label class="dados-sobre"><%= usuarioModel.getCelular() %>
                        </label>
                    </div>
                    <%}%>
                    <% if (usuarioModel.getIdade() != 0) { %>
                    <div>
                        <label class="icones-sobre-celular"><i class="fa fa-birthday-cake" aria-hidden="true"></i></label>
                        <label class="dados-sobre"><%= usuarioModel.getIdade() %>
                        </label>

                    </div>
                    <%}%>
                    <% if (usuarioModel.getCpf() != null) { %>
                    <div>
                        <label class="icones-sobre-celular"><i class="fa fa-address-card-o" aria-hidden="true"></i></label>
                        <label class="dados-sobre"><%= usuarioModel.getCpf() %>
                        </label>
                    </div>
                    <%}%>

                    <% if (usuarioModel.getCep() != null) { %>
                    <div>
                        <label class="icones-sobre-celular"><i class="fa fa-map-marker" aria-hidden="true"></i></label>
                        <label class="dados-sobre"><%= usuarioModel.getCep() %>
                        </label>
                    </div>
                    <%}%>
                    <% if (usuarioModel.getNumero() != 0) { %>
                    <div>
                        <label class="icones-sobre-celular"><i class="fa fa-map-marker" aria-hidden="true"></i></label>
                        <label class="dados-sobre"><%= usuarioModel.getNumero() %>
                        </label>
                    </div>

                </div>
                <%}%>

                <div class="lista-icones2">
                    <% if (usuarioModel.getLogradouro() != null) { %>
                    <div>
                        <label class="icones-sobre-celular"><i class="fa fa-map-marker" aria-hidden="true"></i></label>
                        <label class="dados-sobre"><%= usuarioModel.getLogradouro() %>
                        </label>
                    </div>
                    <%}%>
                    <% if (usuarioModel.getCidade() != null) { %>
                    <div>
                        <label class="icones-sobre-celular"><i class="fa fa-map-marker" aria-hidden="true"></i></label>
                        <label class="dados-sobre"><%= usuarioModel.getCidade() %>
                        </label>
                    </div>
                    <%}%>
                    <% if (usuarioModel.getBairro() != null) { %>
                    <div>
                        <label class="icones-sobre-celular"><i class="fa fa-map-marker" aria-hidden="true"></i></label>
                        <label class="dados-sobre"><%= usuarioModel.getBairro() %>
                        </label>
                    </div>
                    <%}%>
                    <% if (usuarioModel.getGenero() != 0) { %>
                    <div>
                        <label class="icones-sobre-celular"><i class="fa fa-venus-mars" aria-hidden="true"></i></label>
                        <label class="dados-sobre"><%= usuarioModel.getGenero() %>
                        </label>
                    </div>
                    <%}%>
                    <% if (usuarioModel.getUrlTwitter() != null) { %>
                    <div>
                        <label class="icones-sobre-celular"><i class="fa fa-twitter" aria-hidden="true"></i></label>
                        <label class="dados-sobre"><%= usuarioModel.getUrlTwitter() %>
                        </label>
                    </div>
                    <%}%>
                    <% if (usuarioModel.getUrlLinkedin() != null) { %>
                    <div>
                        <label class="icones-sobre-celular"><i class="fa fa-linkedin-square" aria-hidden="true"></i></label>
                        <label class="dados-sobre"><%= usuarioModel.getUrlLinkedin() %>
                        </label>
                    </div>
                    <%}%>
                    <% if (usuarioModel.getUrlInstagram() != null) { %>
                    <div>
                        <label class="icones-sobre-celular"><i class="fa fa-instagram" aria-hidden="true"></i></label>
                        <label class="dados-sobre"><%= usuarioModel.getUrlInstagram() %>
                        </label>
                    </div>
                    <div>
                        <%}%>
                        <% if (usuarioModel.getUrlFacebook() != null) { %>
                        <label class="icones-sobre-celular"><i class="fa fa-facebook-official" aria-hidden="true"></i></label>
                        <label class="dados-sobre"><%= usuarioModel.getUrlFacebook() %>
                        </label>
                    </div>
                    <%}%>
                </div>
            </div>
        </div>
    </div>

    <script>
        function Mudarestado(el) {
            var display = document.getElementById(el).style.display;
            console.log(display);
            if (display == "block")
                document.getElementById(el).style.display = 'none';
            else
                document.getElementById(el).style.display = 'block';
        }
    </script>
    <script>
        function Mostrar(el) {
            var display = document.getElementById(el).style.display;
            console.log(display);
            if (display == "block")
                document.getElementById(el).style.display = 'none';
            else
                document.getElementById(el).style.display = 'block';
        }
    </script>
    <script>
        //document.getElementById('getval').addEventListener('change', readURL, true);

        function readURL() {
            var file = document.getElementById("getval").files[0];
            var reader = new FileReader();
            reader.onloadend = function () {
                document.getElementById('clock').style.backgroundImage = "url(" + reader.result + ")";
            }
            if (file) {
                reader.readAsDataURL(file);
            } else {
            }
        }
    </script>

    <div id="div-amigos">
        <%-- <% AmigoDAO amigoDAO = (AmigoDAO) session.getAttribute("usuario"); %> --%>
        <% ArrayList<UsuarioModel> amigos = (ArrayList<UsuarioModel>) AmigoDAO.carregarAmigos(usuarioModel.getCodigo()); %>
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
    </div>
    <div class="separar-divs"></div>
    <div class="tabela-posts-feed">

        <% ArrayList<PostModel> posts = (ArrayList<PostModel>) PostDAO.retornarPosts(usuarioModel.getCodigo()); %>
        <% for (PostModel post : posts) { %>

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

                    <a class="icones-post-doar" href="#"><i class="fa fa-credit-card-alt fa-lg"
                                                            aria-hidden="true"><label
                            class="apoiar">Doar</label></i></a>
                    <%if(((UsuarioModel) session.getAttribute("usuario")).getCodigo() != post.getUsuario().getCodigo()){ %>

                    <%}else{ %>
                    <div class="alterar-excluir">
                        <a type="button" href="posts_alterar.jsp?id=<%=post.getCodigo()%>"><i class="fa fa-pencil"></i></a>
                        <a class="icon-excluir" href="post_acao_excluir.jsp?id=<%=post.getCodigo()%>"><i
                                class="fa fa-trash"></i></a>
                    </div>
                    <% } %>
                </div>
            </div>
            <div class="imagem-nome-usuario">
                <div class="imagem-usuario">
                    <a class="fotoperfil" href="perfil.jsp"><img class="perfil"
                                                                 src="usuario_get_imagem.jsp?id=<%=usuarioModel.getCodigo()%>"></a>
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

        <%
    } catch (NumberFormatException num) {
    }
%>
</body>
</html>
