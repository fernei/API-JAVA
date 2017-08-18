package com.accenture.apiautomacao.sac.tela;


import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
import static com.accenture.apiautomacao.logger.LogTrace.log;
import static com.accenture.apiautomacao.sac.controller.Execucao.host;
import static com.accenture.apiautomacao.sac.controller.Execucao.mainFrame;

/**
 * Classe responsável por toda e qualquer manipulação de popups no Sistema SAC
 *
 * @author fernando.m.souza
 * @since 1.0.0
 */
public class PopUpGeraisSAC {

    /**
     * Trata todos os popups derivados de comandos executados entre telas no
     * SAC.
     *
     * @return <b>TRUE</b> - Todos os popups foram tratados
     * <b>FALSE</b> - Algum popup não pode ser tratado
     * @since 1.0.0
     */
    public boolean popupGeraisSAC() throws RcNegativoException {
        boolean ret;
        int countLoop = 0;

        do {
            ret = false;

            // *** Popup ESTE TELEFONE ESTA EM AREA DE CORTE ***
            if (host.queryStringAt(10, 21, "ESTE TELEFONE ESTA EM AREA DE CORTE")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                host.printScreenContent();
                ret = true;
            }

            // *** Popup ESTE TELEFONE É SIGILOSO - MATRICULA REGISTRADA ***
            if (host.queryStringAt(12, 58, "CGS0389")) {
                host.setStringAt(23, 69, "S");
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                host.printScreenContent();
                ret = true;
            }

            // *** Popup E-BILLING ***
            if (host.queryStringAt(9, 41, "E-BILLING")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(13, 71, "CG00020")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                host.printScreenContent();
                ret = true;
            }
            if (host.queryStringAt(16, "OI TOTAL") || host.queryStringAt(16, "Oi Total")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                host.printScreenContent();
                ret = true;
            }
            // *** Popup ACL de ATENCAO *** - COBRANÇA APÓS PRIMEIRO ACESSO
            if (host.queryStringAt(15, 30, "PRIMEIRO ACESSO :")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                host.printScreenContent();
                ret = true;
            }
            // *** Popup AA de ATENCAO *** - COBRANÇA APÓS PRIMEIRO ACESSO
            if (host.queryStringAt(15, 33, "PRIMEIRO ACESSO :")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                host.printScreenContent();
                ret = true;
            }

            if (host.queryStringAt(15, 46, "CG00020")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
//                retornaTelaInicialSAC();
                ret = true;
            }
            // popup PROBLEMAS  NO  SISTEMA  SAC
            if (host.queryStringAt(19, 51, "ERROR =")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                log.info("Problemas no sistema SAC, contatar a equipe de sistemas!");
                ret = true;
            }
            if (host.queryStringAt(18, 52, "Documento não encontrado")) {
//                log.error("{popupGeraisSAC} Documento nao encontrado!. " + registroAtual.getNumOS());
                log.info("{popupGeraisSAC} Documento nao encontrado!. ");
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(19, 29, "TERMINAL/CONTRATO")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(15, 20, "EXISTE OI CONTA TOTAL")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(14, 35, "TERMINAL OI CONTA TOTAL")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(11, 36, "A T E N C A O ")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(11, "TERMINAL INFORMADO POSSUI GECO.")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(11, 56, "A T E N C A O")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(14, 10, "NRO-OS")) {
                int linha = 15;
                while (!host.getScreenContentAt(linha, 8, 1).trim().isEmpty()) {
                    if ("PENDENTE".equals(host.getScreenContentAt(linha, 71, 8).trim())) {
                        host.setStringAt(linha, 6, "X");
                        host.sendEnterKeyWait(mainFrame.getTimeout());
                        break;
                    } else if ((linha == 19)) {
                        host.sendPFKeyWait(8, mainFrame.getTimeout());
                    }

                    linha += 2;
                }
                ret = true;
            }

            if (host.queryStringAt(12, 36, "A  T  E  N  C  A  O")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(13, 36, "*** A L E R T A ***")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(13, 71, "CGACB00D")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(15, 30, "PRIMEIRO ACESSO")) {
                host.sendPFKey(3);
                host.waitForTerminalReady(mainFrame.getTimeout());
                host.printScreenContent();
                ret = true;
            }

            if (host.queryStringAt(13, 30, "A T E N C A O")) {
//                host.setStringAt(15, 52, "S");
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                host.printScreenContent();
                ret = true;
            }

//            if (host.queryStringAt(13, 30, "A T E N C A O")) {
//                //host.printScreenContent();
//                host.sendPFKey(3);
//                host.waitForTerminalReady(mainFrame.getTimeout());
//                ret = true;
//            }
            if (host.queryStringAt(12, 68, "CG00200E")) {
                //host.printScreenContent();
                host.sendPFKey(3);
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            // BD COM CAUSA COMUM
            // DESEJA DETALHAR? _ (S/N)
            // TECLE < ENTER >.
            if (host.queryStringAt(12, 32, "BD COM CAUSA COMUM") || host.queryStringAt(14, 29, "DESEJA DETALHAR")) {
                //host.printScreenContent();
                host.setStringAt(14, 46, "S");
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            // GRAU DE PRIORIDADE
            // DEFEITO
            // INFO CALL CENTER
            if (host.queryStringAt(21, 5, "PF3 - VOLTAR") || host.queryStringAt(14, 4, "INFO CALL CENTER")) {
                //host.printScreenContent();
                host.sendPFKey(3);
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(15, 45, "ESTE TELEFONE EH SIGILOSO")) {
                //host.printScreenContent();
                host.setStringAt(23, 69, "S");
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(12, "'BD COM CAUSA COMUM'")) {
                //host.printScreenContent();
                host.setStringAt(14, 46, "N");
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(21, 33, "O cliente participa do Programa Relacionamento")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(8, 24, "OCORRENCIAS DE BLOQUEIO")) {
                //host.printScreenContent();
                host.sendPFKey(3);
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(20, 21, "ESTE CLIENTE PASSOU")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;;
            }

            if (host.queryStringAt(15, 20, "Codigo do Plano")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;;
            }

            if (host.queryStringAt(14, 35, "A T E N C A O")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;;
            }

            //*** Tratamento do popup de NA ULTIMA HORA FORAM REGISTRADOS BD ***//
            if (host.queryStringAt(13, 35, "NA ULTIMA HORA FORAM REGISTRADOS BD")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;;
            }

            if (host.queryStringAt(10, 35, "A T E N C A O") && host.queryStringAt(13, 13, "NAO ESTA MAIS")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                return false;
            }

            //*** Tratamento do popup MENSAGEM - Existem servicos nesta ordem para serem executados
            if (host.queryStringAt(11, 15, "Existem servicos nesta ordem para serem executados")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                log.info("Existem servicos nesta ordem para serem executados.");
                return false;
            }

            if (host.queryStringAt(14, 11, "MORE")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                return false;
            }

            if (host.queryStringAt(18, 52, "Documento não encontrado")) {
                log.info("Documento nao encontrado!.");
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            // EXISTE SOLICITACAO DE REPARO ABERTA PARA ESTE TELEFONE
            if (host.queryStringAt(17, 28, "A T E N C A O") || host.queryStringAt(19, 21, "EXISTE")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(17, 28, "A T E N C A O !")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(9, 58, "A T E N C A O")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(10, 34, "A T E N C A O")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            // SERVIÇO TRAMITANDO SEM FACILIDADE DESIGNADA.
            if (host.queryStringAt(10, 34, "A T E N C A O !")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(7, 38, "A T E N C A O")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(7, 38, "ATENCAO")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(2, 33, "A T E N C A O")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(13, 8, "NAO ENCONTROU FACILIDADE PARA O TERMINAL")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(1, 2, "CONTRATO INVALIDO.")) {
                try {
                    new Tela().retornaMenuPrincipal();
                } catch (MainFrameException ex) {
                    throw new RuntimeException(ex.getMessage());
                }

                return false;
            }

            //*** Tratamento do popup *** S V O I *** //
            if (host.queryStringAt(13, 36, "*** S V O I ***")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(13, 40, "*** S V O I ***")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(17, 7, "PROG")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(13, 36, "Este Telefone ja esta")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                log.info("Este Telefone ja esta sendo detalhado por outra pessoa!");
                return false;
            }

            if (host.queryStringAt(13, 36, "Tipo de Utilizacao")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                return false;
            }

            if (host.queryStringAt(17, "PF3-Desiste  PF4-Detalhes  PF7-Bloq")) {
                //host.printScreenContent();
                host.sendPFKey(3);
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            // *** Este telefone encontra-se na Gerencia de Pendencia. ***
            if (host.queryStringAt(8, 35, "MENSAGEM") || host.queryStringAt(11, 15, "Este telefone encontra-se na Gerencia de Pendencia")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                log.info("Este telefone encontra-se na Gerência de Pendência.");

                try {
                    new Tela().retornaMenuPrincipal();
                } catch (MainFrameException ex) {
                    throw new RuntimeException(ex.getMessage());
                }

                return false;
            }

            if (host.queryStringAt(9, 35, "RETORNO CLICK")) {
                host.printScreenContent();
                host.sendPFKey(4);
                host.waitForTerminalReady(mainFrame.getTimeout());
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            //*** Tratamento de popups de Alerta que exigem apenas <ENTER> ***//
            // POPUPS ERRADOS DE TELA
            if (host.queryStringAt(16, 42, "Usuario nao autorizado")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                host.printScreenContent();
                return false;
            }

            if (host.queryStringAt(16, 40, "COMANDO NAO CADASTRADO")) {
                //host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                return false;
            }

            // TELEFONE COM TARIFACAO LOCAL EM MINUTOS.
            // CENTRAL COM BLOQUEIO ATENDIDO PELO 7IP
            // EWT ATIVADO .....
            if (host.queryStringAt(17, 30, "*** A L E R T A ***")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(17, 30, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(13, 40, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            //Todo: Verificar outro lugar para colocar este popUp
//            if (host.queryStringAt(15, 41, "USUARIO NAO AUTORIZADO")) {
//                try {
//                    host.printScreenContent();
//                    host.sendEnterKey();
//                    host.waitForTerminalReady(mainFrame.getTimeout());
//
//                    log.warn("Usuario " + usuarioSAC.getUsuario() + " sem permissão em alguma tela da execucao.");
//
//                    usuarioSAC.desaloca();
//
//                    conexaoSAC.logoffUsuario();
//
//                    usuarioSAC = SacControleUsuario.alocaUsuario(controleExec, permLista);
//                } catch (UsuarioNaoEncontradoException ex) {
//                    throw new RuntimeException("Não existem mais usuários disponíveis para alocar.");
//                }
//
//            }
            if (host.queryStringAt(15, 41, "Tecle <ENTER>")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(10, 42, "A T E N C A O")) {
                host.printScreenContent();
                host.sendPFKey(7);
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(8, 35, "Nao e permitido incluir aviso")) {
//                host.printScreenContent();
                log.info("Não é permitido incluir aviso para uma Ordem em processo de Interoperação.");
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                return false;
            }

            //*** Tratamento de popups de Alerta que exigem apenas <ENTER> ***//
            if (host.queryStringAt(2, 27, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            // Este telefone pertence a area 'ASA'.
            if (host.queryStringAt(16, 46, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(17, 30, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(14, 34, "A T E N C A O !")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(8, 31, "MENSAGEM") && host.queryStringAt(11, 13, "EXISTEM ORDEM DE")) {
                host.printScreenContent();
                host.sendPFKey(4);
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            // Existe OI VELOX (ADSL) Projetado para esse telefone.
            if (host.queryStringAt(17, 28, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            // Existe OI VELOX (ADSL) Projetado para esse telefone.
            if (host.queryStringAt(17, 28, "A T E N C A O !")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.getScreenContentAt(17, 22, 25).trim().equals("A T E N C A O !")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            //*** Tratamento de popups de alerta que exigem apenas <PF3>  ***//
            if (host.queryStringAt(12, 20, "CLIENTE COM ATENDIMENTO ESPECIALIZADO") && host.queryStringAt(22, 21, "PF3")) {
                host.printScreenContent();
                host.sendPFKey(3);
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(10, 26, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(8, 38, "ATENCAO") || host.queryStringAt(10, 21, "A LIBERACAO do tom de discar  do  terminal")) {
                host.printScreenContent();
                host.setStringAt(16, 44, "N");
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            //O BLOQUEIO do tom de discar do terminal
            if (host.queryStringAt(8, 38, "ATENCAO") || host.queryStringAt(10, 21, "O BLOQUEIO")) {
                host.printScreenContent();
                host.setStringAt(16, 44, "N");
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            //*** Tratamento de popups de alerta EXISTEM ORDEM DE 'SERVICO' E 'APOIO' ABERTAS.  ***//
            if (host.queryStringAt(16, 13, "PF4= 'OS'")) {
                host.printScreenContent();
                host.sendPFKey(4);
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            //*** Tratamento de popups de Alerta que exigem apenas <ENTER> ***//
            if (host.queryStringAt(21, 32, "TECLE <ENTER...>")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            //*** Tratamento de popup ESTE TELEFONE NAO FIGURA EM LISTA TELEFONICA ***//
            if (host.queryStringAt(21, 31, "TECLE <ENTER...>")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            //*** Tratamento de popup PROCESSO DE MIGRACAO DE CAMPANHA VELOX. ***//
            if (host.queryStringAt(17, 30, "** A L E R T A **")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(17, 30, "*** A L E R T A ***")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            //*** Tratamento de popups de Alerta que exigem apenas <ENTER> ***//
            if (host.queryStringAt(15, 31, "** A L E R T A **")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            //*** Tratamento de popup ATENCAO - CLIENTE BRONZE ***//
            if (host.queryStringAt(15, 29, "** A L E R T A **")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            //*** Tratamento de popup ATENCAO - CLIENTE OURO ***//
            if (host.queryStringAt(15, 31, "** A L E R T A **")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            //*** Tratamento de popup ATENCAO - ESTE TELEFONE NAO FIGURA EM LISTA TELEFONICA ***//
            if (host.queryStringAt(15, 35, "ATENCAO")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(17, 32, "*** A L E R T A ***")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            //*** Tratamento de popups de Alerta que exigem apenas <ENTER> ***//
            // Este telefone pertence a area 'ASA' com agendamento.
            if (host.queryStringAt(21, 29, "<Enter>")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            //*** Tratamento de popup ENTREVISTA DA ATENDENTE COM O USUARIO ***//
            if (host.queryStringAt(19, 65, "Tecle enter")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            //*** Tratamento de popup de INSAPOIO ***//
            if (host.queryStringAt(19, 42, "ENTER")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            //*** Tratamento de popups de alerta que exigem apenas <PF7>  ***//
            // Popup de cliente ANATEL
            if (host.queryStringAt(19, 63, "TECLE <PF7...>")) {
                host.printScreenContent();
                host.sendPFKey(7);
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            //*** Tratamento de popup de alerta da existencia de Velox ***//
            if (host.queryStringAt(19, 21, "Existe OI VELOX (ADSL)")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            //*** Tratamento de popup de serviços associados ao terminal ***//
            if (host.queryStringAt(8, 29, "Lista dos Servicos existentes")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            //*** Tratamento do popup de Avisos por telefone ***///
            if (host.queryStringAt(5, 38, "AVISOS POR TELEFONE")) {
                host.printScreenContent();
                host.sendPFKey(3);
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            //*** Tratamento do popup de terminal com plano controle ***///
            if (host.queryStringAt(12, 29, "TERMINAL PLANO CONTROLE")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(17, 25, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(22, 31, "Tecle <ENTER")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            //*** Tratamento do popup de CLIENTE EMPRESARIAL ***///
            if (host.queryStringAt(22, 15, "TECLE <ENTER...>")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            //*** Tratamento do popup ESTE CLIENTE TEM CONSULTOR ***///
            if (host.queryStringAt(23, 15, "TECLE <ENTER...>")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(12, 19, "Esta O.S. ja foi selecionada")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(8, 17, "S E G M E N T O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(8, 12, "S E G M E N T O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(11, 29, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(10, 41, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(17, 41, "ALERTA")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(17, 37, "Observacao")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(17, 37, "ATENCAO")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(17, 37, "Observacao Atendente")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            // Parcelamento Nao Pago
            if (host.queryStringAt(10, 29, "Parcelamento Nao Pago")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(16, 25, "*** ALERTA ***")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(15, 29, "A T E N C A O")) {
                host.printScreenContent();
                if (host.queryStringAt(18, 12, "Existe outro Usuario utilizando este Registro.")) {
                    host.sendEnterKey();
                    host.waitForTerminalReady(mainFrame.getTimeout());
                    log.info("Existe outro Usuario utilizando este Registro!");
                    return false;
                }
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(16, 44, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(12, 19, "CLIENTE COM ATENDIMENTO ESPECIALIZADO")) {
                host.printScreenContent();
                host.sendPFKey(3);
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(10, 13, "LOCALIDADE")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(8, 29, "MENSAGEM")) {
                host.printScreenContent();
                if (host.queryStringAt(10, 15, "USUARIO NAO AUTORIZADO NESTE POSTO")) {
                    host.printScreenContent();
                    log.info("USUARIO NAO AUTORIZADO NESTE POSTO");
                    host.sendEnterKey();
                    host.waitForTerminalReady(mainFrame.getTimeout());
                    return false;
                }
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(3, 27, "EQUIPAMENTOS DO TERMINAL DVI")) {
                host.printScreenContent();
                host.sendPFKey(3);
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(16, 30, "*** A L E R T A ***")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(4, 71, "CGS0375A")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(9, 36, "ATENCAO")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(17, 23, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(12, 16, "Logradouro")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(17, 31, "A L E R T A")) {
                host.printScreenContent();
                //O  NUMERO _______ FOI PORTADO PARA OUTRA OPERADORA.PARA VER DADOS DO FICTICIO
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(5, 48, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            // Abertura de Reparo de WLL
            if (host.queryStringAt(9, 41, "Abertura de Reparo de WLL")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(17, 41, "ALERTA")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(14, 39, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(4, 37, "COBRANCA")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(12, 25, "DESEJA CONTINUAR")) {
                host.printScreenContent();
                host.setStringAt(12, 43, "S");
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(5, 27, "ENTREVISTA")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(10, 35, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(11, 31, "A T E N C A O")) {
                host.setStringAt(14, 51, "S");
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(11, 36, "A T E N C A O")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(9, 58, "A T E N C A O")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());

                ret = true;
            }

            if (host.queryStringAt(10, 33, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }
            // Ordem esta Aprazada  //// Tela I.A
            if (host.queryStringAt(12, 29, "Ordem esta Aprazada")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(9, 8, "Telefone")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(12, 15, "Rede Interna")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(6, 56, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(12, 48, "A T E N C A O")) {
                host.printScreenContent();
                if (host.queryStringAt(16, 42, "Usuario nao autorizado")) {
                    host.sendEnterKey();
                    host.waitForTerminalReady(mainFrame.getTimeout());
                    host.printScreenContent();
                    return false;
                }
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(19, 66, "<TODOS>")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            // Voce ira providenciar A LIBERACAO  do  tom de discar manualmente?
            if (host.queryStringAt(16, 31, "manualmente?")) {
                host.printScreenContent();
                host.setStringAt(16, 44, "N");
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(1, 2, "Nao existem dados para os criterios informados")) {
                host.printScreenContent();
                log.info("Não existem dados para os critérios informados.");
                return false;
            }

            if (host.queryStringAt(12, 36, "A V I S O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                if (host.queryStringAt(16, 13, "Deseja reservar esta ordem para uma futura execucao ?")) {
                    host.sendEnterKey();
                    host.waitForTerminalReady(mainFrame.getTimeout());
                }
                ret = true;
            }

            if (host.queryStringAt(11, 11, "EXISTEM ORDEM DE 'SERVICO' E 'APOIO' ABERTAS")) {
                host.printScreenContent();
                host.sendPFKey(4); //Seleciona OS
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(9, 37, "ATENCAO")) {
                host.printScreenContent();
                log.info("Popup não mapeado.\n\nPrintar a tela e enviar para a equipe de desenvolvimento.");
                host.printScreenContent();
                return false;
            }

            if (host.queryStringAt(10, 31, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(12, 16, "ESTA OS SERA AUTOMATICAMENTE FECHADA PELO SISTEMA")) {
                host.printScreenContent();
                log.info("Esta OS será automaticamente fechada pelo sistema");
                return false;
            }

            if (host.getScreenContentAt(10, 38, 20).replace(" ", "").equals("ATENCAO")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(10, 38, "A T E N C A O")) {
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.getScreenContentAt(8, 20, 32).replace(" ", "").equals("MENSAGEM")) {
                host.printScreenContent();
                if (host.getScreenContentAt(11, 10, 60).trim().equals("Existem servicos nesta ordem para serem executados")) {
                    log.info("ATENCAO! Existem servicos nesta ordem para serem executados");
                    return false;
                } else if (host.queryStringAt(12, 13, "Nao existe O.S. aberta para o telefone informado.")) {
                    host.sendEnterKey();
                    host.waitForTerminalReady(mainFrame.getTimeout());
                    log.info("ATENCAO! Nao existe O.S. aberta para o telefone informado. ");
                    return false;
                } else {
                    host.sendEnterKey();
                    host.waitForTerminalReady(mainFrame.getTimeout());
                    ret = true;
                }
            }

            if (host.queryStringAt(5, 38, "AVISOS")) {
                host.printScreenContent();
                host.sendPFKey(3);
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(7, 11, "Descricao do erro")) {
                while ("IFF0MENU".equals(host.getScreenContentAt(7, 73, 8))) {
                    host.sendEnterKey();
                    host.waitForTerminalReady(mainFrame.getTimeout());
                }

                return false;
            }

            if (host.queryStringAt(5, 39, "AVISO")) {
                host.printScreenContent();
                host.sendPFKey(3);
                host.waitForTerminalReady(mainFrame.getTimeout());
                ret = true;
            }

            if (host.queryStringAt(12, 65, "CGS1152A")) {
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                host.printScreenContent();
                ret = true;
            }

            countLoop++;

        } while (ret && countLoop < 15);

        if (ret && countLoop >= 15) {
            log.info("Loop infinito no popupGeraisSAC. Mais de 15 tentativas.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Trata a tela de seleção de DDD através de uma Localidade.
     *
     * @param localidade Localidade a ser utilizada para a busca.
     * @since 1.0.0
     */
    public void popUpSelecaoDddByLocalidade(String localidade) throws RcNegativoException {
        if (host.queryStringAt(4, 71, "CGS2225A") || host.queryStringAt(4, 71, "CGS1225A")) {
            int linha_ddd = 6;

            while (!host.queryStringAt(linha_ddd, 39, localidade) && linha_ddd < 21) {
                linha_ddd++;
            }

            if (host.queryStringAt(linha_ddd, 39, localidade)) {
                host.setStringAt(linha_ddd, 16, "X");
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                host.printScreenContent();
            }
        }
    }

    /**
     * Trata a tela de seleção de DDD através de um DDD.
     *
     * @param ddd DDD a ser utilizado para a busca.
     * @return Localidade do BD.
     * @since 1.0.0
     */
    public String popUpSelecaoDddByDDD(String ddd) throws RcNegativoException {
        String localidade = null;

        if (host.queryStringAt(4, 71, "CGS2225A") || host.queryStringAt(4, 71, "CGS1225A")) {
            int linha_ddd = 6;

            while (!host.queryStringAt(linha_ddd, 35, ddd) && linha_ddd < 21) {
                linha_ddd++;
            }

            if (host.queryStringAt(linha_ddd, 35, ddd)) {
                host.setStringAt(linha_ddd, 16, "X");
                localidade = host.getScreenContentAt(linha_ddd, 39, 4).trim();
                host.printScreenContent();
                host.sendEnterKey();
                host.waitForTerminalReady(mainFrame.getTimeout());
                host.printScreenContent();
            }
        }

        return localidade;
    }

    /**
     * Verifica se existe o popup <i>PROBLEMAS NA ATUALIZACAO</i>.
     *
     * @param ddd DDD a ser utilizado para a busca.
     * @since 1.0.0
     */
    public Boolean popUpProblemaNaAtualizacao() {
        return host.queryStringAt(17, 32, "PROBLEMAS NA ATUALIZACAO . TENTE NOVAMENTE");
    }
}
