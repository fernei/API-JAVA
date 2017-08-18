package com.accenture.apiautomacao.controller;


import static com.accenture.apiautomacao.logger.LogTrace.log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Classe responsável por toda a utilização de arquivos ZIP.
 *
 * @author fernando.m.souza
 * @since 1.0.0
 */
public class ZipHelper {

    /**
     * Zipa um arquivo.
     *
     * @param files Conjunto de arquivos a serem zipados.
     * @param outputFile Arquivo destino para o zip.
     * @since 1.0.0
     */
    @SuppressWarnings("null")
    public void zip(File[] files, File outputFile) {

        if (files != null && files.length > 0) {
            ZipOutputStream out = null;
            try {
                out = new ZipOutputStream(new FileOutputStream(outputFile));
                Stack<File> parentDirs = new Stack<>();
                zipFiles(parentDirs, files, out);
                out.close();
            } catch (FileNotFoundException ex) {
                log.info(ZipHelper.class.getName() + ": Erro ao Zipar Arquivos " + ex);
            } catch (IOException ex) {
                log.info(ZipHelper.class.getName() + ": Erro ao Zipar Arquivos " + ex);
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    log.info(ZipHelper.class.getName() + ": Erro ao Zipar Arquivos " + ex);
                }
            }
        }
    }

    @SuppressWarnings("null")
    private void zipFiles(Stack<File> parentDirs, File[] files,
            ZipOutputStream out) {

        byte[] buf = new byte[1024];

        for (File file : files) {
            if (file.isDirectory()) {
                //se a entrada é um diretório, empilha o diretório e 
                //chama o mesmo método recursivamente
                parentDirs.push(file);
                zipFiles(parentDirs, file.listFiles(), out);
                //após processar as entradas do diretório, desempilha
                parentDirs.pop();
            } else {
                FileInputStream in = null;
                try {
                    in = new FileInputStream(file);
                    //itera sobre os itens da pilha para montar o caminho
                    //completo do arquivo
                    String path = "";
                    for (File parentDir : parentDirs) {
                        path += parentDir.getName() + "/";
                    }   //grava os dados no arquivo zip
                    out.putNextEntry(new ZipEntry(path + file.getName()));
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                    out.closeEntry();
                    in.close();
                } catch (IOException ex) {
                    log.info(ZipHelper.class.getName() + ": Erro ao zipar arquivos " + ex);
                } finally {
                    try {
                        in.close();
                    } catch (IOException ex) {
                        log.info(ZipHelper.class.getName() + ": Erro ao zipar arquivos " + ex);
                    }
                }
            }
        }
    }

    /**
     * Descompacta um arquivo zip.
     *
     * @param zipFile Arquivo a ser descompactado.
     * @param dir Diretório destino para os arquivos.
     * @since 1.0.0
     */
    public void unzip(File zipFile, File dir) {
        ZipFile zip = null;
        File arquivo;
        InputStream is = null;
        OutputStream os = null;
        byte[] buffer = new byte[1024];

        try {
            // cria diretório informado, caso não exista
            if (!dir.exists()) {
                dir.mkdirs();
            }
            if (!dir.exists() || !dir.isDirectory()) {
                log.info(ZipHelper.class.getName() + ": O diretório " + dir.getName()
                        + " não é um diretório válido");
                throw new IOException("O diretório " + dir.getName() + " não é um diretório válido");
            }

            zip = new ZipFile(zipFile);
            Enumeration e = zip.entries();
            while (e.hasMoreElements()) {
                ZipEntry entrada = (ZipEntry) e.nextElement();
                arquivo = new File(dir, entrada.getName());

                // se for diretório inexistente, cria a estrutura e pula 
                // pra próxima entrada
                if (entrada.isDirectory() && !arquivo.exists()) {
                    arquivo.mkdirs();
                    continue;
                }

                // se a estrutura de diretórios não existe, cria
                if (!arquivo.getParentFile().exists()) {
                    arquivo.getParentFile().mkdirs();
                }
                try {
                    // lê o arquivo do zip e grava em disco
                    is = zip.getInputStream(entrada);
                    os = new FileOutputStream(arquivo);
                    int bytesLidos;

                    if (is == null) {
                        log.info(ZipHelper.class.getName() + ": Erro ao ler a entrada do zip: " + entrada.getName());
                        throw new ZipException("Erro ao ler a entrada do zip: " + entrada.getName());
                    }

                    while ((bytesLidos = is.read(buffer)) > 0) {
                        os.write(buffer, 0, bytesLidos);
                    }
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                }
            }
        } catch (IOException ex) {
            log.info(ZipHelper.class.getName() + ": Erro ao extrair arquivos " + ex);
        } finally {
            if (zip != null) {
                try {
                    zip.close();
                } catch (Exception e) {
                    log.info(ZipHelper.class.getName() + ": Erro ao extrair arquivos " + e);
                }
            }
        }
    }
}
