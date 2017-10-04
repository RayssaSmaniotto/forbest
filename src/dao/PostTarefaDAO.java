package dao;

import database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.PostTarefaModel;

/**
 * @author Rayssa Smaniotto 23/08/2017
 */
public class PostTarefaDAO {

    public static void excluir(int codigo) throws SQLException {
        try {
            String sql = "DELETE FROM posts_tarefas WHERE codigo = ?";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
    }

    public static int alterar(PostTarefaModel post) throws SQLException {
        try {
            String sql = "UPDATE posts_tarefas SET codigo_post = ?, codigo_usuario = ?, titulo = ?, status = ?, descricao = ? WHERE codigo = ?";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql);
            preparedStatement.setInt(1, post.getPost().getCodigo());
            preparedStatement.setInt(2, post.getUsuario().getCodigo());
            preparedStatement.setString(3, post.getTitulo());
            preparedStatement.setString(4, post.getStatus());
            preparedStatement.setString(5, post.getDescricao());
            preparedStatement.setInt(6, post.getCodigo());
            int resultado = preparedStatement.executeUpdate();
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            Conexao.desconectar();
        }
    }

    public static int inserir(PostTarefaModel postTarefa) {
        String sql = "INSERT INTO posts_tarefas (codigo_post, codigo_usuario, titulo, status, descricao) VALUES "
                + "(?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, postTarefa.getPost().getCodigo());
            preparedStatement.setInt(2, postTarefa.getUsuario().getCodigo());
            preparedStatement.setString(3, postTarefa.getTitulo());
            preparedStatement.setString(4, postTarefa.getStatus());
            preparedStatement.setString(5, postTarefa.getDescricao());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                int codigo = resultSet.getInt(1);
                return codigo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return -1;
    }

    public static List<PostTarefaModel> retornarPost(int idPost) throws SQLException {
        List<PostTarefaModel> postTarefas = new ArrayList<>();
        String sql = "SELECT codigo, codigo_post, codigo_usuario, titulo, status, descricao FROM posts_tarefas WHERE id_post = ?";
        try {
            Statement statement = Conexao.conectar().createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                PostTarefaModel post = new PostTarefaModel();
                post.setCodigo(resultSet.getInt("codigo"));
                post.setPost(PostDAO.buscarPostPorId(resultSet.getInt("codigo_post")));
                post.setUsuario(UsuarioDAO.buscarUsuarioPorId(resultSet.getInt("codigo_usuario")));
                post.setTitulo(resultSet.getString("titulo"));
                post.setStatus(resultSet.getString("status"));
                post.setDescricao(resultSet.getString("descricao"));
                postTarefas.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return postTarefas;
    }

    public static PostTarefaModel buscarPostTarefaPorId(int codigo) throws SQLException {
        PostTarefaModel post = null;
        String sql = "SELECT codigo, codigo_post, codigo_usuario, titulo, status, descricao FROM posts_tarefas WHERE codigo = ?";
        try {
            PreparedStatement preparedStatement = Conexao.conectar().prepareCall(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                post = new PostTarefaModel();
                post.setCodigo(codigo);
                post.setPost(PostDAO.buscarPostPorId(resultSet.getInt("codigo_post")));
                post.setUsuario(UsuarioDAO.buscarUsuarioPorId(resultSet.getInt("codigo_usuario")));
                post.setTitulo(resultSet.getString("titulo"));
                post.setStatus(resultSet.getString("status"));
                post.setDescricao(resultSet.getString("descricao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return post;
    }

    public static int retornarQuantidadeRegistros() throws SQLException {
        String sql = "SELECT COUNT (codigo) AS quantidade FROM posts_tarefas";
        try {
            Statement statement = Conexao.conectar().createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                return resultSet.getInt("quantidade");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return -1;
    }
}
