<%@ page import="dao.UsuarioDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String email = request.getParameter("email");
    String senha = request.getParameter("senha");
    boolean logado = UsuarioDAO.realizarLogin(email, senha);
    if (logado){
        session.setAttribute("email", email);
        response.sendRedirect("bem_vindo_usuario.jsp");
    } else {
        session.removeAttribute("email");
        response.sendRedirect("usuario_login.jsp");
    }
%>
