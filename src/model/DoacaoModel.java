package model;

/**
 * @author Antonio Pedro 22/08/2017
 */
public class DoacaoModel {
    private int codigo;
    private float valor;
    private String urlFormaPagamento;
    private PostModel post;

    public PostModel getPost() {
        return post;
    }

    public void setPost(PostModel post) {
        this.post = post;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getUrlFormaPagamento() {
        return urlFormaPagamento;
    }

    public void setUrlFormaPagamento(String urlFormaPagamento) {
        this.urlFormaPagamento = urlFormaPagamento;
    }
}
