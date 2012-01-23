package com.enjava.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import libreria.Editorial;
import libreria.Libro;

import org.testng.annotations.Test;

import com.enjava.tutorial.hibernate.Alumno;

public class PruebaSelectLibrosDeAutor {

	@Test
	public void pruebaPorId(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager em = emf.createEntityManager(); 
		
		Libro libro2=em.find(Libro.class, new Long(2));
		Libro libro1=em.find(Libro.class, new Long(1));
		
		Long autorId=new Long(1);
		Query query = em.createQuery("from Libro li join li.autores aut where aut.id=:autorId");
		query.setParameter("autorId", autorId);
		List resultList = query.getResultList();
		assert(resultList.size()==2);
	
		Object [] lista  =(Object[]) resultList.get(0);
		Libro l1=(Libro) lista[0];
		//assert(resultList.contains(libro2));
		//assert(resultList.contains(libro1));
		
		
		em.close();
		emf.close(); //close at application end
	}
	
	

}
