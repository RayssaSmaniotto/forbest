package dao;

import database.Limpeza;
import model.TagModel;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * @author Rayssa Smaniotto 29/08/2001
 */
public class TagJUnitTest {

    @Test
    public void testarCriacao() {
        Limpeza.truncateTabelas();
        TagModel tag = new TagModel();
        tag.setNome("Rayssa");
        tag.setCodigo(TagDAO.inserir(tag));
    }

    @Test
    public void testarBuscarTagPorId() {
        Limpeza.truncateTabelas();
        TagModel tag = new TagModel();
        tag.setNome("Rayssa");
        tag.setCodigo(TagDAO.inserir(tag));
        assertEquals(1, tag.getCodigo());

        TagModel tagBuscada = TagDAO.buscarTagPorId(tag.getCodigo());
        assertEquals(tag.getCodigo(), tagBuscada.getCodigo());
        assertEquals(tag.getNome(), tagBuscada.getNome());
    }

    @Test
    public void testarAlterar() {
        Limpeza.truncateTabelas();
        TagModel tag = new TagModel();
        tag.setNome("Rayssa");
        tag.setCodigo(TagDAO.inserir(tag));
        assertEquals(1, tag.getCodigo());

        TagModel tagBuscada = TagDAO.buscarTagPorId(tag.getCodigo());
        assertEquals(tag.getCodigo(), tagBuscada.getCodigo());
        assertEquals(tag.getNome(), tagBuscada.getNome());
        Assert.assertNotEquals(tagBuscada.getCodigo(), 0);
    }
    
    @Test 
    public void testarExcluir() {
        Limpeza.truncateTabelas();
        TagModel tag = new TagModel();
        tag.setNome("Rayssa");
        tag.setCodigo(TagDAO.inserir(tag));
        TagDAO.excluir(tag.getCodigo());
        assertNull(TagDAO.buscarTagPorId(tag.getCodigo()));
        
    }
}
