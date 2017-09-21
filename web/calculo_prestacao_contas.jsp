<%@ page import="model.PostModel" %>
<%@ page import="dao.PostDAO" %>
<%@ page import="dao.DoacaoDAO" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page import="model.UsuarioModel" %>
<%@ page import="model.DoacaoModel" %><%--
  Created by IntelliJ IDEA.
  User: Henrique Gioppo Roman Ross
  Date: 19/09/2017
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    double total = 0;
    double informado = 0;

    UsuarioModel usuario = UsuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("id")));
    PostModel post = PostDAO.buscarPostPorId(Integer.parseInt(request.getParameter("id")));

    for (DoacaoModel doacao : post.getDoacoes()) {
        total += DoacaoDAO.buscarDoacaoPorIdDoPost(post.getCodigo()).get(Integer.parseInt("?")).getValor();
    }
    if(informado != total) {
        usuario.setSenha("snAndromedaCapivara");
        response.sendRedirect("index.jsp");
        //o usuario vai ter a senha alterada para saAndromedaCapivara e ela vai ser atualizada não permitindo o acesso deste.
    }

%>
