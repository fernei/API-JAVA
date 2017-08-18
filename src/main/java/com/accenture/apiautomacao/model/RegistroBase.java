package com.accenture.apiautomacao.model;

import java.util.TreeMap;

/**
 *
 * @author fernando.m.souza
 */
public class RegistroBase {
    private String uf;
    private String ddd;
    private String terminal;
    private String logradouro;
    private String numero;
    private String situacao;
    private String dtAbertura;
    private String dtEntradaAnalise;
    private String dtSaidaAnalise;
    private String dtEntradaCampo;
    private String dtSaidaCampo;
    private String dtFechamentoTotal;
    private String localidade;
    private String numOS;
    public TreeMap mapaAuxiliarInfo = new TreeMap(); //incluso no RESET

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(String dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public String getDtEntradaAnalise() {
        return dtEntradaAnalise;
    }

    public void setDtEntradaAnalise(String dtEntradaAnalise) {
        this.dtEntradaAnalise = dtEntradaAnalise;
    }

    public String getDtSaidaAnalise() {
        return dtSaidaAnalise;
    }

    public void setDtSaidaAnalise(String dtSaidaAnalise) {
        this.dtSaidaAnalise = dtSaidaAnalise;
    }

    public String getDtEntradaCampo() {
        return dtEntradaCampo;
    }

    public void setDtEntradaCampo(String dtEntradaCampo) {
        this.dtEntradaCampo = dtEntradaCampo;
    }

    public String getDtSaidaCampo() {
        return dtSaidaCampo;
    }

    public void setDtSaidaCampo(String dtSaidaCampo) {
        this.dtSaidaCampo = dtSaidaCampo;
    }

    public String getDtFechamentoTotal() {
        return dtFechamentoTotal;
    }

    public void setDtFechamentoTotal(String dtFechamentoTotal) {
        this.dtFechamentoTotal = dtFechamentoTotal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getNumOS() {
        return numOS;
    }

    public void setNumOS(String numOS) {
        this.numOS = numOS;
    }

    public TreeMap getMapaAuxiliarInfo() {
        return mapaAuxiliarInfo;
    }

    public void setMapaAuxiliarInfo(TreeMap mapaAuxiliarInfo) {
        this.mapaAuxiliarInfo = mapaAuxiliarInfo;
    }

}
