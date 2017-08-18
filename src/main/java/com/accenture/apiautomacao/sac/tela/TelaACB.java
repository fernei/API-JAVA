package com.accenture.apiautomacao.sac.tela;

//package com.accenture.api.sac.tela;
//
//import com.accenture.apiautomacao.controller.Util;
//import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
//import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
//import com.accenture.apiautomacao.exception.mainframe.TelaNaoAcessadaException;
//import static com.accenture.apiautomacao.logger.LogTrace.log;
//import static com.accenture.sac.controller.Execucao.conexaoSAC;
//import static com.accenture.sac.controller.Execucao.host;
//import com.accenture.sac.model.TelefonesContatoACB;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Classe representando a tela <b>ACB</b>.
// *
// * @author fernando.m.souza
// * @since 1.0.0
// */
//public class TelaACB extends Tela {
//
//    private final String codTela = "CGACB00A";
//    private final String nomeTela = "ACB";
//
//    /*IDENTIFICAÇÃO DO CLIENTE*/
//    private final String comando = "24,6,ACB";
//    private final String posicaoIdentCliLocalidade = "6,24,4";
//    private final String posicaoIdentCliDdd = "6,35,2";
//    private final String posicaoIdentCliCat = "6,42,3";
//
//    private final String posicaoTerminal = "6,13";
//
//    private final String posicaoBD = "4,37,9";
//
//    /* TELEFONES PARA CONTATO - F4 */
//    private final String posicaoTipoResidencial = "14,16,11";
//    private final String posicaoNomeResidencial = "15,22,20";
//    private final String posicaoDddResidencial = "15,48,4";
//    private final String posicaoFoneResidencial = "15,59,9";
//    private final String posicaoRamalResidencial = "15,75,4";
//
//    private final String posicaoTipoComercial = "17,16,11";
//    private final String posicaoNomeComercial = "18,22,20";
//    private final String posicaoDddComercial = "18,48,4";
//    private final String posicaoFoneComercial = "18,59,9";
//    private final String posicaoRamalComercial = "18,75,4";
//
//    private final String posicaoTipoCelular = "20,16,11";
//    private final String posicaoNomeCelular = "21,22,20";
//    private final String posicaoDddCelular = "21,48,4";
//    private final String posicaoFoneCelular = "21,59,9";
//    private final String posicaoRamalCelular = "21,75,4";
//
//    private final String posicaoOrigemBD = "7,51,30";
//    private final String posicaoPostoAtual = "13,7,74";
//    private final String posicaoCMRAtual = "12,7,74";
//
//    private final String posicaoCentral = "9,76,4";
//
//    /* DADOS DE FACILIDADE - F8 */
//    private final String posicaoEstFilaExeUso = "6,50,3";
//    private final String posicaoEstFilaExeCategoria = "6,42,3";
//    private final String posicaoEstFilaExeCliente = "9,11,53";
//    private final String posicaoDadFacPontaA = "7,20,61";
//    private final String posicaoDadFacLocal = "12,2,5";
//    private final String posicaoDadFacEstacao = "12,8,7";
//    private final String posicaoDadFacCabo = "12,16,4";
//    private final String posicaoDadFacParp = "12,22,4";
//    private final String posicaoDadFacAd = "12,27,2";
//    private final String posicaoDadFacAsterisco = "12,30,3";
//    private final String posicaoDadFacPars = "12,34,4";
//    private final String posicaoDadFacCaixa = "12,39,5";
//    private final String posicaoDadFacPtCan = "12,45,6";
//    private final String posicaoDadFacAdslAdsl = "9,60,15";
//    private final String posicaoDadFacAdslEQN = "9,24,19";
//
//    /**
//     * Digita o comando TelaACB na linha do CMD do SAC, efetuando assim a
//     * abertura da tela TelaACB
//     * <p>
//     * Nome Tela.: IDENTIFICACAO DO CLIENTE
//     * <p>
//     * Codigo Tela.: CGACB00A
//     * <p>
//     * Sigla Tela.:A.C.B
//     *
//     * @exception MainFrameException Caso não seja possível chegar a tela
//     * atraves do comando executado.
//     * @since 1.0.0
//     */
//    public void acessa() throws MainFrameException {
//        acessaTela(nomeTela, comando, codTela);
//
//        if (existemCamposPreenchidos()) {
//            acessaTela(nomeTela, comando, codTela);
//
//            if (existemCamposPreenchidos()) {
//                try {
//                    conexaoSAC.logoffAplicacao();
//                    conexaoSAC.conectarSAC();
//                    conexaoSAC.acessaUfNoSAC();
//                    
//                    acessaTela(nomeTela, comando, codTela);
//                } catch (MainFrameException ex) {
//                    throw ex;
//                }
//            }
//        }
//    }
//
//    /**
//     * Informa o terminal a ser consultado na tela.
//     *
//     * @param terminal Terminal a ser consultado.
//     * @param localidade Localidade do terminal a ser consultado.
//     * @throws RcNegativoException Problemas de conexão com o Mainframe
//     * @since 1.0.0
//     */
//    public void setTerminal(String terminal, String localidade) throws RcNegativoException {
//        host.setStringAt(this.posicaoTerminal, terminal);
//        sendEnter();
//        popUpSelecaoDddByLocalidade(localidade);
//        popupGeraisSAC();
//    }
//
//    /**
//     * Informa o terminal a ser consultado na tela.
//     *
//     * @param terminal Terminal a ser consultado.
//     * @param ddd ddd do terminal a ser consultado.
//     * @return Localidade do BD consultado.
//     * @throws RcNegativoException Problemas na comunicação com o Mainframe
//     * @since 1.0.0
//     */
//    public String setTerminalPorDDD(String terminal, String ddd) throws RcNegativoException {
//        String localidade;
//        
//        host.setStringAt(this.posicaoTerminal, terminal);
//        sendEnter();
//        localidade = popUpSelecaoDddByDDD(ddd);
//        popupGeraisSAC();
//        
//        return localidade;
//    }
//
//    /**
//     * Função para abrir a tela de BD dentro da tela ACB.
//     *
//     * @param localidade Localidade do BD a ser verificado.
//     * @throws RcNegativoException Problemas de conexão com o Mainframe
//     */
//    public void verificaBD(String localidade) throws RcNegativoException {
//        sendF5();
//        popUpSelecaoDddByLocalidade(localidade);
//        popupGeraisSAC();
//    }
//
//    /**
//     * Busca todos os telefones de contato do terminal.
//     *
//     * @return Uma lista com todos os telefones de contato do terminal.
//     * @throws RcNegativoException Problemas de conexão com o Mainframe
//     * @since 1.0.0
//     */
//    public List<TelefonesContatoACB> getTelefonesParaContato() throws RcNegativoException {
//
//        List listTelefonesContatos = new ArrayList();
//
//        TelefonesContatoACB residencial = new TelefonesContatoACB();
//        residencial.setTipo(host.getScreenContentAt(posicaoTipoResidencial).trim());
//        residencial.setNome(trataCaracter(host.getScreenContentAt(posicaoNomeResidencial)));
//        residencial.setDdd(trataCaracter(host.getScreenContentAt(posicaoDddResidencial)));
//        residencial.setFone(trataCaracter(host.getScreenContentAt(posicaoFoneResidencial)));
//        residencial.setRamal(trataCaracter(host.getScreenContentAt(posicaoRamalResidencial)));
//
//        if (!residencial.getNome().isEmpty()) {
//            listTelefonesContatos.add(residencial);
//        }
//
//        TelefonesContatoACB comercial = new TelefonesContatoACB();
//        comercial.setTipo(host.getScreenContentAt(posicaoTipoComercial).trim());
//        comercial.setNome(trataCaracter(host.getScreenContentAt(posicaoNomeComercial)));
//        comercial.setDdd(trataCaracter(host.getScreenContentAt(posicaoDddComercial)));
//        comercial.setFone(trataCaracter(host.getScreenContentAt(posicaoFoneComercial)));
//        comercial.setRamal(trataCaracter(host.getScreenContentAt(posicaoRamalComercial)));
//
//        if (!comercial.getNome().isEmpty()) {
//            listTelefonesContatos.add(comercial);
//        }
//
//        TelefonesContatoACB celular = new TelefonesContatoACB();
//        celular.setTipo(host.getScreenContentAt(posicaoTipoCelular).trim());
//        celular.setNome(trataCaracter(host.getScreenContentAt(posicaoNomeCelular)));
//        celular.setDdd(trataCaracter(host.getScreenContentAt(posicaoDddCelular)));
//        celular.setFone(trataCaracter(host.getScreenContentAt(posicaoFoneCelular)));
//        celular.setRamal(trataCaracter(host.getScreenContentAt(posicaoRamalCelular)));
//
//        if (!celular.getNome().isEmpty()) {
//            listTelefonesContatos.add(celular);
//        }
//
//        sendF3();
//
//        return listTelefonesContatos;
//
//    }
//
//    /**
//     * Coleta todos os servicos disponiveis para o terminal.
//     *
//     * @return Uma lista com todos os serviços disponíveis para o terminal.
//     * @throws RcNegativoException Problemas de conexão com o Mainframe
//     * @since 1.0.0
//     */
//    public List getRelacaoServicosDisponiveis() throws RcNegativoException {
//        sendF7();
//
//        List listaRelacaoServicosDisponiveis = new ArrayList();
//
//        int linha = 12;
//        boolean flag = true;
//
//        do {
//
//            if (!"".equals(host.getScreenContentAt(linha, 3, 27).trim())) {
//                listaRelacaoServicosDisponiveis.add(host.getScreenContentAt(linha, 3, 27).trim());
//            }
//
//            if (!"".equals(host.getScreenContentAt(linha, 33, 27).trim())) {
//                listaRelacaoServicosDisponiveis.add(host.getScreenContentAt(linha, 33, 27).trim());
//            }
//
//            if (linha == 15) {
//                sendF8();
//                if ("S1012- PAGINA FINAL".equals(host.getScreenContentAt(1, 2, 19).trim())) {
//                    flag = false;
//                } else {
//                    linha = 11;
//                }
//            }
//
//            linha++;
//
//        } while (flag);
//
//        return listaRelacaoServicosDisponiveis;
//
//    }
//
//    /**
//     * Retorna o valor para o DDD.
//     * <p>
//     * Posição 6 / 35 - 2
//     * <p>
//     * Nome.: IDENTIFICACAO DO CLIENTE
//     * <p>
//     * Codigo.: CGACB00A
//     * <p>
//     * Sigla.:A.C.B
//     *
//     * @return DDD
//     * @since 1.0.0
//     */
//    public String getIdentCliDdd() {
//        return host.getScreenContentAt(posicaoIdentCliDdd).trim();
//    }
//
//    /**
//     * Retorna o valor para a Categoria.
//     * <p>
//     * Posição 6 / 42 - 3
//     * <p>
//     * Nome.: IDENTIFICACAO DO CLIENTE
//     * <p>
//     * Codigo.: CGACB00A
//     * <p>
//     * Sigla.:A.C.B
//     *
//     * @return Categoria
//     * @since 1.0.0
//     */
//    public String getIdentCliCat() {
//        return host.getScreenContentAt(this.posicaoIdentCliCat).trim();
//    }
//
//    /**
//     * Retorna o valor para a Localidade.
//     * <p>
//     * Posição 6 / 24 - 4
//     * <p>
//     * Nome.: IDENTIFICACAO DO CLIENTE
//     * <p>
//     * Codigo.: CGACB00A
//     * <p>
//     * Sigla.:A.C.B
//     *
//     * @return Localidade
//     * @since 1.0.0
//     */
//    public String getIdentCliLocalidade() {
//        return host.getScreenContentAt(this.posicaoIdentCliLocalidade);
//    }
//
//    /**
//     * Retorna o valor para a Origem.
//     * <p>
//     * Posição 7 / 51 - 30
//     * <p>
//     * Nome.: IDENTIFICACAO DO CLIENTE
//     * <p>
//     * Codigo.: CGS1010A
//     * <p>
//     * Sigla.:A.C.B
//     *
//     * @return Origem
//     * @since 1.0.0
//     */
//    public String getIdentCliOrigem() {
//        return host.getScreenContentAt(this.posicaoOrigemBD).trim();
//    }
//
//    /**
//     * Retorna o valor para o posto atual.
//     * <p>
//     * Posição 13 / 7 - 72
//     * <p>
//     * Nome.: IDENTIFICACAO DO CLIENTE
//     * <p>
//     * Codigo.: CGS1010A
//     * <p>
//     * Sigla.:A.C.B
//     *
//     * @return Posto
//     * @since 1.0.0
//     */
//    public String getIdentCliPostoAtual() {
//        String posto = host.getScreenContentAt(this.posicaoPostoAtual).trim();
//        String[] postos = posto.split(" ");
//
//        if (postos.length > 0) {
//            posto = postos[postos.length - 1];
//            return posto;
//        } else {
//            return null;
//        }
//    }
//
//    /**
//     * Retorna o valor para o CMR atual.
//     * <p>
//     * Posição 12 / 7 - 72
//     * <p>
//     * Nome.: IDENTIFICACAO DO CLIENTE
//     * <p>
//     * Codigo.: CGS1010A
//     * <p>
//     * Sigla.:A.C.B
//     *
//     * @return CMR
//     * @since 1.0.0
//     */
//    public String getIdentCliCMRAtual() {
//        String cmr = host.getScreenContentAt(this.posicaoCMRAtual).trim();
//        String[] cmrs = cmr.split(" ");
//
//        if (cmrs.length > 0) {
//            cmr = cmrs[cmrs.length - 1];
//            return cmr;
//        } else {
//            return null;
//        }
//    }
//
//    /**
//     * Retorna o valor para Central.
//     * <p>
//     * Posição 9 / 76 - 4
//     * <p>
//     * Nome.: IDENTIFICACAO DO CLIENTE
//     * <p>
//     * Codigo.: CGS1012A
//     * <p>
//     * Sigla.:A.C.B
//     *
//     * @return Central
//     * @since 1.0.0
//     */
//    public String getIdentCliCentral() {
//        return host.getScreenContentAt(this.posicaoCentral).trim();
//    }
//
//    /**
//     * Retorna o codigo do BD.
//     * <p>
//     * Posição 4 / 37 - 8
//     * <p>
//     * Nome.: IDENTIFICACAO DO CLIENTE
//     * <p>
//     * Codigo.: CGS1012A
//     * <p>
//     * Sigla.:A.C.B
//     *
//     * @return BD
//     * @since 1.0.7
//     */
//    public String getBD() {
//        return Util.removeCaracter(host.getScreenContentAt(this.posicaoBD), " ", "").trim();
//    }
//
//    public boolean isTerminal() throws RcNegativoException {
//        if (host.queryStringAt(2, "ACB00 - TERMINAL INEXISTENTE")) {
//            sendEnter();
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    private boolean existemCamposPreenchidos() {
//        boolean terminalPreenchido = !host.getScreenContentAt(6, 13, 10).replace("_", "").trim().isEmpty();
//        boolean localidadePreenchida = !host.getScreenContentAt(6, 24, 4).replace("_", "").trim().isEmpty();
//        boolean dddPreenchido = !host.getScreenContentAt(6, 33, 4).replace("_", "").trim().isEmpty();
//
//        return terminalPreenchido || localidadePreenchida || dddPreenchido;
//    }
//
//    public String getEstFilaExeUso() {
//        return host.getScreenContentAt(this.posicaoEstFilaExeUso).trim();
//    }
//
//    public String getEstFilaExeCategoria() {
//        return host.getScreenContentAt(this.posicaoEstFilaExeCategoria).trim();
//    }
//
//    public String getEstFilaExeCliente() {
//        return host.getScreenContentAt(this.posicaoEstFilaExeCliente).trim();
//    }
//
//    /**
//     * Valida e executa o F7 que leva até a tela de conexões de rede.
//     *
//     * @throws TelaNaoAcessadaException A aplicação não se encontra na tela
//     * esperada.
//     * @throws RcNegativoException Problemas de conexão com o Mainframe
//     * @since 1.0.0
//     */
//    public void navegaConexoesRede() throws TelaNaoAcessadaException, RcNegativoException {
//        log.debug("Navegando até as conexões de rede do registro");
//
//        validaTelaAtual("CGACB00A");
//
//        sendF8();
//    }
//
//    public String getDadFacPontaA() {
//        return host.getScreenContentAt(this.posicaoDadFacPontaA).trim();
//    }
//
//    public String getDadFacLocal() {
//        return host.getScreenContentAt(this.posicaoDadFacLocal).trim();
//    }
//
//    public String getDadFacEstacao() {
//        return host.getScreenContentAt(this.posicaoDadFacEstacao).trim();
//    }
//
//    public String getDadFacCabo() {
//        return host.getScreenContentAt(this.posicaoDadFacCabo).trim();
//    }
//
//    public String getDadFacParp() {
//        return host.getScreenContentAt(this.posicaoDadFacParp).trim();
//    }
//
//    public String getDadFacAd() {
//        return host.getScreenContentAt(this.posicaoDadFacAd).trim();
//    }
//
//    public String getDadFacAsterisco() {
//        return host.getScreenContentAt(this.posicaoDadFacAsterisco).trim();
//    }
//
//    public String getDadFacPars() {
//        return host.getScreenContentAt(this.posicaoDadFacPars).trim();
//    }
//
//    public String getDadFacCaixa() {
//        return host.getScreenContentAt(this.posicaoDadFacCaixa).trim();
//    }
//
//    public String getDadFacPtCan() {
//        return host.getScreenContentAt(this.posicaoDadFacPtCan).trim();
//    }
//
//    public String getDadFacAdslNroPortaAdsl() {
//        String dslam = host.getScreenContentAt(this.posicaoDadFacAdslAdsl).trim();
//
//        if (dslam.isEmpty()) {
//            return dslam;
//        } else {
//            return dslam.substring(0, dslam.length() - 6);
//        }
//    }
//
//    public String getDadFacAdslPorta() {
//        String dslam = host.getScreenContentAt(this.posicaoDadFacAdslAdsl).trim();
//
//        if (dslam.isEmpty()) {
//            return dslam;
//        } else {
//            return dslam.substring(dslam.length() - 2, dslam.length());
//        }
//    }
//
//    public String getDadFacAdslSlot() {
//        String dslam = host.getScreenContentAt(this.posicaoDadFacAdslAdsl).trim();
//
//        if (dslam.isEmpty()) {
//            return dslam;
//        } else {
//            return dslam.substring(dslam.length() - 5, dslam.length() - 3);
//        }
//    }
//
//    public String getDadFacAdslNroPortaEQN() {
//        return host.getScreenContentAt(this.posicaoDadFacAdslEQN).trim();
//    }
//
//    /**
//     * Valida e executa o F9 que leva até a tela de Infos ADSL.
//     *
//     * @throws TelaNaoAcessadaException A aplicação não se encontra na tela
//     * esperada.
//     * @throws RcNegativoException Problemas de conexão com o Mainframe
//     * @since 1.0.0
//     */
//    public void navegaInfosADSL() throws TelaNaoAcessadaException, RcNegativoException {
//        log.debug("Navegando até as informações de ADSL do registro");
//
//        validaTelaAtual("CGS2799A");
//
//        sendF9();
//    }
//}
