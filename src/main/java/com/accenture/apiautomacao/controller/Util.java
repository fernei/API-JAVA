package com.accenture.apiautomacao.controller;


import static com.accenture.apiautomacao.logger.LogTrace.log;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe responsável por todas as funções genéricas que podem ser utilizadas
 * por todo o sistema.
 *
 * @author otavio.c.ferreira
 * @since 1.0.0
 */
public class Util {

    /**
     * Função para pegar o <b>HostName</b>
     *
     * @return String com o HostName.
     * @since 1.0.0
     */
    public static String getHostName() {
        String hostName = null;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            log.info("Erro ao recuperar o HostName");
        }
        return hostName;
    }

    /**
     * Função para pegar o <b>IP do Host</b>
     *
     * @return String com o IP do Host
     * @since 1.0.0
     */
    public static String getIp() {
        String ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            log.info("Erro ao recuperar o IP");
        }
        return ip;
    }

    /**
     * Função para pegar o <b>User Name</b> da máquina
     *
     * @return String com o User Name da Máquina
     * @since 1.0.0
     */
    public static String getUserName() {
        return System.getProperty("user.name");
    }

    /**
     * Retorna os dados do Sistema
     *
     * @return String com dos dados do Sistema
     * @since 1.0.0
     */
    public static String traceCpuEnvironment() {

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.println("General information: ");

        Properties p = System.getProperties();

        String[] split = p.toString().split(",");

        for (String string : split) {
            pw.println(string);
        }

        return sw.toString();
    }

    /**
     * Função para pegar algumas informações do Sistema: <b>SO, Java Version,
     * Espaço de Pilha, User Name, Language, Country</b>. Este função cria um
     * arquivo de nome logCpuEnvironment.txt no diretorio onde o sistma é
     * executado.
     *
     * @return String com algumas informações do sistema.
     * @since 1.0.0
     */
    public static String logCpuEnvironment() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.println("General information: ");
        pw.println("Operating System: " + System.getProperty("os.name")
                + " " + System.getProperty("sun.os.patch.level"));
        pw.println("Java Version: "
                + System.getProperty("java.version") + " - "
                + System.getProperty("java.vendor"));
        final long max = Runtime.getRuntime().maxMemory();
        final int maxMega = (int) ((float) max / 1048576);
        pw.println("Heap Space (Espaço de Pilha): " + maxMega + "MB");
        pw.println("User name: " + System.getProperty("user.name"));
        pw.println("Language: " + System.getProperty("user.language"));
        pw.println("Country: " + System.getProperty("user.country"));

        try (FileWriter arq = new FileWriter(new java.io.File(".").getCanonicalPath() + "\\logCpuEnvironment.txt")) {
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.print(sw.toString());

        } catch (IOException ex) {
            log.info(Util.class.getName() + Level.WARNING + Arrays.toString(ex.getStackTrace()));
        }

        return sw.toString();
    }

    /**
     * Verificando caracteres de <b>a-z 0-9</b> e acentos.
     *
     * @param string String para verificação.
     * @return String validada.
     * @since 1.0.0
     */
    public String verificaAceitaCaracteresAaZe0a9Acentos(String string) {
        String saida = "";
        Pattern pattern = Pattern
                .compile("[áàéèíìóòúùãç qwertyuiopasdfghjklzxcvbnm QWERTYÇUIOPASDFGHJKLZXCVBNM 0123456789]");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            saida += matcher.group();
        }
        return saida;
    }

    /**
     * Verificando caracteres de <b>[a-z] [0-9]</b> e sem acentos
     *
     * @param string String para verificação.
     * @return String validada.
     * @since 1.0.0
     */
    public String verificaAceitaCaracteresAaZe0a9SemAcentos(String string) {
        String saida = "";
        Pattern pattern = Pattern
                .compile("[qwertyuiopasdfghjklzxcvbnm QWERTYUIOPASDFGHJKLZXCVBNM 0123456789]");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            saida += matcher.group();
        }
        return saida;
    }

    /**
     * Verifica texto com maiúscula e minusculas
     *
     * @param string String que será analisada
     * @return String sem espaços duplicados e sem letras repetidas
     * @since 1.0.0
     */
    public String verificaNome(String string) {
        String saida = "";
        string = retiraAcentos(string).toUpperCase();
        String string2 = retiraEspacosDuplicados(string);
        Pattern pattern = Pattern
                .compile("[qwertyuiopasdfghjklzxcvbnm QWERTYUIOPASDFGHJKLZXCVBNM]");
        Matcher matcher = pattern.matcher(string2);
        while (matcher.find()) {
            saida += matcher.group();
        }
        return retiraLetrasRepetidas(saida);
    }

    /**
     * Retirando espaços duplicados
     *
     * @param string String que será analisada
     * @return string String sem espaços duplicados
     * @since 1.0.0
     */
    public String retiraEspacosDuplicados(String string) {
        String patternStr = "\\s+";
        String replaceStr = " ";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(string);
        string = matcher.replaceAll(replaceStr);
        return string;
    }

    /**
     * Verificando char repetido
     *
     * @param string String para verificação.
     * @return String validada.
     * @since 1.0.0
     */
    public String verificaCharRepetido(String string) {
        Pattern p = Pattern.compile("(\\w)\\1+");
        Matcher m = p.matcher(string);
        return m.group(1);
    }

    /**
     * Retira letras repetidas
     *
     * @param s String para verificação.
     * @return String sem letras repetidas
     * @since 1.0
     */
    public String retiraLetrasRepetidas(String s) {
        String aux = "";
        String string1;
        List<String> lista = new ArrayList<>();
        int cont = 0;

        for (int i = 0; i < s.length(); i++) {
            string1 = "" + s.charAt(i);
            if (string1.equalsIgnoreCase(aux)) {
                cont++;
                if (cont >= 3) {
                    cont = 0;
//                    lista.add(retornaStringRepetida(s, aux));
                }
            }
            aux = string1;
        }

        for (String ss : lista) {
            char c = ss.charAt(0);
            s = s.replace(ss, String.valueOf(c));
        }

        return s;
    }

    /**
     * Retira Acentos da String
     *
     * @param str String para verificação.
     * @return String sem acentos.
     * @since 1.0
     */
    public static String retiraAcentos(String str) {
        if (str != null) {
            str = Normalizer.normalize(str, Normalizer.Form.NFD);
            str = str.replaceAll("[^\\p{ASCII}]", "");
        }
        return str;
//        return Normalizer.normalize(str, Normalizer.Form.NFKC).replaceAll("[^\\p{ASCII}]", "");
    }

    /**
     * Altera letras acentuadas para não acentuadas da String
     *
     * @param s String para verificação.
     * @return String sem acentos.
     * @since 1.0 -- * @deprecated Essa versão não realiza nenhuma ação. A mesma
     * deve ser substituída pela retiraAcentos, desta mesma classe.
     */
    public static String removeAcento(String s) {
        s = s.replaceAll("[ÂÀÁÄÃ]", "A");
        s = s.replaceAll("[âãàáä]", "a");
        s = s.replaceAll("[ÊÈÉË]", "E");
        s = s.replaceAll("[êèéë]", "e");
        s = s.replaceAll("ÎÍÌÏ", "I");
        s = s.replaceAll("îíìï", "i");
        s = s.replaceAll("[ÔÕÒÓÖ]", "O");
        s = s.replaceAll("[ôõòóö]", "o");
        s = s.replaceAll("[ÛÙÚÜ]", "U");
        s = s.replaceAll("[ûúùü]", "u");
        s = s.replaceAll("Ç", "C");
        s = s.replaceAll("ç", "c");
        s = s.replaceAll("[ýÿ]", "y");
        s = s.replaceAll("Ý", "Y");
        s = s.replaceAll("ñ", "n");
        s = s.replaceAll("Ñ", "N");
        return s;
    }

    /**
     * Converte uma String para um objeto Date. Caso a String seja vazia ou
     * nula, retorna null - para facilitar em casos onde formulários podem ter
     * campos de datas vazios.
     *
     * @throws ParseException Caso a String esteja no formato errado
     * @since 1.0
     */
    public static Date stringToDate(String data) throws ParseException {
        if (data == null || data.equals("")) {
            return null;
        }

        Date date = null;

        if (data.length() < 19) {

            if (data.length() == 15) {
                data = data + "00";
            }

            if (data.contains("-")) {
                if (data.indexOf("-") == 9) {
                    String aux[] = data.split("-");
                    data = aux[0].trim() + " " + aux[1].trim();
                }
            }

            date = new SimpleDateFormat("ddMMyyyy HHmmss").parse(data);
        } else if (data.contains("/") && data.contains(":")) {
            date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(data);
        }

        return date;
    }

    /**
     * Realiza o replace de caracteres em um texto ou palavra.
     *
     * @param texto Texto a ser alterado.
     * @param valor Caracter a ser substituído.
     * @param replacement Caracter que será inserido no lugar do valor.
     * @return O texto com os caracteres substituídos.
     * @since 1.0
     */
    public static String removeCaracter(String texto, String valor, String replacement) {
        return texto.replaceAll(Pattern.quote(valor), replacement);
    }

//    public static String getIdAcesso() {
//
//        String id = null;
//
//        try {
//            InetAddress address = InetAddress.getLocalHost();
//            NetworkInterface ni = NetworkInterface.getByInetAddress(address);
//            byte[] mac = ni.getHardwareAddress();
//            StringBuilder endMac = new StringBuilder();
//            for (int i = 0; i < mac.length; i++) {
//                endMac.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "" : ""));
//            }
//            String hostName = getHostName();
//            endMac.append(hostName);
//            id = Util.GerarMD5String(endMac.toString());
//        } catch (UnknownHostException | SocketException ex) {
//            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return id;
//    }
    /**
     * Caputra o Endereço MAC da placa de rede.
     *
     * @return String com o endereço MAC da máquina
     * @throws SocketException
     * @throws UnknownHostException
     * @since 1.0
     */
    public static String getEndMac() throws SocketException, UnknownHostException {
        try {
            InetAddress address = InetAddress.getLocalHost();
            NetworkInterface ni = NetworkInterface.getByInetAddress(address);
            byte[] mac = ni.getHardwareAddress();
            StringBuilder endMac = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                endMac.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "" : ""));
            }
            return endMac.toString();
        } catch (SocketException | UnknownHostException ex) {
            throw ex;
        }
    }

    public static Date getDataAtual() {
        Calendar calendar = new GregorianCalendar();
        Date date = new Date();
        calendar.setTime(date);
        return calendar.getTime();
    }
}
