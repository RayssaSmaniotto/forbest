<%@ page import="model.UsuarioModel" %>
<%@ page import="dao.UsuarioDAO" %>
<html>

<head>
    <link rel="stylesheet" href="css/dado-usuarios.css">
</head>

<body>

<form method="post" action="usuario-acao-cadastrar.jsp">
    <div class="campos">
        <div>
            <label for="usuario-nome">Nome</label>
            <input type="text" name="usuario-nome" id="usuario-nome" required="required">
        </div>
        <div>
            <label for="usuario-sobrenome">Sobrenome</label>
            <input type="text" name="usuario-sobrenome" id="usuario-sobrenome" required="required">
        </div>
        <div>
            <label for="usuario-idade">Idade</label>
            <input type="number" name="usuario-idade" id="usuario-idade" required="required">
        </div>
        <div>
            <label for="usuario-data-nascimento">Data de Nacimento</label>
            <input type="date" name="usuario-data-nascimento" id="usuario-data-nascimento" required="required">
        </div>
        <div>
            <label for="usuario-email">E-mail</label>
            <input type="email" name="usuario-email" id="usuario-email" required="required">
        </div>

        <div>
            <label for="usuario-cpf">CPF</label>
            <input type="text" name="usuario-cpf" id="usuario-cpf" required="required">
        </div>
        <div>
            <label for="usuario-cep">CEP</label>
            <input type="text" name="usuario-cep" id="usuario-cep" required="required">
        </div>
        <div>
            <label for="usuario-logradouro">Rua</label>
            <input type="text" name="usuario-logradouro" id="usuario-logradouro" required="required">
        </div>
        <div>
            <label for="usuario-numero-local">Numero Da Casa</label>
            <input type="number" name="usuario-numero-local" id="usuario-numero-local" required="required">
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
            <input type="text" name="usuario-cidade" id="usuario-cidade" required="required">
        </div>
        <div>
            <label for="usuario-bairro">Bairro</label>
            <input type="text" name="usuario-bairro" id="usuario-bairro" required="required">
        </div>
        <div>
            <label for="usuario-senha">Senha</label>
            <input type="password" name="usuario-senha" id="usuario-senha" required="required">
        </div>
        <div>
            <label for="usuario-celular">Celular</label>
            <input type="text" name="usuario-celular" id="usuario-celular" required="required">
        </div>
        <div>
            <label for="usuario-genero">Genero</label>
            <select id="usuario-genero" name="usuario-genero">
                <option>Masculino</option>
                <option>Feminino</option>
            </select>
        </div>
        <input class="cadastrar-botao" type="submit" value="Salvar">
    </div>
</form>

</div>


</body>

</html>