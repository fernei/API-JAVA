package com.accenture.apiautomacao.sac.tela;

//package com.accenture.api.sac.tela;
//
//import com.accenture.apiautomacao.exception.bloco.BlocoParametroIncorreto;
//import com.accenture.apiautomacao.exception.empreiteira.EmpreiteiraNaoEncontradaException;
//import com.accenture.apiautomacao.exception.empreiteira.EmpreiteiraSemReparosException;
//import com.accenture.apiautomacao.exception.fila.FilaNaoEncontradaException;
//import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
//import com.accenture.apiautomacao.exception.mainframe.TelaNaoAcessadaException;
//import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
//import com.accenture.apiautomacao.exception.registro.RegistroNaoEncontradoException;
//import static com.accenture.apiautomacao.logger.LogTrace.log;
//import static com.accenture.sac.controller.Execucao.host;
//
///**
// * Classe representando a tela <b>IG</b>.
// *
// * @author fernando.m.souza
// * @since 1.0.0
// */
//public class TelaIG extends Tela {
//
//    /* Acesso a tela TOTAL DE DOCUMENTOS ABERTOS */
//    private final String nomeTela = "IG";
//    private final String comando = "24,6,IG";
//    private final String empreiteira = "14,39,x";
//
//    private final String codTela = "CGIG000A";
//
//    /* ESTATISTICA DA FILA DE EXECUCAO OS/BD - CGIG001B */
//    private final String estFilExeReparos = "18,39,x";
//
//    /* ESTATISTICA DA FILA DE EXECUCAO OS/BD - CGS0371A*/
//    private final String posicaoEstFilaExeNumBD = "4,40,8";
//    private final String posicaoEstFilaExeLocalidade = "5,22,4";
//    private final String posicaoEstFilaExeTerminal = "5,27,8";
//    private final String posicaoEstFilaExeDataHoraSolicitacao = "9,24,13";
//    private final String posicaoEstFilaExeDataHoraPromessa = "10,24,13";
//    private final String posicaoEstFilaExeOrigem = "13,9,10";
//    private final String posicaoEstFilaExeReparoSolicitado = "14,20,17";
//    private final String posicaoEstFilaExeEmpreiteira = "19,51,4";
//    private final String posicaoEstFilaExeCategoria = "7,12,2";
//    private final String posicaoEstFilaExeUso = "7,19,3";
//    private final String posicaoEstFilaExeCliente = "6,10,53";
//    private final String posicaoEstFilaExeClasse = "12,9,20";
//
//    /*PopUp Inicia Tela */
//    public final String observacaoAssinante = "13,55,x";
//
//    /*DADOS DE FACILIDADE - CGS2799A*/
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
//
//    /*DADOS DE FACILIDADES PORTA ADSL - CGS1155A*/
//    private final String posicaoDadFacAdslAdsl = "9,60,15";
//    private final String posicaoDadFacAdslEQN = "9,24,19";
//
//    /**
//     * Digita o comando <b>IG</b> na linha do CMD do SAC, efetuando assim a
//     * abertura da tela <b>IG</b>.
//     * <p>
//     * Nome Tela.: ESTATISTICA DA FILA DE EXECUCAO OS/BD
//     * <p>
//     * Codigo Tela.: CGS1310B
//     * <p>
//     * Sigla Tela.: I.G
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
//     * Seleciona a opção de listar por Empreiteiras
//     *
//     * @throws TelaNaoAcessadaException A aplicação não se encontra na tela
//     * esperada.
//     * @since 1.0.0
//     */
//    public void selecionaEmpreiteira() throws TelaNaoAcessadaException, RcNegativoException {
//        log.debug("Selecionando a opção de Empreiteiras");
//
//        validaTelaAtual("CGIG000A");
//
//        host.setStringAt(this.empreiteira);
//        sendEnter();
//    }
//
//    /**
//     * Seleciona uma empreiteira da lista.
//     *
//     * @param linha Linha na qual a empreiteira se encontra.
//     * @throws TelaNaoAcessadaException A aplicação não se encontra na tela
//     * esperada.
//     * @throws EmpreiteiraNaoEncontradaException Não existe empreiteira na linha
//     * informada.
//     * @since 1.0.0
//     */
//    public void selecDetEmpreiteira(int linha) throws EmpreiteiraNaoEncontradaException, TelaNaoAcessadaException, RcNegativoException {
//        log.debug("Selecionando uma Empreiteiras na linha " + linha);
//
//        validaTelaAtual("CGIG001A");
//
//        if (linha < 20 && !host.getScreenContentAt(linha, 33, 4).trim().isEmpty()) {
//            host.setStringAt(linha, 24, "X");
//            sendEnter();
//        } else {
//            sendF8();
//
//            if (!host.queryStringAt(1, "FINAL PAGINA")) {
//                host.setStringAt(7, 24, "X");
//                sendEnter();
//            } else {
//                throw new EmpreiteiraNaoEncontradaException();
//            }
//        }
//    }
//
//    /**
//     * Seleciona uma empreiteira com o código informado.
//     *
//     * @param codEmp Código da empreiteira a ser selecionada.
//     * @throws BlocoParametroIncorreto O parametro informado no bloco está
//     * incorreto.
//     * @throws TelaNaoAcessadaException A aplicação não se encontra na tela
//     * esperada.
//     * @since 1.0.0
//     */
//    public void selecDetEmpreiteira(String codEmp) throws BlocoParametroIncorreto, TelaNaoAcessadaException, RcNegativoException {
//        log.debug("Selecionando uma Empreiteiras com código " + codEmp);
//
//        try {
//            int linha = 7;
//            int empId = Integer.parseInt(codEmp);
//            int empMainFrame;
//
//            validaTelaAtual("CGIG001A");
//
//            while (!host.getScreenContentAt(linha, 33, 4).trim().isEmpty()) {
//                empMainFrame = Integer.parseInt(host.getScreenContentAt(linha, 33, 4).trim());
//
//                if (empId == empMainFrame) {
//                    host.setStringAt(linha, 24, "X");
//                    sendEnter();
//                    break;
//                }
//
//                linha++;
//            }
//        } catch (NumberFormatException ex) {
//            throw new BlocoParametroIncorreto(ex.getMessage());
//        }
//    }
//
//    /**
//     * Seleciona a opção de Reparos dentro da empreiteira.
//     *
//     * @throws EmpreiteiraSemReparosException A empreiteira não tem reparos.
//     * @throws TelaNaoAcessadaException A aplicação não se encontra na tela
//     * esperada.
//     * @since 1.0.0
//     */
//    public void selecEstFilaExeReparos() throws EmpreiteiraSemReparosException, TelaNaoAcessadaException, RcNegativoException {
//        log.debug("Selecionando a fila de reparos");
//
//        validaTelaAtual("CGIG001B");
//
//        if (!host.getScreenContentAt(18, 39, 1).trim().isEmpty()) {
//            host.setStringAt(estFilExeReparos);
//            sendEnter();
//        } else {
//            throw new EmpreiteiraSemReparosException(host.getScreenContentAt(5, 15, 4).trim());
//        }
//    }
//
//    /**
//     * Seleciona uma fila dentro da tela de reparos.
//     *
//     * @param fila Nome da fila a ser acessada.
//     * @throws FilaNaoEncontradaException Não existe fila com esse nome.
//     * @throws TelaNaoAcessadaException A aplicação não se encontra na tela
//     * esperada.
//     * @since 1.0.0
//     */
//    public void selecTelBraTel(String fila) throws FilaNaoEncontradaException, TelaNaoAcessadaException, RcNegativoException {
//        log.debug("Selecionando a fila " + fila);
//
//        int linha = 7;
//        int coluna = 11;
//        String filaMainFrame;
//
//        validaTelaAtual("CGS1310A");
//
//        while (!host.getScreenContentAt(linha, coluna, 2).trim().isEmpty()) {
//            filaMainFrame = host.getScreenContentAt(linha, coluna, 2).trim();
//
//            if (fila.equals(filaMainFrame)) {
//                host.setStringAt(linha, coluna + 3, "X");
//                sendEnter();
//                return;
//            }
//
//            coluna += 13;
//
//            if (coluna > 80) {
//                coluna = 11;
//                linha++;
//            }
//        }
//
//        throw new FilaNaoEncontradaException(fila + " não encontrada no sistema.");
//    }
//
//    /**
//     * Seleciona o registro na linha informada.
//     *
//     * @param linha Linha na qual o registro se encontra.
//     * @throws RegistroNaoEncontradoException Não existe registro na linha
//     * informada.
//     * @throws TelaNaoAcessadaException A aplicação não se encontra na tela
//     * esperada.
//     * @since 1.0.0
//     */
//    public void selecReparoDetalhar(int linha) throws RegistroNaoEncontradoException, TelaNaoAcessadaException, RcNegativoException {
//        log.debug("Selecionando o reparo na linha " + linha);
//
//        validaTelaAtual("CGS1310B");
//
//        if (linha <= 21 && !host.getScreenContentAt(linha, 5, 4).trim().isEmpty()) {
//            host.setStringAt(linha, 3, "X");
//            sendEnter();
//        } else {
//            sendF8();
//
//            if (!host.queryStringAt(1, "FINAL DE CONSULTA")) {
//                host.setStringAt(8, 3, "X");
//                sendEnter();
//            } else {
//                throw new RegistroNaoEncontradoException();
//            }
//        }
//    }
//
//    /**
//     * Valida e executa o F8 que leva até a tela de historico de tramitações
//     * entre filas.
//     *
//     * @throws TelaNaoAcessadaException A aplicação não se encontra na tela
//     * esperada.
//     * @since 1.0.0
//     */
//    public void navegaEncaminhamentoBD() throws TelaNaoAcessadaException, RcNegativoException {
//        log.debug("Navegando até as informações de Encaminhamento de BD");
//
//        validaTelaAtual("CGS0371A");
//
//        sendF8();
//    }
//
//    /**
//     * Valida e executa o F7 que leva até a tela de conexões de rede.
//     *
//     * @throws TelaNaoAcessadaException A aplicação não se encontra na tela
//     * esperada.
//     * @since 1.0.0
//     */
//    public void navegaConexoesRede() throws TelaNaoAcessadaException, RcNegativoException {
//        log.debug("Navegando até as conexões de rede do registro");
//
//        validaTelaAtual("CGS0371A");
//
//        sendF7();
//    }
//
//    /**
//     * Valida e executa o F9 que leva até a tela de Infos ADSL.
//     *
//     * @throws TelaNaoAcessadaException A aplicação não se encontra na tela
//     * esperada.
//     * @since 1.0.0
//     */
//    public void navegaInfosADSL() throws TelaNaoAcessadaException, RcNegativoException {
//        log.debug("Navegando até as informações de ADSL do registro");
//
//        validaTelaAtual("CGS2799A");
//
//        sendF9();
//    }
//
//    public String getEstFilaExeNumBD() {
//        return host.getScreenContentAt(this.posicaoEstFilaExeNumBD).trim();
//    }
//
//    public String getEstFilaExeLocalidade() {
//        return host.getScreenContentAt(this.posicaoEstFilaExeLocalidade).trim();
//    }
//
//    public String getEstFilaExeTerminal() {
//        return host.getScreenContentAt(this.posicaoEstFilaExeTerminal).trim();
//    }
//
//    public String getEstFilaExeDataHoraSolicitacao() {
//        return host.getScreenContentAt(this.posicaoEstFilaExeDataHoraSolicitacao).trim();
//    }
//
//    public String getEstFilaExeDataHoraPromessa() {
//        return host.getScreenContentAt(this.posicaoEstFilaExeDataHoraPromessa).trim();
//    }
//
//    public String getEstFilaExeOrigem() {
//        return host.getScreenContentAt(this.posicaoEstFilaExeOrigem).trim();
//    }
//
//    public String getEstFilaExeReparoSolicitado() {
//        return host.getScreenContentAt(this.posicaoEstFilaExeReparoSolicitado).trim();
//    }
//
//    public String getEstFilaExeEmpreiteira() {
//        return host.getScreenContentAt(this.posicaoEstFilaExeEmpreiteira).trim();
//    }
//
//    public String getEstFilaExeCategoria() {
//        return host.getScreenContentAt(this.posicaoEstFilaExeCategoria).trim();
//    }
//
//    public String getEstFilaExeUso() {
//        return host.getScreenContentAt(this.posicaoEstFilaExeUso).trim();
//    }
//
//    public String getEstFilaExeCliente() {
//        return host.getScreenContentAt(this.posicaoEstFilaExeCliente).trim();
//    }
//
//    public String getEstFilaExeClasse() {
//        return host.getScreenContentAt(this.posicaoEstFilaExeClasse).trim();
//    }
//
//    /**
//     * Pega as observações do Assinante após o F5.
//     *
//     * @return Todas as informações de observação do assinante.
//     * @since 1.0.0
//     */
//    public String getObservacaoAssinante() throws RcNegativoException {
//        if (host.getScreenContentAt(10, 24, 5).equals("S0042")) {
//            sendF3();
//            return "Sem observações do assinante.";
//        }
//
//        StringBuilder sb = new StringBuilder();
//        int i = 6;
//
//        do {
//            sb.append(host.getScreenContentAt(i, 8, 71).trim());
//            i++;
//            System.out.println(host.getScreenContentAt(i, 8, 71).trim());
//        } while (!host.getScreenContentAt(i, 8, 71).trim().isEmpty());
//
//        sendF3();
//
//        return sb.toString();
//    }
//
//    /**
//     * Comando F5 especifico para a tela IG devido a possibilidade de seleção.
//     *
//     * @param labelOpcao observacaoAssinante, observacaoUnidade ou entrevista.
//     * @since 1.0.0
//     */
//    public void sendF5(String labelOpcao) throws RcNegativoException {
//        log.debug("Selecionando a opção de Observações do Cliente");
//
//        super.sendF5();
//        host.setStringAt(labelOpcao);
//        sendEnter();
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
//     * Pega a data mais atual de entrada na fila informada.
//     *
//     * @param fila Fila da qual se quer a ultima data de entrada
//     *
//     * @return Uma String no formato <i>dd/mm/aaaa hh:mm</i>
//     * @since 1.0.0
//     */
//    public String verificaUltimaEntradaPosto(String fila) {
//        int linha = 7;
//        String data = "";
//
//        while (!host.getScreenContentAt(linha, 19, 2).trim().isEmpty()) {
//            if (host.getScreenContentAt(linha, 19, 2).equals(fila)) {
//                data = host.getScreenContentAt(linha - 1, 41, 17).trim();
//            } else if (linha > 21) {
//                break;
//            }
//
//            linha++;
//        }
//
//        return data.replace("  ", " ");
//    }
//
//    /**
//     * Pega a matricula mais atual de entrada na fila informada.
//     *
//     * @param fila Fila da qual se quer a ultima data de entrada
//     *
//     * @return A matricula da última entrada no posto
//     * @since 1.0.0
//     */
//    public String verificaMatriculaUltimaEntradaPosto(String fila) {
//        int linha = 7;
//        String matricula = "";
//
//        while (!host.getScreenContentAt(linha, 19, 2).trim().isEmpty()) {
//            if (host.getScreenContentAt(linha, 19, 2).equals(fila)) {
//                matricula = host.getScreenContentAt(linha - 1, 31, 8).trim();
//            } else if (linha > 21) {
//                break;
//            }
//
//            linha++;
//        }
//
//        return matricula;
//    }
//
//    /**
//     * Pega o posto mais atual de entrada na fila informada.
//     *
//     * @param fila Fila da qual se quer o ultimo posto de entrada
//     *
//     * @return O posto da última entrada
//     * @since 2.0.0
//     */
//    public String verificaPostoUltimaEntrada(String fila) {
//        int linha = 7;
//        String posto = "";
//
//        while (!host.getScreenContentAt(linha, 19, 2).trim().isEmpty()) {
//            if (host.getScreenContentAt(linha, 19, 2).equals(fila)) {
//                posto = host.getScreenContentAt(linha - 1, 19, 2).trim();
//            } else if (linha > 21) {
//                break;
//            }
//
//            linha++;
//        }
//
//        return posto;
//    }
//
//}
