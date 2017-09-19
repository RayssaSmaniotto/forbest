<%@ page import="model.UsuarioModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="dados_usuario.jsp">
    <link rel="stylesheet" href="css/perfil.css">
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

    <form method="post" action="usuario_acao_cadastrar.jsp">
        <div class="campos">
            <div>
                <label>Nome: <%= usuarioModel.getNome() %>
                </label>
            </div>
            <div>
                <label>Sobrenome: <%= usuarioModel.getSobrenome() %>
                </label>
            </div>
            <div>
                <label>Idade: </label>
                <input type="text" name="usuario-idade" id="usuario-idade" required="required">
            </div>
            <div>
                <label>Data de Nascimento: </label>
                <input type="text" name="usuario-data-nascimento" id="usuario-data-nascimento" required="required">
            </div>
            <div>
                <label>Email: <%= usuarioModel.getEmail() %>
                </label>
            </div>
            <div>
                <label>Cpf: </label>
                <input type="text" name="usuario-cpf" id="usuario-cpf" required="required">
            </div>
            <div>
                <label>Logradouro: </label>
                <input type="text" name="usuario-logradouro" id="usuario-logradouro" required="required">
            </div>
            <div>
                <label>Número Local</label>
                <input type="text" name="usuario-numero-local" id="usuario-numero-local" required="required">
            </div>
            <div>
                <label>Estado: </label>
                <input type="text" name="usuario-estado" id="usuario-estado" required="required">
            </div>
            <div>
                <label>Cidade: </label>
                <input type="text" name="usuario-cidade" id="usuario-cidade" required="required">
            </div>
            <div>
                <label>Bairro: </label>
                <input type="text" name="usuario-bairro" id="usuario-bairro" required="required">
            </div>
            <div>
                <label>Celular: </label>
                <input type="text" name="usuario-celular" id="usuario-celular" required="required">
            </div>
            <div>
                <label>Gênero: </label>
                <input type="text" name="usuario-genero" id="usuario-genero" required="required">
            </div>
            <input class="cadastrar-botao" type="submit" value="Salvar">
        </div>
    </form>
</div>

</body>

</html>



