package fr.gtm.proxibanquesiv4.service;

import java.util.Date;
import java.util.List;

import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.metier.Conseiller;
import fr.gtm.proxibanquesiv4.metier.Virement;

/**
 * 
 * L'interface iServiceGerant inclu toutes les méthodes du gérant
 * 
 * @author Guillaume Jamin, Severine Romano, Damien Esteve, Kevin BUEWAERT
 * @version 4.0
 *
 */

public interface IServiceGerant {
	public List<Conseiller> selectAllConseillers();

	public List<Virement> selectVirementsFromDate(Date d);

	public long SelectIdByLoginGerant(String l);

	public List<Compte> selectClientDecouvert();
}
