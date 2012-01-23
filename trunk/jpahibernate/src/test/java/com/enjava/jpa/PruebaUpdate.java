package com.enjava.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

import libreria.Autor;
import libreria.Cliente;
import libreria.Libro;
import libreria.Pedido;
import libreria.PedidoLinea;

import org.testng.annotations.Test;

import com.enjava.tutorial.hibernate.Alumno;

public class PruebaUpdate {

	/**
	 * PARA ACTUALIZAR LA BASE DE DATOS SIEMPRE DENTRO DE UNA TRANSACCION
	 */
	/**
	 * falta configurar las cascades
	 */
	
	@Test
	public void pruebaBorrar(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager
		PedidoLinea pl = em.find(PedidoLinea.class, new Long(1));
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		em.remove(pl);
		
		transaction.commit();
		em.close();
		emf.close(); 
	}
	@Test
	public void pruebaActualizar(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager
		PedidoLinea pl = em.find(PedidoLinea.class, new Long(1));
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		pl.setCantidad(8);
		
		transaction.commit();
		em.close();
		emf.close(); 
	}
	@Test
	public void pruebaIncluir(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager
		Cliente cl = new Cliente();
		cl.setNombre("juan");
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(cl);
		
		transaction.commit();
		em.close();
		emf.close(); 
	}
}
