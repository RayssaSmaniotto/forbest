<%@ page import="model.PostModel" %>
<%@ page import="dao.PostDAO" %>
<%@ page import="static dao.PostDAO.buscarPostPorId" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% try {
    int id = Integer.parseInt(request.getParameter("id"));
    if (id > 0) {
        PostDAO.excluir(id);
        PostModel post = buscarPostPorId(id);
        if (post == null) {
            response.sendRedirect("feed.jsp?message=OK");
        } else {
            response.sendRedirect("feed.jsp?message=INCORRETO");
        }
    }
} catch (NumberFormatException e) {
}
%>