package com.accenture.apiautomacao.controller;


import com.accenture.apiautomacao.exception.ftp.CloseException;
import com.accenture.apiautomacao.exception.ftp.ConnectException;
import com.accenture.apiautomacao.exception.ftp.DownloadFileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import com.accenture.apiautomacao.model.FTPModel;
import org.apache.commons.net.ftp.FTPClient;
import com.accenture.apiautomacao.exception.ftp.UploadFileException;
import static com.accenture.apiautomacao.logger.LogTrace.log;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.net.ftp.FTPFile;

/**
 * Classe responsável por controlar a utilização de um FTP.
 *
 * @author fernando.m.souza
 * @since 1.0.0
 */
public class FTPHelper {

    private final FTPClient ftpClient = new FTPClient();

    /**
     * Responsável por realizar Upload de um arquivo.
     *
     * @param ftp Model do ftp, possui os dados para realizar o Upload do
     * arquivo.
     * @param nomeArq Nome do arquivo a ser transferido.
     * @throws UploadFileException não foi possível transferir o arquivo.
     * @since 1.0.0
     */
    @SuppressWarnings("null")
    public void uploadFile(FTPModel ftp) throws UploadFileException {
        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream(new File(ftp.getPastaLocal() + "\\" + ftp.getNomeArquivoLocal()));
            log.info("Iniciando upload do arquivo.");

            ftpClient.changeWorkingDirectory(ftp.getPastaFTP());

            if (ftpClient.storeFile(ftp.getNomeArquivoFTP(), inputStream)) {
                log.info("Upload executado com sucesso.");
            } else {
                throw new UploadFileException("Não realizou o upload, verifique a existência dos arquivos." + ftpClient.getReplyCode());
            }
        } catch (IOException ex) {
            throw new UploadFileException("Erro ao transmitir arquivo", ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                throw new UploadFileException("Erro ao liberar o arquivo", ex);
            }
        }
    }

    /**
     * Responsável por realizar Download de um arquivo.
     *
     * @param ftp Model do ftp, possui os dados para realizar o Download do
     * arquivo.
     * @param nomeArq Nome do arquivo a ser baixado.
     * @throws DownloadFileException Não foi possível baixar o arquivo.
     * @since 1.0.0
     */
    @SuppressWarnings("null")
    public void downloadFile(FTPModel ftp) throws DownloadFileException {
        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(new File(ftp.getPastaLocal() + "\\" + ftp.getNomeArquivoLocal()));
            log.info("Iniciando download do arquivo.");

            ftpClient.changeWorkingDirectory(ftp.getPastaFTP());

            if (ftpClient.retrieveFile(ftp.getNomeArquivoFTP(), outputStream)) {
                log.info("Download executado com sucesso.");
            } else {
                throw new DownloadFileException("Não realizou o download, verifique a existência dos arquivos.");
            }
        } catch (IOException ex) {
            throw new DownloadFileException("Erro ao baixar arquivo", ex);
        } finally {
            try {
                outputStream.close();
            } catch (IOException ex) {
                throw new DownloadFileException("Erro ao liberar o arquivo", ex);
            }
        }
    }

    /**
     * Realiza conexão com o servidor FTP.
     *
     * @param ftp Model do ftp, possui os dados para realizar o Upload do
     * arquivo e a conexão com o servidor FTP.
     * @throws ConnectException Não foi poss[ivel se conectar com o FTP.
     * @since 1.0.0
     */
    public void connect(FTPModel ftp) throws ConnectException {
        try {
            ftpClient.connect(ftp.getServer(), ftp.getPort());
            ftpClient.login(ftp.getUser(), ftp.getPass());
//            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        } catch (IOException ex) {
            throw new ConnectException("Erro ao conectar no FTP" + ex);
        }
    }

    /**
     * Fecha a conexão com o servidor FTP
     *
     * @throws CloseException Não foi possível se desconectar do FTP.
     * @since 1.0.0
     */
    public void close() throws CloseException {
        try {
            ftpClient.logout();
        } catch (IOException ex) {
            throw new CloseException("Erro ao fechar a conexão do FTP", ex);
        }
    }

    /**
     * Responsável por listar todos os arquivos encontrados na pasta do FTP.
     *
     * @param ftpModel do ftp, possui os dados para realizar o Download do
     * arquivo.
     * @return Uma lista com os nomes dos arquivos.
     * @throws IOException Não foi possível listar os arquivos.
     * @since 1.0.0
     */
    public List<String> listarArquivos(FTPModel ftp) throws IOException {
        try {
            log.info("Listando arquivos da pasta " + ftp.getPastaFTP() + ".");

            ftpClient.changeWorkingDirectory(ftp.getPastaFTP());

            List<String> nomeArqs = new ArrayList<>();

            for (FTPFile file : ftpClient.listFiles()) {
                nomeArqs.add(file.getName());
            }

            return nomeArqs;
        } catch (IOException ex) {
            throw new IOException("Erro ao baixar arquivo", ex);
        }
    }
}
