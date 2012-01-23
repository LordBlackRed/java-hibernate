package es.cea.inmobiliaria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import libreria.Libro;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testArranca {

	EntityManagerFactory emf;
	@BeforeTest
	public void arranca(){
		
		emf = Persistence.createEntityManagerFactory("manager1");
	}
	
	@Test
	public void pruebaArranque(){
		
		 EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager
		
		List<Ciudad> resultList = em.createQuery("from Ciudad").getResultList();
		int tamanyo=resultList.size();
		
		
		assert(tamanyo==5):tamanyo+" -----";
		for(Ciudad c:resultList)
		System.out.println(c.getCodigo());
		
		em.close();
		emf.close(); //close at application end
	}
}
