package fr.gtm.proxibanquesiv4.main;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquesiv4.dao.ConseillerDao;
import fr.gtm.proxibanquesiv4.dao.GerantDao;
import fr.gtm.proxibanquesiv4.dao.IConseillerDao;
import fr.gtm.proxibanquesiv4.dao.IGerantDao;
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
		IGerantDao gerantDao = (GerantDao) appContext.getBean("gerantDao", GerantDao.class);
		
		// Creation d'un conseiller en BDD
		
		
		// Creation de deux clients en BDD
//		Client client1 = new Client();
//		Client client2 = new Client();
//		client.setPassword(password);
//		client.setLogin(login);
//		client1.setNom(nom1);
//		client1.setPrenom(prenom1);
//		conseillerDao.createClient(client1);
//		client2.setNom(nom2);
//		client2.setPrenom(prenom2);
//		conseillerDao.createClient(client2);
		
		// Lecture de tous les clients en BDD
		List<Client> clients = conseillerDao.selectAllClients();
		for (Client cl : clients){
			System.out.println("client : "+cl.getPrenom()+" "+cl.getNom());
		}
		
		List<Client> clientsConseiller = conseillerDao.selectClientsByConsId(3l);
		for (Client cl : clientsConseiller){
			System.out.println("client du conseiller : "+cl.getPrenom()+" "+cl.getNom());
		}
		
		List<Compte> comptes = conseillerDao.selectAllComptes();
		for (Compte cpt : comptes){
			System.out.println("comptes : "+cpt.getNumeroCompte()+" "+cpt.getSolde());
		}
		
//		CompteCourant cc1 = (CompteCourant) conseillerDao.selectCompteById(1l);
//		CompteCourant cc2 = (CompteCourant) conseillerDao.selectCompteById(3l);
//		
//		Virement vir1 = new Virement();
//		vir1.setCompteCrediteur(cc1);
//		vir1.setCompteDebiteur(cc2);
//		vir1.setMontant(500);
//		vir1.setDateExecution(new Date());
//		conseillerDao.createVirement(vir1);
//		Virement vir2 = new Virement();
//		vir2.setCompteCrediteur(cc2);
//		vir2.setCompteDebiteur(cc1);
//		vir2.setMontant(100);
//		vir2.setDateExecution(new Date());
//		conseillerDao.createVirement(vir2);
		
		long i = conseillerDao.SelectIdByLoginConseiller("2jg");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> i = "+i+" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
}


