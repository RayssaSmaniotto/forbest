<%@ page import="model.UsuarioModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UsuarioModel usuario = new UsuarioModel();
    usuario.setNome(request.getParameter("usuario-nome"));
    usuario.setCnpj(request.getParameter("usuario-cnpj"));
    usuario.setEmail(request.getParameter("usuario-email"));
    usuario.setSenha(request.getParameter("usuario-senha"));
    int id = UsuarioDAO.inserir(usuario);
    if (id != -1) {
        response.sendRedirect("perfil-empresa.jsp?id=" + id);
    } else {

    }
%>
