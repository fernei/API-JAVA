package com.accenture.apiautomacao.exception.mainframe;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class OpcaoSuspensaNaoEncontradaException extends MainFrameException {
    private static final String ERRO = "A opção suspensa não foi encontrada: ";
    
    public OpcaoSuspensaNaoEncontradaException(String opcao){
        super(ERRO + opcao);
        log.warn(ERRO + opcao);
    }

    public OpcaoSuspensaNaoEncontradaException(String opcao, Throwable cause) {
        super(ERRO + opcao, cause);
        log.warn(ERRO + opcao);
    }
}
