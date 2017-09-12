import dao.TagDAO;
import database.Limpeza;
import model.TagModel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ruan Pasta 30/08/2017
 */
public class TagJunitTest {
    
    @Test
    public void testarInserir() {
        Limpeza.truncateTabelas();
        
        TagModel tag = new TagModel();
        tag.setNome("Jojo");
        tag.setCodigo(TagDAO.inserir(tag));
        assertEquals(1, tag.getCodigo());
    }
    
    @Test
    public void testarBuscarPorId(){
        Limpeza.truncateTabelas();
        
        TagModel tag = new TagModel();
        tag.setNome("Jojo");
        tag.setCodigo(TagDAO.inserir(tag));
        assertEquals(1, tag.getCodigo());
        
        TagModel tagOutro = TagDAO.buscarTagPorId(tag.getCodigo());
        assertEquals(tag.getNome(), tagOutro.getNome());
        assertEquals(tag.getCodigo(), tagOutro.getCodigo());
    }
    
    @Test
    public void testarAlterar(){
        Limpeza.truncateTabelas();
        
        TagModel tag = new TagModel();
        tag.setNome("Jojo");
        tag.setCodigo(TagDAO.inserir(tag));
        assertEquals(1, tag.getCodigo());
                
        
        tag.setNome("Jojo");
        tag.setCodigo(TagDAO.alterar(tag));
        assertEquals(1, tag.getCodigo());
        
        TagModel tagOutro = TagDAO.buscarTagPorId(tag.getCodigo());
        assertEquals(tag.getNome(), tagOutro.getNome());
        assertEquals(tag.getCodigo(), tagOutro.getCodigo());
    }
    
    @Test
    public void testarExcluir(){
        Limpeza.truncateTabelas();
        TagModel tag = new TagModel();
        tag.setNome("Jojo");
        tag.setCodigo(TagDAO.inserir(tag));
        TagDAO.excluir(tag.getCodigo());
        assertNull(TagDAO.buscarTagPorId(tag.getCodigo()));        
    }
}
