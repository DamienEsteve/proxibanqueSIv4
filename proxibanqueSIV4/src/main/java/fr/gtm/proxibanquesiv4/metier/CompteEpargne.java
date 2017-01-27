package fr.gtm.proxibanquesiv4.metier;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.stereotype.Component;

/**
 *
 * ComtpeEpargne est la classe repr�sentant un compte epargne. Elle h�rite
 * de la sur-classe Compte.
 * 
 * @author Guillaume Jamin, Severine Romano, Damien Esteve, Kevin BUEWAERT
 * @version 4.0
 *
 */
@SuppressWarnings("serial")
@Entity
@Component
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends Compte {

	/**
	 * tauxRemuneration correspond au taux de remuneration du compte (
	 * multiplier par 100 pour l'obtenir en pourcentage).
	 */
	@Column(name = "taux", nullable = false)
	private double tauxRemuneration = 0.03;

	/**
	 * Constructeur par defaut de la classe compte epargne
	 */
	public CompteEpargne() {
	}

	/**
	 * constructeur avec arguments de la classe compte epargne
	 * 
	 * @param numeroCompte
	 *            numero unique d'identification du compte epargne, de type long
	 * @param solde
	 *            montant present sur le compte epargne, de double
	 * @param dateOuverture
	 *            date d'ouverture du compte epargne dans l'agence, de type date
	 */
	public CompteEpargne(Long numeroCompte, double solde, Date dateOuverture) {
		super(numeroCompte, solde, dateOuverture);
	}

	/**
	 * Retourne la valeur du taux de renumeration du compte Epargne.
	 * 
	 * @return La valeur du taux de renumeration du compte Epargne.
	 */
	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	/**
	 * Met a jour la valeur du taux de renumeration du compte Epargne.
	 * 
	 * @param tauxRemuneration
	 *            La nouvelle valeur du taux de renumeration du compte Epargne,
	 *            de type double
	 */
	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

}