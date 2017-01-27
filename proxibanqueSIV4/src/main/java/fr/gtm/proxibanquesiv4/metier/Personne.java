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

	/**
	 * La civilit� du client.
	 */	
	@Column(nullable=false)
	private String civilite;
	
	/**
	 * Numero prive d'identification d'une personne. En base de donn�es, correspond � la cl� primaire des tables conseiller, client et g�rant.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPersonne;


	/*--------------------------------------------------------------------------------*/

	/**
	 * Constructeur par defaut de la classe Personne
	 *
	 */
	public Personne() {
	}

	/**
	 * @param nom le nom de la personne
	 * @param prenom le pr�nom de la personne
	 * @param idPersonne l'identifiant de la personne
	 * @param coordonnees les coordonn�es de la personne
	 */
	public Personne(String nom, String prenom, int idPersonne, Coordonnees coordonnees) {
		this.nom = nom;
		this.prenom = prenom;
		this.idPersonne = idPersonne;
	}

	/** 
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            le nom � modifier
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            le prenom � modifier
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return idPersonne
	 */
	public long getIdPersonne() {
		return idPersonne;
	}

	/**
	 * @param idPersonne
	 *            l'idPersonne � modifier
	 */
	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
	}

	/**
	 * @return civilite
	 */
	public String getCivilite() {
		return civilite;
	}
	
	/**
	 * @param civilite
	 *            la civilite de la personne � modifier
	 */	
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