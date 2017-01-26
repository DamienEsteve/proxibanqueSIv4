package fr.gtm.proxibanquesiv4.presentation;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.beans.factory.annotation.Autowired;

import fr.gtm.proxibanquesiv4.metier.Virement;
import fr.gtm.proxibanquesiv4.service.IServiceGerant;

@ManagedBean
@Named("primeFacesBar")
@SessionScoped
public class PrimeFacesBar implements Serializable {

	@PostConstruct
	public void init() {
		createBarModel();
	}
	
	@Autowired
	IServiceGerant serviceGerant;

	private Date date;
	private BarChartModel barModel;

	private Date getDate() {
		Date referenceDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(referenceDate);
		c.add(Calendar.MONTH, 3);
		return c.getTime();
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	private BarChartModel initBarModel() {
		date = getDate();
		List<Virement> virements = serviceGerant.selectVirementsFromDate(date);
		int x = 0, y = 0, z = 0;
		for (Virement v : virements) {
			if (v.getMontant() <= 50) {
				x += 1;
			} else if (v.getMontant() <= 100) {
				y += 1;
			} else {
				z += 1;
			}
		}
		
		BarChartModel model = new BarChartModel();

		ChartSeries montants = new ChartSeries();
		montants.setLabel("Montants");
		montants.set("inferieur a 50€", x);
		montants.set("entre 50€ et 100€", y);
		montants.set("superieur a 100€", z);

		model.addSeries(montants);

		return model;
	}

	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Distribution du nombre de virements en fonction du montant");
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Montant");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Nombre de virements");
//		yAxis.setMin(0);
//		yAxis.setMax(10);
	}
}