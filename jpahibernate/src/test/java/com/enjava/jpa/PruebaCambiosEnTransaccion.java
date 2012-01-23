package com.enjava.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

import libreria.Libro;

import org.testng.annotations.Test;

import com.enjava.tutorial.hibernate.Alumno;

public class PruebaCambiosEnTransaccion {

	@Test
	public void pruebaArranque(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		List<Libro> resultList = em.createQuery("from Libro").getResultList();
		assert(resultList.size()==3);
		resultList.get(0).getEditorial().setNombre("nuevaEditorial");
		transaction.commit();
		Object singleResult = em.createQuery("from Editorial l where l.nombre='nuevaEditorial'").getSingleResult();
		assert(singleResult!=null);
		
		em.close();
		emf.close(); //close at application end
	}
}
