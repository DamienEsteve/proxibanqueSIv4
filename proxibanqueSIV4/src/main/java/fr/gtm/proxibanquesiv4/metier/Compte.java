package fr.gtm.proxibanquesiv4.metier;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * Compte est la classe abstraite d'un compte. Cette classe h�rite de deux sous
 * classes : CompteCourant et CompteEpargne.
 * 
 * 
 * @author Guillaume Jamin,Séverine Romano.
 * @version 3.0
 *
 */
@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "COMPTE_TYPE")
@Component
public abstract class Compte implements Serializable {

	@Transient
	private static Logger logger = Logger.getLogger(Compte.class);

	/**
	 * Le numero de Compte. Chaque num�ro est unique.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numeroCompte;

	/**
	 * Le solde du compte.
	 */
	@Column(nullable=false)
	private double solde;

	@ManyToOne
	private Client client;

	/**
	 * La date d'ouverture du compte.
	 */
	private Date dateOuverture;

	/**
	 * Le boolean est vrai si le compte est un compte d'entreprise, faux s'il
	 * s'agit d'un compte particulier
	 */
	@Column(nullable=false)
	private boolean compteEntreprise = false;

	/**
	 * Le constructeur du compte sans param�tre.
	 */
	public Compte() {
		super();
		logger.info("Constructeur par défaut de la classe modele.Compte");
	}

	/**
	 * Le constructeur du Compte. 3 Param�tres sont pris en compte :
	 * 
	 * @param numeroCompte2
	 *            Le num�ro de compte.
	 * @param solde
	 *            Le solde du compte.
	 * @param dateOuverture2
	 *            La date d'ouverture du compte.
	 * 
	 */
	public Compte(Long numeroCompte2, double solde, Date dateOuverture2) {
		this.numeroCompte = numeroCompte2;
		this.solde = solde;
		this.dateOuverture = dateOuverture2;
	}

	/**
	 * Retourne le num�ro de compte.
	 * 
	 * @return Le num�ro de compte.
	 */
	public Long getNumeroCompte() {
		return numeroCompte;
	}

	/**
	 * Met � jour le num�ro de compte du client.
	 * 
	 * @param numeroCompte
	 *            Le nouveau num�ro de compte.
	 */
	public void setNumeroCompte(Long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	/**
	 * Accesseur get de l'attribut solde de la classe Compte
	 * 
	 * @return Le solde du compte.
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * Accesseur set de l'attribut solde de la classe Compte Met � jour le solde
	 * du compte.
	 * 
	 * @param solde
	 *            Le nouveau solde du compte.
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * Retourne la date d'ouverture du compte.
	 * 
	 * @return La date d'ouverture du compte.
	 */
	public Date getDateOuverture() {
		return dateOuverture;
	}

	/**
	 * Accesseur get de l'attribut dateOuverture de la classe Compte Met � jour
	 * la date d'ouverture du compte.
	 * 
	 * @param dateOuverture
	 *            La nouvelle date d'ouverture du compte.
	 */
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	/**
	 * Retourne le type entreprise ou priv�e du compte.
	 * 
	 * @return le type entreprise ou priv�e du compte.
	 */
	public boolean getCompteEntreprise() {
		return compteEntreprise;
	}

	/**
	 * Met � jour le type entreprise ou priv�e du compte
	 * 
	 * @param compteEntreprise
	 *            le type entreprise ou priv�e du compte.
	 */
	public boolean isCompteEntreprise() {
		return compteEntreprise;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + (compteEntreprise ? 1231 : 1237);
		result = prime * result + ((dateOuverture == null) ? 0 : dateOuverture.hashCode());
		result = prime * result + ((numeroCompte == null) ? 0 : numeroCompte.hashCode());
		long temp;
		temp = Double.doubleToLongBits(solde);
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
		Compte other = (Compte) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (compteEntreprise != other.compteEntreprise)
			return false;
		if (dateOuverture == null) {
			if (other.dateOuverture != null)
				return false;
		} else if (!dateOuverture.equals(other.dateOuverture))
			return false;
		if (numeroCompte == null) {
			if (other.numeroCompte != null)
				return false;
		} else if (!numeroCompte.equals(other.numeroCompte))
			return false;
		if (Double.doubleToLongBits(solde) != Double.doubleToLongBits(other.solde))
			return false;
		return true;
	}

	


	
	

}