package com.accenture.apiautomacao.model;


import com.accenture.apiautomacao.controller.MD5Helper;
import com.accenture.apiautomacao.exception.md5.GeraMD5Exception;
import static com.accenture.apiautomacao.logger.LogTrace.log;
import java.io.File;

/**
 *
 * @author fernando.m.souza
 */
public class SistemaModel {

    private String path;
    private String md5;
    private File[] systemLib;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public File[] getSystemLib() {
        return systemLib;
    }

    public void setSystemLib(File[] systemLib) {
        this.systemLib = systemLib;
    }

    public final String getMD5Lib(String libName) {

        File[] libs = this.systemLib;
        for (int i = 0; i < libs.length; i++) {
            if (libs[i].toString().substring(libs[i].toString().lastIndexOf("\\") + 1, libs[i].toString().length()).equalsIgnoreCase(libName)) {
                try {
                    return MD5Helper.geraMD5(new File(libs[i].toString()));
                } catch (GeraMD5Exception ex) {
                    log.info("Erro ao gerar o MD5 da Lib " + libs[i]);
                }
            }
        }

        return null;

    }

}
