package com.accenture.apiautomacao.exception.usuario;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class SemPermissaoException extends UsuarioException {

    private static final String ERRO = "Usuário sem permissão.";

    public SemPermissaoException() {
        super(ERRO);
        log.warn(ERRO);
    }

    public SemPermissaoException(Throwable cause) {
        super(ERRO, cause);
        log.warn(ERRO);
    }
}
