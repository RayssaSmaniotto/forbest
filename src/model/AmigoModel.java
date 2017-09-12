package model;

import java.util.Date;

/**
 * @author Antonio Pedro 22/08/2017
 */
public class AmigoModel {

    private int codigo;
    private UsuarioModel solicitante, solicitado;
    private boolean confirmado;
    private Date dataCriacao;

    public int getCodigo() {
        return codigo;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public UsuarioModel getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(UsuarioModel solicitante) {
        this.solicitante = solicitante;
    }

    public UsuarioModel getSolicitado() {
        return solicitado;
    }

    public void setSolicitado(UsuarioModel solicitado) {
        this.solicitado = solicitado;
    }

    public Date getDataCriacaos() {
        return dataCriacao;
    }

    public void setDataCriacaos(Date dataCriacaos) {
        this.dataCriacao = dataCriacao;
    }

}
