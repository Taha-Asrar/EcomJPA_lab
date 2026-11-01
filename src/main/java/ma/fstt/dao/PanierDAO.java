package ma.fstt.dao;

import ma.fstt.entities.Panier;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

@ApplicationScoped
public class PanierDAO {
    
    public void save(Panier panier) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(panier);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Panier panier) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(panier);
        em.getTransaction().commit();
        em.close();
    }

    public Panier findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Panier panier = em.find(Panier.class, id);
        if (panier != null) {
            em.refresh(panier);
            if (panier.getLignes() != null) {
                panier.getLignes().size();
            }
        }
        em.close();
        return panier;
    }
}
