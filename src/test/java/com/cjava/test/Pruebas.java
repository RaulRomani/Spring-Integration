package com.cjava.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cjava.spring.entity.Persona;
import com.cjava.spring.service.PersonaService;
import com.cjava.spring.service.ServiceFactory;

public class Pruebas extends AbstractBaseUnitTest {

	@Autowired
	PersonaService personaService;
	
	
	@Autowired
	private ServiceFactory serviceFactory;
	

	
	

//	@Test
	public void registrar() {
		Persona persona = new Persona("Raúl", "Romani", 24);
		personaService.registrar(persona);
		Assert.assertNotNull(persona.getId());
	}
	
	@Test
	public void actualizar() {
		Persona persona = new Persona(9L, "Jeán", "Rámal Alvarez", 25);
		personaService.actualizar(persona);
		Assert.assertNotNull(persona.getId());
	}
	
//	@Test
	public void obtener() {
		Persona persona = personaService.obtener(1L);
		Assert.assertNotNull(persona);
	}
	
	//@Test
	public void eliminar() {
		personaService.eliminar(6L);
	}
	
//	@Test
	public void listar() throws Exception {
//		List<Persona> personas = personaService.listar();
		
		List<Persona> personas = serviceFactory.getPersonaService().listar();
		Assert.assertNotNull(personas);
		Assert.assertTrue(personas.size() >= 0);
		for (Persona persona : personas) {
			System.out.println(persona.getNombres());
			
		}
	}

}
