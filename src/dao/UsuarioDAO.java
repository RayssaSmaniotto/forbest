package dao;

import database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

    public static int alterar(UsuarioModel usuarioModel) {
        try {
            String sql = "UPDATE usuarios SET nome = ?, sobrenome = ?, idade = ?, data_nascimento = ?, email = ?, "
                    + "razao_social = ?, cnpj = ?, cpf = ?, cep = ?, numero = ?, logradouro = ?, estado = ?, cidade = ?, bairro = ?, "
                    + "senha = ?, celular = ?, genero = ?, biografia = ?, foto = ?, galeria = ?, url_facebook = ?, "
                    + "url_linkedin = ?, url_twitter = ?, url_instagram = ?, numero_local = ? WHERE codigo = ?";

            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, usuarioModel.getNome());
            ps.setString(2, usuarioModel.getSobrenome());
            ps.setInt(3, usuarioModel.getIdade());
            ps.setDate(4, usuarioModel.getDataNascimento());
            ps.setString(5, usuarioModel.getEmail());
            ps.setString(6, usuarioModel.getRazaoSocial());
            ps.setString(7, usuarioModel.getCnpj());
            ps.setString(8, usuarioModel.getCpf());
            ps.setString(9, usuarioModel.getCep());
            ps.setInt(10, usuarioModel.getNumero());
            ps.setString(11, usuarioModel.getLogradouro());
            ps.setString(12, usuarioModel.getEstado());
            ps.setString(13, usuarioModel.getCidade());
            ps.setString(14, usuarioModel.getBairro());
            ps.setString(15, usuarioModel.getSenha());
            ps.setString(16, usuarioModel.getCelular());
            ps.setString(17, String.valueOf(usuarioModel.getGenero()));
            ps.setString(18, usuarioModel.getBiografia());
            ps.setBlob(19, usuarioModel.getFoto());
            ps.setBlob(20, usuarioModel.getGaleria());
            ps.setString(21, usuarioModel.getUrlFacebook());
            ps.setString(22, usuarioModel.getUrlLinkedin());
            ps.setString(23, usuarioModel.getUrlTwitter());
            ps.setString(24, usuarioModel.getUrlInstagram());
            ps.setInt(25, usuarioModel.getNumeroLocal());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return -1;
    }

    public static int inserir(UsuarioModel usuarioModel) {
        String sql = "INSERT INTO usuarios (nome, sobrenome, idade, data_nascimento, email, razao_social, cnpj, cpf, cep, "
                + "numero, logradouro, estado, cidade, bairro, senha, celular, genero, biografia, foto, galeria, "
                + "url_facebook, url_linkedin, url_twitter, url_instagram, numero_local) VALUES (?, ?, ?,  ?,  ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuarioModel.getNome());
            ps.setString(2, usuarioModel.getSobrenome());
            ps.setInt(3, usuarioModel.getIdade());
            ps.setDate(4, usuarioModel.getDataNascimento());
            ps.setString(5, usuarioModel.getEmail());
            ps.setString(6, usuarioModel.getRazaoSocial());
            ps.setString(7, usuarioModel.getCnpj());
            ps.setString(8, usuarioModel.getCpf());
            ps.setString(9, usuarioModel.getCep());
            ps.setInt(10, usuarioModel.getNumero());
            ps.setString(11, usuarioModel.getLogradouro());
            ps.setString(12, usuarioModel.getEstado());
            ps.setString(13, usuarioModel.getCidade());
            ps.setString(14, usuarioModel.getBairro());
            ps.setString(15, usuarioModel.getSenha());
            ps.setString(16, usuarioModel.getCelular());
            ps.setString(17, String.valueOf(usuarioModel.getGenero()));
            ps.setString(18, usuarioModel.getBiografia());
            ps.setBlob(19, usuarioModel.getFoto());
            ps.setBlob(20, usuarioModel.getGaleria());
            ps.setString(21, usuarioModel.getUrlFacebook());
            ps.setString(22, usuarioModel.getUrlLinkedin());
            ps.setString(23, usuarioModel.getUrlTwitter());
            ps.setString(24, usuarioModel.getUrlInstagram());
            ps.setInt(25, usuarioModel.getNumeroLocal());
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
                usuario.setGenero(resultSet.getString("genero").charAt(0));
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

    public static boolean realizarLogin(String email, String senha) {
        String sql = "SELECT id FROM alunos WHERE email = ? AND senha = ?";
        try {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);
            ps.execute();
            ResultSet resultados = ps.getResultSet();
            if (resultados.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return false;
    }
}
