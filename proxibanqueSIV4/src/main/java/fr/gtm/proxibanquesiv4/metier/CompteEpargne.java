package fr.gtm.proxibanquesiv4.metier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.log4j.Logger;

/**
 *
 * ComtpeEpargne est la classe repr�sentant un compte epargne. Elle h�rite de la
 * sur-classe Compte.
 * 
 * @author Guillaume Jamin, K�vin Buewaert.
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends Compte {

	@Transient
	private static Logger logger = Logger.getLogger(CompteEpargne.class);
	
	/**
	 * tauxRemuneration correspond au taux de r�mun�ration du compte (�
	 * multiplier par 100 pour l'obtenir en pourcentage).
	 */
	@Column(name="taux")
	private double tauxRemuneration = 0.03;

	/**
	 * Constructeur par défaut de la classe compte epargne
	 */
	public CompteEpargne() {
		logger.info("Constructeur par défaut de la classe modele.CompteEpargne");
	}

	/**
	 * constructeur avec arguments de la classe compte epargne
	 * 
	 * @param numeroCompte
	 *            numero unique d'identification du compte épargne
	 * @param solde
	 *            montant présent sur le compte épargne
	 * @param dateOuverture
	 *            date d'ouverture du compte épargne dans l'agence
	 */
	public CompteEpargne(String numeroCompte, double solde, String dateOuverture) {
		super(numeroCompte, solde, dateOuverture);
	}

	/**
	 * Retourne la valeur du taux de r�num�ration du compte Epargne.
	 * 
	 * @return La valeur du taux de r�num�ration du compte Epargne.
	 */
	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	/**
	 * Met � jour la valeur du taux de r�num�ration du compte Epargne.
	 * 
	 * @param tauxRemuneration
	 *            La nouvelle valeur du taux de r�num�ration du compte Epargne
	 */
	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}


}