package com.accenture.apiautomacao.exception.alocacao;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 * Exception para alocações.
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class AlocacaoException extends Exception {

    public AlocacaoException(String msg) {
        super(msg);
        log.warn(msg);
    }

    public AlocacaoException(String msg, Throwable cause) {
        super(msg, cause);
        log.warn(msg);
    }
}
