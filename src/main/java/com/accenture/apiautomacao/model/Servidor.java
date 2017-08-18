package com.accenture.apiautomacao.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe representando a tabela <b>SERVIDOR_SAC</b>.
 *
 * @author otavio.c.ferreira
 * @since 1.0.0
 * @deprecated 1.0
 */
@Entity
@Table(name = "SERVIDOR_SAC")
public class Servidor implements Serializable {

    @Id
    @Column(name = "NUMERO")
    private int id;
    @Column(name = "IP")
    private String ip;
    @Column(name = "ATIVO")
    private char ativo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public char getAtivo() {
        return ativo;
    }

    public void setAtivo(char ativo) {
        this.ativo = ativo;
    }
}
