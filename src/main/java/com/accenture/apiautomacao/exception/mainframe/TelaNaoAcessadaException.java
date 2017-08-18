package com.accenture.apiautomacao.exception.mainframe;

import static com.accenture.apiautomacao.logger.LogTrace.log;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class TelaNaoAcessadaException extends MainFrameException {

    private static final String ERRO = "A tela não foi acessada: ";

    public TelaNaoAcessadaException(String codTela) {
        super(ERRO + codTela);
        log.warn(ERRO + codTela);
    }

    public TelaNaoAcessadaException(String codTela, Throwable cause) {
        super(ERRO + codTela, cause);
        log.warn(ERRO + codTela);
    }
}
