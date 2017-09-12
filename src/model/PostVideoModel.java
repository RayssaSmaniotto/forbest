package model;

import java.sql.Blob;

/**
 * @author Henrique Gioppo Roman Ross 22/08/2017
 */
public class PostVideoModel {
    private int codigo;
    private PostModel post;
    private Blob video;

    public Blob getVideo() {
        return video;
    }

    public void setVideo(Blob video) {
        this.video = video;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public PostModel getPost() {
        return post;
    }

    public void setPost(PostModel post) {
        this.post = post;
    }
   
    
}
