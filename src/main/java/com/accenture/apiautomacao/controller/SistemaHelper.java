package com.accenture.apiautomacao.controller;


import com.accenture.apiautomacao.exception.md5.GeraMD5Exception;
import static com.accenture.apiautomacao.logger.LogTrace.log;
import com.accenture.apiautomacao.model.SistemaModel;
import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author fernando.m.souza
 */
public class SistemaHelper {

    private static final String Property_User_Dir = "user.dir";
    private static final String Lib_Folder_Name = "\\lib\\";

    private SistemaModel model;

    public SistemaHelper(String path) {

        model = new SistemaModel();

        try {

            File file = new File(path);
            model.setPath(path);
            model.setMd5(MD5Helper.geraMD5(file));
            model.setSystemLib(getSistemaLib());

        } catch (GeraMD5Exception ex) {
            log.info("Erro ao gerar o MD5 na classe FileHelper " + ex);
        }

    }

    /**
     * Retorna o SistemaModel populado.
     *
     * @return SistemaModel
     */
    public final SistemaModel getModel() {
        return this.model;
    }

    /**
     * Retorna o diretorio onde o sistema está instalado
     *
     * @return String contendo o caminho da instalação do Sistema.
     * @since 1.0.0
     */
    public static final String getUserDir() {
        return System.getProperty(Property_User_Dir);
    }

    /**
     * Retorna as lib´s que estão na pasta LIB onde o sistema está instalado.
     *
     * @return File[] com as lib´s do Sistema.
     */
    public static final File[] getSistemaLib() {

        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return file.getName().endsWith(".jar");
            }
        };
        File dir = new File(getUserDir() + Lib_Folder_Name);
        File[] files = dir.listFiles(filter);

        return files;

    }

}
