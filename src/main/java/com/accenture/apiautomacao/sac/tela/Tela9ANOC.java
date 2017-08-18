package com.accenture.apiautomacao.sac.tela;

//package com.accenture.api.sac.tela;
//
//import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
//import com.accenture.apiautomacao.exception.mainframe.TelaNaoAcessadaException;
//import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
//import static com.accenture.sac.controller.Execucao.host;
//import static com.accenture.sac.controller.Execucao.mainFrame;
//
///**
// * Classe representando a tela <b>9ANOC</b>.
// *
// * @author fernando.m.souza
// * @since 1.0.0
// */
//public class Tela9ANOC extends Tela {
//
//    protected final String nomeTela = "9ANOC";
//    protected final String codTela = "CG9ANOCA";
//
//    /* CONSULTA  OCORRENCIA DE CR - CME - CPA */
//    protected static final String posicaoCodTela = "4,71,8";
//    protected static final String comando = "24,6,9ANOC";
//
//    /*CG9ANOCA*/
//    protected static final String posicaoUf = "6,6,2";
//    protected static final String posicaoDddInicial = "7,15,4";
//    protected static final String posicaoDddFinal = "7,33,4";
//    protected static final String posicaoCentral = "8,11,4";
//    protected static final String posicaoModuloEstacao = "8,35,6";
//    protected static final String posicaoEstacao = "9,12,4";
//    protected static final String posicaoPrefixoCaboSecaoServico = "9,45,4";
//    protected static final String posicaoMilharContagem = "9,67,13";
//    protected static final String posicaoTipo = "10,8,13";
//    protected static final String posicaoNrOcor = "10,71,9";
//    protected static final String posicaoInicio = "11,10,15";
//    protected static final String posicaoPrevisao = "11,38,15";
//    protected static final String posicaoTermino = "11,65,15";
//    protected static final String posicaoDefeito = "14,20,50";
//    protected static final String posicaoDefeito2 = "15,20,50";
//    protected static final String posicaoInfoCallCenter = "16,20,50";
//    protected static final String posicaoInfoCallCenter2 = "17,20,50";
//
//
//    /**
//     * Digita o comando <b>9ANOC</b> na linha do CMD do SAC, efetuando assim a
//     * abertura da tela <b>9ANOC</b>.
//     * <p>
//     * Nome Tela.: CONSULTA OCORRENCIA DE CR - CME - CPA
//     * <p>
//     * Codigo Tela.: CGS1004A
//     * <p>
//     * Sigla Tela.:9.A.N.O.C
//     *
//     * @exception MainFrameException Caso não seja possível chegar a tela
//     * atraves do comando executado.
//     * @since 1.0.0
//     */
//    public void acessa() throws MainFrameException {
//        acessaTela(nomeTela, comando, codTela);
//    }
//
//    protected void setCentral(String valor) throws RcNegativoException {
//        host.setStringAt(8, 11, valor);
//        host.sendEnterKeyWait(mainFrame.getTimeout());
//    }
//
//    public String getUf() {
//        return host.getScreenContentAt(this.posicaoUf);
//    }
//
//    public String getDddInicial() {
//        return host.getScreenContentAt(this.posicaoDddInicial);
//    }
//
//    public String getDddFinal() {
//        return host.getScreenContentAt(this.posicaoDddFinal);
//    }
//
//    public String getCentral() {
//        return host.getScreenContentAt(this.posicaoCentral);
//    }
//
//    public String getModuloEstacao() {
//        return host.getScreenContentAt(this.posicaoModuloEstacao);
//    }
//
//    public String getEstacao() {
//        return host.getScreenContentAt(this.posicaoEstacao).replace("_", "");
//    }
//
//    public String getPrefixoCaboSecaoServico() {
//        return host.getScreenContentAt(this.posicaoPrefixoCaboSecaoServico).replace("_", "");
//    }
//
//    public String getMilharContagem() {
//        return host.getScreenContentAt(this.posicaoMilharContagem);
//    }
//
//    public String getTipo() {
//        return host.getScreenContentAt(this.posicaoTipo);
//    }
//
//    public String getNrOcor() {
//        return host.getScreenContentAt(this.posicaoNrOcor);
//    }
//
//    public String getInicio() {
//        return host.getScreenContentAt(this.posicaoInicio);
//    }
//
//    public String getPrevisao() {
//        return host.getScreenContentAt(this.posicaoPrevisao);
//    }
//
//    public String getTermino() {
//        return host.getScreenContentAt(this.posicaoTermino);
//    }
//
//    public String getDefeito() {
//        return host.getScreenContentAt(this.posicaoDefeito).trim() + " " + host.getScreenContentAt(this.posicaoDefeito2).trim();
//    }
//
//    public String getInfoCallCenter() {
//        return host.getScreenContentAt(this.posicaoInfoCallCenter) + " " + host.getScreenContentAt(this.posicaoInfoCallCenter2).trim();
//    }
//
//}
