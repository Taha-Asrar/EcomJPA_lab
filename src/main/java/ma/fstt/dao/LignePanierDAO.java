package ma.fstt.dao;

import ma.fstt.entities.LignePanier;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

@ApplicationScoped
public class LignePanierDAO {
    
    public void save(LignePanier lignePanier) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(lignePanier);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        LignePanier lignePanier = em.find(LignePanier.class, id);
        if (lignePanier != null) {
            em.remove(lignePanier);
        }
        em.getTransaction().commit();
        em.close();
    }
}