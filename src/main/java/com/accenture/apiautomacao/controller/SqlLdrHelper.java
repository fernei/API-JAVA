package com.accenture.apiautomacao.controller;


import com.accenture.apiautomacao.exception.sqlLdr.InstalacaoException;
import static com.accenture.apiautomacao.logger.LogTrace.log;
import com.accenture.apiautomacao.model.SqlLdrModel;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * Classe responsável pelas operações do SqlLdrModel.
 *
 * @author fernando.m.souza
 * @since 1.0.0
 */
public class SqlLdrHelper {

    /**
     * Verifica se o SQL Loader está instalado na máquina
     *
     * @return o valor de saída do subprocesso representado pelo Object Process.
     * Por convenção, o valor <i>0</i> indica um encerramento normal.
     * @throws InstalacaoException Caso o SQL Loader não esteja instalado na
     * máquina.
     * @since 1.0.0
     */
    private static int isSQLLDR() throws InstalacaoException {

        Process proc = null;

        try {
            String sqlldrCmd = "sqlldr";
            Runtime rt = Runtime.getRuntime();
            proc = rt.exec(sqlldrCmd);
            proc.waitFor();
        } catch (IOException | InterruptedException ex) {
            throw new InstalacaoException("SQL Loader não instalado ou com error na instalação, favor entrar em contato com o TI Responsável");
        }

        return proc.exitValue();

    }

    /**
     * Executa carga no Banco de Dados via SQL Loader.
     *
     * @param sqlldr Model utilizado para enviar os dados do SqlLdrModel e os
     * Dados de conexão.
     * @throws InstalacaoException Caso o SQL Loader não esteja instalado na
     * máquina.
     * @since 1.0.0
     */
    public static void executar(final SqlLdrModel sqlldr) throws InstalacaoException {
        log.info("Iniciando carga via SQL Loader.");

        if (isSQLLDR() == 0) {
            FileFilter filter = new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return file.getName().endsWith(sqlldr.getTipoArquivoOrigem());
                }
            };

            File dir = new File(sqlldr.getDirArquivoOrigem());
            File arquivos[] = dir.listFiles(filter);

            for (int i = 0; i < arquivos.length; i++) {
                try {
                    log.info("Realizando carga do arquivo: " + arquivos[i].getName());

                    String sqlldrCmd = "sqlldr " + sqlldr.getBanco().getUsuario() + "/" + sqlldr.getBanco().getSenha() + "@\\\"\\(DESCRIPTION=\\(ADDRESS=\\(PROTOCOL=TCP\\)\\(HOST=" + sqlldr.getBanco().getIp() + "\\)\\(PORT=" + sqlldr.getBanco().getPorta() + "\\)\\)\\(CONNECT_DATA=\\(SERVICE_NAME=" + sqlldr.getBanco().getSid() + "\\)\\)\\)\\\" data='" + arquivos[i] + "' control='" + sqlldr.getCaminhoCTL() + sqlldr.getArquivoCTL() + "' discard='" + sqlldr.getCaminhoCTL() + arquivos[i].getName().replace(".txt", ".dis") + "' bad='" + sqlldr.getCaminhoCTL() + arquivos[i].getName().replace(".txt", ".bad") + "' log='" + sqlldr.getCaminhoCTL() + arquivos[i].getName().replace(".txt", ".log") + "' parallel=true silent=feedback";

                    Runtime rt = Runtime.getRuntime();
                    Process proc = rt.exec(sqlldrCmd);
                    proc.waitFor();

                    if (proc.exitValue() != 0) {
                        log.error("Erro no SQL Loader para o arquivo " + arquivos[i].getName().replaceAll(sqlldr.getTipoArquivoOrigem(), ""));
                    }
                } catch (IOException | InterruptedException ex) {
                    log.error("Erro na execução do SQL Loader: " + ex.getMessage());
                }
            }

            log.info("Carga finalizada!");
        }
    }
}
