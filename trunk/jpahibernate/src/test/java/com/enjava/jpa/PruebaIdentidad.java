package com.enjava.jpa;

import libreria.Libro;

import org.testng.annotations.Test;

public class PruebaIdentidad {

	@Test
	public void pruebaIdentidad(){
		Libro libro1=new Libro();
		libro1.setNombre("jpa book");
		
		Libro libro2=new Libro();
		libro2.setNombre("jpa book");
		System.out.println(libro1);
		System.out.println(libro2);
		
		assert(libro1.equals(libro2));
//		int enteroprimitivo=5;
//		Integer enteroEnvolvente=new Integer(5);
		//float, boolean . Float, Boolean ....
		//assert(libro1.getId().equals(libro2.getId())):" no son iguales";
		
		
		
		
	}
	
}
