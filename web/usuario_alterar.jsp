<%@ page import="dao.UsuarioDAO" %>
<%@ page import="model.UsuarioModel" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" href="css/entrar.css">
</head>

<body>
<% UsuarioModel usuario = UsuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("id"))); %>
<form method="post" action="usuario_acao_cadastrar.jsp">
    <div>
        <label for="usuario-nome">Nome</label>
        <input type="text" name="usuario-nome" id="usuario-nome" required="required" value="<%= usuario.getNome() %>">
    </div>
    <div>
        <label for="usuario-sobrenome">Sobrenome</label>
        <input type="text" name="usuario-sobrenome" id="usuario-sobrenome" required="required"
               value="<%= usuario.getSobrenome() %>">
    </div>
    <div>
        <label for="usuario-idade">Idade</label>
        <input type="number" name="usuario-idade" id="usuario-idade" required="required"
               value="<%= usuario.getIdade() %>">
    </div>
    <div>
        <label for="usuario-data-nascimento">Data de Nacimento</label>
        <input type="date" name="usuario-data-nascimento" id="usuario-data-nascimento" required="required"
               value="<%= usuario.getDataNascimento() %>">
    </div>
    <div>
        <label for="usuario-email">E-mail</label>
        <input type="text" name="usuario-email" id="usuario-email" required="required"
               value="<%= usuario.getEmail() %>">
    </div>
    <div>
        <label for="usuario-cpf">CPF</label>
        <input type="text" name="usuario-cpf" id="usuario-cpf" required="required" value="<%= usuario.getCpf() %>">
    </div>
    <div>
        <label for="usuario-cep">CEP</label>
        <input type="text" name="usuario-cep" id="usuario-cep" required="required" value="<%= usuario.getCep() %>">
    </div>
    <div>
        <label for="usuario-logradouro">Rua</label>
        <input type="text" name="usuario-logradouro" id="usuario-logradouro" required="required"
               value="<%= usuario.getLogradouro() %>">
    </div>
    <div>
        <label for="usuario-numero-local">Numero Da Casa</label>
        <input type="number" name="usuario-numero-local" id="usuario-numero-local" required="required"
               value="<% usuario.getNumeroLocal();%>">
    </div>
    <div>
        <label for="usuario-estado">Estado</label>
        <select name="usuario-estado" id="usuario-estado" required="required">
            <option>AC</option>
            <option>AL</option>
            <option>AP</option>
            <option>AM</option>
            <option>BA</option>
            <option>CE</option>
            <option>DF</option>
            <option>ES</option>
            <option>GO</option>
            <option>MA</option>
            <option>MT</option>
            <option>MS</option>
            <option>MG</option>
            <option>PA</option>
            <option>PB</option>
            <option>PR</option>
            <option>PE</option>
            <option>PI</option>
            <option>RJ</option>
            <option>RN</option>
            <option>RS</option>
            <option>RO</option>
            <option>RR</option>
            <option>SC</option>
            <option>SP</option>
            <option>SE</option>
            <option>TO</option>
        </select>
    </div>
    <div>
        <label for="usuario-cidade">Cidade</label>
        <input type="text" name="usuario-cidade" id="usuario-cidade" required="required"
               value="<%= usuario.getCidade()%>">
    </div>
    <div>
        <label for="usuario-bairro">Bairro</label>
        <input type="text" name="usuario-bairro" id="usuario-bairro" required="required"
               value="<%= usuario.getBairro()%>">
    </div>
    <div>
        <label for="usuario-senha">Senha</label>
        <input type="password" name="usuario-senha" id="usuario-senha" required="required"
               value="<%= usuario.getSenha()%>">
    </div>
    <div>
        <label for="usuario-celular">Celular</label>
        <input type="text" name="usuario-celular" id="usuario-celular" required="required"
               value="<%= usuario.getCelular()%>">
    </div>
    <div>
        <label for="usuario-genero">Genero</label>
        <select id="usuario-genero" name="usuario-genero" required="required">
            <option>Masculino</option>
            <option>Feminino</option>
        </select>
    </div>
    <button type="submit">Alterar</button>
</form>
</div>

</body>
</html>
