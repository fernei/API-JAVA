package com.accenture.apiautomacao.dao;

import com.accenture.apiautomacao.connection.ConnectionFactory;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Criteria;
import org.hibernate.StaleObjectStateException;
import org.hibernate.TransientObjectException;
import org.hibernate.exception.ConstraintViolationException;

/**
 * Classe que encapsula todas as funções de Banco de Dados com o Hibernate
 *
 * @author otavio.c.ferreira
 * @since 1.0.0
 */
public class GenericDAO {

    protected void insere(Object obj) {
        try (Session sessao = new ConnectionFactory().getSession()) {
            sessao.getTransaction().begin();
            sessao.persist(obj);
            sessao.flush();
            sessao.getTransaction().commit();
        } catch (Exception ex) {
            throw new HibernateException(ex.getMessage());
        }
    }

    protected void insere(Object obj, Session sessao) {
        sessao.getTransaction().begin();
        sessao.persist(obj);
    }

    protected void altera(Object obj) {
        try {
            Session sessao = new ConnectionFactory().getSession();
            sessao.getTransaction().begin();
            sessao.merge(obj);
            sessao.flush();
            sessao.getTransaction().commit();
        } catch (StaleObjectStateException ex) {
            throw ex;
        } catch (TransientObjectException ex) {
            throw ex;
        } catch (ConstraintViolationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    protected void altera(Object obj, Session sessao) {
        sessao.getTransaction().begin();
        sessao.merge(obj);
    }

    protected void deleta(Object obj) {
        try (Session sessao = new ConnectionFactory().getSession()) {
            sessao.getTransaction().begin();
            sessao.delete(obj);
            sessao.flush();
            sessao.getTransaction().commit();
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    protected static Object buscaPorId(Class clazz, int id) {
        try (Session sessao = new ConnectionFactory().getSession()) {
            return sessao.get(clazz, id);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    protected static Object buscaPorString(Class clazz, String id) {
        try (Session sessao = new ConnectionFactory().getSession()) {
            return sessao.get(clazz, id);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    protected List lista(Class clazz) {
        try (Session sessao = new ConnectionFactory().getSession()) {
            Criteria selectAll = sessao.createCriteria(clazz);
            List objts = selectAll.list();
            return objts;
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    protected static void recarrega(Object obj) {
        try (Session sessao = new ConnectionFactory().getSession()) {
            sessao.refresh(obj);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    protected void salvarOuAtualizarTodos(List<Object> lista) {
        try (Session sessao = new ConnectionFactory().getSession()) {
            sessao.getTransaction().begin();

            for (Object obj : lista) {
                sessao.merge(obj);
            }

            sessao.flush();
            sessao.getTransaction().commit();
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
