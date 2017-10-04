<%@ page import="dao.UsuarioDAO" %>
<%@ page import="model.UsuarioModel" %>
<%@ page import="java.util.zip.DataFormatException" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.DataInputStream" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    try {
        request.setCharacterEncoding("UTF-8");
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(request.getParameter("usuario-nome"));
        usuario.setEmail(request.getParameter("usuario-email"));
        usuario.setSenha(request.getParameter("usuario-senha"));

        //usuario.setCodigo(UsuarioDAO.inserir(usuario));

        DataInputStream Imagem = new DataInputStream(request.getInputStream());
        int id = UsuarioDAO.inserir(usuario, Imagem);
        if (id != -1) {
            usuario.setCodigo(id);
            System.out.println(id );
            session.setAttribute("usuario", usuario);
            response.sendRedirect("perfil.jsp?id=" + usuario.getCodigo());
        } else {
            response.sendRedirect("perfil.jsp?id=" + usuario.getCodigo());
        }
    } catch (NumberFormatException num) {
        num.printStackTrace();
    }
%>