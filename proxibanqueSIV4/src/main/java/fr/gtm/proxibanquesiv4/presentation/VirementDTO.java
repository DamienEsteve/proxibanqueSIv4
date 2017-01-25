package fr.gtm.proxibanquesiv4.presentation;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.metier.Virement;
import fr.gtm.proxibanquesiv4.service.IServiceConseiller;

@Controller("virementbean")
@SessionScoped
public class VirementDTO implements Serializable {
	
	private Compte compteCrediteur;
	private Compte compteDebiteur;
	private double montant;
	
	private static Logger logger = Logger.getLogger(VirementDTO.class);

	@Autowired
	IServiceConseiller servicetransaction;
	
	public VirementDTO() {
		// TODO Auto-generated constructor stub
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
	
	public void Virement(Virement virement) {
		servicetransaction.createVirement(virement);
	}
}