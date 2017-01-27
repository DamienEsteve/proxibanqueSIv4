package fr.gtm.proxibanquesiv4.presentation;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.gtm.proxibanquesiv4.metier.Compte;
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
	 * @param numCompteDebiteur the numCompteDebiteur to set
	 */
	public void setNumCompteDebiteur(long numCompteDebiteur) {
		this.numCompteDebiteur = numCompteDebiteur;
	}
	public String virer() {
		System.out.println("##############################################");
		this.compteCrediteur = servicetransaction.selectCompteById(numCompteCrediteur);
		this.compteDebiteur = servicetransaction.selectCompteById(numCompteDebiteur);
		System.out.println(this.montant);
		this.dateExecution = new Date();
		Virement virement = new Virement();
		virement.setCompteCrediteur(this.compteCrediteur);
		virement.setCompteDebiteur(this.compteDebiteur);
		virement.setMontant(this.montant);
		virement.setDateExecution(this.dateExecution);
		System.out.println("tototototo");
		System.out.println(virement.getMontant());
		System.out.println(virement.getCompteCrediteur());
		System.out.println(virement.getCompteDebiteur());
		System.out.println(virement.getDateExecution());
		servicetransaction.createVirement(virement);
		return "indexConseiller?faces-redirect=true";
	}
}