package com.accenture.apiautomacao.sac.tela;

//package com.accenture.api.sac.tela;
//
//import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
//import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
//import com.accenture.apiautomacao.exception.registro.RegistroSemProcessamentoException;
//import static com.accenture.sac.controller.Execucao.host;
//
///**
// * Classe representando a tela <b>BACP</b>.
// *
// * @author otavio.c.ferreira
// * @since 1.0.0
// */
//public class TelaBACP extends Tela {
//
//    /* Acesso a tela TOTAL DE DOCUMENTOS ABERTOS */
//    private final String nomeTela = "BACP";
//    private final String comando = "24,6," + nomeTela;
//
//    private final String codTela = "CGBACP0A";
//
//    private final String posicaoCentral = "5,24";
//    private final String posicaoEstacao = "5,38";
//
//    /**
//     * Digita o comando <b>BACP</b> na linha do CMD do SAC, efetuando assim a
//     * abertura da tela <b>BACP</b>.
//     * <p>
//     * Nome Tela.: CONSULTA PREFIXOS E FAIXA NUMERACAO
//     * <p>
//     * Codigo Tela.: CGBACP0A
//     * <p>
//     * Sigla Tela.: B.A.C.P
//     *
//     * @exception MainFrameException Caso não seja possível chegar a tela
//     * atraves do comando executado.
//     * @since 1.0.0
//     */
//    public void acessa() throws MainFrameException {
//        acessaTela(nomeTela, comando, codTela);
//    }
//
//    public void setCentral(String central) throws RcNegativoException {
//        host.setStringAt(this.posicaoCentral, central);
//    }
//
//    public void setEstacao(String estacao) throws RcNegativoException {
//        host.setStringAt(this.posicaoEstacao, estacao);
//    }
//
//    public String getOrigem() {
//        StringBuilder origem = new StringBuilder();
//        
//        origem.append(host.getScreenContentAt(14, 10, 12).trim());
//        origem.append(" | ");
//        origem.append(host.getScreenContentAt(14, 23, 12).trim());
//        origem.append(" | ");
//        origem.append(host.getScreenContentAt(15, 10, 12).trim());
//        origem.append(" | ");
//        origem.append(host.getScreenContentAt(15, 23, 12).trim());
//        
//        return origem.toString();
//    }
//
//    public void selecionaPrimeiroResultado() throws RcNegativoException, RegistroSemProcessamentoException {
//        if (!host.getScreenContentAt(9, 3, 50).trim().isEmpty()) {
//            host.setStringAt(9, 3, "X");
//            sendEnter();
//            popupGeraisSAC();
//        } else {
//            throw new RegistroSemProcessamentoException();
//        }
//    }
//}
