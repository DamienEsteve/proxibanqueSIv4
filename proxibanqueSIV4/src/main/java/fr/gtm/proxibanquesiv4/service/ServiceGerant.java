package fr.gtm.proxibanquesiv4.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquesiv4.dao.IGerantDao;
import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.metier.Conseiller;
import fr.gtm.proxibanquesiv4.metier.Virement;

/**
 * 
 * La classe ServiceGerant inclu toutes les m�thodes du g�rant
 * 
 * @author Guillaume Jamin, Severine Romano, Damien Esteve, Kevin BUEWAERT
 * @version 4.0
 *
 */

@Service
@Transactional
public class ServiceGerant implements IServiceGerant {

	@Autowired
	private IGerantDao daog;

	@Override
	public List<Conseiller> selectAllConseillers() {
		return daog.selectAllConseillers();
	}

	@Override
	public List<Virement> selectVirementsFromDate(Date d) {
		return daog.selectVirementsFromDate(d);
	}

	@Override
	public long SelectIdByLoginGerant(String l) {
		return daog.SelectIdByLoginGerant(l);
	}

	@Override
	public List<Compte> selectClientDecouvert() {
		return daog.selectClientDecouvert();
	}
}
