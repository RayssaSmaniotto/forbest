<%@ page import="model.PostModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page import="java.sql.Date" %><%--
  Created by IntelliJ IDEA.
  User: Henrique Gioppo
  Date: 15/09/2017
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    PostModel post = new PostModel();
    post.setUsuario(UsuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("codigo_usuario"))));
    post.setDescricao(request.getParameter("descricao"));
    post.setTitulo(request.getParameter("titulo"));
    post.setDataEvento(Date.valueOf(request.getParameter("data_evento")));
    post.setStatus(request.getParameter("status"));
    post.setApoios(Integer.parseInt(request.getParameter("apoios")));
    post.setCodigo(Integer.parseInt(request.getParameter("codigo")));


%>