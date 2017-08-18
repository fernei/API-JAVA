package com.accenture.apiautomacao.exception.md5;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author fernando.m.souza
 * @since 1.0
 */
public class GeraMD5Exception extends Exception {

    public GeraMD5Exception(String msg) {
        super(msg);
        log.warn(msg);
    }

    public GeraMD5Exception(String msg, Throwable cause) {
        super(msg, cause);
        log.warn(msg);
    }

}
