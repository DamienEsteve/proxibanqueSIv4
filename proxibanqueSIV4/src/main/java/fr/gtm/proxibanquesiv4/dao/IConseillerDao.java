package fr.gtm.proxibanquesiv4.dao;

import java.util.List;

import fr.gtm.proxibanquesiv4.metier.Client;
import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.metier.Virement;

public interface IConseillerDao {
	public void createClient(Client cl);
	public void updateClient(Client cl);
	public void updateCompte(Compte cpt);
	public List<Compte> selectComptesByClientId(long idClient);
	public List<Client> selectClientsByConsId(long idCons);
	public List<Compte> selectAllComptes();
	public List<Client> selectAllClients();
	public void createVirement(Virement vir);
	public void createCompte(Compte c);
}
