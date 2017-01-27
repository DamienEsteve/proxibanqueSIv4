package fr.gtm.proxibanquesiv4.dao;

import java.util.Date;
import java.util.List;

import fr.gtm.proxibanquesiv4.metier.Client;
import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.metier.Conseiller;
import fr.gtm.proxibanquesiv4.metier.Virement;

public interface IGerantDao {
	public List<Conseiller> selectAllConseillers();

	public List<Virement> selectVirementsFromDate(Date d);

	public long SelectIdByLoginGerant(String l);

	public List<Compte> selectClientDecouvert();
}
