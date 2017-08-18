package com.accenture.apiautomacao.exception.usuario;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class SenhaExpiradaException extends UsuarioException {

    private static final String ERRO = "Usuário com senha expirada.";

    public SenhaExpiradaException() {
        super(ERRO);
        log.warn(ERRO);
    }

    public SenhaExpiradaException(Throwable cause) {
        super(ERRO, cause);
        log.warn(ERRO);
    }
}
