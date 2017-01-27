package fr.gtm.proxibanquesiv4.presentation;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.gtm.proxibanquesiv4.metier.Client;
import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.metier.Conseiller;
import fr.gtm.proxibanquesiv4.metier.Coordonnees;
import fr.gtm.proxibanquesiv4.service.IServiceConseiller;

@Controller("clientbean")
@SessionScoped
public class ClientDTO implements Serializable {

	private long id, idC;
	private String telephone;
	private String nom, prenom, email, adresse, ville, civilite;
	int cp;
	private List<Compte> listecomptes;
	private Conseiller conseiller;

	private static Logger logger = Logger.getLogger(ClientDTO.class);

	@Autowired
	IServiceConseiller serviceconseiller;

	public ClientDTO() {
		// TODO Auto-generated constructor stub
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

	public void creerClient(Client client) {
		serviceconseiller.createClient(client);
	}
	
	public void modifierClient(Client client) {
		serviceconseiller.updateClient(client);
	}
	
	public List<Compte> ListeComptesParClient() {
		return setListecomptes(serviceconseiller.selectComptesByClientId(this.id));
	}
	
	public List<Compte> ListeAllComptes() {
		return setListecomptes(serviceconseiller.selectAllComptes());
	}
	public String goCreerCli(){
		this.adresse=null;
		this.civilite=null;
		this.conseiller=null;
		this.email=null;
		this.cp=0;
		this.idC=0;
		this.listecomptes=null;
		this.nom=null;
		this.prenom=null;
		this.telephone=null;
		this.ville=null;
		return "creerclient?faces-redirect=true";
	}
	public String goModifCli(){
		return "modifclient?faces-redirect=true";
	}
	public String goCompteCli(){
		return "listecompte?faces-redirect=true";
	}
	public String modifClient(){
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
	
	public String creerClient(){
		Client cl = new Client();
		cl.setNom(this.nom);
		cl.setPrenom(this.prenom);
		Coordonnees coord = new Coordonnees(adresse, cp, ville, telephone, email);
		cl.setCoordonneesClient(coord);
		cl.setCivilite(this.civilite);
		String login=FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		Conseiller cons = serviceconseiller.selectConseillerByLogin(login);
		cl.setConseiller(cons);
		serviceconseiller.createClient(cl);
		return "indexConseiller?faces-redirect=true";
	}
	
}