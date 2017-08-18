package com.accenture.apiautomacao.exception.mainframe;

/**
 *
 * @author otavio.c.ferreira
 * @since 1.0
 */
public class RcNegativoException extends MainFrameException {
    private static final String ERRO = "Falha na conexão com o Terminal, RC Negativo.";
    
    public RcNegativoException(){
        super(ERRO);
    }

    public RcNegativoException(Throwable cause){
        super(ERRO, cause);
    }
}
