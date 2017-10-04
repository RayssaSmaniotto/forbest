<%@ page import="dao.UsuarioDAO" %>
<%@ page import="static dao.UsuarioDAO.buscarUsuarioPorId" %>
<%@ page import="model.UsuarioModel" %>
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