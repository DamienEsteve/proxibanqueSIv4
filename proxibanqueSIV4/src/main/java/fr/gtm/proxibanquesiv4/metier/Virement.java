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

/**
 * 
 * @author Guillaume Jamin, Severine Romano, Damien Esteve, Kevin BUEWAERT 
 * @version 4.0
 *
 */
@Entity
@Component
public class Virement {

	/**
	 * L'id du virement. En base de données, correspond à la clé primaire de la table coordonées.
	 */		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVirement;

	/**
	 * Le compte débiteur. 
	 */	
	@OneToOne
	@JoinColumn(name = "cpt_debit")
	private Compte compteDebiteur;

	/**
	 * Le compte créditeur. 
	 */	
	@OneToOne
	@JoinColumn(name = "cpt_credit")
	private Compte compteCrediteur;

	/**
	 * La date d'execution du virement.
	 */	
	@Column(nullable = false)
	private Date dateExecution;
	
	/**
	 * Le montant du virement.
	 */	
	@Column(nullable = false)
	private double montant;

	/**
	 * Constructeur par defaut de la classe Virement
	 */
	public Virement() {
	}

	/**
	 * @return compteDebiteur
	 */
	public Compte getCompteDebiteur() {
		return compteDebiteur;
	}
	
	/**
	 * @param compteDebiteur
	 *            Le compteDebiteur à modifier
	 */
	public void setCompteDebiteur(Compte compteDebiteur) {
		this.compteDebiteur = compteDebiteur;
	}

	/**
	 * @return compteCrediteur
	 */
	public Compte getCompteCrediteur() {
		return compteCrediteur;
	}

	/**
	 * @param compteDebiteur
	 *            Le compteCrediteur à modifier
	 */
	public void setCompteCrediteur(Compte compteCrediteur) {
		this.compteCrediteur = compteCrediteur;
	}

	/**
	 * @return dateExecution
	 */
	public Date getDateExecution() {
		return dateExecution;
	}

	/**
	 * @param dateExecution
	 *            Le date d'execution du virement à modifier
	 */
	public void setDateExecution(Date dateExecution) {
		this.dateExecution = dateExecution;
	}

	/**
	 * @return montant
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * @param montant
	 *            La valeur du montant à modifier
	 */	
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * @return idVirement
	 */
	public Long getIdVirement() {
		return idVirement;
	}
	
	/**
	 * @param idVirement
	 *            l'id du virement à modifier
	 */	
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