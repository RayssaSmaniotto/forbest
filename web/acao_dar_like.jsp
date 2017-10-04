<%@ page import="model.PostModel" %>
<%--
  Created by IntelliJ IDEA.
  User: Henrique Gioppo
  Date: 20/09/2017
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    PostModel post = null;
    String sql = "UPDATE posts SET apoios = ? WHERE codigo = ?";

    //Precisa do butão
%>
