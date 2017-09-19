<%@ page import="model.UsuarioModel" %>
<%@ page import="dao.UsuarioDAO" %>
<html>

<head>
    <link rel="stylesheet" href="css/perfil_empresa.css">
</head>
<body>

<form method="post" action="perfil_empresa.jsp">
    <div class="campos">
        <div>
            <label for="usuario-nome">Nome da Empresa</label>
            <input type="text" name="usuario-nome" id="usuario-nome" required="required">
        </div>
        <div>
            <label for="usuario-cnpj">CNPJ</label>
            <input type="text" name="usuario-cnpj" id="usuario-cnpj" required="required">
        </div>
        <div>
            <label for="usuario-email">E-mail</label>
            <input type="text" name="usuario-email" id="usuario-email" required="required">
        </div>
        <div>
            <label for="usuario-senha">Senha</label>
            <input type="password" name="usuario-senha" id="usuario-senha" required="required">
        </div>
    </div>
</form>

</div>

</body>

</html>