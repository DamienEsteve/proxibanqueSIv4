package fr.gtm.proxibanquesiv4.service;

import java.util.Date;
import java.util.List;

import fr.gtm.proxibanquesiv4.metier.Conseiller;
import fr.gtm.proxibanquesiv4.metier.Virement;

public interface IServiceGerant {
	public List<Conseiller> selectAllConseillers();
	public List<Virement> selectVirementsFromDate(Date d);
	public long SelectIdByLoginGerant(String l);
}
