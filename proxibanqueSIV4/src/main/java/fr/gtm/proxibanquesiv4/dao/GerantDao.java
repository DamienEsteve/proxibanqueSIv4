package fr.gtm.proxibanquesiv4.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquesiv4.metier.Conseiller;
import fr.gtm.proxibanquesiv4.metier.Virement;

@Repository("gerantDao")
@Transactional
public class GerantDao implements IGerantDao {

	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Conseiller> selectAllConseillers() {
		Query query = getSession().createQuery("Select c from Conseiller c");
		return query.getResultList();
	}
	
	@Override
	public List<Virement> selectVirementsFromDate(Date d) {
		Query query = getSession().createQuery("Select vir from Virement vir where vir.dateExecution <:d");
		query.setParameter("d", d);
		return query.getResultList();
	}
	
	@Override
	public long SelectIdByLoginGerant(String l){
		Query query = getSession().createQuery("Select g.idPersonne from Gerant g where g.login =:l");
		query.setParameter("l", l);
		return (long) query.getSingleResult();
	}
}
