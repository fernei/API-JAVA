package com.accenture.apiautomacao.model;

import static com.accenture.apiautomacao.logger.LogTrace.log;
import java.io.File;
import java.io.IOException;
import org.ini4j.Ini;

/**
 *
 * @author otavio.c.ferreira
 */
public class Banco {

    private String ip;
    private String porta;
    private String sid;
    private String usuario;
    private String senha;

    /**
     * Construtor para insânciar a classe Banco já com os parâmetros pegos do
     * arquivo INI informado.
     *
     * @param tagIni Tag no arquivo INI que contêm os atributos utilizados.
     * @param conf Caminha completo do arquivo INI.
     * @since 1.0.0
     */
    public Banco(String tagIni, File conf) {
        try {
            if (conf.exists()) {
                Ini ini = new Ini(conf);
                ip = ini.get(tagIni, "IP");
                porta = ini.get(tagIni, "PORTA");
                sid = ini.get(tagIni, "SID");
                usuario = ini.get(tagIni, "USUARIO");
                senha = ini.get(tagIni, "SENHA");
            } else {
                throw new IOException();
            }
        } catch (RuntimeException | IOException ex) {
            log.error("Não foi possível carregar as configurações de acesso ao banco do arquivo INI.");
        }
    }

    public String getIp() {
        return ip;
    }

    public String getPorta() {
        return porta;
    }

    public String getSid() {
        return sid;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
