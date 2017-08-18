package com.accenture.apiautomacao.persistencia;

import com.accenture.apiautomacao.dao.GenericDAO;
import com.accenture.apiautomacao.exception.alocacao.AlocacaoException;
import com.accenture.apiautomacao.exception.registro.RegistroNaoEncontradoException;
import static com.accenture.apiautomacao.logger.LogTrace.log;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.hibernate.TransientObjectException;
import org.hibernate.exception.ConstraintViolationException;

/**
 * Classe pai de todos os models da API. Contêm todas as funções necessárias
 * para manuseio das informações no Banco de Dados.
 *
 * @author otavio.c.ferreira
 * @since 1.0.0
 */
public abstract class Persistente extends GenericDAO implements Serializable {

    /**
     * Função que insere um novo registro no Banco de Dados.
     *
     * @param obj Um objeto Persistente para ser inserido no Banco de Dados.
     * @exception HibernateException Erro ao inserir o Objeto no Banco de dados.
     * @since 1.0.0
     */
    public void inserir(Persistente obj) {
        try {
            insere(obj);
        } catch (HibernateException ex) {
            log.error(ex.getMessage());
            throw new HibernateException(ex.getMessage());
        }
    }

    public void inserir(Persistente obj, Session sessao) {
        try {
            insere(obj, sessao);
        } catch (HibernateException ex) {
            log.error(ex.getMessage());
            throw new HibernateException(ex.getMessage());
        }
    }

    /**
     * Função que altera um registro no Banco de Dados.
     *
     * @param obj Um objeto Persistente para ser alterado no Banco de Dados.
     * @exception HibernateException Erro ao alterar o Objeto no Banco de dados.
     * @since 1.0.0
     */
    public void alterar(Persistente obj) {
        try {
            altera(obj);
        } catch (StaleObjectStateException ex) {
            throw ex;
        } catch (TransientObjectException ex) {
            throw ex;
        } catch (ConstraintViolationException ex) {
            throw ex;
        } catch (HibernateException ex) {
            log.error(ex.getMessage());
            throw new HibernateException(ex.getMessage());
        }
    }

    public void alterarByUpDate(Persistente obj) {
        try {
            alterarByUpDate(obj);
        } catch (HibernateException ex) {
            log.error(ex.getMessage());
            throw new HibernateException(ex.getMessage());
        }
    }

    public void alterar(Persistente obj, Session sessao) {
        try {
            altera(obj, sessao);
        } catch (HibernateException ex) {
            log.error(ex.getMessage());
            throw new HibernateException(ex.getMessage());
        }
    }

    /**
     * Função que deleta um registro no Banco de Dados.
     *
     * @param obj Um objeto Persistente para ser deletado no Banco de Dados.
     * @exception HibernateException Erro ao deletar o Objeto no Banco de dados.
     * @since 1.0.0
     */
    public void deletar(Object obj) {
        try {
            deleta(obj);
        } catch (HibernateException ex) {
            log.error(ex.getMessage());
            throw new HibernateException(ex.getMessage());
        }
    }

    /**
     * Função que busca um registro no Banco de Dados.
     *
     * @param clazz Classe de entidade a ser buscada no Banco de Dados.
     * @param id Valor do campo identificador do registro no Banco de Dados.
     * @return Um objeto do tipo informado no parâmetro clazz.
     * @exception HibernateException Erro ao buscar o Objeto no Banco de dados.
     * @since 1.0.0
     */
    public static Object buscarPorId(Class clazz, int id) {
        try {
            return buscaPorId(clazz, id);
        } catch (HibernateException ex) {
            log.error(ex.getMessage());
            throw new HibernateException(ex.getMessage());
        }
    }

    /**
     * Função que busca um registro no Banco de Dados.
     *
     * @param clazz Classe de entidade a ser buscada no Banco de Dados.
     * @param id Valor do campo identificador do registro no Banco de Dados.
     * @return Um objeto do tipo informado no parâmetro clazz.
     * @exception HibernateException Erro ao buscar o Objeto no Banco de dados.
     * @since 1.0.0
     */
    public static Object buscarPorString(Class clazz, String id) {
        try {
            return buscaPorString(clazz, id);
        } catch (HibernateException ex) {
            log.error(ex.getMessage());
            throw new HibernateException(ex.getMessage());
        }
    }

    /**
     * Função que retorna uma lista de registros no Banco de Dados.
     *
     * @param clazz Classe de entidade a ser listada no Banco de Dados.
     * @return Uma lista de registros daquela Entidade.
     * @exception HibernateException Erro ao listar os Objetos no Banco de
     * dados.
     * @since 1.0.0
     */
    public List listar(Class clazz) {
        try {
            return lista(clazz);
        } catch (HibernateException ex) {
            log.error(ex.getMessage());
            throw new HibernateException(ex.getMessage());
        }
    }

    /**
     * Atualiza um objeto através da função de refresh do JPA.
     *
     * @param obj Objeto a ser recarregado com as informações do Banco de Dados.
     * @exception HibernateException Erro ao recerragar o Objeto no Banco de
     * dados.
     * @since 1.0.2
     */
    public void recarregar(Object obj) {
        try {
            recarrega(obj);
        } catch (HibernateException ex) {
            log.error(ex.getMessage());
            throw new HibernateException(ex.getMessage());
        }
    }

    /**
     * Realiza toda a validação e padronização da Alocação de um <b>Object</b>
     * do BD.
     *
     * @param sessao Sessão aberta com o BD.
     * @param query <b>Query</b> a ser utlizada para a Alocação.
     * @return Um <b>Object</b> derivado da busca realizada.
     * @throws AlocacaoException Não foi possível alocar nenhum <b>Object</b>.
     * @since 1.0.0
     */
    @SuppressWarnings({"SleepWhileInLoop", "null"})
    protected static Object validaAlocacao(Session sessao, Query query) throws AlocacaoException {
        Object obj;
        Integer tentativas = 0, maxTentativas = 2;

        log.info("Validando alocação.");

        do {
            try {
                obj = query.uniqueResult();

                if (obj == null) {
                    throw new RegistroNaoEncontradoException();
                } else {
                    return obj;
                }
            } catch (RuntimeException ex) {
                log.error("Erro: " + ex.getMessage());
                throw new AlocacaoException("Problemas na consulta para alocação.");
            } catch (RegistroNaoEncontradoException ex) {
                if (tentativas <= maxTentativas) {
                    log.warn("Nenhum registro encontrado. Tentando novamente em 5 segundos.");

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex1) {
                        log.error("Validando Alocação: " + ex1.getMessage());
                    }
                } else {
                    throw new AlocacaoException("Sem dados para alocar.");
                }
            }

            tentativas++;
        } while (true);
    }
}
