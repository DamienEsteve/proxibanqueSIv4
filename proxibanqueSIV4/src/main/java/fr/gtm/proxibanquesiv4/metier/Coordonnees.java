package fr.gtm.proxibanquesiv4.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Guillaume Jamin, Severine Romano, Damien Esteve, Kevin BUEWAERT
 * @version 4.0
 */
@SuppressWarnings("serial")
@Entity
@Component
public class Coordonnees implements Serializable {
	
	/**
	 * La liste des clients. Plusieurs clients peuvent avoir les mêmes coordonées (exemple : famille)
	 */	
	@OneToMany(mappedBy="coordonneesClient", cascade=CascadeType.ALL)
	private List<Client> listeClient;
	
	/**
	 * L'id des coordonnées. En base de données, correspond à la clé primaire de la table coordonées.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCoordonnees;
	
	/**
	 * L'adresse de la personne. Cette adresse est entree et est modifiable par
	 * le conseiller.
	 */
	@Column(nullable=false)
	private String adresse;

	/**
	 * Le numero de code postal où habite la personne. Ce code postal est entre et est
	 * modifiable par le conseiller.
	 */
	@Column(nullable=false)
	private int codePostal;

	/**
	 * Le nom de la ville où habite la personne. Le nom de la ville est entré et
	 * est modifiable par le conseiller.
	 */
	@Column(nullable=false)
	private String ville;

	/**
	 * Le numero de telephone de la personne. Ce numero est entré et est
	 * modifiable par le conseiller.
	 */
	@Column(nullable=false)
	private String telephone;

	/**
	 * L'email de la personne. Cet email est entre et est modifiable par le
	 * conseiller.
	 */
	@Column(nullable=false, unique=true)
	private String email;

	/**
	 * Constructeur par defaut de la classe Coordonnees
	 */
	public Coordonnees() {
		this.listeClient = new ArrayList<Client>();
	}

	/**
	 * Contructeur avec tous les arguments de la classe coordonnees
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

	/**
	 * @return adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            l'adresse à modifier
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal
	 *            le codePostal à modifier
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return ville
	 */
	public String getVille() {
		return ville;
	}
	
	/**
	 * @param ville
	 *            la ville à modifier
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	
	/**
	 * @param telephone
	 *            le numero de telephone à modifier
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            l'email à modifier
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return idCoordonnees
	 */
	public long getIdCoordonnees() {
		return idCoordonnees;
	}

	/**
	 * @param idC
	 *            les idCoordonnees à modifier
	 */
	public void setIdCoordonnees(long idC) {
		this.idCoordonnees = idC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCoordonnees ^ (idCoordonnees >>> 32));
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
		Coordonnees other = (Coordonnees) obj;
		if (idCoordonnees != other.idCoordonnees)
			return false;
		return true;
	}
}