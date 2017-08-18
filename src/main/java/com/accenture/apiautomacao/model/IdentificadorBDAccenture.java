package com.accenture.apiautomacao.model;



import com.accenture.apiautomacao.persistencia.Persistente;
import javax.persistence.Embeddable;

@Embeddable
public class IdentificadorBDAccenture extends Persistente {

    private Integer idBD;
    private String circuito;

    public Integer getIdBD() {
        return idBD;
    }

    public void setIdBD(Integer idBD) {
        this.idBD = idBD;
    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }
}
