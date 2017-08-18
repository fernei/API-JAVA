package com.accenture.apiautomacao.exception.fila;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class FilaNaoEncontradaException extends Exception {
    private static final String ERRO = "Fila não encontrada: ";
    
    public FilaNaoEncontradaException(String msg){
        super(ERRO + msg);
        log.warn(ERRO);
    }

    public FilaNaoEncontradaException(String msg, Throwable cause){
        super(ERRO + msg, cause);        
        log.warn(ERRO + msg);
    }
}
