/**
 * 
 */
package fr.gtm.proxibanquesiv4.metier;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.log4j.Logger;

/**
 * 
 * @author guillaume Jamin, Severine Romano
 * @version 3.0
 */
@SuppressWarnings("serial")
@Entity
@Table
public class Coordonnees implements Serializable {

	@Transient
	private static Logger logger = Logger.getLogger(Coordonnees.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idC;
	/**
	 * L'adresse de la personne. Cette adresse est entree et est modifiable par
	 * le conseiller.
	 */
	private String adresse;

	/**
	 * Le numero de code postal de la personne. Ce code postal est entre et est
	 * modifiable par le conseiller.
	 */
	private int codePostal;

	/**
	 * Le nom de la ville ou habite la personne. Le nom de la ville est entre et
	 * est modifiable par le conseiller.
	 */
	private String ville;

	/**
	 * Le numero de telephone de la personne. Ce numero est entre et est
	 * modifiable par le conseiller.
	 */
	private String telephone;

	/**
	 * L'email de la personne. Cet email est entre et est modifiable par le
	 * conseiller.
	 */
	private String email;

	/**
	 * constructeur par defaut de la classe Coordonnees
	 */
	public Coordonnees() {
		logger.info("Constructeur par défaut de la classe modele.Coordonnees");

	}

	/**
	 * cosntructeur avec tous les arguments de la classe coordonnees
	 * 
	 * @param adresse
	 *            adresse de la personne
	 * @param codePostal
	 *            numero de code postal de la personne
	 * @param ville
	 *            nom de la ville ou habite la personne
	 * @param telephone
	 *            numero de telephone de la personne
	 * @param email
	 *            email de la personne
	 */
	public Coordonnees(String adresse, int codePostal, String ville, String telephone, String email) {
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the idC
	 */
	public int getIdC() {
		return idC;
	}

	/**
	 * @param idC
	 *            the idC to set
	 */
	public void setIdC(int idC) {
		this.idC = idC;
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
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + codePostal;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idC;
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		if (!(obj instanceof Coordonnees))
			return false;
		Coordonnees other = (Coordonnees) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (codePostal != other.codePostal)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idC != other.idC)
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

}
