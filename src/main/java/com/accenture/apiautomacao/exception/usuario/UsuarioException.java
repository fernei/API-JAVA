package com.accenture.apiautomacao.exception.usuario;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class UsuarioException extends Exception {
    public UsuarioException(String msg){
        super(msg);
    }

    public UsuarioException(String msg, Throwable cause){
        super(msg, cause);
    }
}
