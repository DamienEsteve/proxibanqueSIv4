package fr.gtm.proxibanquesiv4.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquesiv4.metier.Client;
import fr.gtm.proxibanquesiv4.metier.Compte;
import fr.gtm.proxibanquesiv4.metier.Conseiller;
import fr.gtm.proxibanquesiv4.metier.Virement;

/**
 * @author Guillaume, Severine, Kevin, Damien
 *
 */
@Repository("conseillerDao")
@Transactional
public class ConseillerDao implements IConseillerDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @return return the session for JPA
	 */
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Methode de creation d'un client
	 */
	@Override
	public void createClient(Client cl) {
		getSession().save(cl);
	}

	/**
	 * Methode de mise à jour d'un client
	 */
	@Override
	public void updateClient(Client cl) {
		System.out.println(cl);
		getSession().update(cl);
	}

	/**
	 * Methode de mise à jour d'un compte
	 */
	@Override
	public void updateCompte(Compte cpt) {
		getSession().update(cpt);
	}

	/**
	 * Methode de selection d'un conseiller a partir de son login
	 */
	@Override
	public Conseiller selectConseillerByLogin(String l) {
		Query query = getSession().createQuery("Select c from Conseiller c where c.login =:l");
		query.setParameter("l", l);
		return (Conseiller) query.getSingleResult();
	}

	/**
	 * Methode de selection des comptes d'un client
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> selectComptesByClientId(long idClient) {
		Query query = getSession().createQuery("Select cpt from Compte cpt where cpt.client.idPersonne =:idClient");
		query.setParameter("idClient", idClient);
		return query.getResultList();
	}

	/**
	 * Methode de selection des clients d'un conseiller
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> selectClientsByConsId(long idCons) {
		Query query = getSession().createQuery("Select cl from Client cl where cl.conseiller.idPersonne =:idCons");
		query.setParameter("idCons", idCons);
		return query.getResultList();
	}

	/**
	 * Methode de selection de tout les comptes
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> selectAllComptes() {
		Query query = getSession().createQuery("Select cpt from Compte cpt");
		return query.getResultList();
	}

	/**
	 * Methode de selection de tout les clients
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> selectAllClients() {
		Query query = getSession().createQuery("Select cl from Client cl");
		return query.getResultList();
	}

	/**
	 * Methode de creation d'un virement
	 */
	@Override
	public void createVirementDao(Virement vir) {
		Compte cc = vir.getCompteCrediteur();
		Compte cd = vir.getCompteDebiteur();
		cc.setSolde(cc.getSolde() + vir.getMontant());
		cd.setSolde(cd.getSolde() - vir.getMontant());
		updateCompte(cc);
		updateCompte(cd);
		getSession().save(vir);
	}

	/**
	 * Methode de creation de compte
	 */
	@Override
	public void createCompte(Compte c) {
		getSession().save(c);
	}

	/**
	 * Methode de selection d'un compte
	 */
	@Override
	public Compte selectCompteById(long idCpt) {
		Compte c = (Compte) getSession().get(Compte.class, idCpt);
		return c;
	}

	/**
	 * Methode de selection de l'id d'un conseiller grace à son login
	 */
	@Override
	public long SelectIdByLoginConseiller(String l) {
		Query query = getSession().createQuery("Select c.idPersonne from Conseiller c where c.login =:l");
		query.setParameter("l", l);
		return (long) query.getSingleResult();
	}
}