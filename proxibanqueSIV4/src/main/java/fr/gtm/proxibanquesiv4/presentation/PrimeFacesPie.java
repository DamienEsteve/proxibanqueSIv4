package fr.gtm.proxibanquesiv4.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;

import fr.gtm.proxibanquesiv4.metier.Virement;
import fr.gtm.proxibanquesiv4.service.IServiceGerant;

@ManagedBean
@Named("primeFacesPie")
@SessionScoped
public class PrimeFacesPie implements Serializable {

	private PieChartModel pieModel;
	
	@PostConstruct
	public void init() {
		createPieModels();
	}

	@Autowired
	IServiceGerant serviceGerant;
	private Date date;
	
	private Date getDate() {
		Date referenceDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(referenceDate);
		c.add(Calendar.MONTH, 3);
		return c.getTime();
	}
	
	public PieChartModel getPieModel() {
		return pieModel;
	}

	private void createPieModels() {
		createPieModel();
	}
     
	private void createPieModel() {
		date = getDate();
		List<Virement> virements = serviceGerant.selectVirementsFromDate(date);
		int i = 0, j = 0, k = 0;
		for (Virement v : virements) {
			if (v.getMontant() <= 100) {
				i += v.getMontant();
			} else if (v.getMontant() <= 300) {
				j += v.getMontant();
			} else {
				k += v.getMontant();
			}
		}

		pieModel = new PieChartModel();

		pieModel.set("inferieur a 50€", i);
		pieModel.set("entre 50€ et 100€", j);
		pieModel.set("superieur a 100€", k);

		pieModel.setTitle("Distribution des montants des virements");
		pieModel.setLegendPosition("w");
	}
}