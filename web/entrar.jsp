
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>4Best</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/entrar.css">
</head>
<body>
<div class="entrar">
    <div class="entrar-box">

        <div class="entrar-campo">
            <form action="usuario_acao_login.jsp" method="POST">

                <h1 class="titulo">Entre em 4Best</h1>

                <div class="input-usuario" >
                    <input type="text" name="usuario_nome" placeholder="Usuario">
                </div>
                <div>
                    <input  class="input-senha"  type="password" name="usuario_senha" placeholder="Senha">
                </div>
                <div>
                    <input class="botao-entrar" type="submit" value="Entrar" >
                </div>
                <p class="text-inscrever">Não tem uma conta? <a class="inscrever" href="dados_usuario.jsp">Inscreva-se »</a></p>

            </form>
        </div>
    </div>
</div>
</body>
</div>
</body>
</html>
