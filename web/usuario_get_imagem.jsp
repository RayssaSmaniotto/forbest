
<%@ page import="java.io.OutputStream" %>
<%@ page import="model.UsuarioModel" %>
<%@ page import="dao.UsuarioDAO" %>
<%
    int idAluno = Integer.parseInt(request.getParameter("id"));
    UsuarioModel usuario = UsuarioDAO.buscarUsuarioPorId(idAluno);

    byte[] byteArray = usuario.getFoto().getBytes(1, (int) usuario.getFoto().length());
    OutputStream outputStream = response.getOutputStream();
    outputStream.write(byteArray);
    outputStream.flush();
    outputStream.close();
%>