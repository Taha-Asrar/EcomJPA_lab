package ma.fstt.dao;

import ma.fstt.entities.Internaute;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class InternauteDAO {
    
    public void save(Internaute internaute) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(internaute);
        em.getTransaction().commit();
        em.close();
    }

    public Internaute findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Internaute internaute = em.find(Internaute.class, id);
        em.close();
        return internaute;
    }

    public List<Internaute> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Internaute> internautes = em.createQuery("SELECT i FROM Internaute i", Internaute.class).getResultList();
        em.close();
        return internautes;
    }
}