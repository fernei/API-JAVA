package com.accenture.apiautomacao.model;



import com.accenture.apiautomacao.persistencia.Persistente;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe representando a tabela <b>CONTROLE_PROCESSO</b>.
 *
 * @author otavio.c.ferreira
 * @since 1.0.0
 */
@Entity
@Table(name = "CONTROLE_PROCESSO")
public class ControleProcesso extends Persistente {

    private String nomeProcesso;
    private String complemento;
    private Integer nivelLog;
    private Character ativo;
    private String md5;
    private String nomeScript;
    private String responsavel;
    private Date dataAtualizacao;
    private Character exibeTelaSAC;
    private Integer execParalelas;
    private Integer threadTempoLimite;
    private String scheduler;
    private String schedulerRefresh;

    @Id
    @Column(name = "NOME_PROCESSO")
    public String getNomeProcesso() {
        return nomeProcesso;
    }

    public void setNomeProcesso(String nomeProcesso) {
        this.nomeProcesso = nomeProcesso;
    }

    @Column(name = "COMPLEMENTO")
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Column(name = "NIVEL_LOG")
    public Integer getNivelLog() {
        return nivelLog;
    }

    public void setNivelLog(Integer nivelLog) {
        this.nivelLog = nivelLog;
    }

    @Column(name = "ATIVO")
    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
    }

    @Column(name = "MD5")
    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Column(name = "NOME_SCRIPT")
    public String getNomeScript() {
        return nomeScript;
    }

    public void setNomeScript(String nomeScript) {
        this.nomeScript = nomeScript;
    }

    @Column(name = "RESPONSAVEL")
    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Column(name = "DATA_ATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Column(name = "EXIBE_TELA_SAC")
    public Character getExibeTelaSAC() {
        return exibeTelaSAC;
    }

    public void setExibeTelaSAC(Character exibeTelaSAC) {
        this.exibeTelaSAC = exibeTelaSAC;
    }

    @Column(name = "EXEC_PARALELAS")
    public Integer getExecParalelas() {
        return execParalelas;
    }

    public void setExecParalelas(Integer execParalelas) {
        this.execParalelas = execParalelas;
    }

    @Column(name = "THREAD_TEMPO_LIMITE")
    public Integer getThreadTempoLimite() {
        return threadTempoLimite;
    }

    public void setThreadTempoLimite(Integer threadTempoLimite) {
        this.threadTempoLimite = threadTempoLimite;
    }

    @Column(name = "SCHEDULER_EXECUCAO")
    public String getScheduler() {
        return scheduler;
    }

    public void setScheduler(String scheduler) {
        this.scheduler = scheduler;
    }

    @Column(name = "SCHEDULER_REFRESH")
    public String getSchedulerRefresh() {
        return schedulerRefresh;
    }

    public void setSchedulerRefresh(String schedulerRefresh) {
        this.schedulerRefresh = schedulerRefresh;
    }

    /**
     * Função que busca um processo no Banco de Dados.
     *
     * @param id Valor do campo NOME_PROCESSO do processo no Banco de Dados.
     * @return As configurações para um processo.
     * @exception RuntimeException Erro ao buscar o processo no Banco de dados.
     * @since 1.0.0
     */
    public static ControleProcesso buscar(String id) throws RuntimeException {
        return (ControleProcesso) buscarPorString(ControleProcesso.class, id);
    }
}
