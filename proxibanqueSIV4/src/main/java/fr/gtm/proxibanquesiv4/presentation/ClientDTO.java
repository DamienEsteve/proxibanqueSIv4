package fr.gtm.proxibanquesiv4.presentation;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.gtm.proxibanquesiv4.metier.Client;
import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.metier.Conseiller;
import fr.gtm.proxibanquesiv4.metier.Coordonnees;
import fr.gtm.proxibanquesiv4.service.IServiceConseiller;

/**
 * Classe permettant de
 * 
 * @author Guillaume Jamin, Severine Romano, Damien Esteve, Kevin BUEWAERT
 * @version 4.0
 * 
 *          Annotations : Controller bean permettant de naviguer entre les
 *          couches web et presentation SessionSoped Sauvegarde des donnees en
 *          fonction de la session
 *
 */
@SuppressWarnings("serial")
@Controller("clientbean")
@SessionScoped
public class ClientDTO implements Serializable {

	private long id, idC;
	private String telephone;
	private String nom, prenom, email, adresse, ville, civilite;
	int cp;
	private List<Compte> listecomptes;
	private Conseiller conseiller;

	/**
	 * Annotation permettant d'injecter la couche service
	 */
	@Autowired
	public IServiceConseiller serviceconseiller;

	/**
	 * Constructeur par defaut de la classe ClientDTO
	 */
	public ClientDTO() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdC() {
		return idC;
	}

	public void setIdC(long idC) {
		this.idC = idC;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public List<Compte> getListecomptes() {
		return listecomptes;
	}

	public List<Compte> setListecomptes(List<Compte> listecomptes) {
		this.listecomptes = listecomptes;
		return listecomptes;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	/**
	 * Methode permettant d'appeler la methode qui cree un client dans le
	 * package service
	 * 
	 * @param client
	 *            objet de type client
	 */
	public void creerClient(Client client) {
		serviceconseiller.createClient(client);
	}

	/**
	 * Methode permettant d'appeler la methode qui met a jour la fiche d'un
	 * client dans le package service
	 * 
	 * @param client
	 *            objet de type client
	 */
	public void modifierClient(Client client) {
		serviceconseiller.updateClient(client);
	}

	/**
	 * Methode permettant de recuperer la liste des comtpes disponibles d'un
	 * client, elle fait appelle a une methode qui selectionne les comptes
	 * disponibles d'un client selon l'identifiant du client dans le package
	 * service
	 * 
	 * @return une collection ce type Compte
	 */
	public List<Compte> ListeComptesParClient() {
		return setListecomptes(serviceconseiller.selectComptesByClientId(this.id));
	}

	/**
	 * Methode permettant de recuperer la liste de tous les comtpes disponibles
	 * de la banque, elle fait appelle a une methode dans le package service
	 * 
	 * @return une collection ce type Compte
	 */
	public List<Compte> ListeAllComptes() {
		return setListecomptes(serviceconseiller.selectAllComptes());
	}

	/**
	 * Methode permettant de rediriger le conseiller sur la page web de creation
	 * d'une fiche client. Par defaut les champs presentes sont mis a null ou 0
	 * selon l'attribut demande.
	 * 
	 * @return une chaine de caracteres qui vous redirige vers une autre page du
	 *         site
	 */
	public String goCreerCli() {
		this.adresse = null;
		this.civilite = null;
		this.conseiller = null;
		this.email = null;
		this.cp = 0;
		this.idC = 0;
		this.listecomptes = null;
		this.nom = null;
		this.prenom = null;
		this.telephone = null;
		this.ville = null;
		return "creerclient?faces-redirect=true";
	}

	/**
	 * Methode permettant de rediriger le conseiller sur la page web de
	 * modification d'une fiche client. Par defaut les champs presentes sont
	 * remplis avec les attributs presents en base de donnees.
	 * 
	 * @return une chaine de caracteres qui vous redirige vers une autre page du
	 *         site
	 */
	public String goModifCli() {
		return "modifclient?faces-redirect=true";
	}

	/**
	 * Methode permettant au conseiller de voir la liste de ses clients en page
	 * d'accueil de son espace personnel.
	 * 
	 * @return une chaine de caracteres qui vous redirige vers une autre page du
	 *         site
	 */
	public String goCompteCli() {
		return "listecompte?faces-redirect=true";
	}

	/**
	 * Methode permettant d'enregistrer en base de donnees les informations
	 * entrees dans les champs de la page web permettant de modifier une fiche
	 * existante d'un client.
	 * 
	 * @return redirige le conseiller sur la page d'accueil du conseiller
	 */
	public String modifClient() {
		Client cl = new Client();
		cl.setNom(this.nom);
		cl.setPrenom(this.prenom);
		cl.setIdPersonne(this.id);
		cl.getCoordonneesClient().setAdresse(this.adresse);
		cl.getCoordonneesClient().setCodePostal(this.cp);
		cl.getCoordonneesClient().setEmail(this.email);
		cl.getCoordonneesClient().setTelephone(this.telephone);
		cl.getCoordonneesClient().setVille(this.ville);
		cl.getCoordonneesClient().setIdCoordonnees(this.idC);
		cl.setCivilite(this.civilite);
		cl.setConseiller(this.conseiller);
		serviceconseiller.updateClient(cl);
		return "indexConseiller?faces-redirect=true";
	}

	/**
	 * Methode permettant d'enregistrer en base de donnees les informations
	 * entrees dans les champs de la page web permettant de creer une nouvelle
	 * fiche client.
	 * 
	 * @return redirige le conseiller sur la page d'accueil du conseiller
	 */
	public String creerClient() {
		Client cl = new Client();
		cl.setNom(this.nom);
		cl.setPrenom(this.prenom);
		Coordonnees coord = new Coordonnees(adresse, cp, ville, telephone, email);
		cl.setCoordonneesClient(coord);
		cl.setCivilite(this.civilite);
		String login = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		Conseiller cons = serviceconseiller.selectConseillerByLogin(login);
		cl.setConseiller(cons);
		serviceconseiller.createClient(cl);
		return "indexConseiller?faces-redirect=true";
	}

}