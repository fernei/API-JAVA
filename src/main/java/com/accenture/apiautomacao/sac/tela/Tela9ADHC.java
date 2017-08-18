package com.accenture.apiautomacao.sac.tela;

//package com.accenture.api.sac.tela;
//
//import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
//import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
//import static com.accenture.sac.controller.Execucao.host;
//
///**
// * Classe representando a tela <b>9ADHC</b>.
// *
// * @author otavio.c.ferreira
// * @since 1.0.0
// */
//public class Tela9ADHC extends Tela {
//
//    /* Acesso a tela TOTAL DE DOCUMENTOS ABERTOS */
//    private final String nomeTela = "9ADHC";
//    private final String comando = "24,6," + nomeTela;
//
//    private final String codTela = "CG9ADHC";
//
//    private final String posicaoCodigo = "11,44";
//    private final String posicaoRota = "19,10,10";
//
//    /**
//     * Digita o comando <b>9ADHC</b> na linha do CMD do SAC, efetuando assim a
//     * abertura da tela <b>9ADHC</b>.
//     * <p>
//     * Nome Tela.: CONSULTA DE CENTRAIS LIBERADAS PARA O MASC
//     * <p>
//     * Codigo Tela.: CGBAAN0A
//     * <p>
//     * Sigla Tela.: 9.A.D.H.C
//     *
//     * @exception MainFrameException Caso não seja possível chegar a tela
//     * atraves do comando executado.
//     * @since 1.0.0
//     */
//    public void acessa() throws MainFrameException {
//        acessaTela(nomeTela, comando, codTela);
//    }
//
//    public void setCodigo(String codigo) throws RcNegativoException {
//        host.setStringAt(this.posicaoCodigo, codigo);
//        sendEnter();
//        popupGeraisSAC();
//    }
//
//    public String getRota() {
//        return host.getScreenContentAt(this.posicaoRota).trim();
//    }
//}
