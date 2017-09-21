<%@ page import="model.PostModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page import="java.sql.Date" %>
<%@ page import="dao.PostDAO" %><%--
  Created by IntelliJ IDEA.
  User: Henrique Gioppo
  Date: 15/09/2017
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    PostModel post = new PostModel();
    post.setUsuario(UsuarioDAO.buscarUsuarioPorId(1));
//  post.setUsuario(UsuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("codigo_usuario"))));
    post.setDescricao(request.getParameter("post-descricao"));
    post.setTitulo(request.getParameter("post-assunto"));
//  post.setDataEvento(Date.valueOf(request.getParameter("data-evento")));

    int id = PostDAO.inserir(post);
    if (id != -1) {
        response.sendRedirect("feed.jsp");
    } else {

    }
%>