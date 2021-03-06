package fr.gtm.proxibanquesiv4.presentation;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.metier.Conseiller;
import fr.gtm.proxibanquesiv4.metier.Virement;
import fr.gtm.proxibanquesiv4.service.IServiceGerant;

@ManagedBean
@Named("gerantbean")
@SessionScoped
public class GerantDTO {

	private long id;
	private List<Conseiller> listeconseillers;
	private List<Virement> listevirements;
	@SuppressWarnings("unused")
	private List<Compte> listeclientdec;
	@SuppressWarnings("unused")
	private List<Compte> listecompte;

	/**
	 * Annotation permettant d'injecter la couche service
	 */
	@Autowired
	public IServiceGerant servicegerant;

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

	public List<Conseiller> ListeAllConseillers() {
		return listeconseillers = servicegerant.selectAllConseillers();
	}

	public List<Virement> ListeVirements(Date date) {
		return listevirements = servicegerant.selectVirementsFromDate(date);
	}

	public List<Compte> ListeClientDecouvert() {
		return listeclientdec = servicegerant.selectClientDecouvert();
	}
}
