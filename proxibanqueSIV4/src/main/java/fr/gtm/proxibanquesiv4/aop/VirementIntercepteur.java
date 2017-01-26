package fr.gtm.proxibanquesiv4.aop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import fr.gtm.proxibanquesiv4.metier.Virement;

@Aspect
public class VirementIntercepteur {
	
	@Before("execution(* *.createVirement(..))")
	public void logBefore(JoinPoint joinPoint) throws IOException{
		Virement v = (Virement) joinPoint.getArgs()[0];
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<INTERCEPTEURVIREMENT");
		String path = System.getProperty("user.home")+"\\Documents\\Virements.txt";
		System.out.println(path);
		try(
				
				FileWriter fw = new FileWriter(path, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw)
			    		)
			{
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>> On �crit dans le fichier : "+fw+" ce qui suit : "+"Virement : montant :"+v.getMontant()+"� ; date : "+v.getDateExecution()+" ; compte debiteur : "+v.getCompteDebiteur().getNumeroCompte()+" ; compte crediteur : "+v.getCompteCrediteur().getNumeroCompte());
			    out.println("Virement : montant :"+v.getMontant()+"� ; date : "+v.getDateExecution()+" ; compte debiteur : "+v.getCompteDebiteur().getNumeroCompte()+" ; compte crediteur : "+v.getCompteCrediteur().getNumeroCompte());
			} catch (IOException e) {
			   System.out.println(e.getMessage());
			   System.out.println("<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<");
			}
	}
}
