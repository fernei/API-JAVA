package com.accenture.apiautomacao.exception.bloco;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class BlocoParametroIncorreto extends Exception {
    private static final String ERRO = "Bloco com parâmetro incorreto: ";
    
    public BlocoParametroIncorreto(String msg){
        super(ERRO + msg);
        log.warn(ERRO);
    }

    public BlocoParametroIncorreto(String msg, Throwable cause){
        super(ERRO + msg, cause);        
        log.warn(ERRO + msg);
    }
}
