package com.accenture.apiautomacao.sac.tela;

//package com.accenture.api.sac.tela;
//
//import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
//import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
//import static com.accenture.sac.controller.Execucao.host;
//
///**
// * Classe representando a tela <b>IL</b>.
// *
// * @author otavio.c.ferreira
// * @since 1.0.0
// */
//public class TelaIL extends Tela {
//
//    private final String comando = "24,6,IL";
//    private final String nomeTela = "IL";
//    private final String codTela = "CGIL000A";
//
//    private final String posicaoTipoDocumento = "14,24";
//    private final String posicaoLocalidade = "18,24";
//    private final String posicaoTelefone = "18,41";
//    private final String posicaoDocumento = "18,63";
//    private final String posicaoUnidade = "16,40";
//    private final String posicaoFilaCR = "16,24";
//    private final String posicaoOsBd = "19,26";
//
//    private final String posicaoMatrTecnico = "8,20";
//    private final String posicaoCodEncerramento = "9,20";
//
//    /**
//     * Digita o comando IL na linha do CMD do SAC, efetuando assim a abertura da
//     * tela Movimentacao Fila SAC-SGE - CGIL000A
//     * <p>
//     * Nome Tela.: MOVIMENTACAO FILA SAC-SGE
//     * <p>
//     * Codigo Tela.: CGIL000A
//     * <p>
//     * Sigla Tela.:I.L
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
//    public void setUnidade(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoUnidade, valor);
//    }
//
//    public void setFilaCR(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoFilaCR, valor);
//    }
//
//    public void setOsBd(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoOsBd, valor);
//    }
//
//    public void setMatrTecnico(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoMatrTecnico, valor);
//    }
//
//    public void setCodEncerramento(String valor) throws RcNegativoException {
//        host.setStringAt(posicaoCodEncerramento, valor);
//    }
//
//    public void selecionaManualParaAutomatico() throws RcNegativoException {
//        if (host.queryStringAt(12, "PARA AUTOMATICO")) {
//            host.setStringAt(10, 6, "X");
//            sendF5();
//        }
//    }
//
//    public void selecionaAutomaticoParaManual() throws RcNegativoException {
//        if (host.queryStringAt(12, "PARA MANUAL")) {
//            host.setStringAt(11, 6, "X");
//            sendF5();
//        }
//    }
//
//    public void selecionaOpcao(String opcao) throws RcNegativoException {
//        int linha = 10;
//
//        do {
//            if (host.queryStringAt(linha, 12, opcao)) {
//                host.setStringAt(linha, 6, "X");
//                sendEnter();
//
//                return;
//            }
//
//            linha++;
//        } while (linha <= 16);
//    }
//
//    public void confirmaOpcao() throws RcNegativoException {
//        if (host.queryStringAt(20, "CONFIRMA OPCAO")) {
//            host.setStringAt(20, 37, "S");
//            sendEnter();
//        }
//    }
//
//}
