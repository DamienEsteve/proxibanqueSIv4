package fr.gtm.proxibanquesiv4.metier;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import org.apache.log4j.Logger;


public class Gerant implements Serializable{

	@Transient
	private static final long serialVersionUID = 1L;

	@Transient
	private static Logger logger = Logger.getLogger(Conseiller.class);
	
	private String login,password;
	
	private List<Conseiller> listeConseiller;

	public Gerant() {
		listeConseiller = new ArrayList<Conseiller>();
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Conseiller> getListeConseiller() {
		return listeConseiller;
	}

	public void setListeConseiller(List<Conseiller> listeConseiller) {
		this.listeConseiller = listeConseiller;
	}
	
	
}
