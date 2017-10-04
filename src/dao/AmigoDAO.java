package dao;

import database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.AmigoModel;
import model.UsuarioModel;

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
                + "codigo_usuario_solicitado,confirmado) VALUES (?,?,?);";
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, amigoModel.getSolicitante().getCodigo());
            ps.setInt(2, amigoModel.getSolicitado().getCodigo());
            ps.setInt(3, 1);
            ps.execute();
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
                amigoModel.setConfirmado(resultSet.getInt("confirmado"));
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

    public static List<UsuarioModel> encontrarAmigos(String aAmigo, int aUsuario) {
        List<UsuarioModel> amigos = new ArrayList<>();
        String sql = "SELECT codigo,nome,foto FROM USUARIOS WHERE NOME LIKE ? AND " +
                     "CODIGO NOT IN (SELECT " +
                                     "CASE " +
                                         "WHEN CODIGO_USUARIO_SOLICITANTE = ? THEN CODIGO_USUARIO_SOLICITADO " +
                                         "WHEN CODIGO_USUARIO_SOLICITADO = ? THEN CODIGO_USUARIO_SOLICITANTE " +
                                     "END AS CODIGO_AMIGO " +
                     "FROM AMIGOS WHERE ((CODIGO_USUARIO_SOLICITANTE=? AND (CONFIRMADO=2 OR CONFIRMADO=1)) OR (CODIGO_USUARIO_SOLICITADO=? AND (CONFIRMADO=2 OR CONFIRMADO=1))))";
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, "%"+aAmigo+"%");
            ps.setInt(2,aUsuario);
            ps.setInt(3,aUsuario);
            ps.setInt(4,aUsuario);
            ps.setInt(5,aUsuario);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                if (resultSet.getInt("codigo") != aUsuario) {
                    UsuarioModel amigo = new UsuarioModel();
                    amigo.setCodigo(resultSet.getInt("codigo"));
                    amigo.setNome(resultSet.getString("nome"));
                    amigo.setFoto(resultSet.getBlob("foto"));
                    amigos.add(amigo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return amigos;
    }

    public static List<UsuarioModel> buscarSolicitacoes(int aUsuario) {
        List<UsuarioModel> solicitantes = new ArrayList<>();
        String sql = "SELECT codigo_usuario_solicitante FROM AMIGOS WHERE CODIGO_USUARIO_SOLICITADO=? AND CONFIRMADO=1";
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, aUsuario);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                   UsuarioModel solicitante = UsuarioDAO.buscarUsuarioPorId(resultSet.getInt("codigo_usuario_solicitante"));
                   solicitantes.add(solicitante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return solicitantes;
    }

    public static int aceitarSolicitacao(int aSolicitado, int aSolicitante, int aSituacao) {
        String sql = "UPDATE AMIGOS SET CONFIRMADO=? WHERE codigo_usuario_solicitado=? and codigo_usuario_solicitante=?";
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, aSituacao);
            ps.setInt(2, aSolicitado);
            ps.setInt(3, aSolicitante);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return -1;
    }

    public static List<UsuarioModel> carregarAmigos(int aUsuario) {
        List<UsuarioModel> amigos = new ArrayList<>();
        String sql = "SELECT \n" +
                "CASE   \n" +
                "WHEN CODIGO_USUARIO_SOLICITANTE =? THEN CODIGO_USUARIO_SOLICITADO   \n" +
                "WHEN CODIGO_USUARIO_SOLICITADO =? THEN CODIGO_USUARIO_SOLICITANTE   \n" +
                "END AS CODIGO_AMIGO\n" +
                "FROM AMIGOS WHERE ((CODIGO_USUARIO_SOLICITANTE=? AND CONFIRMADO=2) OR (CODIGO_USUARIO_SOLICITADO=? AND CONFIRMADO=2))";
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, aUsuario);
            ps.setInt(2, aUsuario);
            ps.setInt(3, aUsuario);
            ps.setInt(4, aUsuario);
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                UsuarioModel amigo = UsuarioDAO.buscarUsuarioPorId(resultSet.getInt("CODIGO_AMIGO"));
                amigos.add(amigo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return amigos;
    }

}
