package com.accenture.apiautomacao.controller;

import com.accenture.apiautomacao.exception.md5.DivergenciaMD5Exception;
import com.accenture.apiautomacao.exception.md5.GeraMD5Exception;
import com.accenture.apiautomacao.model.ControleExecucao;
import com.accenture.apiautomacao.model.SistemaModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe responsável pela criação de valores MD5.
 *
 * @author fernando.m.souza
 * @since 1.0
 */
public class MD5Helper {

    /**
     * Gera um valor MD5 para a <b>String</b> informada.
     *
     * @param id string que será transformada em MD5
     * @return código MD5 da string enviada
     * @since 1.0.0
     */
    public static String geraMD5(String id) throws GeraMD5Exception {

        StringBuffer sb = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(id.getBytes());
            byte[] digest = md.digest();
            sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
        } catch (NoSuchAlgorithmException ex) {
            throw new GeraMD5Exception("Erro ao gerar MD5", ex);
        }

        return sb.toString();
    }

    /**
     * Gera um valor MD5 para o <b>File</b> informado.
     *
     * @param f File para o qual será gerado o MD5
     * @return String que representa o valor MD5 do arquivo passado por
     * parametro
     * @throws GeraMD5Exception
     * @since 1.0.0
     */
    public static String geraMD5(File f) throws GeraMD5Exception {

        String output = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            InputStream is = new FileInputStream(f);
            byte[] buffer = new byte[8192];
            int read = 0;

            try {
                while ((read = is.read(buffer)) > 0) {
                    digest.update(buffer, 0, read);
                }
                byte[] md5sum = digest.digest();
                BigInteger bigInt = new BigInteger(1, md5sum);
                output = bigInt.toString(16);
            } catch (IOException e) {
                throw new GeraMD5Exception("Não foi possivel processar o arquivo.", e);
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new GeraMD5Exception("Não foi possivel fechar o arquivo", e);
                }
            }

        } catch (NoSuchAlgorithmException | FileNotFoundException ex) {
            throw new GeraMD5Exception("Erro ao gerar MD5", ex);
        }

        return output;
    }

    /**
     *
     * @param nomeJar Nome do arquivo .JAR que será validado.
     * @param nomeLib Nome do arquivo .JAR a ser procurado na pasta lib.
     * @param controleExec Controlador de execução do processo.
     * @throws DivergenciaMD5Exception Retorno caso o MD5 do arquivo .JAR seja
     * diferente do cadastrado no banco na tabela CONTROLE_PROCESSO.
     * @since 1.1.0
     */
    public static void validaMD5(String nomeJar, String nomeLib, ControleExecucao controleExec) throws DivergenciaMD5Exception {

        SistemaModel model = new SistemaHelper(SistemaHelper.getUserDir() + "\\" + nomeJar).getModel();
        controleExec.setNomeScript(nomeJar);
        controleExec.setVersaoMD5(model.getMd5());
        controleExec.setNomeLib(nomeLib);
        controleExec.setVersaoMD5Lib(model.getMD5Lib(nomeLib));

        controleExec.alterar(controleExec);

        if (controleExec.getNomeProcesso().getMd5() == null
                || !controleExec.getNomeProcesso().getMd5().equals(controleExec.getVersaoMD5())) {
            throw new DivergenciaMD5Exception("MD5 divergente entre as tabelas CONTROLE_PROCESSO e CONTROLE_EXECUCAO.");
        }
    }

}
