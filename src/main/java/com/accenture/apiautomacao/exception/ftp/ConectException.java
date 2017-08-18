package com.accenture.apiautomacao.exception.ftp;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author fernando.m.souza
 * @since 1.0
 */
public class ConectException extends Exception {

    public ConectException(String msg) {
        super(msg);
        log.warn(msg);
    }

    public ConectException(String msg, Throwable cause) {
        super(msg, cause);
        log.warn(msg);
    }
}
