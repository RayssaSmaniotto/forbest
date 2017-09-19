<%@ page import="dao.UsuarioDAO" %>
<%@ page import="model.UsuarioModel" %><%--
  Created by IntelliJ IDEA.
  User: 98932
  Date: 19/09/2017
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String email = request.getParameter("usuario_nome");
    String senha = request.getParameter("usuario_senha");
    UsuarioModel usuario = UsuarioDAO.realizarLogin(email, senha);
    if (usuario != null){
        session.setAttribute("usuario", usuario);
        response.sendRedirect("feed.jsp");
    } else {
        session.removeAttribute("usuario");
        response.sendRedirect("entrar.jsp");
    }
%>

