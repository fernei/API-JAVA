package com.accenture.apiautomacao.exception.usuario;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class DadosIncorretosException extends UsuarioException {
    private static final String ERRO = "Dados incorretos: ";
    
    public DadosIncorretosException(String msg){
        super(ERRO + msg);
        log.warn(ERRO + msg);
    }

    public DadosIncorretosException(String msg, Throwable cause){
        super(ERRO + msg, cause);        
        log.warn(ERRO + msg);
    }
}
