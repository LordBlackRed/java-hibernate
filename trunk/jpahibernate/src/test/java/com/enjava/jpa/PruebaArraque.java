package com.enjava.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PrePersist;

import libreria.Libro;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.enjava.tutorial.hibernate.Alumno;

public class PruebaArraque {
	EntityManagerFactory emf;
	@BeforeTest
	public void arranca(){
		emf = Persistence.createEntityManagerFactory("manager1");
	}
	
	@Test
	public void pruebaArranque(){
		
		 EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager
		
		List<Libro> resultList = em.createQuery("from Libro").getResultList();
		int tamanyo=resultList.size();
		
		
		assert(tamanyo==3):tamanyo+" -----";
		for(Libro l:resultList)
		System.out.println(l.getNombre());
		
		em.close();
		emf.close(); //close at application end
	}
}
