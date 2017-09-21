<%--
  Created by IntelliJ IDEA.
  User: Henrique Gioppo Roman Ross
  Date: 20/09/2017
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PrestacaoContas</title>
    <link rel="stylesheet" href="css/prestacao_contas.css">
</head>

<body>
    <div class = "dados">
        <div class = "segundo_fundo">
            <form action="calculo_prestacao_contas.jsp" method="POST">
                <div class="titulo">Quantidade em reais recebida no ultimo mês </div>

                <div class="input-quantidade">
                    <input type="number" name="input-quantidade" placeholder="R$">
                </div>

                <div class="botao-enviar">
                    <input type="button" onclick="alert('Obrigado')" value="Enviar">
                </div>
            </form>
        </div>
    </div>

    <div class="menu-superior">
        <div class="logo">
            <img id="logo" src="assets/image/Logo-For-Best-60x72.png">

        </div>
    </div>

</body>
</html>