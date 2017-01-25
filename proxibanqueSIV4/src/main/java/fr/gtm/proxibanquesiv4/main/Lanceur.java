package fr.gtm.proxibanquesiv4.main;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquesiv4.dao.ConseillerDao;
import fr.gtm.proxibanquesiv4.dao.IConseillerDao;
import fr.gtm.proxibanquesiv4.metier.Client;
import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.metier.CompteCourant;
import fr.gtm.proxibanquesiv4.metier.Virement;


public class Lanceur {

	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spring/application-config.xml");

	public static void main(String[] args) {

		long id = 0;
		String password = "test";
		String login = "test";
		String nom1 = "Esteve";
		String prenom1 = "Damien";
		String nom2 = "Jamin";
		String prenom2 = "Guillaume";
		
		// 2 - Récupération des beans DAO (des objets)
		IConseillerDao conseillerDao = (ConseillerDao) appContext.getBean("conseillerDao", ConseillerDao.class);
		
		// Creation d'un conseiller en BDD
		
		
		// Creation de deux clients en BDD
		Client client1 = new Client();
//		client.setPassword(password);
//		client.setLogin(login);
		client1.setNom(nom1);
		client1.setPrenom(prenom1);
		conseillerDao.createClient(client1);
		client1.setNom(nom2);
		client1.setPrenom(prenom2);
		conseillerDao.createClient(client1);
		
		// Lecture de tous les clients en BDD
		List<Client> clients = conseillerDao.selectAllClients();
		for (Client cl : clients){
			System.out.println("client : "+cl.getPrenom()+" "+cl.getNom());
		}
		
		List<Client> clientsConseiller = conseillerDao.selectClientsByConsId(3l);
		for (Client cl : clientsConseiller){
			System.out.println("client du conseiller : "+cl.getPrenom()+" "+cl.getNom());
		}
		
		CompteCourant cc1 = new CompteCourant();
		CompteCourant cc2 = new CompteCourant();
		cc1.
		cc1.setNumeroCompte(1l);
		cc1.setSolde(1000);
		cc2.setNumeroCompte(2l);
		cc2.setSolde(2000);
		
		List<Compte> comptes = conseillerDao.selectAllComptes();
		for (Compte cpt : comptes){
			System.out.println("comptes : "+cpt.getNumeroCompte()+" "+cpt.getSolde());
		}
		
		Virement vir = new Virement();
		vir.setCompteCrediteur(comptes.get(0));
		vir.setCompteDebiteur(comptes.get(1));
		vir.setMontant(500);
		vir.setDateExecution(new Date());
		conseillerDao.createVirement(vir);
	}
}
