package com.accenture.apiautomacao.exception.mainframe;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class MainFrameException extends Exception {
    public MainFrameException(String msg){
        super(msg);
        log.warn(msg);
    }

    public MainFrameException(String msg, Throwable cause){
        super(msg, cause);        
        log.warn(msg);
    }
}
