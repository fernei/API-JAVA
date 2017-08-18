package com.accenture.apiautomacao.logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import sun.rmi.runtime.Log;

/**
 * Classe responsável por toda a parte de LOGs do Sistema.
 *
 * @author fernando.m.souza
     * @since 1.0.0
  */
public class LogTrace {

    private static String strTraceFile;

    public static Logger log;

    private static final PatternLayout LAYOUTINFO = new PatternLayout("[%d{dd/MM/yyyy HH:mm:ss.SSS}] [%p] - %m%n");
    private static final PatternLayout LAYOUTERRO = new PatternLayout("[%d{dd/MM/yyyy HH:mm:ss.SSS}] [%p] {%C.%M() %L} [%t] - %m%n");
    private static final PatternLayout LAYOUTDEBUG = new PatternLayout("[%d{dd/MM/yyyy HH:mm:ss.SSS}] [%p] {%C.%M() %L} [%t] - %m%n");

    private static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyyMMdd");

    /**
     * Cria o <b>Logger</b> efetivamente.
     *
     * @since 1.0.0
     */
    synchronized static void criarLog() {
        log = Logger.getLogger("Log");
    }

    /**
     * Cria o arquivo de Log e seta todas as suas dependêcias.
     *
     * @param texto Nome para o arquivo de Log. Esse nome é um sufixo para o
     * padrão já definido.
     * @since 1.0.0
     */
    public static void criarArquivoLog(String texto) {
        try {
            strTraceFile = "log/LOG_" + DATEFORMAT.format(new java.util.Date(System.currentTimeMillis())) + "_" + texto + ".log";

            FileAppender appenderLog;
            appenderLog = new FileAppender(LAYOUTINFO, strTraceFile, true);
            appenderLog.setName("logAppender");
            appenderLog.setThreshold(Priority.INFO);

            criarLog();
            log.addAppender(appenderLog);
        } catch (IOException ex) {
            log.info("Erro na parametrização do LOG");
            log.error(ex.getMessage());
        }
    }

    /**
     * Seta um nível de escrita para o Log.
     *
     * @param nivel Novo nível de LOG.
     * @since 1.0.0
     */
    public static void setaNivelLog(int nivel) {
        switch (nivel) {
            case 2:
                ((FileAppender) log.getAppender("logAppender")).setThreshold(Priority.INFO);
                ((FileAppender) log.getAppender("logAppender")).setLayout(LAYOUTERRO);
                break;
            case 3:
                ((FileAppender) log.getAppender("logAppender")).setThreshold(Priority.DEBUG);
                ((FileAppender) log.getAppender("logAppender")).setLayout(LAYOUTDEBUG);
                break;
            default:
                ((FileAppender) log.getAppender("logAppender")).setThreshold(Priority.INFO);
                ((FileAppender) log.getAppender("logAppender")).setLayout(LAYOUTINFO);
                break;
        }
    }

    /**
     * Recupera o path e o nome do arquivo de log definido pelo sistema.
     *
     * @return Path e Nome do arquivo de log.
     * @since 1.0.0
     */
    public static String getLogFile() {
        return strTraceFile;
    }

    /**
     * Remove o arquivo passado por parametro
     *
     * @param fileName Nome (path) do arquivo a ser deletado.
     * @since 1.0.0
     */
    public static void removeFile(String fileName) {
        File f = new File(fileName);
        f.delete();
    }

//    public void removeAppenders() {
//        log.removeAllAppenders();
//    }
    /**
     * Grava dados no arquivo .log
     *
     * @param className Nome da classe onde o metodo está sendo chamado.
     * @param mensagem Texto que será inserido no arquivo de log
     * @param ex Exception gerada pelo erro.
     * @param nivelLog Nivel que será gravada a mensagem
     * (1-Info,2-Error,3-Debug).
     * @since 1.0.0
     */
    public static void gravaLog(Class className, String mensagem, Exception ex, int nivelLog) {
        gravaLog(className, mensagem + ": " + ex.getMessage(), nivelLog);
    }

    /**
     * Grava dados no arquivo .log
     * <p>
     * Default "log.info"
     *
     * @param className Nome da classe onde o metodo está sendo chamado.
     * @param mensagem Texto que será inserido no arquivo de log
     * @param nivelLog Nivel que será gravada a mensagem
     * (1-Info,2-Error,3-Debug).
     * @since 1.0.0
     */
    public static void gravaLog(Class className, String mensagem, int nivelLog) {

        switch (nivelLog) {
            case 1:
                log.info(className.getSimpleName() + ": " + mensagem);
                break;
            case 2:
                log.error(className.getSimpleName() + ": " + mensagem);
                break;
            case 3:
                log.debug(className.getSimpleName() + ": " + mensagem);
                break;
            default:
                log.info(className.getSimpleName() + ": " + mensagem);
                break;
        }

    }

}
