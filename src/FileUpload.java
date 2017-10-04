
import dao.UsuarioDAO;
import database.Utilitarios;
import model.UsuarioModel;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Calendar;

@WebServlet(name = "FileUpload")
@MultipartConfig(maxFileSize = 16177216)
public class FileUpload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* Aluno aluno = new Aluno();
        aluno.setEscola(EscolaDAO.retornarEscolaPorId(Integer.parseInt(request.getParameter("aluno-escola"))));
        aluno.setNome(request.getParameter("aluno-nome"));
        aluno.setEmail(request.getParameter("aluno-email"));
        aluno.setSenha(request.getParameter("aluno-senha"));
        aluno.setDescricao(request.getParameter("aluno-descricao"));
        aluno.setObservacao(request.getParameter("aluno-observacao"));*/

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(request.getParameter("usuario-nome"));
        usuario.setEmail(request.getParameter("usuario-email"));
        usuario.setSenha(request.getParameter("usuario-senha"));
        usuario.setSobrenome(request.getParameter("usuario-sobrenome"));
        usuario.setBiografia(request.getParameter("usuario-biografia"));
        usuario.setEstado(request.getParameter("usuario-estado"));
        usuario.setCelular(request.getParameter("usuario-celular"));
        usuario.setIdade(Integer.parseInt(request.getParameter("usuario-idade")));
        usuario.setDataNascimento(Utilitarios.retornarPadraoSQL(request.getParameter("usuario-data-nascimento")));
        usuario.setCpf(request.getParameter("usuario-cpf"));
        usuario.setCep(request.getParameter("usuario-cep"));
        usuario.setNumero(Integer.parseInt(request.getParameter("usuario-numero")));
        usuario.setLogradouro(request.getParameter("usuario-logradouro"));
        usuario.setCidade(request.getParameter("usuario-cidade"));
        usuario.setBairro(request.getParameter("usuario-bairro"));
        usuario.setGenero(request.getParameter("usuario-genero").charAt(0));
        usuario.setUrlFacebook(request.getParameter("usuario-url-facebook"));
        usuario.setUrlLinkedin(request.getParameter("usuario-url-linkedin"));
        usuario.setUrlTwitter(request.getParameter("usuario-url-twitter"));
        usuario.setUrlInstagram(request.getParameter("usuario-url-instagram"));
        usuario.setCodigo(Integer.parseInt(request.getParameter("usuario-codigo")));

        InputStream is = null;
        Part part = request.getPart("usuario-foto");
        if (part != null) {
            is = part.getInputStream();
        }
        int id = UsuarioDAO.alterar(usuario, is);
        if (id != -1) {
            response.sendRedirect("perfil.jsp?id=" + usuario.getCodigo());
        } else {

        }


    }

    protected void doGet(HttpServletRequest requestuest, HttpServletResponse response) throws ServletException, IOException {

    }
}
