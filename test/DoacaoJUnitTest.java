
import dao.DoacaoDAO;
import dao.PostDAO;
import dao.UsuarioDAO;
import database.Limpeza;
import java.sql.Date;
import java.util.Calendar;
import model.DoacaoModel;
import model.PostModel;
import model.UsuarioModel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henrique Gioppo Roman Ross 25/08/2017
 */
public class DoacaoJUnitTest {

    @Test
    public void testarInserir() {
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
        usuario.setUrlInstagram("hbjg");
        Calendar calendario = Calendar.getInstance();
        calendario.set(2000, 1, 30);
        usuario.setDataNascimento(new Date(calendario.getTimeInMillis()));
        usuario.setGenero('m');
        usuario.setCodigo(UsuarioDAO.inserir(usuario));
        assertEquals(1, usuario.getCodigo());

        PostModel post = new PostModel();
        post.setApoios(10);

        post.setUsuario(usuario);
        post.setDescricao("sds");
        post.setTitulo("sadas");
        post.setStatus("xd");
        Calendar cl = Calendar.getInstance();
        cl.set(2000, 1, 30);
        post.setDataEvento(new Date(cl.getTimeInMillis()));
        post.setCodigo(PostDAO.inserir(post));
        assertEquals(1, post.getCodigo());

        DoacaoModel doacao = new DoacaoModel();
        doacao.setCodigo(1);
        doacao.setPost(post);
        doacao.setUrlFormaPagamento("www.pagseguro.com.br/cod3487");
        doacao.setValor(DoacaoDAO.inserir(doacao));
        assertEquals(1, doacao.getCodigo());
    }

    @Test
    public void testarAlterar() {
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
        usuario.setUrlInstagram("hbjg");
        Calendar calendario = Calendar.getInstance();
        calendario.set(2000, 1, 30);
        usuario.setDataNascimento(new Date(calendario.getTimeInMillis()));
        usuario.setGenero('m');
        usuario.setCodigo(UsuarioDAO.inserir(usuario));
        assertEquals(1, usuario.getCodigo());

        PostModel post = new PostModel();
        post.setApoios(10);

        post.setUsuario(usuario);
        post.setDescricao("sds");
        post.setTitulo("sadas");
        post.setStatus("xd");
        Calendar cl = Calendar.getInstance();
        cl.set(2000, 1, 30);
        post.setDataEvento(new Date(cl.getTimeInMillis()));
        post.setCodigo(PostDAO.inserir(post));
        assertEquals(1, post.getCodigo());

        DoacaoModel doacao = new DoacaoModel();
        doacao.setCodigo(45);
        doacao.setPost(post);
        doacao.setUrlFormaPagamento("www.pagseguro.com.br/486468cod");
        doacao.setCodigo(DoacaoDAO.inserir(doacao));

        DoacaoModel doacaoBuscada = DoacaoDAO.buscarDoacaoPorId(doacao.getCodigo());
        assertEquals(doacao.getCodigo(), doacaoBuscada.getCodigo());
        assertEquals(doacao.getPost().getCodigo(), doacaoBuscada.getPost().getCodigo());
        assertEquals(doacao.getUrlFormaPagamento(), doacaoBuscada.getUrlFormaPagamento());
        assertEquals(doacao.getCodigo(), doacaoBuscada.getPost().getCodigo());

        // testar se conseguiu alterar no banco de dados
        assertNotEquals(0, doacao.getCodigo());
    }

    @Test
    public void testarBuscarDoacaoPorId() {
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
        usuario.setUrlInstagram("hbjg");
        Calendar calendario = Calendar.getInstance();
        calendario.set(2000, 1, 30);
        usuario.setDataNascimento(new Date(calendario.getTimeInMillis()));
        usuario.setGenero('m');
        usuario.setCodigo(UsuarioDAO.inserir(usuario));
        assertEquals(1, usuario.getCodigo());

        PostModel post = new PostModel();
        post.setApoios(10);

        post.setUsuario(usuario);
        post.setDescricao("sds");
        post.setTitulo("sadas");
        post.setStatus("xd");
        Calendar cl = Calendar.getInstance();
        cl.set(2000, 1, 30);
        post.setDataEvento(new Date(cl.getTimeInMillis()));
        post.setCodigo(PostDAO.inserir(post));
        assertEquals(1, post.getCodigo());

        DoacaoModel doacao = new DoacaoModel();
        doacao.setUrlFormaPagamento("www.pagseguro.com.br/cod3487");
        doacao.setValor(10f);
        doacao.setPost(post);
        doacao.setCodigo(DoacaoDAO.inserir(doacao));
        assertEquals(1, doacao.getCodigo());

        DoacaoModel doacaoBuscada = DoacaoDAO.buscarDoacaoPorId(doacao.getCodigo());
        assertEquals(doacao.getCodigo(), doacaoBuscada.getCodigo());
        assertEquals(doacao.getPost().getCodigo(), doacaoBuscada.getPost().getCodigo());
    }

    @Test
    public void testarExcluir() {
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
        usuario.setUrlInstagram("hbjg");
        Calendar calendario = Calendar.getInstance();
        calendario.set(2000, 1, 30);
        usuario.setDataNascimento(new Date(calendario.getTimeInMillis()));
        usuario.setGenero('m');
        usuario.setCodigo(UsuarioDAO.inserir(usuario));
        assertEquals(1, usuario.getCodigo());

        PostModel post = new PostModel();
        post.setApoios(10);

        post.setUsuario(usuario);
        post.setDescricao("sds");
        post.setTitulo("sadas");
        post.setStatus("xd");
        Calendar cl = Calendar.getInstance();
        cl.set(2000, 1, 30);
        post.setDataEvento(new Date(cl.getTimeInMillis()));
        post.setCodigo(PostDAO.inserir(post));
        assertEquals(1, post.getCodigo());

        Limpeza.truncateTabelas();
        DoacaoModel doacao = new DoacaoModel();
        doacao.setPost(post);
        doacao.setUrlFormaPagamento("www.pagseguro.com.br/cod3487");
        doacao.setCodigo(DoacaoDAO.inserir(doacao));
        DoacaoDAO.excluir(doacao.getCodigo());
        assertNull(DoacaoDAO.buscarDoacaoPorId(doacao.getCodigo()));
    }
}
