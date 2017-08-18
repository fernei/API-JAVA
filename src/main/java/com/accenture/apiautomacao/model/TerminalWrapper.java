package com.accenture.apiautomacao.model;

import com.accenture.apiautomacao.exception.mainframe.RcNegativoException;
import static com.accenture.apiautomacao.logger.LogTrace.log;
import com.accenture.apiautomacao.view.TelaMainFrame;
import pw3270.*;

/**
 * Classe Wrapper responável por toda a interação com um terminal.
 *
 * @author otavio.c.ferreira
 * @since 1.0.0
 */
public class TerminalWrapper {

    private final TelaMainFrame tela = new TelaMainFrame();
    private final terminal host;

    private boolean exibeTelaSAC;
    private int nivelLog;

    private int rcNumerico;
    private String rcTexto;

    public TerminalWrapper() {
        rcNumerico = 0;
        rcTexto = "";
        host = new terminal();
    }

    public void setRcNumerico(int rcNumerico) throws RcNegativoException {
        if (rcNumerico != 0) {
            log.error("Erro de RC Negativo!");
            throw new RcNegativoException();
        }

        this.rcNumerico = rcNumerico;
    }

    /**
     * Seta novo título para a Tela.
     *
     * @param titulo Valor a ser utilizado como título da Tela.
     * @since 1.0.0
     */
    public void setTitleTelaSAC(String titulo) {
        tela.setTitle(titulo);
    }

    /**
     * Pega último retorno numérico da aplicação.
     *
     * @return último retorno numérico da aplicação.
     * @since 1.0.0
     */
    public int getRcNumerico() {
        return rcNumerico;
    }

    /**
     * Pega último retorno texto da aplicação.
     *
     * @return último retorno texto da aplicação.
     * @since 1.0.0
     */
    public String getRcTexto() {
        return rcTexto;
    }

    /**
     * Pega a versão da aplicação.
     *
     * @return A versão da aplicação.
     * @since 1.0.0
     */
    public String getVersion() {
        rcTexto = host.getVersion();
        log.debug("[RC=" + rcTexto + "] {getVersion}");
        return rcTexto;
    }

    /**
     * Pega a revisão da aplicação.
     *
     * @return A revisão da aplicação.
     * @since 1.0.0
     */
    public String getRevision() {
        rcTexto = host.getRevision();
        log.debug("[RC=" + rcTexto + "] {getRevision}");
        return rcTexto;
    }

    /**
     * Conecta a aplicação.
     *
     * @param string Hostname/IP do servidor da aplicação.
     * @param i Timeout para a conexão.
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int Connect(String string, int i) throws RcNegativoException {
        setRcNumerico(host.Connect(string, i));
        log.debug("[RC=" + rcNumerico + "] {Connect(" + string + "," + i + ")}");
        return rcNumerico;
    }

    /**
     * Conecta a aplicação.
     *
     * @param string Hostname/IP do servidor da aplicação.
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int Connect(String string) throws RcNegativoException {
        setRcNumerico(host.Connect(string));
        log.debug("[RC=" + rcNumerico + "] {Connect(" + string + ")}");
        return rcNumerico;
    }

    /**
     * Desconect da Aplicação.
     *
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int Disconnect() throws RcNegativoException {
        setRcNumerico(host.Disconnect());
        log.debug("[RC=" + rcNumerico + "] {Disconnect}");
        tela.setVisible(false);
        return rcNumerico;
    }

    /**
     * Pega o estado da conexão com a aplicação.
     *
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int getConnectionState() throws RcNegativoException {
        setRcNumerico(host.getConnectionState());
        log.debug("[RC=" + rcNumerico + "] {getConnectionState}");
        return rcNumerico;
    }

    /**
     * Verifica se existe uma conexão ativa com a Aplicação.
     *
     * @return Um código de retorno da Aplicação.
     * @since 1.0.0
     */
    public boolean isConnected() {
        if (host.isConnected()) {
            log.debug("[RC=true] {isConnected}");
            return true;
        } else {
            log.debug("[RC=false] {isConnected}");
            return false;
        }
    }

    /**
     * Wrapper da função <b>isConnected()</b>. Valida de uma forma mais
     * abrangente se existe uma conexão ativa. Essa validação é realizada
     * através do envio do comando <b>F3</b>, e dependendo do retorno,
     * descobrimos se a conexão está ou não ativa.
     *
     * Essa necessidade surgiu pos a função <b>isConnected()</b>
     * pode apresentar problemas.
     *
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public boolean checarConexao() throws RcNegativoException {
        if (host.isConnected()) {
            sendPFKey(3);

            if (waitForTerminalReady(10) >= 0) {
                log.debug("[RC=true] {isConnected}");
                return true;
            } else {
                log.debug("[RC=false] {isConnected}");
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Verifica se o terminal da aplicação está pronto para receber novos
     * comandos.
     *
     * @return Um código de retorno da Aplicação.
     * @since 1.0.0
     */
    public boolean isTerminalReady() {
        if (host.isTerminalReady()) {
            log.debug("[RC=true] {isTerminalReady}");
            return true;
        } else {
            log.debug("[RC=false] {isTerminalReady}");
            return false;
        }
    }

    /**
     * Pega o Encoding utilizado pela Aplicação.
     *
     * @return Um código de retorno da Aplicação.
     * @since 1.0.0
     */
    public String getEncoding() {
        rcTexto = host.getEncoding();
        log.debug("[RC.length()=" + rcTexto.length() + "] {getEncoding}");
        return rcTexto;
    }

    /**
     * Pega uma informação na tela da aplicação utilizando 3 coordenadas.
     *
     * @param i Linha
     * @param i1 Coluna
     * @param i2 Quantidade de caracteres.
     * @return Um código de retorno da Aplicação.
     * @since 1.0.0
     */
    public String getScreenContentAt(int i, int i1, int i2) {
        rcTexto = host.getScreenContentAt(i, i1, i2);
        log.debug("[RC=" + rcTexto + "] {getScreenContentAt(" + i + "," + i1 + "," + i2 + ")}");
        return rcTexto;
    }

    /**
     * Pega uma informação na tela da aplicação utilizando uma String com 3
     * coordenadas. Exemplo da String: linha,coluna,quantidade => "3,4,5"
     *
     * @param string String que contêm as coordenadas necessárias para encontrar
     * o valor.
     * @return Um código de retorno da Aplicação.
     * @since 1.0.0
     */
    public String getScreenContentAt(String string) {
        String[] parts = string.split(",");
        rcTexto = host.getScreenContentAt(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));

        log.debug("[RC=" + rcTexto + "] {getScreenContentAt(" + parts[0] + "," + parts[1] + "," + parts[2] + ")}");
        return rcTexto;
    }

    /**
     * Pega todo o conteúdo da tela da Aplicação.
     *
     * @return Um código de retorno da Aplicação.
     * @since 1.0.0
     */
    public String getScreenContent() {
        rcTexto = host.getScreenContent();
        log.debug("[RC.length()=" + rcTexto.length() + "] {getScreenContent}");
        return rcTexto;
    }

    /**
     * Imprime, tanto no <b>LOG</b> quanto no <b>CONSOLE</b>, todas as
     * informações da Tela.
     *
     * @since 1.0.0
     */
    public void printScreenContent() {
        System.out.println(host.getScreenContent());
        log.debug("[\n" + host.getScreenContent() + "\n]");

        if (exibeTelaSAC) {
            tela.jTextArea_Log.setText(host.getScreenContent());
            tela.setVisible(true);
        }
    }

    /**
     * Pega uma informação na tela da aplicação utilizando uma String com 2
     * coordenadas e um texto a ser procurado. Exemplo da String:
     * linha,coluna,texto => "3,4,'texto'"
     *
     * @param string Texto procurado
     * @return Retorna <b>TRUE</b> caso o texto seja encontrado na posição
     * informada
     * @since 1.0.0
     */
    public boolean queryStringAt(String string) {
        String[] parts = string.split(",");
        return queryStringAt(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2]);
    }

    /**
     * Procura por um texto em uma posição X e Y de linha e coluna específica.
     *
     * @param i Linha
     * @param i1 Coluna
     * @param string Texto procurado
     * @return Retorna <b>TRUE</b> caso o texto seja encontrado na posição
     * informada
     * @since 1.0.0
     */
    public boolean queryStringAt(int i, int i1, String string) {
        return host.queryStringAt(i, i1, string);
    }

    /**
     * Procura por um texto dentro de uma linha informada.
     *
     * @param i Linha
     * @param string Texto procurado
     * @return Retorna <b>TRUE</b> caso o texto seja encontrado na linha
     * informada
     * @since 1.0.0
     */
    public boolean queryStringAt(int i, String string) {
        return host.getScreenContentAt(i, 1, 80).contains(string);
    }

    /**
     * Envia o comando <b>ENTER</b> para a Aplicação.
     *
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int sendEnterKey() throws RcNegativoException {
        setRcNumerico(host.sendEnterKey());
        log.debug("[RC=" + rcNumerico + "] {sendEnterKey}");

        printScreenContent();

        return rcNumerico;
    }

    /**
     * Envia o comando <b>ENTER</b> para a Aplicação, e aguarda o seu retorno
     * com timeout.
     *
     * @param secs Timeout para aguardar.
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int sendEnterKeyWait(int secs) throws RcNegativoException {
        setRcNumerico(host.sendEnterKey());
        log.debug("[RC=" + rcNumerico + "] {sendEnterKey}");

        setRcNumerico(host.waitForTerminalReady(secs));

        log.debug("[RC=" + rcNumerico + "] {waitForTerminalReady(" + secs + ")}");
        printScreenContent();

        return rcNumerico;
    }

    /**
     * Envia o comando <b>F</b>i para a Aplicação.
     *
     * @param i Número de referencia para o comando.
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int sendPFKey(int i) throws RcNegativoException {
        setRcNumerico(host.sendPFKey(i));
        log.debug("[RC=" + rcNumerico + "] {sendPFKey(" + i + ")}");

        printScreenContent();
        return rcNumerico;
    }

    /**
     * Envia o comando <b>F</b>i para a Aplicação, e aguarda o seu retorno com
     * timeout.
     *
     * @param i Número de referencia para o comando.
     * @param secs Timeout para aguardar.
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int sendPFKeyWait(int i, int secs) throws RcNegativoException {
        setRcNumerico(host.sendPFKey(i));
        log.debug("[RC=" + rcNumerico + "] {sendPFKey(" + i + ")}");

        setRcNumerico(host.waitForTerminalReady(secs));
        log.debug("[RC=" + rcNumerico + "] {waitForTerminalReady(" + secs + ")}");

        printScreenContent();
        return rcNumerico;
    }

    /**
     * Informa um valor em uma posição de Tela.
     *
     * @param i Linha
     * @param i1 Coluna
     * @param string Texto a ser informado
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int setStringAt(int i, int i1, String string) throws RcNegativoException {
        setRcNumerico(host.setStringAt(i, i1, string));
        log.debug("[RC=" + rcNumerico + "] {setStringAt(" + i + "," + i1 + "," + string + ")}");

        printScreenContent();
        return rcNumerico;
    }

    /**
     * Informa um valor em uma posição de Tela utilizando uma <b>String</b>
     * com 2 coordenadas e um valor. Exemplo de String: i,j,z => "3,4,'texto'"
     *
     * @param string Sring com os parametros.
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int setStringAt(String string) throws RcNegativoException {
        String[] parts = string.split(",");
        setRcNumerico(host.setStringAt(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2]));
        log.debug("[RC=" + rcNumerico + "] {setStringAt(" + Integer.parseInt(parts[0]) + "," + Integer.parseInt(parts[1]) + "," + parts[2] + ")}");

        printScreenContent();
        return rcNumerico;
    }

    /**
     * Informa um valor em uma posição de Tela utilizando uma <b>String</b>
     * com 2 coordenadas, e um parametro com o valor. Exemplo de String: i,j =>
     * "3,4"
     *
     * @param string String com as coordenadas
     * @param valor Texto a ser inserido na posição.
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int setStringAt(String string, String valor) throws RcNegativoException {
        String[] parts = string.split(",");
        setRcNumerico(host.setStringAt(Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim()), valor));
        log.debug("[RC=" + rcNumerico + "] {setStringAt(" + Integer.parseInt(parts[0].trim()) + "," + Integer.parseInt(parts[1].trim()) + "," + valor + ")}");

        printScreenContent();
        return rcNumerico;
    }

    /**
     * Informa um valor em uma posição de Tela utilizando uma <b>String</b>
     * com 2 coordenadas, e um parametro com o valor. Exemplo de String: i,j =>
     * "3,4"
     *
     * @param string String com as coordenadas
     * @param valor Número a ser inserido na posição.
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int setStringAt(String string, Integer valor) throws RcNegativoException {
        String[] parts = string.split(",");
        setRcNumerico(host.setStringAt(Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim()), valor.toString()));
        log.debug("[RC=" + rcNumerico + "] {setStringAt(" + Integer.parseInt(parts[0].trim()) + "," + Integer.parseInt(parts[1].trim()) + "," + valor.toString() + ")}");

        printScreenContent();
        return rcNumerico;
    }

    /**
     * Informa uma senha para campos de Senha na Aplicação.
     *
     * @param i Linha
     * @param i1 Coluna
     * @param string Senha
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int setStringAtPassword(int i, int i1, String string) throws RcNegativoException {
        setRcNumerico(host.setStringAt(i, i1, string));
        log.debug("[RC=" + rcNumerico + "] {setStringAtPassword(" + i + "," + i1 + ",******)}");
        return rcNumerico;
    }

    /**
     * Aguarda a aplicação retornar.
     *
     * @param i Timeout
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int wait(int i) throws RcNegativoException {
        setRcNumerico(host.wait(i));
        log.debug("[RC=" + rcNumerico + "] {wait(" + i + ")}");
        return rcNumerico;
    }

    /**
     * Aguarda a aplicação retornar.
     *
     * @param i Timeout
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int waitForTerminalReady(int i) throws RcNegativoException {
        setRcNumerico(host.waitForTerminalReady(i));
        log.debug("[RC=" + rcNumerico + "] {waitForTerminalReady(" + i + ")}");
        return rcNumerico;
    }

    /**
     * Aguarda a aplicação retornar.
     * <i>NO_ERROR</i> ainda não implementado.
     *
     * @param i Timeout
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int waitForTerminalReady_NoError(int i) throws RcNegativoException {
        setRcNumerico(host.waitForTerminalReady(i));
        log.debug("[RC=" + rcNumerico + "] {waitForTerminalReady(" + i + ")}");
        return rcNumerico;
    }

    /**
     * Aguarda um texto aparecer na tela em uma posição específica.
     *
     * @param i Linha
     * @param i1 Coluna
     * @param string Texto esperado
     * @param i2 Timeout
     * @return Um código de retorno da Aplicação.
     * @exception RcNegativoException Erro de conexão com o Mainframe.
     * @since 1.0.0
     */
    public int waitForStringAt(int i, int i1, String string, int i2) throws RcNegativoException {
        setRcNumerico(host.waitForStringAt(i, i1, string, i2));
        log.debug("[RC=" + rcNumerico + "] {waitForStringAt(" + i + "," + i1 + "," + string + "," + i2 + ")}");
        return rcNumerico;
    }

    /**
     * Retorna se a Tela está visível.
     *
     * @return Um código de retorno da Aplicação.
     * @since 1.0.0
     */
    public boolean isExibeTelaSAC() {
        return exibeTelaSAC;
    }

    /**
     * Informa se a Tela será visível.
     *
     * @param exibeTelaSAC Valor para definir a visibilidade.
     * @since 1.0.0
     */
    public void setExibeTelaSAC(boolean exibeTelaSAC) {
        this.exibeTelaSAC = exibeTelaSAC;
    }

    /**
     * Pega o nível atual do LOG.
     *
     * @return O nível do LOG.
     * @since 1.0.0
     */
    public int getNivelLog() {
        return nivelLog;
    }

    /**
     * Seta um novo nível para o LOG.
     *
     * @param nivelLog Novo nível para o LOG.
     * @since 1.0.0
     */
    public void setNivelLog(int nivelLog) {
        this.nivelLog = nivelLog;
    }

}
