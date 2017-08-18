package com.accenture.apiautomacao.sac.model;


import com.accenture.apiautomacao.persistencia.Persistente;
import static com.accenture.apiautomacao.persistencia.Persistente.buscarPorId;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session;

/**
 * Classe representando a tabela <b>CONTROLE_SERVIDOR_SAC</b>.
 * <p>
 * Permissão de telas que é associada a um usuário específico para nivelar o seu
 * acesso ao SAC.</p>
 *
 * @author otavio.c.ferreira
 * @since 1.0.0
 */
@Entity
@Table(name = "CONTROLE_SERVIDOR")
public class ControleServidor extends Persistente {

    private Integer idServidor;
    private String endereco;

    @Id
    @Column(name = "ID_SERVIDOR")
    public Integer getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(Integer idServidor) {
        this.idServidor = idServidor;
    }

    @Column(name = "ENDERECO")
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Função que busca um Servidor SAC no Banco de Dados.
     *
     * @param id Valor do campo identificador.
     * @return Um servidor SAC.
     * @exception RuntimeException Erro ao buscar o servidor.
     * @since 1.0.0
     */
    public static ControleServidor buscar(int id, Session sessao) throws RuntimeException {
        return (ControleServidor) buscarPorId(ControleServidor.class, id);
    }
}
