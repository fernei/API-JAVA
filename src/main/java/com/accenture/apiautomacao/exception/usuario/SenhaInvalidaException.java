package com.accenture.apiautomacao.exception.usuario;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class SenhaInvalidaException extends UsuarioException {

    private static final String ERRO = "Usuário com senha Inválida.";

    public SenhaInvalidaException() {
        super(ERRO);
        log.warn(ERRO);
    }

    public SenhaInvalidaException(Throwable cause) {
        super(ERRO, cause);
        log.warn(ERRO);
    }
}
