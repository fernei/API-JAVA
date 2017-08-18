package com.accenture.apiautomacao.exception.usuario;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class UsuarioRevogadoException extends UsuarioException {
    private static final String ERRO = "Usuário revogado.";
    
    public UsuarioRevogadoException(){
        super(ERRO);
        log.warn(ERRO);
    }

    public UsuarioRevogadoException(Throwable cause){
        super(ERRO, cause);        
        log.warn(ERRO);
    }
}
