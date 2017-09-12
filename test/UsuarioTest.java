
import dao.UsuarioDAO;
import database.Limpeza;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import model.UsuarioModel;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Antonio Pedro Laus Neto
 */
public class UsuarioTest {

    @Test
    public void testarInseriri() {
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

    }

    @Test
    public void tessteBuscarPorId() {
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

        UsuarioModel postBuscado = UsuarioDAO.buscarUsuarioPorId(usuarioModel.getCodigo());
        assertEquals(postBuscado.getCodigo(), usuarioModel.getCodigo());
        assertEquals(postBuscado.getBairro(), usuarioModel.getBairro());
        assertEquals(postBuscado.getBiografia(), usuarioModel.getBiografia());
        assertEquals(postBuscado.getCelular(), usuarioModel.getCelular());
        assertEquals(postBuscado.getCep(), usuarioModel.getCep());
        assertEquals(postBuscado.getCidade(), usuarioModel.getCidade());
        assertEquals(postBuscado.getCnpj(), usuarioModel.getCnpj());
        assertEquals(postBuscado.getCpf(), usuarioModel.getCpf());

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        assertEquals(formato.format(postBuscado.getDataNascimento()), formato.format(usuarioModel.getDataNascimento()));
        assertEquals(postBuscado.getEmail(), usuarioModel.getEmail());
        assertEquals(postBuscado.getEstado(), usuarioModel.getEstado());
        assertEquals(postBuscado.getGenero(), usuarioModel.getGenero());
        assertEquals(postBuscado.getIdade(), usuarioModel.getIdade());
        assertEquals(postBuscado.getLogradouro(), usuarioModel.getLogradouro());
        assertEquals(postBuscado.getNome(), usuarioModel.getNome());
        assertEquals(postBuscado.getNumero(), usuarioModel.getNumero());
        assertEquals(postBuscado.getNumeroLocal(), usuarioModel.getNumeroLocal());
        assertEquals(postBuscado.getRazaoSocial(), usuarioModel.getRazaoSocial());
        assertEquals(postBuscado.getSenha(), usuarioModel.getSenha());
        assertEquals(postBuscado.getSobrenome(), usuarioModel.getSobrenome());
        assertEquals(postBuscado.getUrlFacebook(), usuarioModel.getUrlFacebook());
        assertEquals(postBuscado.getUrlInstagram(), usuarioModel.getUrlInstagram());
        assertEquals(postBuscado.getUrlLinkedin(), usuarioModel.getUrlLinkedin());
        assertEquals(postBuscado.getUrlTwitter(), usuarioModel.getUrlTwitter());
    }

    @Test
    public void testarAlterar() {

        Limpeza.truncateTabelas();
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setIdade(10);
        usuarioModel.setNumero(10);
        usuarioModel.setNumeroLocal(1);
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

        UsuarioModel postBuscado = UsuarioDAO.buscarUsuarioPorId(usuarioModel.getCodigo());
        assertEquals(postBuscado.getCodigo(), usuarioModel.getCodigo());
        assertEquals(postBuscado.getBairro(), usuarioModel.getBairro());
        assertEquals(postBuscado.getBiografia(), usuarioModel.getBiografia());
        assertEquals(postBuscado.getCelular(), usuarioModel.getCelular());
        assertEquals(postBuscado.getCep(), usuarioModel.getCep());
        assertEquals(postBuscado.getCidade(), usuarioModel.getCidade());
        assertEquals(postBuscado.getCnpj(), usuarioModel.getCnpj());
        assertEquals(postBuscado.getCpf(), usuarioModel.getCpf());

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        assertEquals(formato.format(postBuscado.getDataNascimento()), formato.format(usuarioModel.getDataNascimento()));
        assertEquals(postBuscado.getEmail(), usuarioModel.getEmail());
        assertEquals(postBuscado.getEstado(), usuarioModel.getEstado());
        assertEquals(postBuscado.getGenero(), usuarioModel.getGenero());
        assertEquals(postBuscado.getIdade(), usuarioModel.getIdade());
        assertEquals(postBuscado.getLogradouro(), usuarioModel.getLogradouro());
        assertEquals(postBuscado.getNome(), usuarioModel.getNome());
        assertEquals(postBuscado.getNumero(), usuarioModel.getNumero());
        assertEquals(postBuscado.getNumeroLocal(), usuarioModel.getNumeroLocal());
        assertEquals(postBuscado.getRazaoSocial(), usuarioModel.getRazaoSocial());
        assertEquals(postBuscado.getSenha(), usuarioModel.getSenha());
        assertEquals(postBuscado.getSobrenome(), usuarioModel.getSobrenome());
        assertEquals(postBuscado.getUrlFacebook(), usuarioModel.getUrlFacebook());
        assertEquals(postBuscado.getUrlInstagram(), usuarioModel.getUrlInstagram());
        assertEquals(postBuscado.getUrlLinkedin(), usuarioModel.getUrlLinkedin());
        assertEquals(postBuscado.getUrlTwitter(), usuarioModel.getUrlTwitter());

    }

    @Test
    public void testarExcluir() {
        Limpeza.truncateTabelas();
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setIdade(10);
        usuarioModel.setNumero(10);
        usuarioModel.setNumeroLocal(1);
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
    }
}
