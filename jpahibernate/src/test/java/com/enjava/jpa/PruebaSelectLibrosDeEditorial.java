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

public class PruebaSelectLibrosDeEditorial {

	@Test
	public void pruebaPorId(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager em = emf.createEntityManager(); 
		
		
		Long editorialId=new Long(3);
		
		Query query = em.createQuery("from Libro li where li.editorial.id=:editorialId");
		query.setParameter("editorialId", editorialId);
		List<Libro> resultList = query.getResultList();
		assert(resultList.size()==1);
		Libro libro = resultList.get(0);
		assert(libro.getNombre().equals("libro3"));

		
		em.close();
		emf.close(); //close at application end
	}
	
	@Test
	public void pruebaPorObjetoEditorial(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager em = emf.createEntityManager(); 

		Long editorialId=new Long(3);
		
		Query queryEditorial = em.createQuery("from Editorial e where e.id=:editorialId");
		queryEditorial.setParameter("editorialId", editorialId);
		Editorial editorial=(Editorial) queryEditorial.getSingleResult();
		
		Query query = em.createQuery("from Libro li where li.editorial=:editorial");
		query.setParameter("editorial", editorial);
		List<Libro> resultList = query.getResultList();
		assert(resultList.size()==1);
		Libro libro = resultList.get(0);
		assert(libro.getNombre().equals("libro3"));
		
		
		em.close();
		emf.close(); //close at application end
	}
}
