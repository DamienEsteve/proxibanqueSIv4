package fr.gtm.proxibanquesiv4.presentation;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.gtm.proxibanquesiv4.metier.Conseiller;
import fr.gtm.proxibanquesiv4.metier.Virement;
import fr.gtm.proxibanquesiv4.service.IServiceGerant;

@Controller("gerantbean")
@SessionScoped
public class GerantDTO {
	
	private long id;
	private List<Conseiller> listeconseillers;
	private List<Virement> listevirements;
	
	private static Logger logger = Logger.getLogger(GerantDTO.class);

	@Autowired
	IServiceGerant servicegerant;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Conseiller> getListeconseillers() {
		return listeconseillers;
	}

	public void setListeconseillers(List<Conseiller> listeconseillers) {
		this.listeconseillers = listeconseillers;
	}

	public List<Virement> getListevirements() {
		return listevirements;
	}

	public void setListevirements(List<Virement> listevirements) {
		this.listevirements = listevirements;
	}

	public List<Conseiller> ListeConseillers() {
		return listeconseillers = servicegerant.selectAllConseillers();
	}
	
	public List<Virement> ListeVirements(Date date) {
		return  listevirements = servicegerant.selectVirementsFromDate(date);
	}
}
