package fr.gtm.proxibanquesiv4.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Guillaume Jamin, Severine Romano, Damien Esteve, Kevin BUEWAERT 
 * @version 4.0
 *
 */
@SuppressWarnings("serial")
@Entity
@Component
@Table(indexes ={ @Index(columnList = "login", unique=true) })
public abstract class Utilisateur extends Personne{

	/**
	 * Le login de l'utilisateur. Permet de g�rer les acc�s en base de donn�es.
	 */
	@Column(nullable=false)
	private String login;
	
	/**
	 * Le mot de passe de l'utilisateur. Permet de g�rer les acc�s en base de donn�es.
	 */
	@Column(nullable=false)
	private String password;
	
	/**
	 * Constructeur par defaut de la classe utilisateur
	 */	
	public Utilisateur() {
	}

	/**
	 * @return login
	 */	
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            le login � modifier
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return password
	 */	
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password
	 *            le password � modifier
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}