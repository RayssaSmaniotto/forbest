package dao;

import database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.DoacaoModel;

/**
 * @author Rayssa Smaniotto 23/08/2017
 */
public class DoacaoDAO {

    public static void excluir(int codigo) {
        try {
            String sql = "DELETE FROM doacoes WHERE codigo = ?";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
    }

    public static int alterar(DoacaoModel doacao) {
        try {
            String sql = "UPDATE doacoes SET codigo_post = ?, valor = ?, url_forma_pagamento = ? WHERE codigo = ?";

            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql);
            preparedStatement.setInt(1, doacao.getPost().getCodigo());
            preparedStatement.setFloat(2, doacao.getValor());
            preparedStatement.setString(3, doacao.getUrlFormaPagamento());
            preparedStatement.setInt(4, doacao.getCodigo());
            int resultado = preparedStatement.executeUpdate();
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            Conexao.desconectar();
        }
    }

    public static int inserir(DoacaoModel doacao) {
        String sql = "INSERT INTO doacoes (codigo_post, valor, url_forma_pagamento) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, doacao.getPost().getCodigo());
            preparedStatement.setFloat(2, doacao.getValor());
            preparedStatement.setString(3, doacao.getUrlFormaPagamento());
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

    public static List<DoacaoModel> retornarDoacao() {
        List<DoacaoModel> doacoes = new ArrayList<>();
        String sql = "SELECT codigo, codigo_post, valor, url_forma_pagamento FROM doacoes";
        try {
            Statement statement = Conexao.conectar().createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                DoacaoModel doacaoModel = new DoacaoModel();
                doacaoModel.setCodigo(resultSet.getInt("codigo"));
                doacaoModel.setPost(PostDAO.buscarPostPorId(resultSet.getInt("codigo_post")));
                doacaoModel.setValor(resultSet.getFloat("valor"));
                doacaoModel.setUrlFormaPagamento(resultSet.getString("url_forma_pagamento"));
                doacoes.add(doacaoModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return doacoes;
    }

    public static DoacaoModel buscarDoacaoPorId(int codigo) {
        DoacaoModel doacao = null;
        String sql = "SELECT codigo, codigo_post, valor, url_forma_pagamento FROM doacoes WHERE codigo = ?";
        try {
            PreparedStatement preparedStatement = Conexao.conectar().prepareCall(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                doacao = new DoacaoModel();
                doacao.setCodigo(resultSet.getInt("codigo"));
                doacao.setPost(PostDAO.buscarPostPorId(resultSet.getInt("codigo_post")));
                doacao.setValor(resultSet.getFloat("valor"));
                doacao.setUrlFormaPagamento(resultSet.getString("url_forma_pagamento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return doacao;

    }

    public static int retornarQuantidadeRegistros() {
        String sql = "SELECT COUNT(codigo) AS quantidade FROM doacoes";
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

    public static ArrayList<DoacaoModel> buscarDoacaoPorIdDoPost(int codigo) {
        ArrayList<DoacaoModel> doacoes = new ArrayList<>();
        String sql = "SELECT codigo, codigo_post, valor, url_forma_pagamento FROM doacoes WHERE codigo_post = ?";
        try {
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                DoacaoModel doacaoModel = new DoacaoModel();
                doacaoModel.setCodigo(resultSet.getInt("codigo"));
                doacaoModel.setPost(PostDAO.buscarPostPorId(resultSet.getInt("codigo_post")));
                doacaoModel.setValor(resultSet.getFloat("valor"));
                doacaoModel.setUrlFormaPagamento(resultSet.getString("url_forma_pagamento"));
                doacoes.add(doacaoModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return doacoes;
    }

}
