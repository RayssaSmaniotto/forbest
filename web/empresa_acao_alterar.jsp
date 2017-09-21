<%@ page import="model.UsuarioModel" %>
<%@ page import="dao.UsuarioDAO" %><%--
  Created by IntelliJ IDEA.
  User: Henrique Gioppo Roman Ross
  Date: 19/09/2017
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UsuarioModel usuario = new UsuarioModel();
    usuario.setNome(request.getParameter("usuario-nome"));
    usuario.setCnpj(request.getParameter("usuario-cnpj"));
    usuario.setEmail(request.getParameter("usuario-email"));
    usuario.setSenha(request.getParameter("usuario-senha"));
    int codigo = UsuarioDAO.alterar(usuario);
    if(codigo != -1){
        response.sendRedirect("usuario-alterar.jsp?id=" + usuario.getCodigo());
    }else{

    }
%>
