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
import fr.gtm.proxibanquesiv4.metier.Virement;

@Repository("conseillerDao")
@Transactional
public class ConseillerDao implements IConseillerDao {

	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createClient(Client cl) {
		getSession().save(cl);
	}

	@Override
	public void updateClient(Client cl) {
		getSession().update(cl);
	}

	@Override
	public void updateCompte(Compte cpt) {
		getSession().update(cpt);
	}

	@Override
	public List<Compte> selectComptesByClientId(Long idClient) {
		Query query = getSession().createQuery("Select cpt from Compte cpt where cpt.idclient = idClient");
		return query.getResultList();
	}

	@Override
	public List<Client> selectClientsByConsId(Long idCons) {
		Query query = getSession().createQuery("Select cl from Client cl where cl.idconseiller = idCons");
		return query.getResultList();
	}

	@Override
	public List<Compte> selectAllComptes() {
		Query query = getSession().createQuery("Select cpt from Compte cpt");
		return query.getResultList();
	}

	@Override
	public List<Client> selectAllClients() {
		Query query = getSession().createQuery("Select cl from Client cl");
		return query.getResultList();
	}

	@Override
	public void createVirement(Virement vir) {
		getSession().save(vir);
	}
}
