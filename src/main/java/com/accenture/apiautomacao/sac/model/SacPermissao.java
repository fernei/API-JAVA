package com.accenture.apiautomacao.sac.model;

import com.accenture.apiautomacao.persistencia.Persistente;
import static com.accenture.apiautomacao.persistencia.Persistente.buscarPorId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.Session;

/**
 * Classe representando a tabela <b>SAC_PERMISSAO</b>.
 * <p>
 * Permissão de telas que é associada a um usuário específico para nivelar o seu
 * acesso ao SAC.</p>
 *
 * @author otavio.c.ferreira
 * @since 1.0.0
 */
@Entity
@Table(name = "SAC_PERMISSAO")
@NamedQuery(name = "buscaIDsPermissaoSAC",
        query = "SELECT p.idPermissao FROM SacPermissao p WHERE p.descricao IN (:perms)")
@SuppressWarnings({"ValidPrimaryTableName"})
public class SacPermissao extends Persistente {

    private Integer idPermissao;
    private String descricao;
    private Date dataRegistro;
    private List<ControleUsuario> usuarios = new ArrayList<>();

    @Id
    @Column(name = "ID_PERMISSAO")
    public Integer getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(Integer idPermissao) {
        this.idPermissao = idPermissao;
    }

    @Column(name = "DESCRICAO")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "DATA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    @ManyToMany(mappedBy = "permissoes")
    public List<ControleUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<ControleUsuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Função que busca uma permissao no Banco de Dados.
     *
     * @param id Valor do campo identificador da permissao no Banco de Dados.
     * @return Uma permissao de tela para os usuários.
     * @exception RuntimeException Erro ao buscar a permissao no Banco de dados.
     * @since 1.0.0
     */
    public static SacPermissao buscar(int id, Session sessao) throws RuntimeException {
        return (SacPermissao) buscarPorId(SacPermissao.class, id);
    }
}
