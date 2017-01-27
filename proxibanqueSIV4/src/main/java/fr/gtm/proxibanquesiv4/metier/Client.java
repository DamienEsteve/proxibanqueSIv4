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
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

/**
 * 
 * Client est la classe representant un client de la banque.
 * 
 * @author Guillaume Jamin, Severine Romano, Damien Esteve, Kevin BUEWAERT
 * @version 4.0
 *
 */
@Entity
@Component
public class Client extends Personne implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	/**
	 * Objet prive de type Conseiller contenant toutes les informations
	 * relatives au conseiller attribue au client. Un objet de type client ne
	 * peut avoir qu'un seul conseiller.
	 */
	@ManyToOne
	private Conseiller conseiller;

	/**
	 * Collection privee de type Compte contenant tous les comptes disponibles
	 * que le client a ouvert dans la banque. Un client peut avoir plusieurs
	 * compte a la fois.
	 */
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Compte> listeCompte;

	/**
	 * Objet de type coordonnees contenant toutes les informations relatives a
	 * l'adresse du client. Un client peut avoir une ou plusieurs coordonnees.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	private Coordonnees coordonneesClient;

	/**
	 * Objet de type booleen permettant d'indiquer si le compte creer pour le
	 * client est un compte lie a une activite d'entreprise (true) ou non
	 * (false). Cette colonne est par défaut false.
	 */
	@Column(nullable = false)
	private boolean estSociete;

	/**
	 * Le constructeur de la classe Client sans parametre. Il initialise une
	 * liste de compte et permet d'entrer les informations pour creer un objet
	 * de type coordonnees lie au client
	 */
	public Client() {
		super();
		setListeCompte(new ArrayList<Compte>());
		this.coordonneesClient = new Coordonnees();
	}

	/**
	 * Constructeur avec arguement de la classe Client
	 * 
	 * @param nom
	 *            nom de famille du client, de type String
	 * @param prenom
	 *            prenom du client, de type String
	 * @param idPersonne
	 *            identifiant unique du client, de type long
	 * @param coordonnees
	 *            objet de type coordonnees qui contient l'adresse du client
	 * @param cc
	 *            objet de type compte qui contient les informations relatives
	 *            au compte courant
	 * @param ce
	 *            objet de type compte qui contient les informations relatives
	 *            au compte epargne
	 * @param conseiller
	 *            objet de type conseiller qui contient toutes les informations
	 *            relatives au conseiller attribue au client
	 * @param listeCompte
	 *            liste de tous les comptes du client
	 */
	public Client(String nom, String prenom, int idPersonne, Coordonnees coordonnees, Conseiller conseiller,
			List<Compte> listeCompte) {
		super(nom, prenom, idPersonne, coordonnees);
		this.conseiller = conseiller;
		setListeCompte(listeCompte);
	}

	/**
	 * Accesseur de type get d'un objet de type conseiller lie au client
	 * 
	 * @return un objet de type conseiller
	 */
	public Conseiller getConseiller() {
		return conseiller;
	}

	/**
	 * Accesseur de type set d'un objet de type conseiller lie au client
	 * 
	 * @param conseiller
	 *            objet de type conseiller
	 */
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	/**
	 * Accesseur de type get d'une collection qui contient des objets de type
	 * Compte.
	 * 
	 * @return the listeCompte une liste de type ArrayList qui contient des
	 *         objet de type Compte
	 */
	public List<Compte> getListeCompte() {
		return listeCompte;
	}

	/**
	 * Accesseur de type set d'une collection qui contient des objets de type
	 * 
	 * @param listeCompte
	 *            the listeCompte to set
	 */
	public void setListeCompte(List<Compte> listeCompte) {
		for (Compte c : listeCompte)
			c.setClient(this);
		this.listeCompte = listeCompte;
	}

	/**
	 * Accesseur de type get d'un objet de type coordonnees lie au client
	 * 
	 * @return un objet de type coordonnees
	 */
	public Coordonnees getCoordonneesClient() {
		return coordonneesClient;
	}

	/**
	 * Accesseur de type set d'un objet de type coordonnees lie au client
	 * 
	 * @param coordonneesClient
	 *            un objet de type coordonnees
	 */
	public void setCoordonneesClient(Coordonnees coordonneesClient) {
		this.coordonneesClient = coordonneesClient;
	}

	/**
	 * Accesseur de type get permettant de recuperer la valeur de estSociete
	 * 
	 * @return un booleen, par defaut initialise a false
	 */
	public boolean isEstSociete() {
		return estSociete;
	}

	/**
	 * Accesseur de type set permettant de modifier la valeur de estSociete
	 * 
	 * @param estSociete
	 *            un booleen par defaut initialise a false
	 */
	public void setEstSociete(boolean estSociete) {
		this.estSociete = estSociete;
	}

	/**
	 * Methode permettant d'afficher directement les valeurs de chacuns des
	 * attributs de la classe, et non pas l'adresse memoire
	 */
	public String toString() {
		return "Client [nom=" + super.getNom() + ", prenom=" + super.getPrenom() + ", adresse="
				+ getCoordonneesClient().getAdresse() + ", codePostal=" + getCoordonneesClient().getCodePostal()
				+ ", ville=" + getCoordonneesClient().getVille() + ", telephone="
				+ getCoordonneesClient().getTelephone() + ", email=" + getCoordonneesClient().getEmail() + "idco : "
				+ getCoordonneesClient().getIdCoordonnees() + "]";
	}

}