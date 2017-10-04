<%@ page import="model.PostModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page import="java.sql.Date" %>
<%@ page import="dao.PostDAO" %>
<%@ page import="javafx.geometry.Pos" %><%--
  Created by IntelliJ IDEA.
  User: Henrique Gioppo
  Date: 15/09/2017
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    PostModel post = PostDAO.buscarPostPorId(Integer.parseInt(request.getParameter("id")));
//  post.setUsuario(UsuarioDAO.buscarUsuarioPorId(1));
//  post.setUsuario(UsuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("codigo_usuario"))));
    post.setDescricao(request.getParameter("descricao"));
    post.setTitulo(request.getParameter("titulo"));
//  post.setDataEvento(Date.valueOf(request.getParameter("data_evento")));
//  post.setStatus(request.getParameter("status"));


    int codigo = PostDAO.alterar(post);
    if (codigo != -1) {
        response.sendRedirect("deu-errado.jsp?id=" + post.getCodigo());
    } else {
        response.sendRedirect("feed.jsp?id=" + post.getCodigo());
    }
%>