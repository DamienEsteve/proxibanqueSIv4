package fr.gtm.proxibanquesiv4.metier;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Entity
@Component
public abstract class Utilisateur extends Personne{

	private String login, password;
	
	public Utilisateur() {
		// TODO Auto-generated constructor stub
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
	
	
}
