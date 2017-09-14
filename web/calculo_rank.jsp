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
    String rankPassado;
    double pontuacaoMensal = 0;
    double pontuacaoTotal = 0;
    int repeticao = 0;

    if(prestacao = false) {
        if(repeticao == 0) {
            pontuacaoMensal = -1;
            pontuacaoTotal = -1;
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
%>
