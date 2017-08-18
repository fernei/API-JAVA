package com.accenture.apiautomacao.model;

import java.util.List;

/**
 *
 * @author fernando.m.souza
 */
public class FTPModel {

    private String server;
    private int port;
    private String user;
    private String pass;
    private String pastaLocal;
    private String pastaFTP;
    private String nomeArquivoLocal;
    private String nomeArquivoFTP;
    private List<String> ListArquivos;
    
    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPastaLocal() {
        return pastaLocal;
    }

    public void setPastaLocal(String pastaLocal) {
        this.pastaLocal = pastaLocal;
    }

    public String getPastaFTP() {
        return pastaFTP;
    }

    public void setPastaFTP(String pastaFTP) {
        this.pastaFTP = pastaFTP;
    }

    public List<String> getListArquivos() {
        return ListArquivos;
    }

    public void setListArquivos(List<String> ListArquivos) {
        this.ListArquivos = ListArquivos;
    }

    public String getNomeArquivoLocal() {
        return nomeArquivoLocal;
    }

    public void setNomeArquivoLocal(String nomeArquivoLocal) {
        this.nomeArquivoLocal = nomeArquivoLocal;
    }

    public String getNomeArquivoFTP() {
        return nomeArquivoFTP;
    }

    public void setNomeArquivoFTP(String nomeArquivoFTP) {
        this.nomeArquivoFTP = nomeArquivoFTP;
    }

}
