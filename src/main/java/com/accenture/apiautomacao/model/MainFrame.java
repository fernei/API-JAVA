package com.accenture.apiautomacao.model;

/**
 * Classe respons[avel por manter todas as informa;'oes necess[arias para
 * utilização de um terminal.
 *
 * @author otavio.c.ferreira
 * @since 1.0.0
 */
public class MainFrame {

    private String hostIP; //Endereço para conexão com mainframe
    private String canal; //Trilha de conexão com mainframe
    private int timeout = 30; //Tempo padrão de espera pela resposta do mainframe
    private boolean statusConexao;

    public String getHostIP() {
        return hostIP;
    }

    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isStatusConexao() {
        return statusConexao;
    }

    public void setStatusConexao(boolean statusConexao) {
        this.statusConexao = statusConexao;
    }

}
