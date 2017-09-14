<%@ page import="dao.UsuarioDAO" %>
<%@ page import="model.UsuarioModel" %>
<%@ page import="java.util.zip.DataFormatException" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UsuarioModel usuario = new UsuarioModel();
    usuario.setNome(request.getParameter("usuario-nome"));
    usuario.setSobrenome(request.getParameter("usuario-sobrenome"));
    usuario.setIdade(Integer.parseInt(request.getParameter("usuario-idade")));

    String dataNascimento = request.getParameter("usuario-data-nascimento");
    String[] campos = dataNascimento.split("-");
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(campos[2]));
    calendar.set(Calendar.MONTH, Integer.parseInt(campos[1]));
    calendar.set(Calendar.YEAR, Integer.parseInt(campos[0]));
    usuario.setDataNascimento(new Date(calendar.getTimeInMillis()));

    usuario.setEmail(request.getParameter("usuario-email"));
    usuario.setCpf(request.getParameter("usuario-cpf"));
    usuario.setCep(request.getParameter("usuario-cep"));
    usuario.setNumero(Integer.parseInt(request.getParameter("usuario-numero-local")));
    usuario.setLogradouro(request.getParameter("usuario-logradouro"));
    usuario.setEstado(request.getParameter("usuario-estado"));
    usuario.setCidade(request.getParameter("usuario-cidade"));
    usuario.setBairro(request.getParameter("usuario-bairro"));
    usuario.setSenha(request.getParameter("usuario-senha"));
    usuario.setCelular(request.getParameter("usuario-celular"));
    usuario.setGenero(request.getParameter("usuario-genero").charAt(0));
    usuario.setBiografia(request.getParameter("usuario-biografia"));
//  usuario.setfoto();
//  usuario.setGaleria();
//  usuario.setUrlFacebook(request.getParameter("usuario-url-facebook"));
//  usuario.setUrlLinkedin(request.getParameter("usuario-url-linkedin"));
//  usuario.setUrlTwitter(request.getParameter("usuario-url-twitter"));
//  usuario.setUrlInstagram(request.getParameter("usuario-url-instagram"));
    int id = UsuarioDAO.inserir(usuario);
    if (id != -1) {
        response.sendRedirect("usuario_alterar.jsp?id=" + id);
    } else {

    }
%>