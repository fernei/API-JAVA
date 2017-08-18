package com.accenture.apiautomacao.exception.usuario;

import com.accenture.apiautomacao.exception.alocacao.AlocacaoException;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class UsuarioNaoEncontradoException extends AlocacaoException {
    private static final String ERRO = "Sem usuários disponíveis.";
    
    public UsuarioNaoEncontradoException(){
        super(ERRO);
    }

    public UsuarioNaoEncontradoException(Throwable cause){
        super(ERRO, cause);  
    }
}
