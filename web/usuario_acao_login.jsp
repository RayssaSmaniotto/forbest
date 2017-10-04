<%@ page import="dao.UsuarioDAO" %>
<%@ page import="model.UsuarioModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String email = request.getParameter("usuario-nome");
    String senha = request.getParameter("usuario-senha");
    UsuarioModel usuario = UsuarioDAO.realizarLogin(email, senha);
    if (usuario != null){
        session.setAttribute("usuario", usuario);
        response.sendRedirect("feed.jsp");
    } else {
        session.removeAttribute("usuario");
        response.sendRedirect("entrar.jsp");
    }
%>
