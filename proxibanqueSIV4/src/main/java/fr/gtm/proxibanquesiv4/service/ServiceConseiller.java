package fr.gtm.proxibanquesiv4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquesiv4.metier.Client;
import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.metier.Virement;

@Service
@Transactional
public class ServiceConseiller implements IServiceConseiller {

	@Autowired
	private IDaoConseiller daoc;
	
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
	public List<Compte> selectComptesByClientId(Long idClient) {
		return daoc.selectComptesByClientId(idClient);
	}

	@Override
	public List<Client> selectClientsByConsId(Long idCons) {
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

}
