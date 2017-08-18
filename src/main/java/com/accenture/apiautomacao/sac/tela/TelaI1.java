package com.accenture.apiautomacao.sac.tela;

//package com.accenture.api.sac.tela;
//
//import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
//import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
//import static com.accenture.sac.controller.Execucao.host;
//
///**
// * Classe representando a tela <b>I1</b>.
// *
// * @author otavio.c.ferreira
// * @since 1.0.0
// */
//public class TelaI1 extends Tela {
//
//    private final String comando = "24,6,I1";
//    private final String nomeTela = "I1";
//    private final String codTela = "CGI1000A";
//
//    private final String posicaoTipoDocumento = "8,22";
//    private final String posicaoLocalidade = "10,15";
//    private final String posicaoTelefone = "10,31";
//    private final String posicaoDocumento = "12,14";
//    private final String posicaoBa = "12,28";
//    private final String posicaoObs = "14,9";
//    private final String posicaoIrla = "16,9";
//    private final String posicaoNroSerie = "15,32";
//
//    /**
//     * Digita o comando I1 na linha do CMD do SAC, efetuando assim a abertura da
//     * tela Movimentacao Fila SAC-CLICK - CGI1000A
//     * <p>
//     * Nome Tela.: MOVIMENTACAO FILA SAC-CLICK
//     * <p>
//     * Codigo Tela.: CGI1000A
//     * <p>
//     * Sigla Tela.:I.1
//     *
//     * @exception MainFrameException Caso não seja possível chegar a tela
//     * atraves do comando executado.
//     * @since 1.0.0
//     */
//    public void acessa() throws MainFrameException {
//        acessaTela(nomeTela, comando, codTela);
//    }
//
//    public void setTipoDocumento(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoTipoDocumento, valor);
//    }
//
//    public void setLocalidade(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoLocalidade, valor);
//    }
//
//    public void setTelefone(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoTelefone, valor);
//    }
//
//    public void setDocumento(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoDocumento, valor);
//    }
//
//    public void setBa(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoBa, valor);
//    }
//
//    public void setNroSerie(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoNroSerie, valor);
//    }
//    
//    public void confirmaTrocaModemADSL() throws RcNegativoException {
//        host.setStringAt(21, 60, "V");
//        sendF4();
//    }
//
//    public void setObs(String valor) throws RcNegativoException {
//        if (valor.length() > 50) {
//            host.setStringAt(posicaoObs, valor.substring(0, 49));
//        } else {
//            host.setStringAt(posicaoObs, valor);
//        }
//    }
//
//    public void setIrla(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoIrla, valor);
//    }
//    
//    public void confirmaEncerramentoBa() throws RcNegativoException {
//        if (host.queryStringAt(13, "CONFIRMA ENCERRAMENTO DO BA")) {
//            host.setStringAt(13, 52, "S");
//            sendEnter();
//        }
//    }
//    
//}
