package com.accenture.apiautomacao.model;


/**
 *
 * @author fernando.m.souza
 */
public class SqlLdrModel {

    private String dirArquivoOrigem;
    private String tipoArquivoOrigem;
    private String caminhoCTL;
    private String arquivoCTL;

    private Banco banco;

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getDirArquivoOrigem() {
        return dirArquivoOrigem;
    }

    public void setDirArquivoOrigem(String dirArquivoOrigem) {
        this.dirArquivoOrigem = dirArquivoOrigem;
    }

    public String getTipoArquivoOrigem() {
        return tipoArquivoOrigem;
    }

    public void setTipoArquivoOrigem(String tipoArquivoOrigem) {
        this.tipoArquivoOrigem = tipoArquivoOrigem;
    }

    public String getCaminhoCTL() {
        return caminhoCTL;
    }

    public void setCaminhoCTL(String caminhoCTL) {
        this.caminhoCTL = caminhoCTL;
    }

    public String getArquivoCTL() {
        return arquivoCTL;
    }

    public void setArquivoCTL(String arquivoCTL) {
        this.arquivoCTL = arquivoCTL;
    }
}
