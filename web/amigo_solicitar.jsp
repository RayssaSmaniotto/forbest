<%@ page import="model.AmigoModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page import="dao.AmigoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    AmigoModel amizade = new AmigoModel();
    amizade.setSolicitante(UsuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("id"))));
    amizade.setSolicitado(UsuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("solicitado"))));

    int codigo = AmigoDAO.inserir(amizade);
    if (codigo != -1) {
        response.sendRedirect("deu-errado.jsp");
    } else {
        response.sendRedirect("lista_amigos.jsp?id="+request.getParameter("id"));
    }
%>
