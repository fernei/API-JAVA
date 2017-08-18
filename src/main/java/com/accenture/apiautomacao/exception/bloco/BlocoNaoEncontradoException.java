package com.accenture.apiautomacao.exception.bloco;

import com.accenture.apiautomacao.exception.alocacao.AlocacaoException;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class BlocoNaoEncontradoException extends AlocacaoException {
    private static final String ERRO = "Sem blocos disponíveis.";
    
    public BlocoNaoEncontradoException(){
        super(ERRO);
    }

    public BlocoNaoEncontradoException(Throwable cause){
        super(ERRO, cause);
    }
}
