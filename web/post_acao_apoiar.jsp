<%@ page import="model.PostModel" %>
<%@ page import="dao.PostDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    PostModel post = PostDAO.buscarPostPorId(Integer.parseInt(request.getParameter("id")));
    int codigo = PostDAO.apoiar(post);
    if (codigo != -1) {
        response.sendRedirect("deu-errado.jsp?id=" + post.getCodigo());
    } else {
        response.sendRedirect("feed.jsp");
    }
%>