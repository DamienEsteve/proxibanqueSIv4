package aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class VirementIntercepteur {
	
	@Pointcut("execution(* *.createVirement(..))")
	public void virement() {}

	@Before("virement()")
	public void InitialisationVirement() {
		System.out.println("Virement initialisé");
	}
	
	@After("virement()")
	public void RealisationViremennt() {
		System.out.println("Virement terminé");
	}
}
