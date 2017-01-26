package fr.gtm.proxibanquesiv4.presentation;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.gtm.proxibanquesiv4.metier.Client;
import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.service.IServiceConseiller;

@Controller("clientbean")
@SessionScoped
public class ClientDTO implements Serializable {

	private long id;
	private String telephone;
	private String nom, prenom, email, adresse, ville, civilite;
	int cp;
	private List<Compte> listecomptes;

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

	public void creerClient(Client client) {
		serviceconseiller.createClient(client);
	}
	
	public void modifierClient(Client client) {
		serviceconseiller.updateClient(client);
	}
	
	public List<Compte> ListeComptesParClient(long id) {
		return setListecomptes(serviceconseiller.selectComptesByClientId(id));
	}
	
	public List<Compte> ListeAllComptes() {
		return setListecomptes(serviceconseiller.selectAllComptes());
	}
	public String goModifCli(){
		return "modifclient?faces-redirect=true";
	}
	public String modifClient(){
		Client cl = new Client();
		cl.setNom(this.nom);
		cl.setPrenom(this.prenom);
		cl.getCoordonneesClient().setAdresse(this.adresse);
		cl.getCoordonneesClient().setCodePostal(this.cp);
		cl.getCoordonneesClient().setEmail(this.email);
		cl.getCoordonneesClient().setTelephone(this.telephone);
		cl.getCoordonneesClient().setVille(this.ville);
		cl.setCivilite(this.civilite);
		serviceconseiller.updateClient(cl);
		return "indexConseiller?faces-redirect=true";
	}
	
}