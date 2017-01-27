package fr.gtm.proxibanquesiv4.dao;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquesiv4.metier.Client;

public class ConseillerDaoTestCase {

	private static Logger logger = Logger.getLogger(ConseillerDaoTestCase.class);
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/application-config.xml");
	// private static IConseillerDao conseillerDao;
	private static long id = 0;
	@SuppressWarnings("unused")
	private static String password = "test";
	@SuppressWarnings("unused")
	private static String login = "test";
	private static String nom = "Esteve";
	private static String prenom = "Damien";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test1Creer() {
		IConseillerDao conseillerDao = (ConseillerDao) appContext.getBean("conseillerDao", ConseillerDao.class);
		Client client = new Client();
		// client.setPassword(password);
		// client.setLogin(login);
		client.setNom(nom);
		client.setPrenom(prenom);
		logger.info(">>>>>>>>>>>> creation du client");
		conseillerDao.createClient(client);
		logger.info(">>>>>>>>>>>> client cree");
		id = client.getIdPersonne();
		assertNotNull(id);
		assertNotEquals(null, id);
	}

}
