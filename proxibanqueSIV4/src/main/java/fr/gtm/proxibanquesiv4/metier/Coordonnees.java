/**
 * 
 */
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
import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * @author guillaume Jamin, Severine Romano
 * @version 3.0
 */
@SuppressWarnings("serial")
@Entity
@Component
public class Coordonnees implements Serializable {

	@Transient
	private static Logger logger = Logger.getLogger(Coordonnees.class);

	@OneToMany(mappedBy="coordonneesClient", cascade=CascadeType.ALL)
	private List<Client> listeClient;
	
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
	 * Le numero de code postal de la personne. Ce code postal est entre et est
	 * modifiable par le conseiller.
	 */
	@Column(nullable=false)
	private int codePostal;

	/**
	 * Le nom de la ville ou habite la personne. Le nom de la ville est entre et
	 * est modifiable par le conseiller.
	 */
	@Column(nullable=false)
	private String ville;

	/**
	 * Le numero de telephone de la personne. Ce numero est entre et est
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
	 * constructeur par defaut de la classe Coordonnees
	 */
	public Coordonnees() {
		logger.info("Constructeur par d�faut de la classe metier.Coordonnees");
		this.listeClient = new ArrayList<Client>();
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
	public long getIdCoordonnees() {
		return idCoordonnees;
	}

	/**
	 * @param idC
	 *            the idC to set
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
