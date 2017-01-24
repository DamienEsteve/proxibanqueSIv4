/**
 * 
 */
package fr.gtm.proxibanquesiv4.metier;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.apache.log4j.Logger;

/**
 * 
 * @author Adminl
 *
 */
@Entity
public class Conseiller implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Transient
	private static Logger logger = Logger.getLogger(Conseiller.class);
	
	private String login,password;
	
	private List<Client> listeClient;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ger_cons")
	private Gerant gerant;

	/**
	 * Constructeur par défaut de la classe Conseiller
	 */
	public Conseiller() {
		logger.info("Constructeur par d�faut de la classe modele.Conseiller");
		listeClient = new ArrayList<Client>();
	}

	/**
	 * Constructeur avec arguments de la classe client
	 * 
	 * @param gerant
	 *            personne qui gère les affaires bancaires du client
	 */
	public Conseiller(Gerant gerant) {
		this();
		this.gerant = gerant;
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param idPersonne
	 * @param coordonnees
	 * @param gerant
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

}
