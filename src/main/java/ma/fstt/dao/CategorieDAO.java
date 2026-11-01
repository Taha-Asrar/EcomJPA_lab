package ma.fstt.dao;

import ma.fstt.entities.Categorie;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CategorieDAO {
    
    public void save(Categorie categorie) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(categorie);
        em.getTransaction().commit();
        em.close();
    }

    public Categorie findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Categorie categorie = em.find(Categorie.class, id);
        em.close();
        return categorie;
    }

    public List<Categorie> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Categorie> categories = em.createQuery("SELECT c FROM Categorie c", Categorie.class).getResultList();
        em.close();
        return categories;
    }
}