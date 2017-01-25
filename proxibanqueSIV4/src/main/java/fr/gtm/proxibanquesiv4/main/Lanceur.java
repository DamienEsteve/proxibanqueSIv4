package fr.gtm.proxibanquesiv4.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquesiv4.dao.ConseillerDao;
import fr.gtm.proxibanquesiv4.dao.IConseillerDao;
import fr.gtm.proxibanquesiv4.metier.Client;


public class Lanceur {

	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
			"application-config.xml");

	public static void main(String[] args) {

		long id = 0;
		String password = "test";
		String login = "test";
		String nom = "Jamin";
		String prenom = "Guillaume";
		
		// 2 - Récupération des beans DAO (des objets)
		IConseillerDao conseillerDao = appContext.getBean("conseillerDao", ConseillerDao.class);
		Client client = new Client();
//		client.setPassword(password);
//		client.setLogin(login);
		client.setNom(nom);
		client.setPrenom(prenom);
		conseillerDao.createClient(client);
	}
}
