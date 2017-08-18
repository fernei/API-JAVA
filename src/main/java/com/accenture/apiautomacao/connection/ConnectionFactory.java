package com.accenture.apiautomacao.connection;

import static com.accenture.apiautomacao.logger.LogTrace.log;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Classe responsável por criar a sessão para interação com o Banco de Dados,
 * utilizando uma SessionFactory.
 *
 * @author otavio.c.ferreira
 * @since 1.0.0
 */
public class ConnectionFactory {

    public static SessionFactory sessao;

    /**
     * Cria a sessão com o Banco de Dados.
     *
     * @return Uma sessão aberta com o Banco de Dados.
     * @exception ExceptionInInitializerError Não foi possível abrir a sessão
     * com o Banco de Dados.
     * @since 1.0.0
     */
    public Session getSession() {
        try {
            return sessao.openSession();
        } catch (HibernateException ex) {
            log.error("Falha na criação da sessão:" + ex);
            throw new HibernateException(ex);
        }
    }
}
