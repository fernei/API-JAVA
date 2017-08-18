package com.accenture.apiautomacao.model;

import com.accenture.apiautomacao.persistencia.Persistente;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author marcos.b.oliveira
 * @since 1.0.1
 */
@Entity
@Table(name = "TAB_ASSIA_ENTRADA", schema = "AUTOMACAO")
public class AssiaEntrada extends Persistente {

    private String circuito;
    private String estabilidade;

    @Id
    @Column(name = "CIRCUITO")
    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    @Column(name = "ESTABILIDADE")
    public String getEstabilidade() {
        return estabilidade;
    }

    public void setEstabilidade(String estabilidade) {
        this.estabilidade = estabilidade;
    }

    /**
     * Função que busca uma Estabilidade Assia no Banco de Dados.
     *
     * @param String Valor do campo <b>CIRCUITO</b> da Estabilidade no Banco de
     * Dados.
     * @return Uma estabilidade.
     * @exception RuntimeException Erro ao buscar a estabilidade no Banco de
     * dados.
     * @since 1.0.0
     */
    public static AssiaEntrada buscar(String circuito) throws RuntimeException {
        return (AssiaEntrada) buscarPorString(AssiaEntrada.class, circuito);
    }

}
