package fr.gtm.proxibanquesiv4.presentation;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.gtm.proxibanquesiv4.metier.Client;
import fr.gtm.proxibanquesiv4.service.IServiceConseiller;

@ManagedBean
@Named("conseillerbean")
@SessionScoped
public class ConseillerDTO implements Serializable {

	private long id;
	private List<Client> listeclients;
	
	@Autowired
	IServiceConseiller serviceconseiller;

	public ConseillerDTO() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
		
	public List<Client> getListeclients() {
		return listeclients;
	}
	public void setListeclients(List<Client> listeclients) {
		this.listeclients = listeclients;
	}
	public List<Client> ListeClients(long id) {
		return listeclients = serviceconseiller.selectClientsByConsId(id);
	}
	
	public List<Client> ListeAllClients() {
		return listeclients = serviceconseiller.selectAllClients();
	}
	
}
