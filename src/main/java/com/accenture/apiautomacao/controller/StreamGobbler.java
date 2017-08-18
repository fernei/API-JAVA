package com.accenture.apiautomacao.controller;


import static com.accenture.apiautomacao.logger.LogTrace.log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 *
 * @author otavio.c.ferreira
 */
public class StreamGobbler extends Thread {

    InputStream is;
    String type;
    OutputStream os;

    public StreamGobbler(InputStream is, String type) {
        this(is, type, null);
    }

    public StreamGobbler(InputStream is, String type, OutputStream redirect) {
        this.is = is;
        this.type = type;
        this.os = redirect;
    }

    @Override
    public void run() {
        try {
            PrintWriter pw = null;

            if (os != null) {
                pw = new PrintWriter(os);
            }

            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;

            while ((line = br.readLine()) != null) {
                if (pw != null) {
                    pw.println(line);
                }

                System.out.println(type + ">" + line);
            }

            if (pw != null) {
                pw.flush();
            }
        } catch (IOException ioe) {
            log.error(ioe.getMessage());
        }
    }

}
