package com.accenture.apiautomacao.sac.tela;

import com.accenture.apiautomacao.exception.mainframe.MainFrameException;
import com.accenture.apiautomacao.exception.mainframe.OpcaoSuspensaNaoEncontradaException;
import com.accenture.apiautomacao.exception.mainframe.TelaNaoAcessadaException;
import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
import static com.accenture.apiautomacao.logger.LogTrace.log;
import static com.accenture.apiautomacao.sac.controller.Execucao.conexaoSAC;
import static com.accenture.apiautomacao.sac.controller.Execucao.host;
import static com.accenture.apiautomacao.sac.controller.Execucao.mainFrame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Classe Pai de todas as telas de Mainframe.
 *
 * @author fernando.m.souza
 * @since 1.0.0
 */
public class Tela extends PopUpGeraisSAC {

    private static final String CAMINHO_ARQUIVOS_PROPERTIES = "./properties/";

//    private static final String CAMINHO_ARQUIVOS_PROPERTIES = "C:/Automacoescg/Java/SAC/branches/sac_EXTERNO/properties/";
    private final String mensagemSAC = "1,2,70";

    public static final String SAC_CMD = "cmd";
    public static final String SAC_NOME_TELA = "nome.tela";
    public static final String SAC_CODIGO_TELA = "codigo.tela";

    public static Properties prop = null;

    protected static Properties getProp(String nomeArquivoProperties) {
        Properties props = null;
        FileInputStream file = null;
        try {
            props = new Properties();
            file = new FileInputStream(CAMINHO_ARQUIVOS_PROPERTIES + nomeArquivoProperties + ".properties");
            props.load(file);
        } catch (FileNotFoundException ex) {
            log.error("Arquivo properties da tela " + nomeArquivoProperties + " não localizado.");
        } catch (IOException ex) {
            log.error("Arquivo properties da tela " + nomeArquivoProperties + " com erro de leitura.");
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                log.info("Erro ao fechar o arquivo properti");
            }
        }

        return props;
    }

    /**
     * Retorna ao Menu Principal da Aplicação.
     *
     * @throws MainFrameException Caso não consiga retornar ao Menu Principal.
     * @since 1.0.0
     */
    public void retornaMenuPrincipal() throws MainFrameException {
        if (host.isConnected()) {
            if (!host.queryStringAt(4, 72, "CG00000A")) {
                log.debug("Retornando à tela inicial da Funcionalidade");

                int cont = 1;

                if (!host.checarConexao()) {
                    conexaoSAC.conectarSAC();
                    conexaoSAC.acessaUfNoSAC();
                }

                if (host.queryStringAt(16, 13, "Matricula")) {
                    conexaoSAC.logarUsuario();
                }

                if ("APLICACOES ON LINE DISPONIVEIS".equals(host.getScreenContentAt(3, 2, 30).trim())) {
                    conexaoSAC.acessaUfNoSAC();
                }

                while (!host.queryStringAt(4, 72, "CG00000A")) {
                    if (!host.checarConexao()) {
                        conexaoSAC.conectarSAC();
                        conexaoSAC.acessaUfNoSAC();
                    }

                    if (!popupGeraisSAC()) {
                        log.error("[ERRO] PopUp não mapeado");
                    }

                    if (!host.queryStringAt(4, 72, "CG00000A")) {
                        if (host.queryStringAt(24, 2, "CMD")) {
                            String telaAtual = host.getScreenContentAt(2, 70, 10).trim();

                            if (!telaAtual.isEmpty()) {
                                host.setStringAt(24, 6, telaAtual.substring(0, 1));
                                try {
                                    sendEnter();
                                } catch (RcNegativoException ex) {
                                    conexaoSAC.conectarSAC();
                                    conexaoSAC.acessaUfNoSAC();
                                }
                            }
                        }
                    }

                    if (cont > 10 || host.getScreenContent().trim().isEmpty()) {
                        conexaoSAC.conectarSAC();
                        conexaoSAC.acessaUfNoSAC();
                        return;
                    }

                    sendF3();
                    cont++;
                }
            }
        } else {
            conexaoSAC.conectarSAC();
            conexaoSAC.acessaUfNoSAC();
        }
    }

    /**
     * Envia o comando <b>F3</b> para a tela.
     *
     * @since 1.0.0
     */
    public void sendF3() throws RcNegativoException {
        host.sendPFKeyWait(3, mainFrame.getTimeout());
        popupGeraisSAC();
    }

    /**
     * Envia o comando <b>F2</b> para a tela.
     *
     * @since 1.0.0
     */
    public void sendF2() throws RcNegativoException {
        host.sendPFKeyWait(2, mainFrame.getTimeout());
        popupGeraisSAC();
    }

    /**
     * Envia o comando <b>F4</b> para a tela.
     *
     * @since 1.0.0
     */
    public void sendF4() throws RcNegativoException {
        host.sendPFKeyWait(4, mainFrame.getTimeout());
        popupGeraisSAC();
    }

    /**
     * Envia o comando <b>F5</b> para a tela.
     *
     * @since 1.0.0
     */
    public void sendF5() throws RcNegativoException {
        host.sendPFKeyWait(5, mainFrame.getTimeout());
        popupGeraisSAC();
    }

    /**
     * Envia o comando <b>F7</b> para a tela.
     *
     * @since 1.0.0
     */
    public void sendF7() throws RcNegativoException {
        host.sendPFKeyWait(7, mainFrame.getTimeout());
        popupGeraisSAC();
    }

    /**
     * Envia o comando <b>F8</b> para a tela.
     *
     * @since 1.0.0
     */
    public void sendF8() throws RcNegativoException {
        host.sendPFKeyWait(8, mainFrame.getTimeout());
        popupGeraisSAC();
    }

    /**
     * Envia o comando <b>F9</b> para a tela.
     *
     * @since 1.0.0
     */
    public void sendF9() throws RcNegativoException {
        host.sendPFKeyWait(9, mainFrame.getTimeout());
        popupGeraisSAC();
    }

    /**
     * Envia o comando <b>F10</b> para a tela.
     *
     * @since 1.0.0
     */
    public void sendF10() throws RcNegativoException {
        host.sendPFKeyWait(10, mainFrame.getTimeout());
        popupGeraisSAC();
    }

    /**
     * Envia o comando <b>ENTER</b> para a tela.
     *
     * @since 1.0.0
     */
    public void sendEnter() throws RcNegativoException {
        host.sendEnterKeyWait(mainFrame.getTimeout());
        popupGeraisSAC();
    }

    /**
     * Substitui os <b>UNDERSCORE</b> por espaços vazios
     *
     * @param texto Texto a receber o Replace.
     * @return Uma <i>String</i> sem hífens.
     * @since 1.0.0
     */
    public String trataCaracter(String texto) {
        return texto.replaceAll("_", " ").trim();
    }

    /**
     * Verifica se uma <b>Tela Base</b> foi acessada e tenta acessá-la.
     *
     * @param codigo Código de verificação da tela
     * @param tela Tela a ser acessada. Ex.: IG, ACB, CA, I7JB
     * @throws TelaNaoAcessadaException Caso a aplicação não consiga chegar a
     * tela informada.
     * @since 1.0.0
     */
    public void verificaTela(String codigo, String tela) throws TelaNaoAcessadaException, MainFrameException {
        int count = 0;

        log.debug("Verificando se chegou na tela " + tela + " com código " + codigo);

        while (!codigo.equals(getCodigoTela())) {
            popupGeraisSAC();

            if (host.queryStringAt(16, 13, "Matricula")) {
                try {
                    conexaoSAC.logarUsuario();
                } catch (MainFrameException ex) {
                    throw new TelaNaoAcessadaException(ex.getMessage());
                }
            }

            if ("APLICACOES ON LINE DISPONIVEIS".equals(host.getScreenContentAt(3, 2, 30).trim())) {
                try {
                    conexaoSAC.acessaUfNoSAC();
                } catch (MainFrameException ex) {
                    throw new TelaNaoAcessadaException(ex.getMessage());
                }
            }

            if ("CMD".equals(host.getScreenContentAt(24, 2, 3).trim().toUpperCase())) {
                host.setStringAt(24, 06, tela);
                try {
                    sendEnter();
                } catch (RcNegativoException ex) {
                    count++;
                    conexaoSAC.conectarSAC();
                    conexaoSAC.acessaUfNoSAC();
                    verificaTela(codigo, tela);
                }
            }

            if (!codigo.equals(getCodigoTela())) {
                sendF3();
                count++;
            }

            if (count > 3) {
                throw new TelaNaoAcessadaException(codigo);
            }
        }
    }

    /**
     * Valida se a aplicação se encontra na tela com o código informado.
     *
     * @param codigo Código de verificação da tela
     * @throws TelaNaoAcessadaException Caso a aplicação não consiga chegar a
     * tela informada.
     * @since 1.0.0
     */
    public void validaTelaAtual(String codigo) throws TelaNaoAcessadaException, RcNegativoException {
        log.debug("Validando se o mainframe está na tela com código " + codigo);

        if (!codigo.equals(getCodigoTela())) {
            popupGeraisSAC();

            if (!codigo.equals(getCodigoTela())) {
                throw new TelaNaoAcessadaException(codigo);
            }
        }
    }

    /**
     * Captura a hora atual do servidor da aplicação que está sendo acessado.
     *
     * @return A data atual informada na aplicação.
     * @since 1.0.0
     */
    public Date pegaDataHoraAtualServidor() {
        try {
            String data = host.getScreenContentAt(2, 3, 10).trim();
            String horario = host.getScreenContentAt(4, 3, 8).trim();
            String dataHora = data + " " + horario;

            return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dataHora);
        } catch (ParseException ex) {
            log.error("Não foi possível pegar a data do servidor: " + ex.getMessage());
        }

        return null;
    }

    /**
     * Seleciona uma opção suspensa, em tela única, buscando a linha pelo nome
     * da opção.
     *
     * @param linhaIni Linha inicial para a busca.
     * @param linhaFim Linha final para a busca.
     * @param posX Posição para marcar o <i>X</i>.
     * @param posIniTextoOpcao Posição do primeiro caracter do texto da opção.
     * @param keySelecionar Valor do <i>Function</i> para selecionar a opção
     * caso número ou <i>ENTER</i> caso letra.
     * @param keyRetornar Valor do <i>Function</i> para sair do Popup caso
     * número ou <i>ENTER</i> caso letra.
     * @param opcao Opção a ser localizada.
     * @throws OpcaoSuspensaNaoEncontradaException Caso não encontre a opção
     * desejada.
     * @throws RcNegativoException Caso o SAC desconecte.
     * @since 1.0.0
     */
    public void marcaOpcaoSuspensa(int linhaIni, int linhaFim, int posX,
            int posIniTextoOpcao, String keySelecionar, String keyRetornar,
            String opcao) throws OpcaoSuspensaNaoEncontradaException, RcNegativoException {
        int linhaAtual = linhaIni;

        do {
            if (host.queryStringAt(linhaAtual, posIniTextoOpcao, opcao)) {
                host.setStringAt(linhaAtual, posX, "X");

                try {
                    Integer fkey = Integer.parseInt(keySelecionar);
                    host.sendPFKeyWait(fkey, mainFrame.getTimeout());
                } catch (NumberFormatException ex) {
                    host.sendEnterKeyWait(mainFrame.getTimeout());
                }

                return;
            }

            linhaAtual++;
        } while (linhaAtual <= linhaFim
                || !host.getScreenContentAt(linhaAtual, posIniTextoOpcao, 1).trim().isEmpty());

        try {
            Integer fkey = Integer.parseInt(keyRetornar);
            host.sendPFKeyWait(fkey, mainFrame.getTimeout());
        } catch (NumberFormatException ex) {
            host.sendEnterKeyWait(mainFrame.getTimeout());
        }

        throw new OpcaoSuspensaNaoEncontradaException(opcao);
    }

    /**
     * Seleciona uma opção suspensa, em tela paginável, buscando a linha pelo
     * nome da opção.
     *
     * @param linhaIni Linha inicial para a busca.
     * @param linhaFim Linha final para a busca.
     * @param posX Posição para marcar o <i>X</i>.
     * @param posIniTextoOpcao Posição do primeiro caracter do texto da opção.
     * @param pfKey Valor da tecla <i>Function</i> para paginar.
     * @param msgFinal Mensagem que mostra a última tela de paginação
     * @param linhaMsg Linha na qual aparece a mensagem de fim de paginação.
     * @param colMsg Coluna na qual aparece a mensagem de fim de paginação.
     * @param keySelecionar Valor do <i>Function</i> para selecionar a opção
     * caso número ou <i>ENTER</i> caso letra.
     * @param keyRetornar Valor do <i>Function</i> para sair do Popup caso
     * número ou <i>ENTER</i> caso letra.
     * @param opcao Opção a ser localizada.
     * @throws OpcaoSuspensaNaoEncontradaException Caso não encontre a opção
     * desejada.
     * @throws RcNegativoException Caso o SAC desconecte.
     * @since 1.0.0
     */
    public void marcaOpcaoSuspensa(int linhaIni, int linhaFim, int posX,
            int posIniTextoOpcao, String msgFinal, int linhaMsg, int colMsg,
            int pfKey, String keySelecionar, String keyRetornar, String opcao)
            throws OpcaoSuspensaNaoEncontradaException, RcNegativoException {

        int linhaAtual = linhaIni;

        do {
            if (host.queryStringAt(linhaAtual, posIniTextoOpcao, opcao)) {
                host.setStringAt(linhaAtual, posX, "X");

                try {
                    Integer fkey = Integer.parseInt(keySelecionar);
                    host.sendPFKeyWait(fkey, mainFrame.getTimeout());
                } catch (NumberFormatException ex) {
                    host.sendEnterKeyWait(mainFrame.getTimeout());
                }
                return;
            }

            linhaAtual++;

            if (linhaAtual >= linhaFim) {
                host.sendPFKeyWait(pfKey, mainFrame.getTimeout());

                if (host.queryStringAt(linhaMsg, colMsg, msgFinal)) {
                    break;
                }

                linhaAtual = linhaIni;
            }
        } while (!host.getScreenContentAt(linhaAtual, posIniTextoOpcao, 1).trim().isEmpty());

        try {
            Integer fkey = Integer.parseInt(keyRetornar);
            host.sendPFKeyWait(fkey, mainFrame.getTimeout());
        } catch (NumberFormatException ex) {
            host.sendEnterKeyWait(mainFrame.getTimeout());
        }

        throw new OpcaoSuspensaNaoEncontradaException(opcao);
    }

    /**
     * Função para acesso a telas do SAC.
     *
     * @param nomeTela Nome da tela a ser acessada.
     * @param comando Coordenadas do CMD (Ex.: '1,2,IG') e comando a ser
     * executado no mainframe.
     * @param codTela Codigo da tela para ser validado após a execução do
     * comando.
     * @throws MainFrameException Caso não seja possível chegar a tela atraves
     * do comando executado.
     */
    protected void acessaTela(String nomeTela, String comando, String codTela) throws MainFrameException {
        log.debug("Acessando tela " + nomeTela);

        sendF2();

        host.setStringAt(comando);
        sendEnter();

        verificaTela(codTela, nomeTela);
    }

    public String mensagemSAC() {
        return host.getScreenContentAt(mensagemSAC).trim();
    }

    /**
     * Função para pegar o codigo das telas do SAC.
     *
     * @return o código da tela atual
     * @since 1.0.2
     */
    public String getCodigoTela() {
        log.debug("Pegando código da tela.");

        String[] codsTela = host.getScreenContentAt(4, 65, 16).trim().split(" ");

        if (codsTela.length > 0) {
            return codsTela[codsTela.length - 1];
        } else {
            return "";
        }
    }
}
