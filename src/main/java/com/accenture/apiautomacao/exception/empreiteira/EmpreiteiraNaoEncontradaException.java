package com.accenture.apiautomacao.exception.empreiteira;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class EmpreiteiraNaoEncontradaException extends Exception {
    private static final String ERRO = "Não foi possível selecionar uma empreiteira.";
    
    public EmpreiteiraNaoEncontradaException(){
        super(ERRO);
        log.warn(ERRO);
    }

    public EmpreiteiraNaoEncontradaException(Throwable cause){
        super(ERRO, cause);        
        log.warn(ERRO);
    }
}
