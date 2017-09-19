<%@ page import="model.UsuarioModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page import="static dao.UsuarioDAO.buscarUsuarioPorId" %><%--
  Created by IntelliJ IDEA.
  User: 98932
  Date: 19/09/2017
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    try {
        int id = Integer.parseInt(request.getParameter("id"));
        if (id > 0) {
            UsuarioDAO.excluir(id);
            UsuarioModel usuario = buscarUsuarioPorId(id);
            if (usuario == null) {
                response.sendRedirect("usuario_lista.jsp?message=OK");
            } else {
                response.sendRedirect("usuario_lista.jsp?message=INCORRETO");
            }
        }
    }catch (NumberFormatException e){

    }
%>
