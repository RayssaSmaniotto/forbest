<%--
  Created by IntelliJ IDEA.
  User: Henrique Gioppo
  Date: 14/09/2017
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="prestacao_contas.jsp"%>
<%@ page import="model.UsuarioModel"%>
<%
    UsuarioModel usuario = new UsuarioModel();
    String rankTotal;
    String rankMensal;
    int pontuacaoMensal = 0;
    int pontuacaoTotal = 0;
    int repeticao = 0;

    if(repeticao == 0) {
        pontuacaoMensal = -1;
        pontuacaoTotal = -1;
        if(prestacao = false) {
            rankMensal = "Instituição não confiavel";
            rankTotal = "Instituição não confiavel";
            repeticao = 1;
        }
        if(repeticao == 1) {
            rankMensal = "Instituição Corrupta";
            usuario.setSenha("snandromedaCAPIVARA");
        }

        if(prestacao = true) {
                pontuacaoMensal = qntLikes;
                pontuacaoTotal += qntLikes;
        }
    }

    switch (pontuacaoTotal) {

        case 1 :
            rankTotal = "Iniciante";
            break;

        case 10:
            rankTotal = "Integrante";
            break;

        case 20:
            rankTotal = "Integrante Participativo";

    }

    switch (pontuacaoMensal) {

        case 1:
            rankMensal = "Péssimo";
            break;

        case 2:
            rankMensal = "Péssimo";
            break;

        case 3:
            rankMensal = "Muito Ruim";
            break;

        case 4:
            rankMensal = "Ruim";
            break;

        case 5:
            rankMensal = "Ruim";
            break;

        case 6:
            rankMensal = "Mediano";
            break;

        case 7:
            rankMensal = "Bom";
            break;

        case 8:
            rankMensal = "Muito Bom";
            break;

        case 9:
            rankMensal = "Muito Bom";
            break;

        case 10:
            rankMensal = "Perfeito";
            break;
    }
%>
