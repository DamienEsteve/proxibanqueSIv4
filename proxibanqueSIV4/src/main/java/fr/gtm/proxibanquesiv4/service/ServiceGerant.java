package fr.gtm.proxibanquesiv4.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.metier.Virement;

@Service
@Transactional
public class ServiceGerant implements IServiceGerant {

	@Autowired
	private IDaoGerant daog;
	
	@Override
	public List<Compte> selectAllConseiller() {
		return daog.selectAllConseiller();
	}

	@Override
	public List<Virement> selectVirementsFromDate(Date d) {
		return daog.selectVirementsFromDate(d);
	}

}
