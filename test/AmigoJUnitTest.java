import dao.UsuarioDAO;
import dao.AmigoDAO;
import database.Limpeza;
import java.sql.Date;
import java.util.Calendar;
import model.AmigoModel;
import model.UsuarioModel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Ruan Pasta, date = 23/08/2017. 
 */
public class AmigoJUnitTest {

    @Test
    public void AmigoJUnitTestCriacao() {
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

        UsuarioModel usuario2 = new UsuarioModel();
        usuario2.setIdade(10);
        usuario2.setNumero(10);
        usuario2.setNumeroLocal(5);
        usuario2.setNome("Antonio");
        usuario2.setSobrenome("Pedro");
        usuario2.setEmail("antoniopikadura@gmail.com");
        usuario2.setRazaoSocial("Trabalho");
        usuario2.setCnpj("213547634");
        usuario2.setCpf("213547634");
        usuario2.setCep("213547634");
        usuario2.setEstado("SC");
        usuario2.setCidade("Blumenau");
        usuario2.setLogradouro("Rua Jose Roiter");
        usuario2.setBairro("velha");
        usuario2.setSenha("123Zezinho321");
        usuario2.setCelular("213547634");
        usuario2.setBiografia("VASP");
        usuario2.setUrlFacebook("urlFace");
        usuario2.setUrlLinkedin("urlLinkedin");
        usuario2.setUrlTwitter("urlTwiter");
        usuario2.setUrlInstagram("urlInsta");
        usuario2.setDataNascimento(new Date(calendario.getTimeInMillis()));
        usuario2.setGenero('m');
        usuario2.setCodigo(UsuarioDAO.inserir(usuario2));

        AmigoModel amigoModel = new AmigoModel();
        amigoModel.setConfirmado(true);
        amigoModel.setSolicitante(usuario);
        amigoModel.setSolicitado(usuario2);
        amigoModel.setDataCriacaos(new Date(1994, 3, 5));
        amigoModel.setCodigo(AmigoDAO.inserir(amigoModel));
        assertEquals(1, amigoModel.getCodigo());

        AmigoModel outro = AmigoDAO.buscarAmigoModelPorId(amigoModel.getCodigo());
        assertEquals(amigoModel.getSolicitante().getCodigo(), outro.getSolicitante().getCodigo());
        assertEquals(amigoModel.getSolicitado().getCodigo(), outro.getSolicitado().getCodigo());
    }

    @Test
    public void testarBuscarAmigoPorId() {
        Limpeza.truncateTabelas();
        Limpeza.truncateTabelas();
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome("Anita");
        usuarioModel.setSobrenome("Camargo");
        usuarioModel.setEmail("nita@elasquerem.com.br");
        usuarioModel.setRazaoSocial("Anita Ltda Me");
        usuarioModel.setCnpj("98765.43213.215-6");
        usuarioModel.setCpf("879.987.694-54");
        usuarioModel.setCep("89022122");
        usuarioModel.setEstado("SC");
        usuarioModel.setCidade("Feits");
        usuarioModel.setLogradouro("naRua xdxd");
        usuarioModel.setIdade(20);
        usuarioModel.setNumeroLocal(308);
        usuarioModel.setNumero(9879879);
        usuarioModel.setBairro("LosPerdidos");
        usuarioModel.setSenha("senhorita");
        usuarioModel.setCelular("(47)999669696");
        usuarioModel.setBiografia("Juvenal Pega Cana");
        usuarioModel.setUrlFacebook("htttp://hojesoumaiseu.com.br/facetrucks");
        usuarioModel.setUrlLinkedin("htttp://podecre.euevc.com.kkkk/hjtm");
        usuarioModel.setUrlTwitter("http://sqn.ficadica.kkkkrrones");
        usuarioModel.setUrlInstagram("http://quemanehurlinstagram.com.br");
        Calendar calendario = Calendar.getInstance();
        calendario.set(1994, 5, 3);
        usuarioModel.setDataNascimento(new Date(calendario.getTimeInMillis()));
        usuarioModel.setGenero('M');
        usuarioModel.setCodigo(UsuarioDAO.inserir(usuarioModel));
        assertEquals(1, usuarioModel.getCodigo());

        UsuarioModel usuarioModel2 = new UsuarioModel();
        usuarioModel2.setNome("Oscar");
        usuarioModel2.setSobrenome("Carlos");
        usuarioModel2.setEmail("oscares@elasquerem.com.br");
        usuarioModel2.setRazaoSocial("Oscar Ltda Me");
        usuarioModel2.setCnpj("222222.432-6");
        usuarioModel2.setCpf("122.987.694-54");
        usuarioModel2.setCep("22");
        usuarioModel2.setEstado("MJ");
        usuarioModel2.setCidade("Feiota");
        usuarioModel2.setLogradouro("Em rua Kaxispital");
        usuarioModel2.setIdade(15);
        usuarioModel2.setNumeroLocal(308);
        usuarioModel2.setNumero(9879879);
        usuarioModel2.setBairro("LosPerdidos");
        usuarioModel2.setSenha("senhorita");
        usuarioModel2.setCelular("(47)999669696");
        usuarioModel2.setBiografia("Juvenal Pega Cana");
        usuarioModel2.setUrlFacebook("htttp://hojesoumaiseu.com.br/facetrucks");
        usuarioModel2.setUrlLinkedin("htttp://podecre.euevc.com.kkkk/hjtm");
        usuarioModel2.setUrlTwitter("http://sqn.ficadica.kkkkrrones");
        usuarioModel2.setUrlInstagram("http://quemanehurlinstagram.com.br");
        usuarioModel2.setDataNascimento(new Date(calendario.getTimeInMillis()));
        usuarioModel2.setGenero('m');
        usuarioModel2.setCodigo(UsuarioDAO.inserir(usuarioModel2));
        assertEquals(2, usuarioModel2.getCodigo());

        AmigoModel amigoModel = new AmigoModel();
        amigoModel.setConfirmado(true);
        amigoModel.setSolicitante(usuarioModel);
        amigoModel.setSolicitado(usuarioModel2);
        amigoModel.setCodigo(AmigoDAO.inserir(amigoModel));
        assertEquals(1, amigoModel.getCodigo());

        AmigoModel amigoBuscado = AmigoDAO.buscarAmigoModelPorId(amigoModel.getCodigo());
        assertEquals(amigoModel.getCodigo(), amigoBuscado.getCodigo());
        assertEquals(amigoModel.getSolicitante().getCodigo(), amigoBuscado.getSolicitante().getCodigo());
        assertEquals(amigoModel.getSolicitado().getCodigo(), amigoBuscado.getSolicitado().getCodigo());
    }

    @Test
    public void testarExcluir() {
        Limpeza.truncateTabelas();
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome("Anita");
        usuarioModel.setSobrenome("Camargo");
        usuarioModel.setEmail("nita@elasquerem.com.br");
        usuarioModel.setRazaoSocial("Anita Ltda Me");
        usuarioModel.setCnpj("98765.43213.215-6");
        usuarioModel.setCpf("879.987.694-54");
        usuarioModel.setCep("89022122");
        usuarioModel.setEstado("SC");
        usuarioModel.setCidade("Feits");
        usuarioModel.setLogradouro("naRua xdxd");
        usuarioModel.setIdade(20);
        usuarioModel.setNumeroLocal(308);
        usuarioModel.setNumero(9879879);
        usuarioModel.setBairro("LosPerdidos");
        usuarioModel.setSenha("senhorita");
        usuarioModel.setCelular("(47)999669696");
        usuarioModel.setBiografia("Juvenal Pega Cana");
        usuarioModel.setUrlFacebook("htttp://hojesoumaiseu.com.br/facetrucks");
        usuarioModel.setUrlLinkedin("htttp://podecre.euevc.com.kkkk/hjtm");
        usuarioModel.setUrlTwitter("http://sqn.ficadica.kkkkrrones");
        usuarioModel.setUrlInstagram("http://quemanehurlinstagram.com.br");
        Calendar calendario = Calendar.getInstance();
        calendario.set(1994, 5, 3);
        usuarioModel.setDataNascimento(new Date(calendario.getTimeInMillis()));
        usuarioModel.setGenero('M');
        usuarioModel.setCodigo(UsuarioDAO.inserir(usuarioModel));

        UsuarioModel usuarioModel2 = new UsuarioModel();
        usuarioModel2.setNome("Oscar");
        usuarioModel2.setSobrenome("Carlos");
        usuarioModel2.setEmail("oscares@elasquerem.com.br");
        usuarioModel2.setRazaoSocial("Oscar Ltda Me");
        usuarioModel2.setCnpj("222222.432-6");
        usuarioModel2.setCpf("122.987.694-54");
        usuarioModel2.setCep("22");
        usuarioModel2.setEstado("MJ");
        usuarioModel2.setCidade("Feiota");
        usuarioModel2.setLogradouro("Em rua Kaxispital");
        usuarioModel2.setIdade(15);
        usuarioModel2.setNumeroLocal(308);
        usuarioModel2.setNumero(9879879);
        usuarioModel2.setBairro("LosPerdidos");
        usuarioModel2.setSenha("senhorita");
        usuarioModel2.setCelular("(47)999669696");
        usuarioModel2.setBiografia("Juvenal Pega Cana");
        usuarioModel2.setUrlFacebook("htttp://hojesoumaiseu.com.br/facetrucks");
        usuarioModel2.setUrlLinkedin("htttp://podecre.euevc.com.kkkk/hjtm");
        usuarioModel2.setUrlTwitter("http://sqn.ficadica.kkkkrrones");
        usuarioModel2.setUrlInstagram("http://quemanehurlinstagram.com.br");
        usuarioModel2.setDataNascimento(new Date(calendario.getTimeInMillis()));
        usuarioModel2.setGenero('m');
        usuarioModel2.setCodigo(UsuarioDAO.inserir(usuarioModel2));

        AmigoModel amigoModel = new AmigoModel();
        amigoModel.setConfirmado(true);
        amigoModel.setSolicitante(usuarioModel);
        amigoModel.setSolicitado(usuarioModel2);
        AmigoDAO.excluir(amigoModel.getCodigo());
        assertNull(AmigoDAO.buscarAmigoModelPorId(amigoModel.getCodigo()));
    }

}
