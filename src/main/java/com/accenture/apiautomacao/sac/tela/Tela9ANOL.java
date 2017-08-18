package com.accenture.apiautomacao.sac.tela;

//package com.accenture.api.sac.tela;
//
//import com.accenture.apiautomacao.controller.Util;
//import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
//import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
//import static com.accenture.sac.controller.Execucao.host;
//import static com.accenture.sac.controller.Execucao.mainFrame;
//
///**
// * Classe representando a tela <b>9ANOL</b>.
// *
// * @author fernando.m.souza
// * @since 1.0.0
// */
//public class Tela9ANOL extends Tela {
//
//    private final String nomeTela = "9ANOL";
//    private final String codTela = "CGS1004A";
//
//    /*LISTAGEM OCORRENCIA DE CR - CME - CPA*/
//    private final String posicaoCodTela = "4,71,8";
//    private final String comando = "24,6,9ANOL";
//    private final String posicaoCodSituacao = "6,28";
//
//    /*CG9ANOLL*/
//    private final String posicaoItem = "23,8";
//    private static final String posicaoFimRelatorio = "21,16,F I M  D E  R E L A T O R I O  T E C L E  <E N T E R>";
//
//    /*CG9ANOLB - LISTAGEM OCORRENCIA DE CR - CME - CPA*/
//    private final String posicaoUf = "6,6,2";
//    private final String posicaoDddInicial = "7,15,4";
//    private final String posicaoDddFinal = "7,33,4";
//    private final String posicaoCentral = "8,12,4";
//    private final String posicaoModuloProcessador = "8,37,6";
//    private final String posicaoEstacao = "9,12,4";
//    private final String posicaoPrefixoCaboSecaoServico = "9,45,4";
//    private final String posicaoMilharContagem = "9,67,13";
//    private final String posicaoTipo = "10,8,20";
//    private final String posicaoNrOcor = "10,71,9";
//    private final String posicaoDataInicio = "11,10,15";
//    private final String posicaoDataPrevisao = "11,38,15";
//    private final String posicaoDataTermino = "11,65,15";
//    private final String posicaoDefeito = "13,25,50";
//    private final String posicaoDefeito2 = "14,25,50";
//    private final String posicaoInfoCallCenter = "15,25,50";
//    private final String posicaoInfoCallCenter2 = "16,25,50";
//
//    private final String posicaoMatriculaResponsavel = "18,15,8";
//    private final String posicaoEndereco = "17,25,50";
//    private final String posicaoObs = "19,25,60";
//    private final String posicaoObs2 = "20,25,60";
//
//    /**
//     * Digita o comando <b>9ANOL</b> na linha do CMD do SAC, efetuando assim a
//     * abertura da tela <b>9ANOL</b>.
//     * <p>
//     * Nome Tela.: LISTAGEM OCORRENCIA DE CR - CME - CPA
//     * <p>
//     * Codigo Tela.: CGS1004A
//     * <p>
//     * Sigla Tela.:9.A.N.O.L
//     *
//     * @exception MainFrameException Caso não seja possível chegar a tela
//     * atraves do comando executado.
//     * @since 1.0.0
//     */
//    public void acessa() throws MainFrameException {
//        acessaTela(nomeTela, comando, codTela);
//    }
//
//    /**
//     * Define a chave a ser consultada, caso queira todas enviar <b>null</b> por
//     * parametro.
//     *
//     * @param chave Chave a ser consultada, null para todas.
//     * @since 1.0.0
//     */
//    public void setChave(String chave) throws RcNegativoException {
//        if (chave == null) {
//            sendEnter();
//        } else {
//            host.setStringAt(14, 19, chave);
//            sendEnter();
//        }
//    }
//
//    /**
//     * Digita o comando 9ANOL na linha do CMD do SAC, efetuando assim a abertura
//     * da tela 9ANOL
//     * <p>
//     * Nome Tela.: LISTAGEM OCORRENCIA DE CR - CME - CPA
//     * <p>
//     * Codigo Tela.: CG9ANOLA
//     * <p>
//     * Sigla Tela.:9.A.N.O.L
//     * <p>
//     * @param codSituacao 0 - OCORRENCIAS EM ABERTO / 1 - OCORRENCIAS ENCERRADAS
//     *
//     * @since 1.0.0
//     */
//    public void setSituacao(Integer codSituacao) throws RcNegativoException {
//        host.setStringAt(this.posicaoCodSituacao, codSituacao);
//    }
//
//    /**
//     *
//     * @param linha
//     * @param codItem
//     */
//    public void setItem(Integer codItem) throws RcNegativoException {
//        if ("CG9ANOLL".equals(host.getScreenContentAt(this.posicaoCodTela).trim())) {
//            if (codItem.toString().length() == 1) {
//                host.setStringAt(this.posicaoItem, String.format("%02d", codItem));
//            } else {
//                host.setStringAt(this.posicaoItem, codItem.toString());
//            }
//
//            host.sendEnterKeyWait(mainFrame.getTimeout());
//        }
//    }
//
//    /**
//     *
//     * @param linha
//     * @return
//     */
//    public Boolean isItem(int linha) {
//
//        boolean flagRetorno;
//        if (host.getScreenContentAt(linha, 3, 2).trim().isEmpty()) {
//            flagRetorno = false;
//        } else {
//            flagRetorno = true;
//        }
//
//        return flagRetorno;
//    }
//
//    /**
//     *
//     * @return
//     */
//    public Boolean isFimRelatorio() {
//        return host.queryStringAt(Tela9ANOL.posicaoFimRelatorio);
//    }
//
//    /*CG9ANOLB*/
//    /**
//     *
//     * @return
//     */
//    public String getUf() {
//        String uf = Util.removeCaracter(host.getScreenContentAt(this.posicaoUf), "_", "");
//        if (uf.equals("")) {
//            return null;
//        } else {
//            return uf;
//        }
//    }
//
//    public String getDddInicial() {
//        return Util.removeCaracter(host.getScreenContentAt(this.posicaoDddInicial), "_", "");
//    }
//
//    public String getDddFinal() {
//        return Util.removeCaracter(host.getScreenContentAt(this.posicaoDddFinal), "_", "");
//    }
//
//    public String getCentral() {
//        return Util.removeCaracter(host.getScreenContentAt(this.posicaoCentral), "_", "");
//    }
//
//    public String getModuloProcessador() {
//        return Util.removeCaracter(host.getScreenContentAt(this.posicaoModuloProcessador), "_", "");
//    }
//
//    public String getEstacao() {
//        return Util.removeCaracter(host.getScreenContentAt(this.posicaoEstacao), "_", "");
//    }
//
//    public String getPrefixoCaboSecaoServico() {
//        return Util.removeCaracter(host.getScreenContentAt(this.posicaoPrefixoCaboSecaoServico), "_", "").trim();
//    }
//
//    public String getMilharContagem() {
//        String milharContagem = host.getScreenContentAt(this.posicaoMilharContagem).trim();
//        if (milharContagem.equals("____  A  ____")) {
//            return null;
//        } else {
//            return milharContagem;
//        }
//    }
//
//    public String getTipo() {
//        return host.getScreenContentAt(this.posicaoTipo).trim();
//    }
//
//    public String getNrOcor() {
//        return host.getScreenContentAt(this.posicaoNrOcor);
//    }
//
//    public String getInicio() {
//        return host.getScreenContentAt(this.posicaoDataInicio);
//    }
//
//    public String getPrevisao() {
//        return host.getScreenContentAt(this.posicaoDataPrevisao);
//    }
//
//    public String getTermino() {
//        return host.getScreenContentAt(this.posicaoDataTermino);
//    }
//
//    public String getDefeito() {
//        return Util.removeCaracter(host.getScreenContentAt(this.posicaoDefeito).trim()
//                + " " + host.getScreenContentAt(this.posicaoDefeito2).trim(), "_", "");
//    }
//
//    public String getInfoCallCenter() {
//        return Util.removeCaracter(host.getScreenContentAt(this.posicaoInfoCallCenter)
//                + " " + host.getScreenContentAt(this.posicaoInfoCallCenter2).trim(), "_", "");
//    }
//
//    public String getMatriculaResponsalve() {
//        return Util.removeCaracter(host.getScreenContentAt(this.posicaoMatriculaResponsavel).trim(), "_", "").trim();
//    }
//
//    public String getEndereco() {
//        return Util.removeCaracter(host.getScreenContentAt(this.posicaoEndereco).trim(), "_", "").trim();
//    }
//
//    public String getObs() {
//        return host.getScreenContentAt(posicaoObs).trim()
//                + " " + host.getScreenContentAt(posicaoObs2).trim();
//    }
//
//}
