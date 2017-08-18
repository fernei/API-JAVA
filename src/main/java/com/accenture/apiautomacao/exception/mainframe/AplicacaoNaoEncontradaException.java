package com.accenture.apiautomacao.exception.mainframe;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class AplicacaoNaoEncontradaException extends MainFrameException {
    private static final String ERRO = "Não existe aplicação para a UF: ";
    
    public AplicacaoNaoEncontradaException(String uf){
        super(ERRO + uf);
        log.warn(ERRO + uf);
    }

    public AplicacaoNaoEncontradaException(String uf, Throwable cause){
        super(ERRO + uf, cause);        
        log.warn(ERRO + uf);
    }
}
