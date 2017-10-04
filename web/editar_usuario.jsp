<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.UsuarioModel" %>
<%@ page import="dao.UsuarioDAO" %><%--
  Created by IntelliJ IDEA.
  User: 56665
  Date: 28/09/2017
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <link rel="stylesheet" href="css/editar_usuario.css">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/menu_superior.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="menu_superior.jsp"></jsp:include>
<% try {
    UsuarioModel usuarioModel = UsuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("id"))); %>


<div class="div-alterar-usuario">
    <div id="alterar-usuario">
        <form method="POST" action="uploadImage" enctype="multipart/form-data">
        <div class="label">
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Nome: </label>
                </div>
                <div class="texto-input">
                    <input type="text" name="usuario-nome" placeholder="Nome" value="<%=usuarioModel.getNome()%>"required>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Email: </label>
                </div>
                <div class="texto-input">
                    <input type="text" name="usuario-email" placeholder="Email" value="<%=usuarioModel.getEmail()%>" required>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Senha: </label>
                </div>
                <div class="texto-input">
                    <input type="password" name="usuario-senha" placeholder="Senha" value="<%=usuarioModel.getSenha()%>" required>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Sobrenome: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getSobrenome() != null) { %>
                    <input type="text" name="usuario-sobrenome" placeholder="Sobrenome" value="<%=usuarioModel.getSobrenome()%>" required>
                    <% } else { %>
                    <input type="text" name="usuario-sobrenome" placeholder="Sobrenome" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Estado: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getEstado() != null) { %>
                    <input type="text" name="usuario-estado" placeholder="Estado" value="<%=usuarioModel.getEstado()%>" required>
                    <% } else { %>
                    <input type="text" name="usuario-estado" placeholder="Estado" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Celular: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getCelular() != null) { %>
                    <input type="text" name="usuario-celular" placeholder="Celular" value="<%=usuarioModel.getCelular()%>" required>
                    <% } else { %>
                    <input type="text" name="usuario-celular" placeholder="Celular" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Idade: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getIdade() != 0) { %>
                    <input type="text" name="usuario-idade" placeholder="Idade" value="<%=usuarioModel.getIdade()%>" required>
                    <% } else { %>
                    <input type="text" name="usuario-idade" placeholder="Idade" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Nascimento: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getDataNascimento() != null) { %>
                    <input type="date" name="usuario-data-nascimento" placeholder="Data Nacimento" value="<%=usuarioModel.getDataNascimento()%>" required>
                    <% } else { %>
                    <input type="date" name="usuario-data-nascimento" placeholder="Data Nacimento" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">CPF: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getCpf() != null) { %>
                    <input type="text" name="usuario-cpf" placeholder="CPF" value="<%=usuarioModel.getCpf()%>" required>
                    <% } else { %>
                    <input type="text" name="usuario-cpf" placeholder="CPF" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">CEP: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getCep() != null) { %>
                    <input type="text" name="usuario-cep" placeholder="CEP" value="<%=usuarioModel.getCep()%>" required>
                    <% } else { %>
                    <input type="text" name="usuario-cep" placeholder="CEP" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Numero: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getNumero() != 0) { %>
                    <input type="number" name="usuario-numero" placeholder="Numero" value="<%=usuarioModel.getNumero()%>" required>
                    <% } else { %>
                    <input type="number" name="usuario-numero" placeholder="Numero" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Logradouro: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getLogradouro() != null) { %>
                    <input type="text" name="usuario-logradouro" placeholder="Logradouro" value="<%=usuarioModel.getLogradouro()%>" required>
                    <% } else { %>
                    <input type="text" name="usuario-logradouro" placeholder="Logradouro" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Cidade: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getCidade() != null) { %>
                    <input type="text" name="usuario-cidade" placeholder="Cidade" value="<%=usuarioModel.getCidade()%>" required>
                    <% } else { %>
                    <input type="text" name="usuario-cidade" placeholder="Cidade" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Bairro: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getBairro() != null) { %>
                    <input type="text" name="usuario-bairro" placeholder="Bairro" value="<%=usuarioModel.getBairro()%>" required>
                    <% } else { %>
                    <input type="text" name="usuario-bairro" placeholder="Bairro" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Genero: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getGenero() != 0) { %>
                    <input type="text" name="usuario-genero" placeholder="Genero" value="<%=usuarioModel.getGenero()%>" required>
                    <% } else { %>
                    <input type="text" name="usuario-genero" placeholder="Genero" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Facebook: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getUrlFacebook() != null) { %>
                    <input type="text" name="usuario-url-facebook" placeholder="Facebook" value="<%=usuarioModel.getUrlFacebook()%>" required>
                    <% } else { %>
                    <input type="text" name="usuario-url-facebook" placeholder="Facebook" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Instagram: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getUrlInstagram() != null) { %>
                    <input type="text" name="usuario-url-instagram" placeholder="Instagram" value="<%=usuarioModel.getUrlInstagram()%>" required>
                    <% } else { %>
                    <input type="text" name="usuario-url-instagram" placeholder="Instagram" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Linkedin: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getUrlLinkedin() != null) { %>
                    <input type="text" name="usuario-url-linkedin" placeholder="Linkedin" value="<%=usuarioModel.getUrlLinkedin()%>" required>
                    <% } else { %>
                    <input type="text" name="usuario-url-linkedin" placeholder="Linkedin" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Twitter: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getUrlTwitter() != null) { %>
                    <input type="text" name="usuario-url-twitter" placeholder="Twitter" value="<%=usuarioModel.getUrlTwitter()%>" required>
                    <% } else { %>
                    <input type="text" name="usuario-url-twitter" placeholder="Twitter" required>
                    <% } %>
                </div>
            </div>
            <div class="blocos">
                <div class="texto-label">
                    <label class="texto">Biografia: </label>
                </div>
                <div class="texto-input">
                    <% if (usuarioModel.getBiografia() != null) { %>
                    <textarea style="resize: none" rows="4" cols="30" name="usuario-biografia" placeholder="Biografia" required><%=usuarioModel.getBiografia()%></textarea><br>
                    <% } else { %>
                    <textarea style="resize: none" rows="4" cols="30" name="usuario-biografia" placeholder="Biografia" required></textarea><br>
                    <% } %>
                </div>
            </div>
            <div class="blocos2">
                <div class="texto-label">
                    <label>Foto perfil: </label>
                </div>
                <div class="texto-input">
                    <input type="file" name="usuario-foto" placeholder="Foto" required>
                </div>
            </div>




                <input type="hidden" name="usuario-codigo" value="<%=usuarioModel.getCodigo()%>" required>


                <input class="botao-salvar" type="submit" value="Salvar">
        </div>
            </form>

    </div>
</div>
<%
    } catch (NumberFormatException num) {
    }
%>
</body>
</html>
