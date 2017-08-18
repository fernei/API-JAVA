package com.accenture.apiautomacao.exception.mainframe.conexao;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class ConexaoException extends Exception {
    public ConexaoException(String msg){
        super(msg);
        log.warn(msg);
    }

    public ConexaoException(String msg, Throwable cause){
        super(msg, cause);
        log.warn(msg);
    }
}
