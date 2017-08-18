package com.accenture.apiautomacao.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 *
 * @author otavio.c.ferreira
 */
public enum TimeZoneBrasil {
    AC("America/Rio_Branco"),
    DF("America/Sao_Paulo"),
    GO("America/Sao_Paulo"),
    MS("America/Campo_Grande"),
    MT("America/Cuiaba"),
    PR("America/Sao_Paulo"),
    RO("America/Porto_Velho"),
    RS("America/Sao_Paulo"),
    SC("America/Sao_Paulo");
    
    private final String timeZone;
    
    TimeZoneBrasil(String timeZone) {
        this.timeZone = timeZone;
    }
    
    public String getTimeZone() {
        return timeZone;
    }
    
    public static TimeZoneBrasil buscaTimeZoneBrasil(String uf) {
        switch(uf) {
            case "AC":
                return TimeZoneBrasil.AC;
            case "DF":
                return TimeZoneBrasil.DF;
            case "GO":
                return TimeZoneBrasil.GO;
            case "MS":
                return TimeZoneBrasil.MS;
            case "MT":
                return TimeZoneBrasil.MT;
            case "PR":
                return TimeZoneBrasil.PR;
            case "RO":
                return TimeZoneBrasil.RO;
            case "RS":
                return TimeZoneBrasil.RS;
            case "SC":
                return TimeZoneBrasil.SC;
            default:
                return TimeZoneBrasil.DF;
        }
    }

    public static Calendar pegaDataAtualDoFuso(String timeZoneDoBD) {
        Calendar calendarioRepasseDeFuso = new GregorianCalendar(TimeZone.getTimeZone(timeZoneDoBD));
        
        Calendar calendarioAtualComFusoDoBD = new GregorianCalendar();
        
        calendarioAtualComFusoDoBD.set( calendarioRepasseDeFuso.get(Calendar.YEAR),
                                        calendarioRepasseDeFuso.get(Calendar.MONTH),
                                        calendarioRepasseDeFuso.get(Calendar.DAY_OF_MONTH),
                                        calendarioRepasseDeFuso.get(Calendar.HOUR_OF_DAY),
                                        calendarioRepasseDeFuso.get(Calendar.MINUTE),
                                        calendarioRepasseDeFuso.get(Calendar.SECOND));
        
        return calendarioAtualComFusoDoBD;
    }
}
