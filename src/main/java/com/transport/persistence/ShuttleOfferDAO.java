package com.transport.persistence;

import com.transport.model.ShuttleOffer;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.List;

public class ShuttleOfferDAO {

    public void create(ShuttleOffer offer) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(offer);
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

    public List<ShuttleOffer> findAll() {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT so FROM ShuttleOffer so", ShuttleOffer.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<ShuttleOffer> searchByCities(String departureCity, String arrivalCity) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT so FROM ShuttleOffer so WHERE so.departureCity = :departure AND so.arrivalCity = :arrival", ShuttleOffer.class)
                    .setParameter("departure", departureCity)
                    .setParameter("arrival", arrivalCity)
                    .getResultList();
        } finally {
            em.close();
        }
    }
    public List<ShuttleOffer> findByCompanyId(Long companyId) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT so FROM ShuttleOffer so WHERE so.company.id = :companyId", ShuttleOffer.class)
                    .setParameter("companyId", companyId)
                    .getResultList();
        } finally {
            em.close();
        }
    }
    /** Find a ShuttleOffer by its ID */
    public ShuttleOffer findById(Long id) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        try {
            return em.find(ShuttleOffer.class, id);
        } finally {
            em.close();
        }
    }
    /** Merge changes into an existing ShuttleOffer */
    public void update(ShuttleOffer offer) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(offer);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    /** Delete a ShuttleOffer by its ID */
    public void delete(Long id) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ShuttleOffer offer = em.find(ShuttleOffer.class, id);
            if (offer != null) {
                em.remove(offer);
            }
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }




}
