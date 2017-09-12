
import dao.PostDAO;
import dao.PostTarefaDAO;
import dao.UsuarioDAO;
import database.Limpeza;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import model.PostModel;
import model.PostTarefaModel;
import model.UsuarioModel;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * @author Rayssa Smaniotto 25/08/2017
 */
public class PostTarefaJUnitTest {
    
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
        usuario.setCnpj("123.123.123.12");
        usuario.setCpf("254.152.120-55");
        usuario.setCep("122358-82");
        usuario.setEstado("SC");
        usuario.setCidade("Blumenau");
        usuario.setLogradouro("Rua Jose Roiter");
        usuario.setBairro("velha");
        usuario.setSenha("123Zezinho321");
        usuario.setCelular("9908-0832");
        usuario.setBiografia("VASP");
        usuario.setUrlFacebook("urlFace");
        usuario.setUrlLinkedin("urlLinkedin");
        usuario.setUrlTwitter("urlTwiter");
        usuario.setUrlInstagram("urlInsta");
        usuario.setDataNascimento(new Date(2000, 10, 02));
        usuario.setGenero('m');
        usuario.setCodigo(UsuarioDAO.inserir(usuario));
        assertEquals(usuario.getCodigo(), 1);
        
        PostModel post = new PostModel();
        post.setUsuario(usuario);
        post.setDescricao("askdaksdkaskdasda");
        post.setTitulo("askdkasd");
        Calendar calendario = Calendar.getInstance();
        calendario.set(2005, 06, 02);
        post.setDataEvento(new Date(calendario.getTimeInMillis()));
        post.setStatus("asdasdasd");
        post.setApoios(55);
        
        post.setCodigo(PostDAO.inserir(post));
        assertEquals(1, post.getCodigo());
        
        PostTarefaModel postTarefa = new PostTarefaModel();
        postTarefa.setDescricao("asdasdasdas");
        postTarefa.setUsuario(usuario);
        postTarefa.setStatus("adasdasdas");
        postTarefa.setTitulo("adsdasdd");
        postTarefa.setPost(post);
        postTarefa.setCodigo(PostTarefaDAO.inserir(postTarefa));
        assertEquals(1, postTarefa.getCodigo());
        
    }
    
    @Test
    public void testarBuscarPostTarefaPorId() throws SQLException {
        Limpeza.truncateTabelas();
        UsuarioModel usuario = new UsuarioModel();
        usuario.setIdade(10);
        usuario.setNumero(10);
        usuario.setNumeroLocal(5);
        usuario.setNome("Antonio");
        usuario.setSobrenome("Pedro");
        usuario.setEmail("antoniopikadura@gmail.com");
        usuario.setRazaoSocial("Trabalho");
        usuario.setCnpj("123.123.123.12");
        usuario.setCpf("254.152.120-55");
        usuario.setCep("122358-82");
        usuario.setEstado("SC");
        usuario.setCidade("Blumenau");
        usuario.setLogradouro("Rua Jose Roiter");
        usuario.setBairro("velha");
        usuario.setSenha("123Zezinho321");
        usuario.setCelular("9908-0832");
        usuario.setBiografia("VASP");
        usuario.setUrlFacebook("urlFace");
        usuario.setUrlLinkedin("urlLinkedin");
        usuario.setUrlTwitter("urlTwiter");
        usuario.setUrlInstagram("urlInsta");
        usuario.setDataNascimento(new Date(2000, 10, 02));
        usuario.setGenero('m');
        usuario.setCodigo(UsuarioDAO.inserir(usuario));
        assertEquals( 1, usuario.getCodigo());
        
        PostModel post = new PostModel();
        post.setUsuario(usuario);
        post.setDescricao("askdaksdkaskdasda");
        post.setTitulo("askdkasd");
        Calendar calendario = Calendar.getInstance();
        calendario.set(2005, 06, 02);
        post.setDataEvento(new Date(calendario.getTimeInMillis()));
        post.setStatus("asdasdasd");
        post.setApoios(55);
        
        post.setCodigo(PostDAO.inserir(post));
        assertEquals(1, post.getCodigo());
        
        PostTarefaModel postTarefa = new PostTarefaModel();
        postTarefa.setDescricao("asdasdasdas");
        postTarefa.setUsuario(usuario);
        postTarefa.setStatus("adasdasdas");
        postTarefa.setTitulo("ad5sdasdd");
        postTarefa.setPost(post);
        postTarefa.setCodigo(PostTarefaDAO.inserir(postTarefa));
        assertEquals(1, postTarefa.getCodigo());
        
        PostTarefaModel postTarefaBuscada = PostTarefaDAO.buscarPostTarefaPorId(postTarefa.getCodigo());
        assertEquals(postTarefa.getCodigo(), postTarefaBuscada.getCodigo());
        assertEquals(postTarefa.getTitulo(), postTarefaBuscada.getTitulo());
        assertEquals(postTarefa.getStatus(), postTarefaBuscada.getStatus());
        assertEquals(postTarefa.getDescricao(), postTarefaBuscada.getDescricao());
        assertEquals(postTarefa.getUsuario().getCodigo(), postTarefaBuscada.getUsuario().getCodigo());
        
    }
    
    @Test
    public void testarAlterar() throws SQLException {
        Limpeza.truncateTabelas();
        UsuarioModel usuario = new UsuarioModel();
        usuario.setIdade(10);
        usuario.setNumero(10);
        usuario.setNumeroLocal(5);
        usuario.setNome("Antonio");
        usuario.setSobrenome("Pedro");
        usuario.setEmail("antoniopikadura@gmail.com");
        usuario.setRazaoSocial("Trabalho");
        usuario.setCnpj("123.123.123.12");
        usuario.setCpf("254.152.120-55");
        usuario.setCep("122358-82");
        usuario.setEstado("SC");
        usuario.setCidade("Blumenau");
        usuario.setLogradouro("Rua Jose Roiter");
        usuario.setBairro("velha");
        usuario.setSenha("123Zezinho321");
        usuario.setCelular("9908-0832");
        usuario.setBiografia("VASP");
        usuario.setUrlFacebook("urlFace");
        usuario.setUrlLinkedin("urlLinkedin");
        usuario.setUrlTwitter("urlTwiter");
        usuario.setUrlInstagram("urlInsta");
        usuario.setDataNascimento(new Date(2000, 10, 02));
        usuario.setGenero('m');
        usuario.setCodigo(UsuarioDAO.inserir(usuario));
        assertEquals(usuario.getCodigo(), 1);
        
        PostModel post = new PostModel();
        post.setUsuario(usuario);
        post.setDescricao("askdaksdkaskdasda");
        post.setTitulo("askdkasd");
        Calendar calendario = Calendar.getInstance();
        calendario.set(2005, 06, 02);
        post.setDataEvento(new Date(calendario.getTimeInMillis()));
        post.setStatus("asdasdasd");
        post.setApoios(55);
        
        post.setCodigo(PostDAO.inserir(post));
        assertEquals(1, post.getCodigo());
        
        PostTarefaModel postTarefa = new PostTarefaModel();
        postTarefa.setDescricao("asdasdasdas");
        postTarefa.setUsuario(usuario);
        postTarefa.setStatus("adasdasdas");
        postTarefa.setTitulo("ad5sdasdd");
        postTarefa.setPost(post);
        postTarefa.setCodigo(PostTarefaDAO.inserir(postTarefa));
        assertEquals(1, postTarefa.getCodigo());
        
        PostTarefaModel postTarefaBuscada = PostTarefaDAO.buscarPostTarefaPorId(postTarefa.getCodigo());
        assertEquals(postTarefaBuscada.getCodigo(), postTarefa.getCodigo());
        assertEquals(postTarefaBuscada.getTitulo(), postTarefa.getTitulo());
        assertEquals(postTarefaBuscada.getStatus(), postTarefa.getStatus());
        assertEquals(postTarefaBuscada.getDescricao(), postTarefa.getDescricao());
        assertEquals(postTarefaBuscada.getUsuario().getCodigo(), postTarefa.getUsuario().getCodigo());
        Assert.assertNotEquals(postTarefa.getCodigo(), 0);
        
    }
    
    @Test
    public void testarExcluir() throws SQLException {
        Limpeza.truncateTabelas();
        UsuarioModel usuario = new UsuarioModel();
        usuario.setIdade(10);
        usuario.setNumero(10);
        usuario.setNumeroLocal(5);
        usuario.setNome("Antonio");
        usuario.setSobrenome("Pedro");
        usuario.setEmail("antoniopikadura@gmail.com");
        usuario.setRazaoSocial("Trabalho");
        usuario.setCnpj("123.123.123.12");
        usuario.setCpf("254.152.120-55");
        usuario.setCep("122358-82");
        usuario.setEstado("SC");
        usuario.setCidade("Blumenau");
        usuario.setLogradouro("Rua Jose Roiter");
        usuario.setBairro("velha");
        usuario.setSenha("123Zezinho321");
        usuario.setCelular("9908-0832");
        usuario.setBiografia("VASP");
        usuario.setUrlFacebook("urlFace");
        usuario.setUrlLinkedin("urlLinkedin");
        usuario.setUrlTwitter("urlTwiter");
        usuario.setUrlInstagram("urlInsta");
        usuario.setDataNascimento(new Date(2000, 10, 02));
        usuario.setGenero('m');
        usuario.setCodigo(UsuarioDAO.inserir(usuario));
        assertEquals(usuario.getCodigo(), 1);
        
        PostModel post = new PostModel();
        post.setUsuario(usuario);
        post.setDescricao("askdaksdkaskdasda");
        post.setTitulo("askdkasd");
        Calendar calendario = Calendar.getInstance();
        calendario.set(2005, 06, 02);
        post.setDataEvento(new Date(calendario.getTimeInMillis()));
        post.setStatus("asdasdasd");
        post.setApoios(55);
        
        post.setCodigo(PostDAO.inserir(post));
        assertEquals(1, post.getCodigo());
        
        PostTarefaModel postTarefa = new PostTarefaModel();
        postTarefa.setDescricao("asdasdasdas");
        postTarefa.setUsuario(usuario);
        postTarefa.setStatus("adasdasdas");
        postTarefa.setTitulo("ad5sdasdd");
        postTarefa.setPost(post);
        postTarefa.setCodigo(PostTarefaDAO.inserir(postTarefa));
        PostTarefaDAO.excluir(postTarefa.getCodigo()); 
        assertNull(PostTarefaDAO.buscarPostTarefaPorId(postTarefa.getCodigo()));
        
    }
}
