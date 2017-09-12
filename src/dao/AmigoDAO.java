package dao;

import database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.AmigoModel;

/**
 * @author Ruan Pasta , date = 23/08/2017.
 */
public class AmigoDAO {

    public static void excluir(int codigo) {
        try {
            String sql = "DELETE FROM amigos WHERE codigo = ?";

            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
    }

    public static int inserir(AmigoModel amigoModel) {
        String sql = "INSERT INTO amigos (codigo_usuario_solicitante,"
                + "codigo_usuario_solicitado) VALUES (?,?);";
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, amigoModel.getSolicitante().getCodigo());
            ps.setInt(2, amigoModel.getSolicitado().getCodigo());
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

    public static List<AmigoModel> retornarAmigoModel(int codigoSolicitante) {
        List<AmigoModel> amigos = new ArrayList<>();
        String sql = "SELECT codigo, codigo_usuario_solicitante, codigo_usuario_solicitado FROM amigos WHERE codigo_usuario_solicitante = ?";
        try {
            Statement statement = Conexao.conectar().createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                AmigoModel amigoModel = new AmigoModel();
                amigoModel.setCodigo(resultSet.getInt("codigo"));
                amigoModel.setSolicitante(UsuarioDAO.buscarUsuarioPorId((resultSet.getInt("codigo_usuario_solicitante"))));
                amigoModel.setSolicitado(UsuarioDAO.buscarUsuarioPorId((resultSet.getInt("codigo_usuario_solicitado"))));
                amigos.add(amigoModel);
            }
         } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return amigos;
    }

    public static AmigoModel buscarAmigoModelPorId(int codigo) {
        AmigoModel amigoModel = null;
        String sql = "SELECT codigo_usuario_solicitante, codigo_usuario_solicitado, confirmado FROM amigos WHERE codigo = ?";
        try {
            PreparedStatement preaparedStatement = Conexao.conectar().prepareCall(sql);
            preaparedStatement.setInt(1, codigo);
            preaparedStatement.execute();
            ResultSet resultSet = preaparedStatement.getResultSet();
            while (resultSet.next()) {
                amigoModel = new AmigoModel();
                amigoModel.setSolicitante(UsuarioDAO.buscarUsuarioPorId((resultSet.getInt("codigo_usuario_solicitante"))));
                amigoModel.setSolicitado(UsuarioDAO.buscarUsuarioPorId((resultSet.getInt("codigo_usuario_solicitado"))));
                amigoModel.setConfirmado(resultSet.getBoolean("confirmado"));
                amigoModel.setCodigo(codigo);
            }
         } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return amigoModel;
    }

    public static int retornarQuantAmigos() {

        String sql = "SELECT COUNT(codigo) AS quantidade FROM amigos";
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
