package fr.gtm.proxibanquesiv4.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * La classe ServiceRest utilise la technologie WEB SERVICE rest. Les méthodes invoquées sont non fonctionnelles.
 * 
 * @author Guillaume Jamin, Severine Romano, Damien Esteve, Kevin BUEWAERT
 * @version 4.0
 *
 */

@Path("/rest")
public class ServiceRest {

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "test";
	}
}