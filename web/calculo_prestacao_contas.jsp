<%@ page import="model.PostModel" %>
<%@ page import="dao.PostDAO" %>
<%@ page import="model.DoacaoModel" %>
<%@ page import="dao.DoacaoDAO" %>
<%@ page import="dao.UsuarioDAO" %>
<%@ page import="model.UsuarioModel" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Array" %><%--
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
    int contador = 0;

    UsuarioModel usuario = UsuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("id")));
    PostModel post = PostDAO.buscarPostPorId(Integer.parseInt(request.getParameter("id")));

    total += DoacaoDAO.buscarDoacaoPorIdDoPost(post.getCodigo()).get(1).getValor();

    if(informado != total) {
        usuario.setSenha("snAndromedaCapivara");
        response.setHeader("Refresh", "endereço da pagina");
        //tem que por o endereço da pagina.
    }

%>
