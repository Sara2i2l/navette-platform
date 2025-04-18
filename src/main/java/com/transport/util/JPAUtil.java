package com.transport.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "navettePU";
    private static EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch(Exception e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        if(emf != null) {
            emf.close();
        }
    }
}
