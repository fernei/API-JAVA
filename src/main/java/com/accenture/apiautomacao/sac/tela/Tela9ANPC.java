package com.accenture.apiautomacao.sac.tela;

//package com.accenture.api.sac.tela;
//
//import com.accenture.apiautomacao.controller.Util;
//import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
//import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
//import static com.accenture.sac.controller.Execucao.host;
//
///**
// * Classe representando a tela <b>9ANPC</b>.
// *
// * @author fernando.m.souza
// * @since 1.0.0
// */
//public class Tela9ANPC extends Tela {
//
//    /* Acesso a tela */
//    private final String nomeTela = "9ANPC";
//    private final String codTela = "CG9ANPCA";
//
//    /*CONSULTA OCORRENCIA DE ADSL*/
//    private final String comando = "24,6,9ANPC";
//
//    private final String posicaoDslam = "6,11,12";
//    private final String posicaoAte = "6,28,12";
//    private final String posicaoTipo = "7,11,8";
//    private final String posicaoSituacao = "7,38,13";
//    private final String posicaoNrOcor = "5,71,9";
//    private final String posicaoInicio = "8,11,15";
//    private final String posicaoPrevisao = "8,38,15";
//    private final String posicaoDefeito = "11,25,60";
//    private final String posicaoDefeito2 = "12,25,60";
//    private final String posicaoInfoCallCenter = "14,25,60";
//    private final String posicaoInfoCallCenter2 = "15,25,60";
//    private final String posicaoObs = "19,25,60";
//    private final String posicaoObs2 = "20,25,60";
//    private final String posicaoLocalidade = "5,57,4";
//    private final String posicaoResponsavel = "18,15,8";
//    private static final String posicaoEndereco = "17,25,60";
//    private static final String posicaoEstacao = "5,11,4";   
//    
//    private final String posicaoDataInicio = "8,11,15";
//    private final String posicaoDataPrevisao = "8,38,15";
//
//    /**
//     * Digita o comando 9ANPC na linha do CMD do SAC, efetuando assim a abertura
//     * da tela 9ANPC
//     * <p>
//     * Nome Tela.: CONSULTA OCORRENCIA DE ADSL
//     * <p>
//     * Codigo Tela.: CG9ANPCA
//     * <p>
//     * Sigla Tela.:9.A.N.P.C
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
//     * Pega o DSLAM
//     *
//     * @return Uma String com o DSLAM
//     * @since 1.0.0
//     */
//    public String getDslam() {
//        return host.getScreenContentAt(posicaoDslam).trim();
//    }
//
//    /**
//     * Pega o Tipo
//     *
//     * @return Uma String com o Tipo
//     * @since 1.0.0
//     */
//    public String getTipo() {
//        return host.getScreenContentAt(posicaoTipo).trim();
//    }
//
//    /**
//     * Pega o ATE
//     *
//     * @return Uma String com o ATE
//     * @since 1.0.0
//     */
//    public String getAte() {
//        return host.getScreenContentAt(posicaoAte).trim();
//    }
//
//    /**
//     * Pega a Situação
//     *
//     * @return Uma String com a Situação
//     * @since 1.0.0
//     */
//    public String getSituacao() {
//        return host.getScreenContentAt(posicaoSituacao).trim();
//    }
//
//    /**
//     * Pega o Numero da Ocorrência
//     *
//     * @return Uma String com o Numero da Ocorrência
//     * @since 1.0.0
//     */
//    public String getNrOcor() {
//        return host.getScreenContentAt(posicaoNrOcor).trim();
//    }
//
//    /**
//     * Pega o Início
//     *
//     * @return Uma String com o Início
//     * @since 1.0.0
//     */
//    public String getInicio() {
//        return host.getScreenContentAt(posicaoInicio).trim();
//    }
//
//    /**
//     * Pega a Previsão
//     *
//     * @return Uma String com a Previsão
//     * @since 1.0.0
//     */
//    public String getPrevisao() {
//        return host.getScreenContentAt(posicaoPrevisao).trim();
//    }
//
//    /**
//     * Pega o Defeito
//     *
//     * @return Uma String com o Defeito
//     * @since 1.0.0
//     */
//    public String getDefeito() {
//        return host.getScreenContentAt(posicaoDefeito).trim()
//                + host.getScreenContentAt(posicaoDefeito2).trim();
//    }
//
//    /**
//     * Pega a Info Call Center
//     *
//     * @return Uma String com a Info Call Center
//     * @since 1.0.0
//     */
//    public String getInfoCallCenter() {
//        return host.getScreenContentAt(posicaoInfoCallCenter).trim()
//                 + host.getScreenContentAt(posicaoInfoCallCenter2).trim();
//    }
//
//    /**
//     * Pega a Observação
//     *
//     * @return Uma String com a Observação
//     * @since 1.0.0
//     */
//    public String getObs() {
//        return host.getScreenContentAt(posicaoObs).trim()
//                 + host.getScreenContentAt(posicaoObs2).trim();
//    }
//
//    /**
//     * Pega a localidade do registro
//     *
//     * @return Uma String com a Localidade
//     * @since 1.0.0
//     */
//    public String getLocalidade() {
//        return host.getScreenContentAt(posicaoLocalidade).trim();
//    }
//
//    /**
//     * Pega o Responsavel
//     *
//     * @return Uma string com a matrícula do Responsável
//     * @since 1.0.0
//     */
//    public String getResponsavel() {
//        return host.getScreenContentAt(posicaoResponsavel).trim();
//    }
//
//    /**
//     * Pega o Endereço.
//     *
//     * @return Uma string com Endereço
//     * @since 1.0.1
//     */
//    public String getEndereco() {
//        return host.getScreenContentAt(posicaoEndereco).trim();
//    }
//
//    /**
//     * Pega a Estação
//     *
//     * @return Uma string com a Estação
//     * @since 1.0.1
//     */
//    public String getEstacao() {
//        return Util.removeCaracter(host.getScreenContentAt(posicaoEstacao), "_", "").trim();
//    }
//    
//    public boolean compararDatasDoMassivo(String dataInicio, String dataPrevisao) {
//        return host.getScreenContentAt(posicaoDataInicio).equals(dataInicio)
//                && host.getScreenContentAt(posicaoDataPrevisao).equals(dataPrevisao);
//    }
//    
//    public boolean contemResultado() {
//        return !host.getScreenContentAt(posicaoDataInicio).split("-")[0].trim().isEmpty();
//    }
//    
//    /* Campos de Pesquisa */
//    public void setUf(String valor) throws RcNegativoException {
//        host.setStringAt(5, 21, valor);
//    }
//    
//    public void setDslamInic(String valor) throws RcNegativoException {
//        host.setStringAt(6, 11, valor);
//    }
//
//    public void setDslamFinal(String valor) throws RcNegativoException {
//        host.setStringAt(6, 28, valor);
//    }
//    
//    public void setDDDInicial(String valor) throws RcNegativoException {
//        host.setStringAt(5, 29, valor);
//    }
//    
//    public void setDDDFinal(String valor) throws RcNegativoException {
//        host.setStringAt(5, 39, valor);
//    }
//
//    public void setLocalidade(String valor) throws RcNegativoException {
//        host.setStringAt(5, 57, valor);
//    }
//    
//    public void setEstacao(String valor) throws RcNegativoException {
//        host.setStringAt(5, 11, valor);
//    }
//
//    public void setProvedor(String valor) throws RcNegativoException {
//        host.setStringAt(6, 54, valor);
//    }
//}
