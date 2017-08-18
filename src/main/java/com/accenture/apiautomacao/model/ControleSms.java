package com.accenture.apiautomacao.model;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.accenture.apiautomacao.model;
//
//import com.accenture.apiautomacao.connection.ConnectionFactory;
//import static com.accenture.apiautomacao.logger.LogTrace.log;
//import com.accenture.apiautomacao.persistencia.Persistente;
//import java.util.Date;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedNativeQuery;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.persistence.Version;
//import org.hibernate.Session;
//import org.hibernate.annotations.DynamicUpdate;
//import static com.accenture.apiautomacao.model.ControleSms.prc_enviar_sms;
//import java.math.BigDecimal;
//import javax.persistence.NamedNativeQueries;
//
///**
// *
// * @author fernando.m.souza
// */
//@Entity
//@DynamicUpdate(true)
//@Table(name = "CO_T_CONTROLE_SMS")
//@NamedNativeQueries({
//    @NamedNativeQuery(name = ControleSms.prc_enviar_sms,
//            query = "call AUTOMACAO.PRC_ENVIAR_SMS(:P_GRUPO_DESTINO,:P_TXT_MENSAGEM,:P_NOME_PROCESSO)")
//    , 
//    @NamedNativeQuery(name = ControleSms.nnq_ultimo_controle_sms,
//            query = "Select * from co_t_controle_sms "
//            + " WHERE data_envio = (select max(data_envio) from co_t_controle_sms)",
//            resultClass = ControleSms.class)
//    ,
//    @NamedNativeQuery(name = ControleSms.nnq_ultimo_lote,
//            query = "Select id_sms from AUTOMACAO.TB_FILA_SMS "
//            + " where NOME_PROCESSO = :proc "
//            + " AND DATA_INCLUSAO = "
//            + " (SELECT max(DATA_INCLUSAO) FROM AUTOMACAO.TB_FILA_SMS where NOME_PROCESSO = :proc2)")
//})
//
//public class ControleSms extends Persistente {
//
//    public static final String prc_enviar_sms = "PRC_ENVIAR_SMS";
//    public static final String nnq_ultimo_controle_sms = "ULTIMO_CONTROLE_SMS";
//    public static final String nnq_ultimo_lote = "ULTIMO_LOTE_SMS";
//
//    private Integer idEnvio;
//    private Date dataEnvio;
//    private Integer qtdPendente;
//    private Integer idSms;
//    private Integer versao;
//
//    @Id
//    @Column(name = "ID_ENVIO")
//    @SequenceGenerator(name = "seq_id_envio", sequenceName = "SEG_ID_ENVIO",
//            allocationSize = 1, initialValue = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_envio")
//    public Integer getIdEnvio() {
//        return idEnvio;
//    }
//
//    public void setIdEnvio(Integer idEnvio) {
//        this.idEnvio = idEnvio;
//    }
//
//    @Column(name = "DATA_ENVIO")
//    public Date getDataEnvio() {
//        return dataEnvio;
//    }
//
//    public void setDataEnvio(Date dataEnvio) {
//        this.dataEnvio = dataEnvio;
//    }
//
//    @Column(name = "QTD_PENDENTE")
//    public Integer getQtdPendente() {
//        return qtdPendente;
//    }
//
//    public void setQtdPendente(Integer qtdPendente) {
//        this.qtdPendente = qtdPendente;
//    }
//
//    @Column(name = "ID_SMS")
//    public Integer getIdSms() {
//        return idSms;
//    }
//
//    public void setIdSms(Integer idSms) {
//        this.idSms = idSms;
//    }
//
//    @Version
//    @Column(name = "VERSAO", insertable = false)
//    public Integer getVersao() {
//        return versao;
//    }
//
//    public void setVersao(Integer versao) {
//        this.versao = versao;
//    }
//
//    /**
//     * Executa a procedure que envia o SMS
//     *
//     * @param processo <b>ControleExecucao</b> a ser atualizado.
//     * @since 1.0.0
//     */
//    public static void enviaSms(Integer idGrupoDestino, String txtMensagem, String nomeProcesso) {
//        try (Session sessao = new ConnectionFactory().getSession()) {
//            log.info("Executando a procedure PRC_ENVIAR_SMS.");
//            sessao.getNamedQuery(prc_enviar_sms)
//                    .setParameter("P_GRUPO_DESTINO", idGrupoDestino)
//                    .setParameter("P_TXT_MENSAGEM", txtMensagem)
//                    .setParameter("P_NOME_PROCESSO", nomeProcesso)
//                    .executeUpdate();
//        } catch (Exception ex) {
//            throw new RuntimeException("Não foi possível executar a procedure para enviar SMS: " + ex.getMessage());
//        }
//    }
//
//    public static ControleSms buscaUltimoEnvio() {
//        try (Session sessao = new ConnectionFactory().getSession()) {
//            return (ControleSms) sessao.getNamedQuery(nnq_ultimo_controle_sms)
//                    .uniqueResult();
//        } catch (Exception ex) {
//            throw new RuntimeException("Não foi possível obter os dados do ultimo envio: " + ex.getMessage());
//        }
//    }
//
//    public static BigDecimal BuscaIdUltimoRegistro(String nomeProcesso) {
//        try (Session sessao = new ConnectionFactory().getSession()) {
//            return (BigDecimal) sessao.getNamedQuery(ControleSms.nnq_ultimo_lote)
//                    .setParameter("proc", nomeProcesso)
//                    .setParameter("proc2", nomeProcesso)
//                    .uniqueResult();
//        } catch (Exception ex) {
//            throw new RuntimeException("Não foi possível obter o ID do ultimo envio: " + ex.getMessage());
//        }
//    }
//}
