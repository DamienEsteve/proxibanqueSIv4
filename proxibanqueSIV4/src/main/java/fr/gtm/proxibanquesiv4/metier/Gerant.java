package fr.gtm.proxibanquesiv4.metier;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import org.apache.log4j.Logger;


public class Gerant extends Utilisateur implements Serializable{

	@Transient
	private static final long serialVersionUID = 1L;

	@Transient
	private static Logger logger = Logger.getLogger(Conseiller.class);
	
	private List<Conseiller> listeConseiller;

	public Gerant() {
		listeConseiller = new ArrayList<Conseiller>();
	}
	
	public List<Conseiller> getListeConseiller() {
		return listeConseiller;
	}

	public void setListeConseiller(List<Conseiller> listeConseiller) {
		this.listeConseiller = listeConseiller;
	}


	
	
}
