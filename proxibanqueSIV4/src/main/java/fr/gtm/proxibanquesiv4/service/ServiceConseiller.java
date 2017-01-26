package fr.gtm.proxibanquesiv4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquesiv4.dao.IConseillerDao;
import fr.gtm.proxibanquesiv4.metier.Client;
import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.metier.Conseiller;
import fr.gtm.proxibanquesiv4.metier.Virement;

@Service
@Transactional
public class ServiceConseiller implements IServiceConseiller {

	@Autowired
	private IConseillerDao daoc;
	
	@Override
	public void createClient(Client cl) {
		daoc.createClient(cl);
	}

	@Override
	public void updateClient(Client cl) {
		daoc.updateClient(cl);
	}

	@Override
	public void updateCompte(Compte cpt) {
		daoc.updateCompte(cpt);
	}

	@Override
	public Conseiller selectConseillerByLogin(String l){
		return daoc.selectConseillerByLogin(l);
	}
	
	@Override
	public List<Compte> selectComptesByClientId(long idClient) {
		return daoc.selectComptesByClientId(idClient);
	}

	@Override
	public List<Client> selectClientsByConsId(long idCons) {
		return daoc.selectClientsByConsId(idCons);
	}

	@Override
	public List<Compte> selectAllComptes() {
		return daoc.selectAllComptes();
	}

	@Override
	public List<Client> selectAllClients() {
		return daoc.selectAllClients();
	}

	@Override
	public void createVirement(Virement vir) {
		daoc.createVirement(vir);
	}

	@Override
	public void createCompte(Compte c) {
		daoc.createCompte(c);
	}
	
	@Override
	public Compte selectCompteById(long idCpt) {
		return daoc.selectCompteById(idCpt);
	}
	
	@Override
	public long SelectIdByLoginConseiller(String l){
		return daoc.SelectIdByLoginConseiller(l);
	}
}
