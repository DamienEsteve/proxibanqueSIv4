package fr.gtm.proxibanquesiv4.metier;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Guillaume Jamin, Severine Romano, Damien Esteve, Kevin BUEWAERT
 * @version 4.0
 *
 */
@Entity
@Component
public class Gerant extends Utilisateur implements Serializable{

	@Transient
	private static final long serialVersionUID = 1L;
	
	/**
	 * La liste des conseillers.
	 */
	@OneToMany(mappedBy="gerant")
	private List<Conseiller> listeConseiller;

	/**
	 * Constructeur par defaut de la classe Gerant
	 */	
	public Gerant() {
		listeConseiller = new ArrayList<Conseiller>();
	}
	
	/**
	 * @return listeConseiller
	 */
	public List<Conseiller> getListeConseiller() {
		return listeConseiller;
	}
	
	/**
	 * @param listeConseiller
	 *            listeConseiller à modifier
	 */
	public void setListeConseiller(List<Conseiller> listeConseiller) {
		this.listeConseiller = listeConseiller;
	}
}