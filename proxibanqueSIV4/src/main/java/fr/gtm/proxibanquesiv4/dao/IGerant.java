package fr.gtm.proxibanquesiv4.dao;

import java.util.Date;
import java.util.List;

import fr.gtm.proxibanquesiv4.metier.Conseiller;
import fr.gtm.proxibanquesiv4.metier.Virement;

public interface IGerant {
	public List<Conseiller> selectAllConseillers();
	public List<Virement> selectVirementsFromDate(Date d);	
}
