package com.accenture.apiautomacao.exception.md5;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author fernando.m.souza
 */
public class DivergenciaMD5Exception extends Exception {

    public DivergenciaMD5Exception(String msg) {
        super(msg);
        log.info(msg);
    }

    public DivergenciaMD5Exception(String msg, Throwable cause) {
        super(msg, cause);
        log.info(msg);
    }

}
