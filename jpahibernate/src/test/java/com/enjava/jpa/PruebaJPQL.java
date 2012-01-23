package com.enjava.jpa;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

import libreria.Libro;

import org.testng.annotations.Test;

import com.enjava.tutorial.hibernate.Alumno;

public class PruebaJPQL {

	@Test
	public void pruebaArranque() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("manager1");
		EntityManager em = emf.createEntityManager(); 
		// inner join => join
		// left outer join =>left join
		String jpqlQuery = "select editorial.id, libro.id, " +
				"libro.nombre, libro.fechaPublicacion " +
				"from Editorial as editorial join Libro as libro " +
				"";
		String jpqlQuery2 = "select editorial.id, libro.id, " +
		"libro.nombre, libro.fechaPublicacion " +
		"from Editorial as editorial, Libro as libro where libro.editorial=editorial" +
		"";

		Query createQuery = em.createQuery(jpqlQuery);
		List<Object[]> resultList = createQuery.getResultList();
		for (Object[] o : resultList) {
			System.out.println(o[0]+"-"+o[1]+"-"+o[2]+"-"+o[3]);
		}
		em.close();
		emf.close(); // close at application end
	}
}
