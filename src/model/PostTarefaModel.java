package model;

/**
 * @author Henrique Gioppo Roman Ross 22/08/2017
 */
public class PostTarefaModel {
    
    private int codigo;
    private String titulo, status, descricao;
    private PostModel post;
    private UsuarioModel usuario;

    public PostModel getPost() {
        return post;
    }

    public void setPost(PostModel post) {
        this.post = post;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}


/*CREATE TABLE posts_tarefas(
	codigo INT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_post INT(20),
	codigo_usuario INT(20),
	titulo VARCHAR(255),
	status VARCHAR(25),
	descricao TEXT,

	FOREIGN KEY (codigo_post) REFERENCES posts(codigo),	
	FOREIGN KEY (codigo_usuario) REFERENCES usuarios(codigo)
);
*/