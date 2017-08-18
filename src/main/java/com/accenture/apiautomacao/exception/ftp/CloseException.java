package com.accenture.apiautomacao.exception.ftp;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author fernando.m.souza
 * @since 1.0
 */
public class CloseException extends Exception {

    public CloseException(String msg) {
        super(msg);
        log.warn(msg);
    }

    public CloseException(String msg, Throwable cause) {
        super(msg, cause);
        log.warn(msg);
    }

}
