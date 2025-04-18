package com.transport.persistence;

import com.transport.model.TransportCompany;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.List;

public class TransportCompanyDAO {

    public void create(TransportCompany company) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(company);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public TransportCompany findById(Long id) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        try {
            return em.find(TransportCompany.class, id);
        } finally {
            em.close();
        }
    }

    public TransportCompany findByEmail(String email) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT c FROM TransportCompany c WHERE c.email = :email", TransportCompany.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // return null if no matching email found
        } finally {
            em.close();
        }
    }

    public List<TransportCompany> findAll() {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT c FROM TransportCompany c", TransportCompany.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
