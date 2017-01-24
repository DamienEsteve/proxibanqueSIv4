package fr.gtm.proxibanquesiv4.service;

import java.util.Date;
import java.util.List;

import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.metier.Virement;

public interface IServiceGerant {

	public List<Compte> selectAllConseiller();
	public List<Virement> selectVirementsFromDate(Date d);
}
