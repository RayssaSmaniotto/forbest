<html>

<head>

<body>

<form method="post" action="usuario_acao_cadastrar.jsp">
    <div class="campos">
        <div>
            <label for="usuario-nome">Nome</label>
            <input type="text" name="nome" id="usuario-nome">
        </div>
        <div>
            <label for="usuario-sobrenome">Sobrenome</label>
            <input type="text" name="sobrenome" id="usuario-sobrenome">
        </div>
        <div>
            <label for="usuario-idade">Idade</label>
            <input type="number" name="idade" id="usuario-idade">
        </div>
        <div>
            <label for="usuario-dataNascimento">Data de Nacimento</label>
            <input type="date" name="data_nascimento" id="usuario-dataNascimento">
        </div>
        <div>
            <label for="usuario-email">E-mail</label>
            <input type="text" name="email" id="usuario-email">
        </div>

        <div>
            <label for="usuario-cpf">CPF</label>
            <input type="text" name="cpf" id="usuario-cpf">
        </div>
        <div>
            <label for="usuario-cep">CEP</label>
            <input type="text" name="cep" id="usuario-cep">
        </div>
        <div>
            <label for="usuario-rua">Rua</label>
            <input type="text" name="rua" id="usuario-rua">
        </div>
        <div>
            <label for="usuario-numeroLocal">Numero Da Casa</label>
            <input type="number" name="numero_local" id="usuario-numeroLocal">
        </div>
        <div>
            <label for="usuario-estado">Estado</label>
            <select>
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
            <input type="text" name="estado" id="usuario-estado">
        </div>
        <div>
            <label for="usuario-cidade">Cidade</label>
            <input type="text" name="cidade" id="usuario-cidade">
        </div>
        <div>
            <label for="usuario-bairro">Bairro</label>
            <input type="text" name="bairro" id="usuario-bairro">
        </div>
        <div>
            <label for="usuario-senha">Senha</label>
            <input type="password" name="senha" id="usuario-senha">
        </div>
        <div>
            <label for="usuario-celular">Celular</label>
            <input type="text" name="celular" id="usuario-celular">
        </div>
        <div>
            <label for="usuario-genero">Genero</label>
            <select>
                <option>Masculino</option>
                <option>Feminino</option>
            </select>
            <input type="text" name="genero" id="usuario-genero">
        </div>

        <button type="submit">Cadastrar</button>
    </div>
</form>
</body>

</html>