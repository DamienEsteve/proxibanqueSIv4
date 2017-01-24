package fr.gtm.proxibanquesiv4.dao;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquesiv4.metier.Client;

public class ConseillerDaoTestCase {

	private static Logger logger = Logger.getLogger(ConseillerDaoTestCase.class);
	private static ClassPathXmlApplicationContext appContext;
	private static IConseillerDao conseillerDao;
	private static long id = 0;
	private static String password = "test";
	private static String login = "test";
	private static String nom = "Jamin";
	private static String prenom = "Guillaume";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		appContext = new ClassPathXmlApplicationContext("src/main/resources/spring/application-config.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test1Creer() {
		conseillerDao = appContext.getBean("conseillerDao", ConseillerDao.class);
		Client client = new Client();
//		client.setPassword(password);
//		client.setLogin(login);
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
