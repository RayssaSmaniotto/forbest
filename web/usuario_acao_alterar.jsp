<%--
  Created by IntelliJ IDEA.
  User: Henrique Gioppo
  Date: 12/09/2017
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.UsuarioModel"%>
<%@ page import="dao.UsuarioDAO" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.Blob" %>
<%
    UsuarioModel usuario = UsuarioDAO.buscarUsuarioPorId(Integer.parseInt(request.getParameter("id")));
    usuario.setNome(request.getParameter("usuario-nome"));
    usuario.setSobrenome(request.getParameter("usuario-sobrenome"));
    usuario.setBiografia(request.getParameter("usuario-biografia"));
    usuario.setEstado(request.getParameter("usuario-estado"));
    usuario.setCelular(request.getParameter("usuario-celular"));
  /*  usuario.setFoto(Blob.parseBlob(request.getParameter("background-image")));*/
    usuario.setEmail(request.getParameter("usuario-email"));
    usuario.setIdade(Integer.parseInt(request.getParameter("usuario-idade")));


    //usuario.setDataNascimento(request.getParameter("usuario-data-aniversario"));


  /*  String valor = jFormattedTextFieldDataPagamentoContaPagar1.getText();
    int dia = Integer.parseInt(valor.substring(0, 2));
    int mes = Integer.parseInt(valor.substring(3, 5));
    int ano = Integer.parseInt(valor.substring(6, 10));
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.DAY_OF_MONTH, dia);
    calendar.set(Calendar.MONTH, mes);
    calendar.set(Calendar.YEAR, ano);*/

 /*   usuario.setCodigo(Integer.parseInt(request.getParameter("codigo")));
    usuario.setNome(request.getParameter("nome"));
    usuario.setSobrenome(request.getParameter("sobrenome"));
    usuario.setIdade(Integer.parseInt(request.getParameter("idade")));
    usuario.setDataNascimento(Date.valueOf(request.getParameter("data_nascimento")));
    usuario.setEmail(request.getParameter("email"));
    usuario.setRazaoSocial(request.getParameter("razao_social"));
    usuario.setCnpj(request.getParameter("cnpj"));
    usuario.setCpf(request.getParameter("cpf"));
    usuario.setCep(request.getParameter("cep"));
    usuario.setNumero(Integer.parseInt(request.getParameter("numero")));
    usuario.setLogradouro(request.getParameter("logradouro"));
    usuario.setEstado(request.getParameter("estado"));
    usuario.setCidade(request.getParameter("cidade"));
    usuario.setBairro(request.getParameter("bairro"));
    usuario.setSenha(request.getParameter("senha"));
    usuario.setCelular(request.getParameter("celular"));
    usuario.setGenero(request.getParameter("genero").charAt(0));
    usuario.setBiografia(request.getParameter("biografia"));
    usuario.setfoto();
    usuario.setGaleria();
    usuario.setUrlFacebook(request.getParameter("url_facebook"));
    usuario.setUrlLinkedin(request.getParameter("url_linkedin"));
    usuario.setUrlTwitter(request.getParameter("url_twitter"));
    usuario.setUrlInstagram(request.getParameter("url_instagram"));
    usuario.setNumeroLocal(Integer.parseInt(request.getParameter("numero_local"))); */


    int codigo = UsuarioDAO.alterar(usuario);
    if(codigo != -1){
        response.sendRedirect("usuario_alterar.jsp?id=" + usuario.getCodigo());
    }else{
        response.sendRedirect("perfil.jsp?id=" + usuario.getCodigo());
    }
%>
