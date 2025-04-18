package com.transport.persistence;

import com.transport.model.SubscriptionRequest;
import javax.persistence.*;
import java.util.List;

public class SubscriptionRequestDAO {

    public void create(SubscriptionRequest req) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(req);
            tx.commit();
        } catch (PersistenceException e) {
            // Check for constraint violation (duplicate request)
            if (tx.isActive()) tx.rollback();
            // Find existing request by all criteria
            em.getTransaction().begin();
            SubscriptionRequest existing = em.createQuery(
                            "SELECT r FROM SubscriptionRequest r " +
                                    "WHERE r.user.id = :userId " +
                                    "AND r.departureCity = :dep " +
                                    "AND r.arrivalCity = :arr " +
                                    "AND r.startDate = :sd " +
                                    "AND r.endDate = :ed " +
                                    "AND r.departureTime = :dt " +
                                    "AND r.arrivalTime = :at", SubscriptionRequest.class)
                    .setParameter("userId", req.getUser().getId())
                    .setParameter("dep", req.getDepartureCity())
                    .setParameter("arr", req.getArrivalCity())
                    .setParameter("sd", req.getStartDate())
                    .setParameter("ed", req.getEndDate())
                    .setParameter("dt", req.getDepartureTime())
                    .setParameter("at", req.getArrivalTime())
                    .getSingleResult();

            // Increment and merge
            existing.setInterestedCount(existing.getInterestedCount() + 1);
            em.merge(existing);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Add this for the user dashboard:
    public List<SubscriptionRequest> findByUserId(Long userId) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery(
                            "SELECT r FROM SubscriptionRequest r WHERE r.user.id = :uid",
                            SubscriptionRequest.class)
                    .setParameter("uid", userId)
                    .getResultList();
        } finally {
            em.close();
        }
    }
    /**
     * Retrieve all subscription requests.
     */
    public List<SubscriptionRequest> findAll() {
        EntityManager em = PersistenceManager
                .getEntityManagerFactory()
                .createEntityManager();
        try {
            return em.createQuery("SELECT r FROM SubscriptionRequest r", SubscriptionRequest.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }


}
