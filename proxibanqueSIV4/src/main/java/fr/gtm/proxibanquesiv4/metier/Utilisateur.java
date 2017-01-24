package fr.gtm.proxibanquesiv4.metier;

@SuppressWarnings("serial")
public class Utilisateur extends Personne{

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
