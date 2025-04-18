package com.transport.persistence;

import com.transport.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

public class UserDAO {

    public void create(User user) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(user);
            tx.commit();
        } finally {
            if (tx.isActive()) tx.rollback();
            em.close();
        }
    }

    public User findByEmail(String email) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
