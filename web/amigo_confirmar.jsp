<%@ page import="model.AmigoModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page import="dao.AmigoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int codigo = AmigoDAO.aceitarSolicitacao(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("solicitante")),Integer.parseInt(request.getParameter("situacao")));
    if (codigo != -1) {
        response.sendRedirect("deu-errado.jsp");
    } else {
        response.sendRedirect("lista_amigos.jsp?id="+request.getParameter("id"));
    }
%>