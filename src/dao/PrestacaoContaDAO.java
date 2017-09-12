package dao;

import database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.PrestacaoContaModel;

/**
 * @author Rayssa Smanitto 24/08/2017
 */
public class PrestacaoContaDAO {

    public static void excluir(int codigo) throws SQLException {
        try {
            String sql = "DELETE FROM  prestacao_contas WHERE codigo = ?";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
    }

    public static int alterar(PrestacaoContaModel prestacaoConta) throws SQLException {
        try {
            String sql = "UPDATE prestacao_contas SET codigo_post = ?, gastos = ?, recebidos = ?, foto = ?, video = ?, texto = ? WHERE codigo = ?";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql);
            preparedStatement.setInt(1, prestacaoConta.getPost().getCodigo());
            preparedStatement.setDouble(2, prestacaoConta.getGastos());
            preparedStatement.setDouble(3, prestacaoConta.getRecebidos());
            preparedStatement.setBlob(4, prestacaoConta.getFoto());
            preparedStatement.setBlob(5, prestacaoConta.getVideo());
            preparedStatement.setString(6, prestacaoConta.getTexto());
            int resultado = preparedStatement.executeUpdate();
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            Conexao.desconectar();
        }
    }

    public static int inserir(PrestacaoContaModel prestacaoConta) throws SQLException {
        String sql = "INSERT INTO prestacao_contas (codigo_post, gastos, recebidos, foto, video, texto) VALEUS (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, prestacaoConta.getPost().getCodigo());
            preparedStatement.setDouble(2, prestacaoConta.getGastos());
            preparedStatement.setDouble(3, prestacaoConta.getRecebidos());
            preparedStatement.setBlob(4, prestacaoConta.getFoto());
            preparedStatement.setBlob(5, prestacaoConta.getVideo());
            preparedStatement.setString(6, prestacaoConta.getTexto());
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

    public static List<PrestacaoContaModel> retornarPrestacaoConta() throws SQLException {
        List<PrestacaoContaModel> prestacoes = new ArrayList<>();
        String sql = "SELECT codigo, codigo_post, gastos, recebidos, foto, video, texto";
        try {
            Statement statement = Conexao.conectar().createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                PrestacaoContaModel prestacaoContaModel = new PrestacaoContaModel();
                prestacaoContaModel.setCodigo(resultSet.getInt("codigo"));
                prestacaoContaModel.setPost(PostDAO.buscarPostPorId(resultSet.getInt("codigo_post")));
                prestacaoContaModel.setGastos(resultSet.getDouble("gastos"));
                prestacaoContaModel.setRecebidos(resultSet.getDouble("recebidos"));
                prestacaoContaModel.setFoto(resultSet.getBlob("foto"));
                prestacaoContaModel.setVideo(resultSet.getBlob("video"));
                prestacaoContaModel.setTexto(resultSet.getString("texto"));
                prestacoes.add(prestacaoContaModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return prestacoes;
    }

    public static PrestacaoContaModel buscarPrestacaoContaPorId(int codigo) {
        PrestacaoContaModel prestacaoContaModel = null;
        String sql = "SELECT codigo, codigo_post, gastos, recebidos, foto, video, texto FROM prestacoes WHERE codigo = ?";
        try {
            PreparedStatement preparedStatement = Conexao.conectar().prepareCall(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                prestacaoContaModel.setCodigo(resultSet.getInt("codigo"));
                prestacaoContaModel.setPost(PostDAO.buscarPostPorId(resultSet.getInt("codigo_post")));
                prestacaoContaModel.setGastos(resultSet.getDouble("gastos"));
                prestacaoContaModel.setRecebidos(resultSet.getDouble("recebidos"));
                prestacaoContaModel.setFoto(resultSet.getBlob("foto"));
                prestacaoContaModel.setVideo(resultSet.getBlob("video"));
                prestacaoContaModel.setTexto(resultSet.getString("texto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return prestacaoContaModel;
    }

    public static int retornarQuantidadeRegistros() throws SQLException {
        String sql = "SELECT COUNT (codigo) AS quantidade FROM prestacoes";
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
