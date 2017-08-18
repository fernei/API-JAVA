package com.accenture.apiautomacao.exception.mainframe.navegacao;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class ComandoException extends Exception {
    public ComandoException(String msg){
        super(msg);
        log.warn(msg);
    }

    public ComandoException(String msg, Throwable cause){
        super(msg, cause);
        log.warn(msg);
    }
}
