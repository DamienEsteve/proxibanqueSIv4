package fr.gtm.proxibanquesiv4.presentation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.metier.CompteCourant;
import fr.gtm.proxibanquesiv4.metier.CompteEpargne;
import fr.gtm.proxibanquesiv4.metier.Virement;
import fr.gtm.proxibanquesiv4.service.IServiceConseiller;

@Controller("virementbean")
@RequestScoped
public class VirementDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5143271333244126997L;
	private Compte compteCrediteur;
	private Compte compteDebiteur;
	private long numCompteCrediteur, numCompteDebiteur;
	private double montant;
	private Date dateExecution;
	private Boolean vrsOK, vrsEffectue, soldeOK;

	/**
	 * Annotation permettant d'injecter la couche service
	 */
	@Autowired
	IServiceConseiller servicetransaction;

	public VirementDTO() {
		vrsOK = true;
		soldeOK = true;
		vrsEffectue = false;
	}

	public Compte getCompteCrediteur() {
		return compteCrediteur;
	}

	public void setCompteCrediteur(Compte compteCrediteur) {
		this.compteCrediteur = compteCrediteur;
	}

	public Compte getCompteDebiteur() {
		return compteDebiteur;
	}

	public void setCompteDebiteur(Compte compteDebiteur) {
		this.compteDebiteur = compteDebiteur;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDateExecution() {
		return dateExecution;
	}

	public void setDateExecution(Date dateExecution) {
		this.dateExecution = dateExecution;
	}

	public long getNumCompteCrediteur() {
		return numCompteCrediteur;
	}

	public void setNumCompteCrediteur(long numCompteCrediteur) {
		this.numCompteCrediteur = numCompteCrediteur;
	}

	/**
	 * @return the numCompteDebiteur
	 */
	public long getNumCompteDebiteur() {
		return numCompteDebiteur;
	}

	/**
	 * @param numCompteDebiteur
	 *            the numCompteDebiteur to set
	 */
	public void setNumCompteDebiteur(long numCompteDebiteur) {
		this.numCompteDebiteur = numCompteDebiteur;
	}

	public Boolean getVrsOK() {
		return vrsOK;
	}

	public void setVrsOK(Boolean vrsOK) {
		this.vrsOK = vrsOK;
	}

	public Boolean getVrsEffectue() {
		return vrsEffectue;
	}

	public void setVrsEffectue(Boolean vrsEffectue) {
		this.vrsEffectue = vrsEffectue;
	}

	public Boolean getSoldeOK() {
		return soldeOK;
	}

	public void setSoldeOK(Boolean soldeOK) {
		this.soldeOK = soldeOK;
	}

	@SuppressWarnings("unused")
	public String virer() {
		Boolean vccOK = false;
		Boolean vcdOK = false;
		List<Compte> comptes = servicetransaction.selectAllComptes();
		if (numCompteCrediteur == numCompteDebiteur) {
			vrsOK = false;
			vrsEffectue = false;
			soldeOK = true;
			return "listecompte?faces-redirect=true";
		}
		for (Compte c : comptes) {
			if (numCompteCrediteur == c.getNumeroCompte()) {
				vccOK = true;
			}
			if (numCompteDebiteur == c.getNumeroCompte()) {
				vcdOK = true;
			}
		}
		if ((vccOK == true) && (vcdOK = true)) {
			this.compteCrediteur = servicetransaction.selectCompteById(numCompteCrediteur);
			this.compteDebiteur = servicetransaction.selectCompteById(numCompteDebiteur);
			if (this.compteDebiteur.getClass().equals(CompteCourant.class)) {
				CompteCourant cc = (CompteCourant) this.compteDebiteur;
				if (cc.getSolde() - montant < -cc.getAuthDecouvert()) {
					vrsEffectue = false;
					soldeOK = false;
					return "listecompte?faces-redirect=true";
				}
			} else {
				CompteEpargne ce = (CompteEpargne) this.compteDebiteur;
				if (ce.getSolde() - montant < 0) {
					vrsEffectue = false;
					soldeOK = false;
					return "listecompte?faces-redirect=true";
				}
			}
			this.dateExecution = new Date();
			Virement virement = new Virement();
			virement.setCompteCrediteur(this.compteCrediteur);
			virement.setCompteDebiteur(this.compteDebiteur);
			virement.setMontant(this.montant);
			virement.setDateExecution(this.dateExecution);
			servicetransaction.createVirement(virement);
			vrsOK = true;
			vrsEffectue = true;
			soldeOK = true;
			return "listecompte?faces-redirect=true";
		} else {
			vrsOK = false;
			vrsEffectue = false;
			soldeOK = true;
			return "listecompte?faces-redirect=true";
		}
	}
}