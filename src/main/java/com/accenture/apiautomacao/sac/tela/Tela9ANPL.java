package com.accenture.apiautomacao.sac.tela;

//package com.accenture.api.sac.tela;
//
//import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
//import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
//import static com.accenture.sac.controller.Execucao.host;
//
///**
// * Classe representando a tela <b>9ANPL</b>.
// *
// * @author fernando.m.souza
// * @since 1.0.0
// */
//public class Tela9ANPL extends Tela {
//
//    private static final String NOME_ARQUIVO_PROPERTY = "9ANPL";
//    private static final String SAC_POSICAO_CHAVE = "posicao.chave";
//    private static final String SAC_POSICAO_CODIGO_SITUACAO = "posicao.codigo.situacao";
//    private static final String SAC_POSICAO_FIM_RELATORIO = "posicao.fim.relatorio";
//    private static final String SAC_POSICAO_DSLAM = "posicao.dslam";
//    private static final String SAC_POSICAO_TIPO = "posicao.tipo";
//    private static final String SAC_POSICAO_ATE = "posicao.ate";
//    private static final String SAC_POSICAO_SITUACAO = "posicao.situacao";
//    private static final String SAC_POSICAO_NUMERO_OCORRENCIA = "posicao.numero.ocorrencia";
//    private static final String SAC_POSICAO_INICIO = "posicao.inicio";
//    private static final String SAC_POSICAO_PREVISAO = "posicao.previsao";
//    private static final String SAC_POSICAO_DEFEITO_PRIMEIRA_LINHA = "posicao.defeito.primeira.linha";
//    private static final String SAC_POSICAO_DEFEITO_SEGUNDA_LINHA = "posicao.defeito.segunda.linha";
//    private static final String SAC_POSICAO_CALLCENTER_PRIMEIRA_LINHA = "posicao.infomacao.callcenter.primeira.linha";
//    private static final String SAC_POSICAO_CALLCENTER_SEGUNDA_LINHA = "posicao.infomacao.callcenter.segunda.linha";
//    private static final String SAC_POSICAO_OBSERVACAO_PRIMEIRA_LINHA = "posicao.observacao.primeira.linha";
//    private static final String SAC_POSICAO_OBSERVACAO_SEGUNDA_LINHA = "posicao.observacao.segunda.linha";
//    private static final String SAC_POSICAO_ENDERECO = "posicao.endereco";
//    private static final String SAC_POSICAO_DATA_INICIO = "posicao.data.inicio";
//    private static final String SAC_POSICAO_DATA_PREVISAO = "posicao.data.previsao";
//
//    /**
//     * Digita o comando 9ANPL na linha do CMD do SAC, efetuando assim a abertura
//     * da tela 9ANPL
//     * <p>
//     * Nome Tela.: LISTAGEM OCORRENCIA DE ADSL
//     * <p>
//     * Codigo Tela.: CGS1004A
//     * <p>
//     * Sigla Tela.:9.A.N.P.L
//     *
//     * @exception MainFrameException Caso não seja possível chegar a tela
//     * atraves do comando executado.
//     * @since 1.0.0
//     */
//    public void acessa() throws MainFrameException {
//
//        prop = getProp(NOME_ARQUIVO_PROPERTY);
//        acessaTela(prop.getProperty(SAC_NOME_TELA), prop.getProperty(SAC_CMD), prop.getProperty(SAC_CODIGO_TELA));
//    }
//
//    public void setChave(String chave) throws RcNegativoException {
//        if (chave == null) {
//            sendEnter();
//        } else {
//            host.setStringAt(prop.getProperty(SAC_POSICAO_CHAVE), chave);
//            sendEnter();
//        }
//    }
//
//    /**
//     * Digita o comando 9ANPL na linha do CMD do SAC, efetuando assim a abertura
//     * da tela 9ANPL
//     * <p>
//     * Nome Tela.: LISTAGEM OCORRENCIA DE ADSL
//     * <p>
//     * Codigo Tela.: CG9ANPLA
//     * <p>
//     * Sigla Tela.:9.A.N.P.L
//     * <p>
//     * @param codSituacao 0 - OCORRENCIAS EM ABERTO / 1 - OCORRENCIAS ENCERRADAS
//     *
//     * @since 1.0.0
//     */
//    public void setSituacao(Integer codSituacao) throws RcNegativoException {
//        host.setStringAt(prop.getProperty(SAC_POSICAO_CODIGO_SITUACAO), codSituacao);
//    }
//
//    //TODO: Verificar
//    public Boolean isItem(int linha) {
//
//        boolean flagRetorno;
//        if (host.getScreenContentAt(linha, 2, 2).trim().isEmpty()) {
//            flagRetorno = false;
//        } else {
//            flagRetorno = true;
//        }
//
//        return flagRetorno;
//    }
//
//    public Boolean isFimRelatorio() {
//        return host.queryStringAt(prop.getProperty(SAC_POSICAO_FIM_RELATORIO));
//    }
//
//    public String getDslam() {
//        return host.getScreenContentAt(prop.getProperty(SAC_POSICAO_DSLAM)).trim();
//    }
//
//    public String getTipo() {
//        return host.getScreenContentAt(prop.getProperty(SAC_POSICAO_TIPO)).trim();
//    }
//
//    public String getAte() {
//        return host.getScreenContentAt(prop.getProperty(SAC_POSICAO_ATE)).trim();
//    }
//
//    public String getSituacao() {
//        return host.getScreenContentAt(prop.getProperty(SAC_POSICAO_SITUACAO)).trim();
//    }
//
//    public String getNrOcor() {
//        return host.getScreenContentAt(prop.getProperty(SAC_POSICAO_NUMERO_OCORRENCIA)).trim();
//    }
//
//    public String getInicio() {
//        return host.getScreenContentAt(prop.getProperty(SAC_POSICAO_INICIO)).trim();
//    }
//
//    public String getPrevisao() {
//        return host.getScreenContentAt(prop.getProperty(SAC_POSICAO_PREVISAO)).trim();
//    }
//
//    public String getDefeito() {
//        return host.getScreenContentAt(prop.getProperty(SAC_POSICAO_DEFEITO_PRIMEIRA_LINHA)).trim()
//                + " " + host.getScreenContentAt(prop.getProperty(SAC_POSICAO_DEFEITO_SEGUNDA_LINHA)).trim();
//    }
//
//    public String getInfoCallCenter() {
//        return host.getScreenContentAt(prop.getProperty(SAC_POSICAO_CALLCENTER_PRIMEIRA_LINHA)).trim()
//                + " " + host.getScreenContentAt(prop.getProperty(SAC_POSICAO_CALLCENTER_SEGUNDA_LINHA)).trim();
//    }
//
//    public String getObs() {
//        return host.getScreenContentAt(prop.getProperty(SAC_POSICAO_OBSERVACAO_PRIMEIRA_LINHA)).trim()
//                + " " + host.getScreenContentAt(prop.getProperty(SAC_POSICAO_OBSERVACAO_SEGUNDA_LINHA)).trim();
//    }
//
//    public String getEndereco() {
//        return host.getScreenContentAt(prop.getProperty(SAC_POSICAO_ENDERECO)).trim();
//    }
//
//    public String getDataInicio(int linha) {
//        return host.getScreenContentAt(linha + prop.getProperty(SAC_POSICAO_DATA_INICIO));
//    }
//
//    public String getDataPrevisao(int linha) {
//        return host.getScreenContentAt(linha + prop.getProperty(SAC_POSICAO_DATA_PREVISAO));
//    }
//
//    //Campo pra consulta
//    public String getDslamInicLista(int linha) {
//        String dslam = host.getScreenContentAt(linha, 5, 8);
//
//        return dslam.contains(" ") ? null : dslam;
//    }
//
//    public String getDslamFinalLista(int linha) {
//        String dslam = host.getScreenContentAt(linha, 17, 8);
//
//        return dslam.contains(" ") ? null : dslam;
//    }
//
//    public String getSlotInicLista(int linha) {
//        String slot = host.getScreenContentAt(linha, 13, 3);
//
//        return !slot.contains("-") ? null : slot.replace("-", "");
//    }
//
//    public String getSlotFinalLista(int linha) {
//        String slot = host.getScreenContentAt(linha, 25, 3);
//
//        return !slot.contains("-") ? null : slot.replace("-", "");
//    }
//
//    public String getUf(int linha) {
//        String uf = host.getScreenContentAt(linha, 4, 4);
//
//        return !(uf.charAt(0) == ' ' && uf.charAt(3) == ' ') ? null : uf.trim();
//    }
//
//    public String getDDD(int linha) {
//        String ddd = host.getScreenContentAt(linha, 9, 6);
//
//        return !(ddd.charAt(0) == ' ' && ddd.charAt(5) == ' ') ? null : ddd.trim();
//    }
//
//    public String getDDDF(int linha) {
//        String ddd = host.getScreenContentAt(linha, 14, 6);
//
//        return !(ddd.charAt(0) == ' ' && ddd.charAt(5) == ' ') ? null : ddd.trim();
//    }
//
//    public String getLocalidade(int linha) {
//        String loc = host.getScreenContentAt(linha, 19, 6);
//
//        return !(loc.charAt(0) == ' ' && loc.charAt(5) == ' ') ? null : loc.trim();
//    }
//
//    public String getEstacao(int linha) {
//        String est = host.getScreenContentAt(linha, 24, 6);
//
//        return !(est.charAt(0) == ' ' && est.charAt(5) == ' ') ? null : est.trim();
//    }
//
//    public String getProvedor(int linha) {
//        String prov = host.getScreenContentAt(linha, 29, 6);
//
//        return !(prov.charAt(0) == ' ' && prov.charAt(5) == ' ') ? null : prov.trim();
//    }
//}
