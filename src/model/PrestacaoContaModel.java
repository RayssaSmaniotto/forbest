package model;

import java.sql.Blob;

/**
 * @author Henrique Gioppo Roman Ross 22/08/2017
 */
public class PrestacaoContaModel {
    
    private int codigo ;
    private double gastos, recebidos;
    private Blob foto, video;
    private String texto;

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public Blob getVideo() {
        return video;
    }

    public void setVideo(Blob video) {
        this.video = video;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

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

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public double getRecebidos() {
        return recebidos;
    }

    public void setRecebidos(double recebidos) {
        this.recebidos = recebidos;
    }
    
    
    
}

/*CREATE TABLE prestacao_contas(
	codigo INT(20) PRIMARY KEY AUTO_INCREMENT,
    codigo_post INT(20),
    gastos DOUBLE,
    recebidos DOUBLE,
    foto BLOB,
    video BLOB,
    texto TEXT,
    
	FOREIGN KEY (codigo_post) REFERENCES posts(codigo)
);
*/