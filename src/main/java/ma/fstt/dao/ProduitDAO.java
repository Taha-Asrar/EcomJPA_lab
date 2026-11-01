package ma.fstt.dao;

import ma.fstt.entities.Produit;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ProduitDAO {
    
    public void save(Produit produit) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(produit);
        em.getTransaction().commit();
        em.close();
    }

    public List<Produit> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Produit> produits = em.createQuery("SELECT p FROM Produit p", Produit.class).getResultList();
        em.close();
        return produits;
    }
    public Produit findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Produit produit = em.find(Produit.class, id);
        em.close();
        return produit;
    }
}