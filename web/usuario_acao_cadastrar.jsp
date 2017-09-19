<%@ page import="dao.UsuarioDAO" %>
<%@ page import="model.UsuarioModel" %>
<%@ page import="java.util.zip.DataFormatException" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    try {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(request.getParameter("usuario-nome"));
        usuario.setEmail(request.getParameter("usuario-email"));
        usuario.setSenha(request.getParameter("usuario-senha"));
        int id = UsuarioDAO.inserir(usuario);
        if (id != -1) {
            response.sendRedirect("perfil.jsp?id=" + id);
        } else {

        }
    } catch (NumberFormatException num) {
        num.printStackTrace();
    }
%>