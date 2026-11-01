package ma.fstt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf;

    static {
        
        emf = Persistence.createEntityManagerFactory("ecommercePU");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        System.out.println("Database and tables created successfully!");
        em.close();
    }
}