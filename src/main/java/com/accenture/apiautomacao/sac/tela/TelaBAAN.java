package com.accenture.apiautomacao.sac.tela;

//package com.accenture.api.sac.tela;
//
//import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
//import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
//import static com.accenture.sac.controller.Execucao.host;
//
///**
// * Classe representando a tela <b>BAAN</b>.
// *
// * @author otavio.c.ferreira
// * @since 1.0.0
// */
//public class TelaBAAN extends Tela {
//
//    /* Acesso a tela TOTAL DE DOCUMENTOS ABERTOS */
//    private final String nomeTela = "BAAN";
//    private final String comando = "24,6," + nomeTela;
//
//    private final String codTela = "CGBAAN0A";
//
//    private final String posicaoTelefone = "7,24";
//    private final String posicaoCentral = "10,22,4";
//    private final String posicaoTecnologia = "10,27,50";
//
//    /**
//     * Digita o comando <b>BAAN</b> na linha do CMD do SAC, efetuando assim a
//     * abertura da tela <b>BAAN</b>.
//     * <p>
//     * Nome Tela.: ALTERACAO DE NUMERO DE PORTA
//     * <p>
//     * Codigo Tela.: CGBAAN0A
//     * <p>
//     * Sigla Tela.: B.A.A.N
//     *
//     * @exception MainFrameException Caso não seja possível chegar a tela
//     * atraves do comando executado.
//     * @since 1.0.0
//     */
//    public void acessa() throws MainFrameException {
//        acessaTela(nomeTela, comando, codTela);
//    }
//
//    public void setTerminal(String telefone) throws RcNegativoException {
//        host.setStringAt(this.posicaoTelefone, telefone);
//    }
//
//    public String getTerminal() {
//        return host.getScreenContentAt(this.posicaoTelefone + ",8").replace("_", "").trim();
//    }
//
//    public String getCentral() {
//        return host.getScreenContentAt(this.posicaoCentral).trim();
//    }
//
//    public String getTecnologia() {
//        return host.getScreenContentAt(this.posicaoTecnologia).trim();
//    }
//}
