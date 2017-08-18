package com.accenture.apiautomacao.exception.registro;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class MensagemDeErroException extends Exception {
    private static final String ERRO = "Mensagem de erro para o registro ";
    
    public MensagemDeErroException(String registro){
        super(ERRO + registro);
        log.warn(ERRO + registro);
    }

    public MensagemDeErroException(String registro, Throwable cause){
        super(ERRO + registro, cause);        
        log.warn(ERRO + registro);
    }
}
