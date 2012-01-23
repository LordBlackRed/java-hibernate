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

public class PruebaNavegacionPorElGrafo {

	@Test
	public void pruebaNavegacionPorElGrafo(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager
		Cliente cliente1 = 
				em.find(Cliente.class, new Long(1));
		
		List<Pedido> pedidos = cliente1.getPedidos();
		assert(pedidos.size()==1);
		
		Pedido pedido1 = pedidos.get(0);
		List<PedidoLinea> lineasPedido = pedido1.getLineasPedido();
		assert(lineasPedido.size()==2);
		PedidoLinea pedidoLinea = lineasPedido.get(0);
		assert(pedidoLinea.getCantidad().equals(new Integer(5)));
		
		Libro libro = pedidoLinea.getLibro();
		assert(libro.getNombre().equals("libro1"));
		
		List<Autor> autores = libro.getAutores();
		assert(autores.size()==1);
		Autor autor = libro.getAutores().get(0);
		
		assert(autor.getNombre().equals("autor1"));
		
		assert(libro.getEditorial().getNombre().equals("editorial1"));
		
		
		em.close();
		emf.close(); //close at application end
	}
}
