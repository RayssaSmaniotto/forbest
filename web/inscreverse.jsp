<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>4Best</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/inscreverse.css">
</head>
<body>
<div class="inscreverse">
    <div class="inscreverse-box">
        <p id="titulo">Participe do 4Best. Inscreva-se!</p>
        <div class="cadastro-empresa">
            <label>Instituição</label>
            <form action="usuario_acao_cadastrar.jsp" method="post">
                <div>
                    <input class="cadastro-nome" type="text" name="usuario-nome" placeholder="Nome da Empresa">
                </div>
                <div>
                    <input class="cadastro-cnpj" type="text" name="cadastro-cnpj" placeholder="CNPJ">
                </div>

                <div>
                    <input class="cadastro-email" type="text" name="usuario-email" placeholder="Email">
                </div>
                <div>
                    <input class="cadastro-senha" type="password" name="usuario-senha" placeholder="Senha">
                    <input class="botao-entrar" type="submit" value="Inscrever-se">
                </div>
            </form>
        </div>
        <div class="cadastro-pessoa">
            <label>Usuário</label>
            <form action="usuario_acao_cadastrar.jsp" method="post">
                <div>
                    <input class="cadastro-nome" type="text" name="usuario-nome" placeholder="Nome Completo">
                </div>
                <div>
                    <input class="cadastro-email" type="text" name="usuario-email" placeholder="Email">
                </div>
                <div>
                    <input class="cadastro-senha" type="password" name="usuario-senha" placeholder="Senha">
                    <input class="botao-entrar" type="submit" value="Inscrever-se">
                </div>
            </form>
        </div>
        <div class="div-codicao-termos">

            <label class="codicao_termos">Ao inscrever-se, você concorda com os Termos de Serviço e a Política de
                Privacidade, incluindo o Uso de Cookies. Outros poderão encontrá-lo por e-mail ou número de celular,
                quando fornecido.</label>
        </div>


    </div>

</div>

</body>
</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>4Best</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/inscreverse.css">
</head>
<body>

<div class="pai">
    <div class="inscreverse-box">
        <h1 id="titulo">Participe do 4Best. Inscreva-se!</h1>
        <div class="cadastro-empresa">
            <div class="intituicao">
                <label class="instituicao-text"><h2>Instituição</h2></label>
            </div>
            <form action="usuario_acao_cadastrar.jsp" method="post">
                <div>
                    <input class="cadastro-dados" type="text" name="usuario-nome" placeholder="Nome da Empresa">
                </div>
                <div>
                    <input class="cadastro-dados" type="text" name="cadastro-cnpj" placeholder="CNPJ">
                </div>

                <div>
                    <input class="cadastro-dados" type="text" name="usuario-email" placeholder="Email">
                </div>
                <div>
                    <input class="cadastro-dados" type="password" name="usuario-senha" placeholder="Senha">

                </div>
                <div class="botao-entrar-impresa">
                    <input class="botao-entrar-imp" type="submit" value="Inscrever-se">

                </div>
            </form>
        </div>
        <div class="cadastro-pessoa">
            <label class="usuario-text"><h2>Usuário</h2></label>
            <form action="usuario_acao_cadastrar.jsp" method="post">
                <div>
                    <input class="cadastro-dados" type="text" name="usuario-nome" placeholder="Nome">
                </div>
                <div>
                    <input class="cadastro-dados" type="text" name="usuario-email" placeholder="Email">
                </div>
                <div>
                    <input class="cadastro-dados" type="password" name="usuario-senha" placeholder="Senha">

                </div>
                <div class="botao-entrar-pessoa">
                    <input class="botao-entrar-pes" type="submit" value="Inscrever-se">
                </div>
            </form>
        </div>
        <div class="div-codicao-termos">

            <label class="codicao_termos">Ao inscrever-se, você concorda com os Termos de Serviço e a Política de
                Privacidade, incluindo o Uso de Cookies. Outros poderão encontrá-lo por e-mail ou número de celular,
                quando fornecido.</label>
        </div>


    </div>
</div>





</body>
</html>