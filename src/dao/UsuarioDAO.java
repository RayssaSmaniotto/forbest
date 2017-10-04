package dao;

import database.Conexao;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdk.internal.util.xml.impl.Input;
import model.UsuarioModel;

/**
 * @author Henrique Gioppo Roman Ross 23/08/2017
 */
public class UsuarioDAO {

    public static void excluir(int codigo) {
        try {
            String sql = "DELETE FROM usuarios WHERE codigo = ?";

            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
    }

    public static int alterar(UsuarioModel usuarioModel, InputStream aImagem) {
        try {
            String sql = "UPDATE usuarios SET nome = ?, sobrenome = ?, idade = ?, data_nascimento = ?, email = ?, "
                    + "cpf = ?, cep = ?, numero = ?, logradouro = ?, estado = ?, cidade = ?, bairro = ?, "
                    + "senha = ?, celular = ?, genero = ?, biografia = ?, url_facebook = ?, "
                    + "url_linkedin = ?, url_twitter = ?, url_instagram = ? ";
            if(aImagem != null){
                sql += ", foto = ?";
            }
            sql += "\nWHERE codigo = ?";

            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            int posicao = 1;
            ps.setString(posicao++, usuarioModel.getNome());
            ps.setString(posicao++, usuarioModel.getSobrenome());
            ps.setInt(posicao++, usuarioModel.getIdade());
            ps.setDate(posicao++, usuarioModel.getDataNascimento());
            ps.setString(posicao++, usuarioModel.getEmail());
            ps.setString(posicao++, usuarioModel.getCpf());
            ps.setString(posicao++, usuarioModel.getCep());
            ps.setInt(posicao++, usuarioModel.getNumero());
            ps.setString(posicao++, usuarioModel.getLogradouro());
            ps.setString(posicao++, usuarioModel.getEstado());
            ps.setString(posicao++, usuarioModel.getCidade());
            ps.setString(posicao++, usuarioModel.getBairro());
            ps.setString(posicao++, usuarioModel.getSenha());
            ps.setString(posicao++, usuarioModel.getCelular());
            ps.setString(posicao++, String.valueOf(usuarioModel.getGenero()));
            ps.setString(posicao++, usuarioModel.getBiografia());
            ps.setString(posicao++, usuarioModel.getUrlFacebook());
            ps.setString(posicao++, usuarioModel.getUrlLinkedin());
            ps.setString(posicao++, usuarioModel.getUrlTwitter());
            ps.setString(posicao++, usuarioModel.getUrlInstagram());

            if(aImagem !=null){
                ps.setBlob(posicao++, aImagem);
            }

            ps.setInt(posicao++, usuarioModel.getCodigo());

            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return -1;
    }

    public static int inserir(UsuarioModel usuarioModel, InputStream aImagem) {
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?);";


        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuarioModel.getNome());
            ps.setString(2, usuarioModel.getEmail());
            ps.setString(3, usuarioModel.getSenha());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
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

    public static List<UsuarioModel> retornarUsuarios() {
        List<UsuarioModel> usuarios = new ArrayList<>();
        String sql = "SELECT codigo, nome, sobrenome, idade, data_nascimento, email, razao_social, cnpj, cpf, cep, "
                + "numero, logradouro, estado, cidade, bairro, senha, celular, genero, biografia, foto, galeria, "
                + "url_facebook, url_linkedin, url_twitter, url_instagram, numero_local FROM usuarios";
        try {
            Statement statement = Conexao.conectar().createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                UsuarioModel usuario = new UsuarioModel();
                usuario.setCodigo(resultSet.getInt("codigo"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setSobrenome(resultSet.getString("sobrenome"));
                usuario.setIdade(resultSet.getInt("idade"));
                usuario.setDataNascimento(resultSet.getDate("data_nascimento"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setRazaoSocial(resultSet.getString("razao_social"));
                usuario.setCnpj(resultSet.getString("cnpj"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setCep(resultSet.getString("cep"));
                usuario.setNumero(resultSet.getInt("numero"));
                usuario.setLogradouro(resultSet.getString("logradouro"));
                usuario.setEstado(resultSet.getString("estado"));
                usuario.setCidade(resultSet.getString("cidade"));
                usuario.setBairro(resultSet.getString("bairro"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setCelular(resultSet.getString("celular"));
                usuario.setGenero(resultSet.getString("genero").charAt(0));
                usuario.setBiografia(resultSet.getString("biografia"));
                usuario.setFoto(resultSet.getBlob("foto"));
                usuario.setGaleria(resultSet.getBlob("galeria"));
                usuario.setUrlFacebook(resultSet.getString("url_facebook"));
                usuario.setUrlLinkedin(resultSet.getString("url_linkedin"));
                usuario.setUrlTwitter(resultSet.getString("url_twitter"));
                usuario.setUrlInstagram(resultSet.getString("url_instagram"));
                usuario.setNumeroLocal(resultSet.getInt("numero_local"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return usuarios;
    }

    public static UsuarioModel buscarUsuarioPorId(int codigo) {
        UsuarioModel usuario = null;
        String sql = "SELECT "
                + "codigo, nome, sobrenome, idade, data_nascimento, email, razao_social, cnpj, cpf, cep, "
                + "numero, logradouro, estado, cidade, bairro, senha, celular, genero, biografia, foto, galeria, "
                + "url_facebook, url_linkedin, url_twitter, url_instagram, numero_local FROM usuarios WHERE codigo = ?";
        try {
            PreparedStatement preparedStatement = Conexao.conectar().prepareCall(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                usuario = new UsuarioModel();
                usuario.setCodigo(resultSet.getInt("codigo"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setSobrenome(resultSet.getString("sobrenome"));
                usuario.setIdade(resultSet.getInt("idade"));
                usuario.setDataNascimento(resultSet.getDate("data_nascimento"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setRazaoSocial(resultSet.getString("razao_social"));
                usuario.setCnpj(resultSet.getString("cnpj"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setCep(resultSet.getString("cep"));
                usuario.setNumero(resultSet.getInt("numero"));
                usuario.setLogradouro(resultSet.getString("logradouro"));
                usuario.setEstado(resultSet.getString("estado"));
                usuario.setCidade(resultSet.getString("cidade"));
                usuario.setBairro(resultSet.getString("bairro"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setCelular(resultSet.getString("celular"));
                if (resultSet.getString("genero") != null) {
                    usuario.setGenero(resultSet.getString("genero").charAt(0));

                }
                usuario.setBiografia(resultSet.getString("biografia"));
                usuario.setFoto(resultSet.getBlob("foto"));
                usuario.setGaleria(resultSet.getBlob("galeria"));
                usuario.setUrlFacebook(resultSet.getString("url_facebook"));
                usuario.setUrlLinkedin(resultSet.getString("url_linkedin"));
                usuario.setUrlTwitter(resultSet.getString("url_twitter"));
                usuario.setUrlInstagram(resultSet.getString("url_instagram"));
                usuario.setNumeroLocal(resultSet.getInt("numero_local"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return usuario;
    }

    public static UsuarioModel realizarLogin(String email, String senha) {
        String sql = "SELECT codigo FROM usuarios WHERE email = ? AND senha = ?";
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);
            ps.execute();
            ResultSet resultados = ps.getResultSet();
            if (resultados.next()) {
                return UsuarioDAO.buscarUsuarioPorId(resultados.getInt("codigo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public byte[] recuperarImagem(int codigo){
        Conexao conexao = new Conexao();
        byte[] imagem = null;

        try{
            String sql = "SELECT foto FROM usuarios WHERE codigo =?";
            Statement statement = conexao.conectar().createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                imagem = rs.getBytes("foto");
            }
            statement.close();

        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }finally {
            Conexao.desconectar();
        }
        return imagem;
    }

}





























