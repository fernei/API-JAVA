/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.apiautomacao.exception.ftp;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author fernando.m.souza
 */
public class ConnectException extends Exception {

    public ConnectException(String msg) {
        super(msg);
        log.warn(msg);
    }

    public ConnectException(String msg, Throwable cause) {
        super(msg, cause);
        log.warn(msg);
    }

}
