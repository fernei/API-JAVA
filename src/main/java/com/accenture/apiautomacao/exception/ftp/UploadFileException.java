package com.accenture.apiautomacao.exception.ftp;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author fernando.m.souza
 * @since 1.0
 */
public class UploadFileException extends Exception{
    
    public UploadFileException(String msg){
        super(msg);
        log.warn(msg);
    }

    public UploadFileException(String msg, Throwable cause){
        super(msg, cause);
        log.warn(msg);
    }
    
}
