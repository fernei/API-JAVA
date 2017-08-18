package com.accenture.apiautomacao.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author fernando.m.souza
 */
public class TextFileHelper {

    private String cache;
    private final String arquivo;
    private BufferedReader arqLeittura;
    private BufferedWriter arqEscrita;

    /**
     * Contrutor da Classe.
     *
     * @param arquivo - String contendo o caminho \ nome do arquivo . extensão
     * @since 1.0.0
     */
    public TextFileHelper(String arquivo) {
        this.arquivo = arquivo;
    }

    /**
     * Abre arquivo para leitura.
     *
     * @throws IOException Não foi possível manipular a informação.
     * @since 1.0.0
     */
    public void abreArquivoLeitura() throws IOException {
        arqLeittura = new BufferedReader(new InputStreamReader(new FileInputStream(this.arquivo)));
    }

    /**
     * Abre o arquivo para escrita.
     *
     * @throws IOException Não foi possível manipular a informação.
     * @since 1.0.0
     */
    public void abreArquivoEscrita() throws IOException {
        arqEscrita = new BufferedWriter(new FileWriter(arquivo));
    }

    /**
     * Lê a próxima linha.
     *
     * @return O conteúdo da linha.
     * @throws IOException Não foi possível manipular a informação.
     * @since 1.0.0
     */
    public final String leProximaLinha() throws IOException {
        return arqLeittura.readLine();
    }

    /**
     * Fecha o arquivo de leitura.
     *
     * @throws IOException Não foi possível manipular a informação.
     * @since 1.0.0
     */
    public void fechaArquivoLeitura() throws IOException {
        arqLeittura.close();
    }

    /**
     * Fecha e salva o arquivo de escrita.
     *
     * @throws IOException Não foi possível manipular a informação.
     * @since 1.0.0
     */
    public void fechaSalvaArquivoEscrita() throws IOException {
        arqEscrita.flush();  // Valida o fluxo
        arqEscrita.close();
    }

    /**
     * Escreve linha no cache.
     *
     * @param texto Texto a ser escrito no cache.
     * @throws IOException Não foi possível manipular a informação.
     * @since 1.0.0
     */
    public void escreveLinhaCache(String texto) throws IOException {
        cache += texto + "\r\n";
    }

    /**
     * Inclui textpo no cache.
     *
     * @param texto Texto a ser incluído no cache.
     * @throws IOException Não foi possível manipular a informação.
     * @since 1.0.0
     */
    public void appendLinhaCache(String texto) throws IOException {
        cache += texto;
    }

    /**
     * Sobrescreve o arquivo de escrita com o texto informado.
     *
     * @param texto Novo conteúdo para o arquivo de escrita.
     * @throws IOException Não foi possível manipular a informação.
     * @since 1.0.0
     */
    public void escreveTextoArquivoEscrita(String texto) throws IOException {
        arqEscrita.write(texto);
    }

    /**
     * Escreve uma linha no arquivo de escrita.
     *
     * @param texto Texto a ser escrito.
     * @throws IOException Não foi possível manipular a informação.
     * @since 1.0.0
     */
    public void escreveLinhaArquivoEscrita(String texto) throws IOException {
        arqEscrita.write(texto + "\r\n");
    }

    /**
     * Escreve e salva um novo arquivo no caminha destino.
     *
     * @param destino Arquivo novo que irá conter o valor do cache.
     * @throws IOException Não foi possível manipular a informação.
     * @since 1.0.0
     */
    public void escreveSalvaCacheArquivoDestino(String destino) throws IOException {
        arqEscrita = new BufferedWriter(new FileWriter(destino));
        arqEscrita.write(cache);
        arqEscrita.flush();
        arqEscrita.close();
    }

    /**
     * Salva o arquivo de escrita.
     *
     * @throws IOException Não foi possível manipular a informação.
     * @since 1.0.0
     */
    public void salvaArquivoEscrita() throws IOException {
        arqEscrita.flush();
    }
}
