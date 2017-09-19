package dao;

import database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.DoacaoModel;
import model.PostModel;

/**
 * @author Antonio Pedro Laus Neto 23/08/2017
 */
public class PostDAO {

    public static void excluir(int codigo) {
        try {
            String sql = "DELETE FROM posts WHERE codigo = ?";

            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
         } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
    }

    public static void alterar(PostModel postModel) {
        try {
            String sql = "UPDATE posts SET descricao = ?,titulo =?, data_evento =?, codigo_usuario =?, "
                    + "apoios =?,status = ? WHERE codigo = ?";

            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, postModel.getDescricao());
            ps.setString(2, postModel.getTitulo());
            ps.setDate(3, postModel.getDataEvento());
            ps.setInt(4, postModel.getUsuario().getCodigo());
            ps.setInt(5, postModel.getApoios());
            ps.setString(6, postModel.getStatus());
            ps.setInt(7, postModel.getCodigo());
            int resultado = ps.executeUpdate();

         } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }

    }

    public static int inserir(PostModel postModel) {
        String sql = "INSERT INTO posts (descricao,titulo, data_evento, codigo_usuario, "
                + "apoios, status) VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement ps = Conexao.conectar()
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, postModel.getDescricao());
            ps.setString(2, postModel.getTitulo());
            ps.setDate(3, postModel.getDataEvento());
            ps.setInt(4, postModel.getUsuario().getCodigo());
            ps.setInt(5, postModel.getApoios());
            ps.setString(6, postModel.getStatus());
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

    public static List<PostModel> retornarPosts() {
        List<PostModel> posts = new ArrayList<>();
        String sql = "SELECT codigo, descricao,titulo, data_evento, codigo_usuario, "
                + "apoios FROM posts";
        try {
            Statement statement = Conexao.conectar().createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                PostModel post = new PostModel();
                post.setCodigo(resultSet.getInt("codigo"));
                post.setDescricao(resultSet.getString("descricao"));
                post.setTitulo(resultSet.getString("titulo"));
                post.setDataEvento(resultSet.getDate("data_evento"));
                post.setUsuario(UsuarioDAO.buscarUsuarioPorId(resultSet.getInt("codigo_usuario")));
                post.setApoios(resultSet.getInt("apoios"));
                DoacaoModel doacao = DoacaoDAO.buscarDoacaoPorId(resultSet.getInt("doacao"));
                post.setDoacoes(DoacaoDAO.buscarDoacaoPorIdDoPost(post.getCodigo()));
                post.setStatus(resultSet.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return posts;
    }

    public static PostModel buscarPostPorId(int codigo) {

        PostModel post = null;
        String sql = "SELECT codigo_usuario,descricao,titulo,data_evento,status,apoios FROM posts WHERE codigo =?";
        try {

            PreparedStatement ps = Conexao.conectar().prepareCall(sql);
            ps.setInt(1, codigo);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                post = new PostModel();
                post.setCodigo(codigo);
                post.setUsuario(UsuarioDAO.buscarUsuarioPorId(resultSet.getInt("codigo_usuario")));
                post.setDescricao(resultSet.getString("descricao"));
                post.setTitulo(resultSet.getString("titulo"));
                post.setDataEvento(resultSet.getDate("data_evento"));
                post.setStatus(resultSet.getString("status"));
                post.setApoios(resultSet.getInt("apoios"));
            }
         } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return post;
    }

    public static int retornarQuantidadeLikes(int codigo){
        String sql = "COUNT(id) FROM post SET apoios = ? WHERE id = ?";
        return 0;
    }
}