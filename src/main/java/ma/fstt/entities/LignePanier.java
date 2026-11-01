package ma.fstt.entities;

import javax.persistence.*;
import lombok.*;

@Entity
public class LignePanier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer quantite;
    private Double sousTotal;

    @ManyToOne
    @JoinColumn(name = "panier_id")
    private Panier panier;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

	public LignePanier() {
		super();
	}

	public LignePanier(Long id, Integer quantite, Double sousTotal, Panier panier, Produit produit) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.sousTotal = sousTotal;
		this.panier = panier;
		this.produit = produit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Double getSousTotal() {
		return sousTotal;
	}

	public void setSousTotal(Double sousTotal) {
		this.sousTotal = sousTotal;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
    
    
}