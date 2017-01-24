/**
 * 
 */
package fr.gtm.proxibanquesiv4.metier;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * 
 * Client est la classe repr�sentant un client de la banque.
 * 
 * @author Guillaume Jamin, Séverine Romano
 * @version 3.0
 *
 */
@Entity
public class Client extends Personne implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "conseiller_id")
	private Conseiller conseiller;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Compte> listeCompte;
	
	private Coordonnees coordonneesClient;

	/**
	 * Le constructeur du client sans param�tre.
	 */
	public Client() {
		super();
		setListeCompte(new ArrayList<Compte>());
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param idPersonne
	 * @param coordonnees
	 * @param cc
	 * @param ce
	 * @param conseiller
	 * @param listeCompte
	 */
	public Client(String nom, String prenom, int idPersonne, Coordonnees coordonnees, Conseiller conseiller, List<Compte> listeCompte) {
		super(nom, prenom, idPersonne, coordonnees);
		this.conseiller = conseiller;
		setListeCompte(listeCompte);
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	/**
	 * @return the listeCompte
	 */
	public List<Compte> getListeCompte() {
		return listeCompte;
	}

	/**
	 * @param listeCompte
	 *            the listeCompte to set
	 */
	public void setListeCompte(List<Compte> listeCompte) {
		for(Compte c : listeCompte)
			c.setClient(this);
		this.listeCompte = listeCompte;
	}

	public Coordonnees getCoordonneesClient() {
		return coordonneesClient;
	}
	public void setCoordonneesClient(Coordonnees coordonneesClient) {
		this.coordonneesClient = coordonneesClient;
	}


	public String toString() {
		return "Client [nom=" + super.getNom() + ", prenom=" + super.getPrenom() + ", adresse="
				+ getCoordonneesClient().getAdresse() + ", codePostal=" + getCoordonneesClient().getCodePostal() + ", ville="
				+ getCoordonneesClient().getVille() + ", telephone=" + getCoordonneesClient().getTelephone() + ", email="
				+ getCoordonneesClient().getEmail() + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */


}