package fr.gtm.proxibanquesiv4.metier;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Virement {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idVirement;
	
	@OneToOne
	@JoinColumn(name="cpt_debit")
	private Compte compteDebiteur;
	
	@OneToOne
	@JoinColumn(name="cpt_credit")
	private Compte compteCrediteur;
	
	@Column(nullable=false)
	private Date dateExecution;
	
	@Column(nullable=false)
	private double montant;
	
	public Virement() {
		// TODO Auto-generated constructor stub
	}

	public Compte getCompteDebiteur() {
		return compteDebiteur;
	}

	public void setCompteDebiteur(Compte compteDebiteur) {
		this.compteDebiteur = compteDebiteur;
	}

	public Compte getCompteCrediteur() {
		return compteCrediteur;
	}

	public void setCompteCrediteur(Compte compteCrediteur) {
		this.compteCrediteur = compteCrediteur;
	}

	public Date getDateExecution() {
		return dateExecution;
	}

	public void setDateExecution(Date dateExecution) {
		this.dateExecution = dateExecution;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Long getIdVirement() {
		return idVirement;
	}

	public void setIdVirement(Long idVirement) {
		this.idVirement = idVirement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compteCrediteur == null) ? 0 : compteCrediteur.hashCode());
		result = prime * result + ((compteDebiteur == null) ? 0 : compteDebiteur.hashCode());
		result = prime * result + ((dateExecution == null) ? 0 : dateExecution.hashCode());
		result = prime * result + ((idVirement == null) ? 0 : idVirement.hashCode());
		long temp;
		temp = Double.doubleToLongBits(montant);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Virement other = (Virement) obj;
		if (compteCrediteur == null) {
			if (other.compteCrediteur != null)
				return false;
		} else if (!compteCrediteur.equals(other.compteCrediteur))
			return false;
		if (compteDebiteur == null) {
			if (other.compteDebiteur != null)
				return false;
		} else if (!compteDebiteur.equals(other.compteDebiteur))
			return false;
		if (dateExecution == null) {
			if (other.dateExecution != null)
				return false;
		} else if (!dateExecution.equals(other.dateExecution))
			return false;
		if (idVirement == null) {
			if (other.idVirement != null)
				return false;
		} else if (!idVirement.equals(other.idVirement))
			return false;
		if (Double.doubleToLongBits(montant) != Double.doubleToLongBits(other.montant))
			return false;
		return true;
	}
	
	
	
	
}
