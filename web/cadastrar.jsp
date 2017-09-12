<%@ page import="dao.UsuarioDAO" %>
<%@ page import="model.UsuarioModel" %>
<%@ page import="java.util.zip.DataFormatException" %>
<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UsuarioModel usuario = new UsuarioModel();
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
    usuario.setCelular(request.getParameter("celular"));
    usuario.setCelular(request.getParameter("celular"));




%>  private int numeroLocal,;
    private String  , , biografia, urlFacebook, urlLinkedin, urlTwitter, urlInstagram;
    private char genero;
    private Blob foto, galeria;


  ,  biografia, foto, galeria, "
+ "url_facebook, url_linkedin, url_twitter, url_instagram, numero_local)