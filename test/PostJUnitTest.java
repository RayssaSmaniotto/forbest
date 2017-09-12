
import dao.PostDAO;
import dao.UsuarioDAO;
import database.Limpeza;
import java.sql.Date;
import java.util.Calendar;
import model.PostModel;
import model.UsuarioModel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Antonio Pedro 22/08/2017
 */
public class PostJUnitTest {

    @Test
    public void testarCriacao() {
        Limpeza.truncateTabelas();
        UsuarioModel usuario = new UsuarioModel();

        usuario.setIdade(10);
        usuario.setNumero(10);
        usuario.setNumeroLocal(5);
        usuario.setNome("Antonio");
        usuario.setSobrenome("Pedro");
        usuario.setEmail("antoniopikadura@gmail.com");
        usuario.setRazaoSocial("Trabalho");
        usuario.setCnpj("213547634");
        usuario.setCpf("213547634");
        usuario.setCep("213547634");
        usuario.setEstado("SC");
        usuario.setCidade("Blumenau");
        usuario.setLogradouro("Rua Jose Roiter");
        usuario.setBairro("velha");
        usuario.setSenha("123Zezinho321");
        usuario.setCelular("213547634");
        usuario.setBiografia("VASP");
        usuario.setUrlFacebook("urlFace");
        usuario.setUrlLinkedin("urlLinkedin");
        usuario.setUrlTwitter("urlTwiter");
        usuario.setUrlInstagram("urlInsta");
        Calendar calendario = Calendar.getInstance();
        calendario.set(2000, 1, 30);
        usuario.setDataNascimento(new Date(calendario.getTimeInMillis()));
        usuario.setGenero('m');
        usuario.setCodigo(UsuarioDAO.inserir(usuario));

        PostModel postModel = new PostModel();
        postModel.setDescricao("vila nova campeao");
        postModel.setStatus("online");
        postModel.setTitulo("tombo massa");
        postModel.setApoios(1);
        postModel.setUsuario(usuario);
    }

    @Test
    public void testarBuscarCidadePorId() {
        Limpeza.truncateTabelas();
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setIdade(10);
        usuarioModel.setNumero(10);
        usuarioModel.setNumeroLocal(5);
        usuarioModel.setNome("Antonio");
        usuarioModel.setSobrenome("Pedro");
        usuarioModel.setEmail("antoniopikadura@gmail.com");
        usuarioModel.setRazaoSocial("Trabalho");
        usuarioModel.setCnpj("213547634");
        usuarioModel.setCpf("213547634");
        usuarioModel.setCep("213547634");
        usuarioModel.setEstado("SC");
        usuarioModel.setCidade("Blumenau");
        usuarioModel.setLogradouro("Rua Jose Roiter");
        usuarioModel.setBairro("velha");
        usuarioModel.setSenha("123Zezinho321");
        usuarioModel.setCelular("213547634");
        usuarioModel.setBiografia("VASP");
        usuarioModel.setUrlFacebook("urlFace");
        usuarioModel.setUrlLinkedin("urlLinkedin");
        usuarioModel.setUrlTwitter("urlTwiter");
        usuarioModel.setUrlInstagram("urlInsta");
        Calendar calendario = Calendar.getInstance();
        calendario.set(2000, 1, 30);
        usuarioModel.setDataNascimento(new Date(calendario.getTimeInMillis()));
        usuarioModel.setGenero('m');
        usuarioModel.setCodigo(UsuarioDAO.inserir(usuarioModel));

        PostModel postModel = new PostModel();
        postModel.setDescricao("vila nova campeao");
        postModel.setStatus("online");
        postModel.setTitulo("tombo massa");
        postModel.setApoios(1);
        postModel.setUsuario(usuarioModel);
        postModel.setCodigo(PostDAO.inserir(postModel));

        PostModel postBuscado = PostDAO.buscarPostPorId(postModel.getCodigo());
        assertEquals(postBuscado.getCodigo(), postModel.getCodigo());
        assertEquals(postBuscado.getDescricao(), postModel.getDescricao());
        assertEquals(postBuscado.getStatus(), postModel.getStatus());
        assertEquals(postBuscado.getUsuario().getCodigo(), postModel.getUsuario().getCodigo());
        assertEquals(postBuscado.getApoios(), postModel.getApoios());
        assertEquals(postBuscado.getDataEvento(), postModel.getDataEvento());
        assertEquals(postBuscado.getTitulo(), postModel.getTitulo());
    }

    @Test
    public void testarAlterar() {
        Limpeza.truncateTabelas();
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setIdade(10);
        usuarioModel.setNumero(10);
        usuarioModel.setNumeroLocal(5);
        usuarioModel.setNome("rayssa");
        usuarioModel.setSobrenome("smaniotto");
        usuarioModel.setEmail("antoniopikadura@gmail.com");
        usuarioModel.setRazaoSocial("Trabalho");
        usuarioModel.setCnpj("213547634");
        usuarioModel.setCpf("213547634");
        usuarioModel.setCep("213547634");
        usuarioModel.setEstado("SC");
        usuarioModel.setCidade("Blumenau");
        usuarioModel.setLogradouro("Rua Jose Roiter");
        usuarioModel.setBairro("velha");
        usuarioModel.setSenha("123Zezinho321");
        usuarioModel.setCelular("213547634");
        usuarioModel.setBiografia("VASP");
        usuarioModel.setUrlFacebook("urlFace");
        usuarioModel.setUrlLinkedin("urlLinkedin");
        usuarioModel.setUrlTwitter("urlTwiter");
        usuarioModel.setUrlInstagram("urlInsta");
        Calendar calendario = Calendar.getInstance();
        calendario.set(2000, 1, 30);
        usuarioModel.setDataNascimento(new Date(calendario.getTimeInMillis()));
        usuarioModel.setGenero('m');
        usuarioModel.setCodigo(UsuarioDAO.inserir(usuarioModel));

        UsuarioModel usuarioModelAlterar = new UsuarioModel();
        usuarioModelAlterar.setIdade(10);
        usuarioModelAlterar.setNumero(10);
        usuarioModelAlterar.setNumeroLocal(5);
        usuarioModelAlterar.setNome("Antonio");
        usuarioModelAlterar.setSobrenome("Pedro");
        usuarioModelAlterar.setEmail("antoniopikadura@gmail.com");
        usuarioModelAlterar.setRazaoSocial("ALJSGDUA");
        usuarioModelAlterar.setCnpj("213547634");
        usuarioModelAlterar.setCpf("213547634");
        usuarioModelAlterar.setCep("213547634");
        usuarioModelAlterar.setEstado("SC");
        usuarioModelAlterar.setCidade("Blumenau");
        usuarioModelAlterar.setLogradouro("Rua Jose Roiter");
        usuarioModelAlterar.setBairro("velha");
        usuarioModelAlterar.setSenha("123Zezinho321");
        usuarioModelAlterar.setCelular("213547634");
        usuarioModelAlterar.setBiografia("VASP");
        usuarioModelAlterar.setUrlFacebook("urlFace");
        usuarioModelAlterar.setUrlLinkedin("urlLinkedin");
        usuarioModelAlterar.setUrlTwitter("urlTwiter");
        usuarioModelAlterar.setUrlInstagram("urlInsta");
        Calendar cl = Calendar.getInstance();
        cl.set(2000, 1, 30);
        usuarioModelAlterar.setDataNascimento(new Date(calendario.getTimeInMillis()));
        usuarioModelAlterar.setGenero('m');
        usuarioModelAlterar.setCodigo(UsuarioDAO.inserir(usuarioModel));

        PostModel postModel = new PostModel();
        postModel.setDescricao("vila nova campeao");
        postModel.setStatus("online");
        postModel.setTitulo("tombo massa");
        postModel.setApoios(1);
        postModel.setUsuario(usuarioModel);
        postModel.setCodigo(PostDAO.inserir(postModel));

        PostModel postModelAlterar = new PostModel();
        postModelAlterar.setDescricao("vila nova campeao");
        postModelAlterar.setStatus("online");
        postModelAlterar.setTitulo("tombo massa");
        postModelAlterar.setApoios(1);
        postModelAlterar.setUsuario(usuarioModel);
        postModelAlterar.setCodigo(PostDAO.inserir(postModel));

        PostModel postBuscado = PostDAO.buscarPostPorId(postModel.getCodigo());
        assertEquals(postBuscado.getCodigo(), postModel.getCodigo());
        assertEquals(postBuscado.getDescricao(), postModel.getDescricao());
        assertEquals(postBuscado.getStatus(), postModel.getStatus());
        assertEquals(postBuscado.getUsuario().getCodigo(), postModel.getUsuario().getCodigo());
        assertEquals(postBuscado.getApoios(), postModel.getApoios());
        assertEquals(postBuscado.getDataEvento(), postModel.getDataEvento());
        assertEquals(postBuscado.getTitulo(), postModel.getTitulo());

    }

    @Test
    public void testarExcluir() {

        Limpeza.truncateTabelas();
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setIdade(10);
        usuarioModel.setNumero(10);
        usuarioModel.setNumeroLocal(5);
        usuarioModel.setNome("Antonio");
        usuarioModel.setSobrenome("Pedro");
        usuarioModel.setEmail("antoniopikadura@gmail.com");
        usuarioModel.setRazaoSocial("Trabalho");
        usuarioModel.setCnpj("213547634");
        usuarioModel.setCpf("213547634");
        usuarioModel.setCep("213547634");
        usuarioModel.setEstado("SC");
        usuarioModel.setCidade("Blumenau");
        usuarioModel.setLogradouro("Rua Jose Roiter");
        usuarioModel.setBairro("velha");
        usuarioModel.setSenha("123Zezinho321");
        usuarioModel.setCelular("213547634");
        usuarioModel.setBiografia("VASP");
        usuarioModel.setUrlFacebook("urlFace");
        usuarioModel.setUrlLinkedin("urlLinkedin");
        usuarioModel.setUrlTwitter("urlTwiter");
        usuarioModel.setUrlInstagram("urlInsta");
        Calendar calendario = Calendar.getInstance();
        calendario.set(2000, 1, 30);
        usuarioModel.setDataNascimento(new Date(calendario.getTimeInMillis()));
        usuarioModel.setGenero('m');
        UsuarioDAO.excluir(usuarioModel.getCodigo());

        PostModel postModel = new PostModel();
        postModel.setDescricao("vila nova campeao");
        postModel.setStatus("online");
        postModel.setTitulo("tombo massa");
        postModel.setApoios(1);
        postModel.setUsuario(usuarioModel);
        postModel.setCodigo(PostDAO.inserir(postModel));

        PostDAO.excluir(postModel.getCodigo());
        assertNull(PostDAO.buscarPostPorId(postModel.getCodigo()));
    }
}
