package dao;

import database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.PostVideoModel;

/**
 * @author Henrique Gioppo Roman Ross 24/08/2017
 */
public class PostVideoDAO {

    public static void excluir(int codigo) {
        try {
            String sql = "DELETE FROM post_videos WHERE codigo = ?";

            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
    }

    public static int alterar(PostVideoModel postVideoModel) {
        try {
            String sql = "UPDATE post_videos SET codigo = ?, codigo_post = ?, video = ? WHERE codigo = ?";

            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, postVideoModel.getCodigo());
            ps.setInt(2, postVideoModel.getPost().getCodigo());
            ps.setBlob(3, postVideoModel.getVideo());
            int resultado = ps.executeUpdate();
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            Conexao.desconectar();
        }
    }

    public static int inserir(PostVideoModel postVideoModel) {
        String sql = "INSERT INTO post_videos (codigo, codigo_post, video) VALUES (?, ?, ?);";
        try {
            PreparedStatement ps = Conexao.conectar()
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, postVideoModel.getCodigo());
            ps.setInt(2, postVideoModel.getPost().getCodigo());
            ps.setBlob(3, postVideoModel.getVideo());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                int codigo = rs.getInt(1);
                return codigo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return -1;
    }

    public static List<PostVideoModel> retornarPostVideoDAO() {
        List<PostVideoModel> videos = new ArrayList<>();
        String sql = "SELECT codigo, codigo_post, video FROM post_videos";
        try {
            Statement statement = Conexao.conectar().createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                PostVideoModel video = new PostVideoModel();
                video.setCodigo(resultSet.getInt("codigo"));
                video.setPost(PostDAO.buscarPostPorId(resultSet.getInt("post")));
                video.setVideo(resultSet.getBlob("video"));
                videos.add(video);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return videos;
    }

    public static PostVideoModel buscarVideoPorId(int codigo) {
        PostVideoModel video = null;
        String sql = "SELECT codigo, codigo_post, video FROM post_videos WHERE codigo = ?";
        try {
            PreparedStatement preparedStatement = Conexao.conectar().prepareCall(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                video = new PostVideoModel();
                video.setCodigo(resultSet.getInt("codigo"));
                video.setPost(PostDAO.buscarPostPorId(resultSet.getInt("post")));
                video.setVideo(resultSet.getBlob("video"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return video;
    }

}
