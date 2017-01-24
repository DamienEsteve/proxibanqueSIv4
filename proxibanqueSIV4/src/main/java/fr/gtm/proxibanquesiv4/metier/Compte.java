package fr.gtm.proxibanquesiv4.metier;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.apache.log4j.Logger;

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
public abstract class Compte implements Serializable {

	@Transient
	private static Logger logger = Logger.getLogger(Compte.class);
	

	/**
	 * Le numero de Compte. Chaque num�ro est unique.
	 */
	@Id
	private String numeroCompte;

	/**
	 * Le solde du compte.
	 */
	private double solde;

	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;

	/**
	 * La date d'ouverture du compte.
	 */
	private String dateOuverture;

	/**
	 * Le boolean est vrai si le compte est un compte d'entreprise, faux s'il
	 * s'agit d'un compte particulier
	 */
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
	 * @param numeroCompte
	 *            Le num�ro de compte.
	 * @param solde
	 *            Le solde du compte.
	 * @param dateOuverture
	 *            La date d'ouverture du compte.
	 * 
	 */
	public Compte(String numeroCompte, double solde, String dateOuverture) {
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;

	}

	/**
	 * Retourne le num�ro de compte.
	 * 
	 * @return Le num�ro de compte.
	 */
	public String getNumeroCompte() {
		return numeroCompte;
	}

	/**
	 * Met � jour le num�ro de compte du client.
	 * 
	 * @param numeroCompte
	 *            Le nouveau num�ro de compte.
	 */
	public void setNumeroCompte(String numeroCompte) {
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
	public String getDateOuverture() {
		return dateOuverture;
	}

	/**
	 * Accesseur get de l'attribut dateOuverture de la classe Compte Met � jour
	 * la date d'ouverture du compte.
	 * 
	 * @param dateOuverture
	 *            La nouvelle date d'ouverture du compte.
	 */
	public void setDateOuverture(String dateOuverture) {
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
	public void setCompteEntreprise(boolean compteEntreprise) {
		this.compteEntreprise = compteEntreprise;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (compteEntreprise ? 1231 : 1237);
		result = prime * result + ((dateOuverture == null) ? 0 : dateOuverture.hashCode());
		result = prime * result + ((numeroCompte == null) ? 0 : numeroCompte.hashCode());
		long temp;
		temp = Double.doubleToLongBits(solde);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Compte))
			return false;
		Compte other = (Compte) obj;
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

	/**
	 * @return the id
	 */
	public String  getId() {
		return numeroCompte;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	
	

}