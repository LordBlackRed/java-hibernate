package es.cea.chat;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import es.cea.inmobiliaria.Ciudad;

public class TestArrancaChat {

	EntityManagerFactory emf;

	@BeforeMethod
	public void arranca() {

		emf = Persistence.createEntityManagerFactory("manager1");
	}

	@Test
	public void pruebaMEnsajesEnDB() {

		EntityManager em = emf.createEntityManager(); // Retrieve an application
														// managed entity
														// manager

		List<Mensaje> resultList = em.createQuery("from Mensaje")
				.getResultList();
		int tamanyo = resultList.size();

		System.out.println("*******PRINCIPIO*******");
		// En un principio hay 4 mensajes creados
		assert (tamanyo == 4) : tamanyo + " -----";
		for (Mensaje m : resultList)
			System.out.println(m.getTexto());

		em.close();
	}

	@Test
	public void pruebaInsertarMensaje() {

		EntityManager em = emf.createEntityManager(); // Retrieve an application
														// managed entity
														// manager

		// Insertar un mensaje y comprobar que lista mensajes ha crecido

		Chat chat = em.find(Chat.class, 1L);

		Mensaje nuevoMensaje = new Mensaje();
		nuevoMensaje.setChat(chat);
		nuevoMensaje.setFecha(new Date());
		nuevoMensaje.setTexto("Esto es una prueba de mensaje desde el test");
		Usuario usuario = em.find(Usuario.class, 1L);
		nuevoMensaje.setUsuario(usuario);

		EntityTransaction entityTransaction = em.getTransaction();

		entityTransaction.begin();
		em.persist(nuevoMensaje);
		entityTransaction.commit();

		// Mostramos el mensaje NUEVO******
		List<Mensaje> resultList = em.createQuery("from Mensaje")
				.getResultList();
		int tamanyo = resultList.size();

		System.out.println("*******MENSAJE NUEVO*******");

		// En un principio hay 5 mensajes creados
		assert (tamanyo == 5) : tamanyo + " -----";
		for (Mensaje m : resultList)
			System.out.println(m.getTexto());

		em.close();

	}

	@Test
	public void pruebaEliminarMensaje() {
		EntityManager em = emf.createEntityManager(); // Retrieve an application
														// managed entity
														// manager

		// Eliminar Mensaje *********************
		Mensaje mensaje = em.find(Mensaje.class, 1L);

		EntityTransaction entityTransaction = em.getTransaction();

		entityTransaction.begin();
		em.remove(mensaje);
		entityTransaction.commit();

		// Mostramos los mensajes con el nuevo ya eliminado******
		List<Mensaje> resultList = em.createQuery("from Mensaje")
				.getResultList();
		int tamanyo = resultList.size();

		System.out.println("*******ELIMINAR MENSAJE*******");

		assert (tamanyo == 3) : tamanyo + " -----";
		for (Mensaje m : resultList)
			System.out.println(m.getTexto());

		em.close();

	}

	@Test
	public void modificarUsuario() {
		EntityManager em = emf.createEntityManager();

		EntityTransaction entityTransaction = em.getTransaction();

		// Obtenemos el usuario al que vamos a modificar el color
		Usuario usuario = em.find(Usuario.class, 3L);

		// Obtenemos el color que le vamos a asignar al usuario
		Color color = em.find(Color.class, 3L);

		usuario.setColor(color);

		entityTransaction.begin();
		em.persist(usuario);
		entityTransaction.commit();

		// Mostramos los usuarios con sus respectivos colores******
		List<Usuario> resultList = em.createQuery("from Usuario")
				.getResultList();
		int tamanyo = resultList.size();

		System.out.println("*******MODIFICAR COLOR DE USUARIO*******");

		assert (tamanyo == 3) : tamanyo + " -----";
		for (Usuario u : resultList)
			System.out
					.println(u.getNick() + " - " + u.getColor().getHtmlCode());

		em.close();

	}

	@AfterTest
	public void finalizarTest() {
		emf.close(); // close at application end
	}
}
