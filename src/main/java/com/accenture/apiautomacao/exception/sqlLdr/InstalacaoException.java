package com.accenture.apiautomacao.exception.sqlLdr;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author fernando.m.souza
 * @since 1.0
 */
public class InstalacaoException extends Exception{
       
    public InstalacaoException(String msg){
        super(msg);
        log.warn(msg);
    }

    public InstalacaoException(String msg, Throwable cause){
        super(msg, cause);        
        log.warn(msg);
    }
    
}
