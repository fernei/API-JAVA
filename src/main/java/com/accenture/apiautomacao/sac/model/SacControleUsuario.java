package com.accenture.apiautomacao.sac.model;


//import com.accenture.apiautomacao.connection.ConnectionFactory;
import com.accenture.apiautomacao.connection.ConnectionFactory;
import com.accenture.apiautomacao.exception.alocacao.AlocacaoException;
import com.accenture.apiautomacao.exception.usuario.UsuarioNaoEncontradoException;
import com.accenture.apiautomacao.model.ControleExecucao;
import static com.accenture.apiautomacao.logger.LogTrace.log;
import com.accenture.apiautomacao.persistencia.Persistente;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.HibernateError;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Classe representando a tabela <b>SAC_CONTROLE_USUARIO</b>.
 *
 * @author otavio.c.ferreira
 * @since 1.0.0
 */
@Entity
@Table(name = "SAC_CONTROLE_USUARIO")
@NamedQuery(name = "buscaUsuarioDisponivelPorPermissao",
        query = "SELECT u FROM SacControleUsuario u INNER JOIN u.permissoes p"
        + " WHERE p.idPermissao IN :perms AND u.emUso = :uso"
        + " AND u.disponivel = :disp")
@NamedNativeQuery(name = "prLiberaUsuario",
        query = "CALL PR_LIBERA_USUARIO(:proc)")
@SuppressWarnings({"JPQLValidation", "IdDefinedInHierarchy"})
public class SacControleUsuario extends Persistente {

    private String usuario;
    private String senha;
    private String senhaDescriptografada;
    private String arqSessaoExtra;
    private Integer maxSegundosUso;
    private String disponivel;
    private String emUso;
    private ControleExecucao idProcesso;
    private Date dataAtualizacao;
    private String ultimaAcao;
    private Date dataCriacao;
    private Date dataInicio;
    private Date dataFim;
    private Integer duracaoSegundos;
    private List<SacPermissao> permissoes;

    @Id
    @Column(name = "USUARIO")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(name = "SENHA")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Column(name = "ARQ_SESSAO_EXTRA")
    public String getArqSessaoExtra() {
        return arqSessaoExtra;
    }

    public void setArqSessaoExtra(String arqSessaoExtra) {
        this.arqSessaoExtra = arqSessaoExtra;
    }

    @Column(name = "MAX_SEGUNDOS_USO")
    public Integer getMaxSegundosUso() {
        return maxSegundosUso;
    }

    public void setMaxSegundosUso(Integer maxSegundosUso) {
        this.maxSegundosUso = maxSegundosUso;
    }

    @Column(name = "DISPONIVEL")
    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    @Column(name = "EM_USO")
    public String getEmUso() {
        return emUso;
    }

    public void setEmUso(String emUso) {
        this.emUso = emUso;
    }

    @Column(name = "DATA_ATUALIZACAO")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Column(name = "ULTIMA_ACAO")
    public String getUltimaAcao() {
        return ultimaAcao;
    }

    public void setUltimaAcao(String ultimaAcao) {
        this.ultimaAcao = ultimaAcao;
    }

    @Column(name = "DATA_CRIACAO")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
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

    @Column(name = "DURACAO_SEGUNDOS")
    public Integer getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(Integer duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
    }

    @ManyToMany
    @JoinTable(name = "SAC_USUARIO_PERMISSAO",
            joinColumns = @JoinColumn(name = "USUARIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_PERMISSAO"))
    public List<SacPermissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<SacPermissao> permissoes) {
        this.permissoes = permissoes;
    }

    @Transient
    public String getSenhaDescriptografada() {
        return senhaDescriptografada;
    }

    public void setSenhaDescriptografada(String senhaDescriptografada) {
        this.senhaDescriptografada = senhaDescriptografada;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PROCESSO")
    public ControleExecucao getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(ControleExecucao idProcesso) {
        this.idProcesso = idProcesso;
    }

    /**
     * Aloca um usuário para que ele seja utilizado por um sistema para acessar
     * o sistema SAC da OI.
     *
     * @param processo Referência ao ControleExecucao que irá usar o usuário.
     * @param permLista Lista com os nomes das telas que o usuário deverá
     * acessar.
     * @return Um usuário alocado.
     * @throws UsuarioNaoEncontradoException Nenhum usuário dispnível.
     * @since 1.0.0
     */
    @SuppressWarnings({"JPQLValidation", "null", "SleepWhileInLoop"})
    public static SacControleUsuario alocaUsuario(ControleExecucao processo, List<String> permLista)
            throws UsuarioNaoEncontradoException {
        List<Integer> perms;
        SacControleUsuario usuario = null;
        Transaction transacao = null;
        Session sessao = null;

        try {
            log.info("Alocando um novo usuário.");

            sessao = new ConnectionFactory().getSession();
            transacao = sessao.beginTransaction();

            perms = sessao.getNamedQuery("buscaIDsPermissaoSAC")
                    .setParameterList("perms", permLista).list();

            sessao.createSQLQuery("SELECT * FROM SAC_CONTROLE_USUARIO FOR UPDATE").list();

            Query query = sessao.getNamedQuery("buscaUsuarioDisponivelPorPermissao")
                    .setParameter("uso", "N")
                    .setParameter("disp", "S")
                    .setParameterList("perms", perms)
                    .setMaxResults(1);

            usuario = (SacControleUsuario) validaAlocacao(sessao, query);

            usuario.setUltimaAcao("Usuario Alocado");
            usuario.setEmUso("S");
            usuario.setDataInicio(new Date());
            usuario.setDataFim(null);
            usuario.setDuracaoSegundos(0);
            usuario.setIdProcesso(processo);
            usuario.setSenhaDescriptografada(descriptografaSenha(usuario));

            sessao.update(usuario);
            sessao.flush();
        } catch (AlocacaoException ex) {
            throw new UsuarioNaoEncontradoException();
        } finally {
            transacao.commit();
            sessao.close();
        }

        return usuario;
    }

    /**
     * Executa a procedure <b>PR_DESCRIPTOGRAFA</b>, que descriptografa a senha
     * do usuário.
     *
     * @param usuario <B>SacControleUsuario</b> para ter a senha
     * descriptografada.
     * @return Uma String com a senha descriptografada.
     * @since 1.0.0
     */
    private static String descriptografaSenha(SacControleUsuario usuario) {
        @SuppressWarnings("UnusedAssignment")
        String senha = null;

        try (Session sessao = new ConnectionFactory().getSession()) {
            log.info("Descriptografando senha do usuário: " + usuario.getUsuario());

            senha = (String) sessao.createSQLQuery(
                    " SELECT PR_DESCRIPTOGRAFA(:senha, :chave) FROM DUAL")
                    .setParameter("senha", usuario.getSenha())
                    .setParameter("chave", "00000000000000000000000000000000")
                    .uniqueResult();
        } catch (Exception ex) {
            throw new HibernateError("Não foi possível descriptografar a senha para o usuário " + usuario.getUsuario() + ": " + ex.getMessage());
        }

        return senha;
    }

    /**
     * Desaloca o usuário atualmente em utilização.
     *
     * @since 1.0.0
     */
    public void desaloca() {
        try {
            log.info("Desalocando usuário: " + getUsuario());

            this.setDataFim(new Date());
            this.setDuracaoSegundos(Integer.parseInt("" + (this.getDataFim().getTime() - this.getDataInicio().getTime()) / 1000));
            this.setDataAtualizacao(new Date());
            this.setUltimaAcao("Usuario Desalocado");
            this.setEmUso("N");
            alterar(this);
        } catch (RuntimeException ex) {
            log.error("Erro ao desalocar o usuário " + this.getUsuario() + ": " + ex.getMessage());
            throw new RuntimeException("Erro ao desalocar o usuário " + this.getUsuario() + ": " + ex.getMessage());
        }
    }

    /**
     * Função que busca um Usuario do SAC no Banco de Dados.
     *
     * @param id O login do usuário a ser buscado
     * @return Um usuario para o SAC com o campo USUARIO com o valor igual ao
     * parâmetro id.
     * @exception RuntimeException Retorna erro caso não consiga buscar a
     * informação.
     * @since 1.0.0
     */
    public SacControleUsuario buscar(String id, Session sessao) throws RuntimeException {
        return (SacControleUsuario) buscarPorString(SacControleUsuario.class, id);
    }

    /**
     * Indisponibiliza o usuário de acordo com o retorno dado pelo MainFrame.
     *
     * @param motivo Motivo pelo qual está sendo indisponibilizado.
     * @since 1.0.0
     */
    public void tornaIndisponivel(String motivo) {
        try {
            log.info("Colocando o usuário " + getUsuario() + " indisponível.");

            this.setDataAtualizacao(new Date());
            this.setUltimaAcao(motivo);
            this.setEmUso("N");
            this.setDisponivel("N");
            alterar(this);
        } catch (RuntimeException ex) {
            log.error("Erro ao indisponibilizar o usuário " + this.getUsuario() + ": " + ex.getMessage());
            throw new RuntimeException("Erro ao indisponibilizar o usuário " + this.getUsuario() + ": " + ex.getMessage());
        }
    }

    /**
     * Desaloca todos os usuários utilizados por um <b>ControleExecucao</b>.
     *
     * @param processo ControleExecucao que utilizou os usuários.
     * @since 1.0.0
     */
    public static void liberaUsuarios(ControleExecucao processo) {
        try (Session sessao = new ConnectionFactory().getSession()) {
            log.info("Executando a procedure PR_LIBERA_USUARIO.");

            sessao.getNamedQuery("prLiberaUsuario").setParameter("proc", processo.getIdProcesso()).executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("Não foi possível executar a procedure para liberar os usuários: : " + ex.getMessage());
        }
    }

}
