package dao;

import database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.TagModel;

/**
 * @author Antonio Pedro Laus Neto 23/08/2017.
 */
public class TagDAO {

    public static void excluir(int codigo) {
        try {
            String sql = "DELETE FROM tags WHERE codigo = ?";

            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
    }

    public static int alterar(TagModel tagModel) {
        try {
            String sql = "UPDATE tags SET nome = ?  WHERE codigo = ?";

            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, tagModel.getNome());
            ps.setInt(2, tagModel.getCodigo());
            int resultado = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return 1;

    }

    public static int inserir(TagModel tagModel) {
        String sql = "INSERT INTO tags (nome) VALUES (?);";
        try {
            PreparedStatement ps = Conexao.conectar()
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tagModel.getNome());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                int codigo = rs.getInt(1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return 1;

    }

    public static List<TagModel> retornarTags() {
        List<TagModel> tags = new ArrayList<>();
        String sql = "SELECT codigo, nome FROM tags";
        try {
            Statement statement = Conexao.conectar().createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                TagModel tag = new TagModel();
                tag.setCodigo(resultSet.getInt("codigo"));
                tag.setNome(resultSet.getString("nome"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return tags;
    }

    public static TagModel buscarTagPorId(int codigo) {
        TagModel tagModel = null;
        String sql = "SELECT codigo, nome FROM tags WHERE codigo = ?";
        try {
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                tagModel = new TagModel();
                tagModel.setCodigo(resultSet.getInt("codigo"));
                tagModel.setNome(resultSet.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return tagModel;
    }

    public static int retornarQuantRegistros() {
        String sql = "SELECT COUNT(codigo) AS quatidade FROM tags";
        try {
            Statement st = Conexao.conectar().createStatement();
            st.execute(sql);
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                return rs.getInt("quantidade");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return -1;
    }
}
