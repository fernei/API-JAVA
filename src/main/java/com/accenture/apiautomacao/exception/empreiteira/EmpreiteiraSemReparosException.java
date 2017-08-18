package com.accenture.apiautomacao.exception.empreiteira;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class EmpreiteiraSemReparosException extends Exception {
    private static final String ERRO = "Não foi possível selecionar reparos para a empreiteira: ";
    
    public EmpreiteiraSemReparosException(String msg){
        super(ERRO + msg);
        log.warn(ERRO + msg);
    }

    public EmpreiteiraSemReparosException(String msg, Throwable cause){
        super(ERRO + msg, cause);        
        log.warn(ERRO + msg);
    }
}
