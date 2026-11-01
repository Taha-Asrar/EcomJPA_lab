package ma.fstt.entities;

import javax.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    private Double total;

    @OneToOne
    @JoinColumn(name = "internaute_id")
    private Internaute internaute;

    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LignePanier> lignes;

	public Panier() {
		super();
	}

	public Panier(Long id, Date dateCreation, Double total, Internaute internaute, List<LignePanier> lignes) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
		this.total = total;
		this.internaute = internaute;
		this.lignes = lignes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Internaute getInternaute() {
		return internaute;
	}

	public void setInternaute(Internaute internaute) {
		this.internaute = internaute;
	}

	public List<LignePanier> getLignes() {
		return lignes;
	}

	public void setLignes(List<LignePanier> lignes) {
		this.lignes = lignes;
	}

	public Double calculerTotal() {
		double totalCalcul = 0.0;
		if (this.lignes != null) {
			for (LignePanier ligne : this.lignes) {
				if (ligne.getSousTotal() != null) {
					totalCalcul += ligne.getSousTotal();
				}
			}
		}
		this.total = totalCalcul;
		return this.total;
	}
    
}
