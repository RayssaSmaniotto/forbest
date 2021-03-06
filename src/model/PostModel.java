package model;

import java.sql.Date;
import java.util.ArrayList;
import database.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Antonio Pedro 22/08/2017
 */
public class PostModel {

    public ArrayList<DoacaoModel> getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(ArrayList<DoacaoModel> doacoes) {
        this.doacoes = doacoes;
    }

    private int codigo,apoios;
    private ArrayList<DoacaoModel> doacoes;
    private UsuarioModel usuario;
    private String descricao, titulo, status;
    private Date dataCriacao, dataEvento;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getApoios() {
     /*   String sql = "SELECT COUNT(apoios) AS apoios FROM posts WHERE codigo = ?";

        try {
            PreparedStatement ps = Conexao.conectar().prepareCall(sql);
            ps.setInt(1, this.codigo);
            ps.execute();
            apoios = ps.getResultSet().getInt("apoios");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return apoios;*/
        return codigo;
    }

    public void setApoios(int apoios) {
        this.apoios = apoios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

}
