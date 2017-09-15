<%@ page import="model.PostModel" %>
<%@ page import="model.PostModel" %>
<%@ page import="dao.PostDAO" %>
<%@ page import="static dao.PostDAO.buscarPostPorId" %><%--
  Created by IntelliJ IDEA.
  User: Henrique Gioppo Roman Ross
  Date: 15/09/2017
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% try {
    int id = Integer.parseInt(request.getParameter("id"));
    if (id > 0) {
        PostDAO.excluir(id);
        PostModel post = buscarPostPorId(id);
        if (post == null) {
        response.sendRedirect("post_lista.jsp?message=OK");
        } else {
        response.sendRedirect("post_lista.jsp?message=INCORRETO");
        }
    }
} catch (NumberFormatException e){

    }
%>