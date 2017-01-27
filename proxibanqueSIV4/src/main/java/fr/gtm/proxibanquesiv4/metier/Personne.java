/**
 * 
 */
package fr.gtm.proxibanquesiv4.metier;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Guillaume Jamin, Severine Romano, Damien Esteve, Kevin BUEWAERT
 * @version 4.0
 */
@SuppressWarnings("serial")
@Entity
@Component
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne implements Serializable {

	@Transient
	private static Logger logger = Logger.getLogger(Personne.class);

	/**
	 * Le nom du client. Ce nom est entr� et est modifiable par le conseiller.
	 */
	@Column(nullable=false)
	private String nom;

	/**
	 * Le pr�nom du client. Ce pr�nom est entr� et est modifiable par le
	 * conseiller.
	 */
	@Column(nullable=false)
	private String prenom;

	@Column(nullable=false)
	private String civilite;
	
	/**
	 * Numero prive d'identification d'un personne
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPersonne;


	/*--------------------------------------------------------------------------------*/

	/**
	 * Constructeur de la classe Personne
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Personne() {
		logger.info("Constructeur par défaut de la classe modele.Personne");
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param idPersonne
	 * @param coordonnees
	 */
	public Personne(String nom, String prenom, int idPersonne, Coordonnees coordonnees) {
		this.nom = nom;
		this.prenom = prenom;
		this.idPersonne = idPersonne;
	}

	/*--------------------------------------------------------------------------------*/

	/**
	 * Accesseurs de l'attribut nom de la classe Personne
	 * 
	 * @return
	 */
	/**
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Accesseurs de l'attribut prenom de la classe Personne
	 * 
	 * @return
	 */
	/**
	 * 
	 * @return
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Accesseurs de l'attribut idPersonne de la classe Personne
	 */
	/**
	 * @return the idPersonne
	 */
	public long getIdPersonne() {
		return idPersonne;
	}

	/**
	 * @param idPersonne
	 *            the idPersonne to set
	 */
	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getCivilite() {
		return civilite;
	}
	
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idPersonne ^ (idPersonne >>> 32));
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
		Personne other = (Personne) obj;
		if (idPersonne != other.idPersonne)
			return false;
		return true;
	}

	
}
