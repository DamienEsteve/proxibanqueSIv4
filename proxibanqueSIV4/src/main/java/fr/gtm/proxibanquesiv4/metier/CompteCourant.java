package fr.gtm.proxibanquesiv4.metier;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.stereotype.Component;

/**
 * 
 * ComtpeCourant est la classe representant un compte courant. Elle herite de la
 * sur-classe Compte.
 * 
 * @author Guillaume Jamin, Severine Romano, Damien Esteve, Kevin BUEWAERT
 * @version 4.0
 *
 */
@SuppressWarnings("serial")
@Entity
@Component
@DiscriminatorValue("COURANT")
public class CompteCourant extends Compte {

	/**
	 * authDecouvert correspond a la valeur en euro de l'autorisation de
	 * decouvert du compte courant, de type double.
	 */
	@Column(name = "decouvert", nullable = false)
	private double authDecouvert = 1000;

	public CompteCourant() {
		super();
	}

	/**
	 * Constructeur avec les arguments de la classe Compte
	 * 
	 * @param numeroCompte
	 *            numero unique d'identification du compte courant
	 * @param solde
	 *            montant present du le compte courant
	 * @param dateOuverture
	 *            date d'ouverture du compte courant dans l'agence
	 */
	public CompteCourant(Long numeroCompte, double solde, Date dateOuverture) {
		super(numeroCompte, solde, dateOuverture);
	}

	/**
	 * Retourne la valeur du decouvert du compte courant.
	 * 
	 * @return La valeur du decouvert du compte courant.
	 */
	public double getAuthDecouvert() {
		return authDecouvert;
	}

	/**
	 * Met a jour la valeur du decouvert du compte courant.
	 * 
	 * @param authDecouvert
	 *            Le nouveau decouvert du compte courant.
	 */
	public void setAuthDecouvert(double authDecouvert) {
		this.authDecouvert = authDecouvert;
	}

}