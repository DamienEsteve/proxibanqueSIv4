package fr.gtm.proxibanquesiv4.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class VirementIntercepteur {
	
	private static Logger logger = Logger.getLogger(VirementIntercepteur.class);
	
	@Pointcut("execution(* *.createVirement(..))")
	public void virement() {}

	@Before("virement()")
	public void InitialisationVirement() {
		logger.info("********** Virement initialisé **********");
	}
	
	@After("virement()")
	public void RealisationViremennt() {
		logger.info("********** Virement effectué **********");
	}
}
