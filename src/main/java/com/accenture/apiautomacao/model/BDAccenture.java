package com.accenture.apiautomacao.model;

import com.accenture.apiautomacao.connection.ConnectionFactory;
import com.accenture.apiautomacao.exception.registro.RegistroNaoEncontradoException;
import static com.accenture.apiautomacao.logger.LogTrace.log;
import com.accenture.apiautomacao.persistencia.Persistente;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

@Entity
@Table(name = "BD")
public class BDAccenture extends Persistente {

    private IdentificadorBDAccenture ident = new IdentificadorBDAccenture();
    private String posto;
    private String estacao;
    private String gra;
    private String gram;
    private String depto;
    private String grupo;
    private String siglaServico;
    private String pri;
    private String locPontaA;
    private String locPontaB;
    private String produto;
    private String msg;
    private String desp;
    private String apz;
    private Date promessa;
    private String statusPorta;
    private String statusModem;
    private String dslam;
    private String facilidade;
    private String velocidadeContratada;
    private String taxaUP;
    private String taxaDown;
    private String maxrateUP;
    private String maxrateDown;
    private String snrUP;
    private String snrDown;
    private String atenuacaoUP;
    private String atenuacaoDown;
    private String modulacao;
    private String observacao;
    private String diagnostico;
    private Date dtSolicitacao;
    private Date dtInicioResposta;
    private Date dtFimRespostaMassivo;
    private Date dtFimResposta;
    private String statusSolicitacao;
    private String solicitante;
    private Integer threadExecutora;
    private String numeroEventoCIV;
    private Date datainterrupcaoCIV;
    private Date dataPromessaCIV;
    private String numeroEventoJM;
    private Date dataInterrupcaoJM;
    private Date dataPromessaJM;
    private String numeroEventoRVE;
    private Date dataInterrupcaoRVE;
    private Date dataPromessaRVE;
    private Date dtInicioMassivo;

    @EmbeddedId
    public IdentificadorBDAccenture getIdent() {
        return ident;
    }

    public void setIdent(IdentificadorBDAccenture ident) {
        this.ident = ident;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public String getEstacao() {
        return estacao;
    }

    public void setEstacao(String estacao) {
        this.estacao = estacao;
    }

    public String getGra() {
        return gra;
    }

    public void setGra(String gra) {
        this.gra = gra;
    }

    public String getGram() {
        return gram;
    }

    public void setGram(String gram) {
        this.gram = gram;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSiglaServico() {
        return siglaServico;
    }

    public void setSiglaServico(String siglaServico) {
        this.siglaServico = siglaServico;
    }

    public String getPri() {
        return pri;
    }

    public void setPri(String pri) {
        this.pri = pri;
    }

    public String getLocPontaA() {
        return locPontaA;
    }

    public void setLocPontaA(String locPontaA) {
        this.locPontaA = locPontaA;
    }

    public String getLocPontaB() {
        return locPontaB;
    }

    public void setLocPontaB(String locPontaB) {
        this.locPontaB = locPontaB;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    public String getApz() {
        return apz;
    }

    public void setApz(String apz) {
        this.apz = apz;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getPromessa() {
        return promessa;
    }

    public void setPromessa(Date promessa) {
        this.promessa = promessa;
    }

    public String getStatusPorta() {
        if (statusPorta == null || statusPorta.trim().isEmpty()) {
            return "Sem Dados";
        }

        return statusPorta;
    }

    public void setStatusPorta(String statusPorta) {
        this.statusPorta = statusPorta;
    }

    public String getStatusModem() {
        if (statusModem == null || statusModem.trim().isEmpty()) {
            return "Sem Dados";
        }

        return statusModem;
    }

    public void setStatusModem(String statusModem) {
        this.statusModem = statusModem;
    }

    public String getDslam() {
        return dslam;
    }

    public void setDslam(String dslam) {
        this.dslam = dslam;
    }

    public String getFacilidade() {
        return facilidade;
    }

    public void setFacilidade(String facilidade) {
        this.facilidade = facilidade;
    }

    public String getVelocidadeContratada() {
        padronizarVelocidadeContratada();
        return velocidadeContratada;
    }

    public void setVelocidadeContratada(String velocidadeContratada) {
        this.velocidadeContratada = velocidadeContratada;
    }

    public String getTaxaUP() {
        return taxaUP;
    }

    public void setTaxaUP(String taxaUP) {
        this.taxaUP = taxaUP;
    }

    public String getTaxaDown() {
        return taxaDown;
    }

    public void setTaxaDown(String taxaDown) {
        this.taxaDown = taxaDown;
    }

    public String getMaxrateUP() {
        return maxrateUP;
    }

    public void setMaxrateUP(String maxrateUP) {
        this.maxrateUP = maxrateUP;
    }

    public String getMaxrateDown() {
        return maxrateDown;
    }

    public void setMaxrateDown(String maxrateDown) {
        this.maxrateDown = maxrateDown;
    }

    public String getSnrUP() {
        return snrUP;
    }

    public void setSnrUP(String snrUP) {
        this.snrUP = snrUP;
    }

    public String getSnrDown() {
        return snrDown;
    }

    public void setSnrDown(String snrDown) {
        this.snrDown = snrDown;
    }

    public String getAtenuacaoUP() {
        return atenuacaoUP;
    }

    public void setAtenuacaoUP(String atenuacaoUP) {
        this.atenuacaoUP = atenuacaoUP;
    }

    public String getAtenuacaoDown() {
        return atenuacaoDown;
    }

    public void setAtenuacaoDown(String atenuacaoDown) {
        this.atenuacaoDown = atenuacaoDown;
    }

    public String getModulacao() {
        if (modulacao == null || modulacao.trim().isEmpty()) {
            return "ADSL";
        }

        return modulacao;
    }

    public void setModulacao(String modulacao) {
        this.modulacao = modulacao;
    }

    @Lob
    @Column(columnDefinition = "TEXT")
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDtSolicitacao() {
        return dtSolicitacao;
    }

    public void setDtSolicitacao(Date dtSolicitacao) {
        this.dtSolicitacao = dtSolicitacao;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDtInicioResposta() {
        return dtInicioResposta;
    }

    public void setDtInicioResposta(Date dtInicioResposta) {
        this.dtInicioResposta = dtInicioResposta;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDtFimRespostaMassivo() {
        return dtFimRespostaMassivo;
    }

    public void setDtFimRespostaMassivo(Date dtFimRespostaMassivo) {
        this.dtFimRespostaMassivo = dtFimRespostaMassivo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDtFimResposta() {
        return dtFimResposta;
    }

    public void setDtFimResposta(Date dtFimResposta) {
        this.dtFimResposta = dtFimResposta;
    }

    public String getStatusSolicitacao() {
        return statusSolicitacao;
    }

    public void setStatusSolicitacao(String statusSolicitacao) {
        this.statusSolicitacao = statusSolicitacao;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    @Column(columnDefinition = "SMALLINT")
    public Integer getThreadExecutora() {
        return threadExecutora;
    }

    public void setThreadExecutora(Integer threadExecutora) {
        this.threadExecutora = threadExecutora;
    }

    public String getNumeroEventoCIV() {
        return numeroEventoCIV;
    }

    public void setNumeroEventoCIV(String numeroEventoCIV) {
        this.numeroEventoCIV = numeroEventoCIV;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDatainterrupcaoCIV() {
        return datainterrupcaoCIV;
    }

    public void setDatainterrupcaoCIV(Date datainterrupcaoCIV) {
        this.datainterrupcaoCIV = datainterrupcaoCIV;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataPromessaCIV() {
        return dataPromessaCIV;
    }

    public void setDataPromessaCIV(Date dataPromessaCIV) {
        this.dataPromessaCIV = dataPromessaCIV;
    }

    public String getNumeroEventoJM() {
        return numeroEventoJM;
    }

    public void setNumeroEventoJM(String numeroEventoJM) {
        this.numeroEventoJM = numeroEventoJM;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataInterrupcaoJM() {
        return dataInterrupcaoJM;
    }

    public void setDataInterrupcaoJM(Date dataInterrupcaoJM) {
        this.dataInterrupcaoJM = dataInterrupcaoJM;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataPromessaJM() {
        return dataPromessaJM;
    }

    public void setDataPromessaJM(Date dataPromessaJM) {
        this.dataPromessaJM = dataPromessaJM;
    }

    public String getNumeroEventoRVE() {
        return numeroEventoRVE;
    }

    public void setNumeroEventoRVE(String numeroEventoRVE) {
        this.numeroEventoRVE = numeroEventoRVE;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataInterrupcaoRVE() {
        return dataInterrupcaoRVE;
    }

    public void setDataInterrupcaoRVE(Date dataInterrupcaoRVE) {
        this.dataInterrupcaoRVE = dataInterrupcaoRVE;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataPromessaRVE() {
        return dataPromessaRVE;
    }

    public void setDataPromessaRVE(Date dataPromessaRVE) {
        this.dataPromessaRVE = dataPromessaRVE;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDtInicioMassivo() {
        return dtInicioMassivo;
    }

    public void setDtInicioMassivo(Date dtInicioMassivo) {
        this.dtInicioMassivo = dtInicioMassivo;
    }

    /**
     * Função que busca um BD no Banco de Dados MySQL.
     *
     * @param id Valor do campo <b>idBD</b>.
     * @return O bd procurado.
     * @exception RuntimeException Erro ao buscar um BD no Banco de Dados MySQL.
     * @since 1.0
     */
    public static BDAccenture buscar(int id) throws RuntimeException {
        return (BDAccenture) buscarPorId(BDAccenture.class, id);
    }

    public void padronizarVelocidadeContratada() {
        velocidadeContratada = velocidadeContratada == null ? "0" : velocidadeContratada;

        if (!velocidadeContratada.contains("K")
                && !velocidadeContratada.contains("M")) {
            if (Integer.parseInt(velocidadeContratada) >= 1024) {
                int calculo = Integer.parseInt(velocidadeContratada) / 1024;
                velocidadeContratada = "" + calculo + "M";
            } else {
                velocidadeContratada = velocidadeContratada.concat("K");
            }
        }
    }

    /**
     * Função responsável por validar o retorno do testes realizados no CCV.
     *
     * @param solicitante Nome do solicitante do teste.
     * @param data Data a partir da qual o teste será buscado.
     * @param status Status do teste realizado.
     * @param circuito Circuito a ser procurado.
     * @since 1.0
     */
    public static BDAccenture buscarRetornoTesteCCV(String solicitante, Calendar data, String status, String circuito) throws RegistroNaoEncontradoException {
        log.info("Buscando retorno do teste CCV do BD " + circuito + ".");

        try (Session sessao = new ConnectionFactory().getSession()) {
            return (BDAccenture) sessao.createCriteria(BDAccenture.class)
                    .add(Restrictions.eq("solicitante", solicitante))
                    .add(Restrictions.eq("statusSolicitacao", status))
                    //                    .add(Restrictions.gt("dtSolicitacao", data.getTime()))
                    .add(Restrictions.eq("ident.circuito", circuito))
                    .addOrder(Order.desc("dtSolicitacao"))
                    .setMaxResults(1)
                    .uniqueResult();
        } catch (Throwable ex) {
            log.error("Erro buscando retorno do teste CCV no MySQL: " + ex.getMessage());
            throw new RegistroNaoEncontradoException();
        }
    }
}
