package com.accenture.apiautomacao.exception.mainframe;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class PosicaoBloqueadaException extends MainFrameException{
    private static final String ERRO = "Escrevendo em posição bloqueada: ";
    
    public PosicaoBloqueadaException(String msg){
        super(ERRO + msg);
        log.warn(ERRO + msg);
    }

    public PosicaoBloqueadaException(String msg, Throwable cause){
        super(ERRO + msg, cause);        
        log.warn(ERRO + msg);
    }
}
