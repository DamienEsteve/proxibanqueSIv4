/**
 * 
 */
package fr.gtm.proxibanquesiv4.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Guillaume Jamin, Severine Romano, Damien Esteve, Kevin BUEWAERT
 * @version 4.0
 */
@Entity
@Component
public class Conseiller extends Utilisateur implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	/**
	 * Collection privee de type Client contenant tous les clients dont s'occupe
	 * le conseiller. que le client a ouvert dans la banque. Un conseiller peut
	 * gerer les comptes bancaires de plusiers client a la fois.
	 */
	@OneToMany(mappedBy = "conseiller")
	private List<Client> listeClient;

	@ManyToOne
	private Gerant gerant;

	/**
	 * Constructeur par defaut de la classe Conseiller
	 */
	public Conseiller() {
		setListeClient(new ArrayList<Client>());
	}

	/**
	 * Constructeur avec arguments de la classe client
	 * 
	 * @param gerant
	 *            personne qui gere les affaires bancaires du client, de type
	 *            gerant
	 */
	public Conseiller(Gerant gerant) {
		this();
		this.gerant = gerant;
	}

	/**
	 * @param nom
	 *            nom du conseiller, de type String
	 * @param prenom
	 *            prenom du conseiller, de type String
	 * @param idPersonne
	 *            identifiant unique du conseiller, de type long
	 * @param coordonnees
	 *            objet de type coordonnees contenant toutes les informations
	 *            relatives a l'adresse du conseiller
	 * @param gerant
	 *            objet de type gerant contenant toutes les informations
	 *            relatives au gerant attribue au conseiller
	 */
	public Conseiller(String nom, String prenom, int idPersonne, Coordonnees coordonnees, Gerant gerant) {
		super();
		this.gerant = gerant;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public List<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}

}
