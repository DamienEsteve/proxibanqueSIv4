package fr.gtm.proxibanquesiv4.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Entity
@Component
@Table(indexes ={ @Index(columnList = "login", unique=true) })
public abstract class Utilisateur extends Personne{

	@Column(nullable=false)
	private String login;
	
	@Column(nullable=false)
	private String password;
	
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
