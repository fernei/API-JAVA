package com.accenture.apiautomacao.model;


import com.accenture.apiautomacao.controller.Util;
import static com.accenture.apiautomacao.logger.LogTrace.log;
import com.accenture.apiautomacao.persistencia.Persistente;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe representando a tabela <b>CONTROLE_EXECUCAO</b>.
 *
 * @author otavio.c.ferreira
 * @since 1.0.0
 */
@Entity
@Table(name = "CONTROLE_EXECUCAO")
public class ControleExecucao extends Persistente {

    private Integer idProcesso;
    private ControleProcesso nomeProcesso;
    private Date dataInicio;
    private Date dataFim;
    private String resultado;
    private Integer codigoRetorno;
    private String statusProcesso;
    private Integer qtdTotal;
    private Integer qtdOk;
    private Integer qtdNOk;
    private Integer qtdErro;
    private Date dataAtualizacao;
    private Integer pidProcesso;
    private String ipMaquina;
    private String computerName;
    private String userName;
    private Long duracaoSegundos;
    private String nomeScript;
    private String versaoMD5;
    private String nomeLib;
    private String versaoMD5Lib;

    @Id
    @Column(name = "ID_PROCESSO")
    @SequenceGenerator(name = "seq_controle_execucao", sequenceName = "SEQ_ID_PROCESSO",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_controle_execucao")
    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "NOME_PROCESSO")
    public ControleProcesso getNomeProcesso() {
        return nomeProcesso;
    }

    public void setNomeProcesso(ControleProcesso nomeProcesso) {
        this.nomeProcesso = nomeProcesso;
    }

    @Column(name = "DATA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Column(name = "DATA_FIM")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Column(name = "RESULTADO")
    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Column(name = "CODIGO_RETORNO")
    public Integer getCodigoRetorno() {
        return codigoRetorno;
    }

    public void setCodigoRetorno(Integer codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

    @Column(name = "STATUS_PROCESSO", length = 30)
    public String getStatusProcesso() {
        return statusProcesso;
    }

    public void setStatusProcesso(String statusProcesso) {
        this.statusProcesso = statusProcesso;
    }

    @Column(name = "QTD_TOTAL")
    public Integer getQtdTotal() {
        return qtdTotal;
    }

    public void setQtdTotal(Integer qtdTotal) {
        this.qtdTotal = qtdTotal;
    }

    @Column(name = "QTD_OK")
    public Integer getQtdOk() {
        return qtdOk;
    }

    public void setQtdOk(Integer qtdOk) {
        this.qtdOk = qtdOk;
    }

    @Column(name = "QTD_NOK")
    public Integer getQtdNOk() {
        return qtdNOk;
    }

    public void setQtdNOk(Integer qtdNOk) {
        this.qtdNOk = qtdNOk;
    }

    @Column(name = "QTD_ERRO")
    public Integer getQtdErro() {
        return qtdErro;
    }

    public void setQtdErro(Integer qtdErro) {
        this.qtdErro = qtdErro;
    }

    @Column(name = "DATA_ATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Column(name = "PID_PROCESSO")
    public Integer getPidProcesso() {
        return pidProcesso;
    }

    public void setPidProcesso(Integer pidProcesso) {
        this.pidProcesso = pidProcesso;
    }

    @Column(name = "IP_MAQUINA")
    public String getIpMaquina() {
        return ipMaquina;
    }

    public void setIpMaquina(String ipMaquina) {
        this.ipMaquina = ipMaquina;
    }

    @Column(name = "COMPUTER_NAME")
    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "DURACAO_SEGUNDOS")
    public Long getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(Long duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
    }

    @Column(name = "NOME_SCRIPT")
    public String getNomeScript() {
        return nomeScript;
    }

    public void setNomeScript(String nomeScript) {
        this.nomeScript = nomeScript;
    }

    @Column(name = "VERSAO_MD5")
    public String getVersaoMD5() {
        return versaoMD5;
    }

    public void setVersaoMD5(String versaoMD5) {
        this.versaoMD5 = versaoMD5;
    }

    @Column(name = "NOME_LIB")
    public String getNomeLib() {
        return nomeLib;
    }

    public void setNomeLib(String nomeLib) {
        this.nomeLib = nomeLib;
    }

    @Column(name = "VERSAO_MD5_LIB")
    public String getVersaoMD5Lib() {
        return versaoMD5Lib;
    }

    public void setVersaoMD5Lib(String versaoMD5Lib) {
        this.versaoMD5Lib = versaoMD5Lib;
    }

    /**
     * Inicializa o controle processo.
     *
     * @param nomeProcesso O nome do processo a ser iniciado. Esse processo deve
     * estar contido dentro de CONTROLE_PROCESSO.
     * @since 1.0.0
     */
    public void inicializaControleExecucao(String nomeProcesso) {
        log.info("Inicializando um novo controle execução.");

        this.setNomeProcesso(ControleProcesso.buscar(nomeProcesso));
        this.setDataInicio(new Date());
        this.setIpMaquina(Util.getIp());
        this.setComputerName(Util.getHostName());
        this.setQtdTotal(0);
        this.setQtdOk(0);
        this.setQtdNOk(0);
        this.setQtdErro(0);
        this.setUserName(Util.getUserName());
        this.setStatusProcesso("EXECUTANDO");
        inserir(this);

        log.info("Executando com o ControleExecucao: " + this.getIdProcesso());
    }

    /**
     * Atualiza o campo <b>STATUS_PROCESSO</b>.
     *
     * @param status Valor a ser atualizado no campo STATUS_PROCESSO.
     * @since 1.0.0
     */
    public void atualizaStatusProcesso(String status) {
        this.setStatusProcesso(status);
        atualizaControleExecucao();
    }

    /**
     * Atualiza a <b>DATA_ATUALIZACAO</b> com a data/hora atual, e a
     * <b>DURACAO_SEGUNDOS</b>
     * com o tempo em segundos entre o inicio do processo e a data/hora atual.
     *
     * @since 1.0.0
     */
    public void atualizaControleExecucao() {
        this.setDataAtualizacao(new Date());
        this.setDuracaoSegundos((this.getDataAtualizacao().getTime() - this.getDataInicio().getTime()) / 1000);
        alterar(this);
    }

    /**
     * Finaliza o processo atual.
     *
     * @param status Valor a ser atualizado no campo <b>STATUS_PROCESSO</b>. Ex:
     * "FINALIZADO 'valor de status'".
     * @since 1.0.0
     */
    public void finalizaControleExecucao(String status) {
        log.info("Finalizando controle execução.");

        this.setDataFim(new Date());
        this.setStatusProcesso("FINALIZADO " + status);
        this.atualizaControleExecucao();
    }

    /**
     * Função que busca uma execucao no Banco de Dados.
     *
     * @param id Valor do campo <b>ID_PROCESSO</b> da execucao no Banco de
     * Dados.
     * @return Uma execucao.
     * @exception RuntimeException Erro ao buscar a execucao no Banco de dados.
     * @since 1.0.0
     */
    public static ControleExecucao buscar(int id) throws RuntimeException {
        return (ControleExecucao) buscarPorId(ControleExecucao.class, id);
    }
}
