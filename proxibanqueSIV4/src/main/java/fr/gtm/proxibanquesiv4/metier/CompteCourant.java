package fr.gtm.proxibanquesiv4.metier;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * ComtpeCourant est la classe repr�sentant un compte courant. Elle h�rite de la
 * sur-classe Compte.
 * 
 * @author Guillaume Jamin,Séverine Romano
 * @version 3.0
 *
 */
@SuppressWarnings("serial")
@Entity
@Component
@DiscriminatorValue("COURANT")
public class CompteCourant extends Compte {

	@Transient
	private static Logger logger = Logger.getLogger(CompteCourant.class);
	
	/**
	 * authDecouvert correspond � la valeur en euro de l'autorisation de
	 * d�couvert du compte courant.
	 */
	@Column(name="decouvert")
	private double authDecouvert = 1000;

	public CompteCourant() {
		super();
		logger.info("Constructeur par défaut de la classe modele.CompteCourant");
	}

	/**
	 * Constructeur avec les arguments de la classe Compte
	 * 
	 * @param numeroCompte
	 *            numero unique d'identification du compte courant
	 * @param solde
	 *            montant présent du le compte courant
	 * @param dateOuverture
	 *            date d'ouverture du compte courant dans l'agence
	 */
	public CompteCourant(Long numeroCompte, double solde, Date dateOuverture) {
		super(numeroCompte, solde, dateOuverture);
	}

	
	/**
	 * Retourne la valeur du d�couvert du compte courant.
	 * 
	 * @return La valeur du d�couvert du compte courant.
	 */
	public double getAuthDecouvert() {
		return authDecouvert;
	}

	/**
	 * Met � jour la valeur du d�ouvert du compte courant.
	 * 
	 * @param authDecouvert
	 *            Le nouveau d�couvert du compte courant.
	 */
	public void setAuthDecouvert(double authDecouvert) {
		this.authDecouvert = authDecouvert;
	}

}