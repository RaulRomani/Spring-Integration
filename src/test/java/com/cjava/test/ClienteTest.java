package com.cjava.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cjava.spring.entity.Cliente;
import com.cjava.spring.service.ClienteService;
import com.cjava.spring.service.ServiceFactory;

public class ClienteTest extends AbstractBaseUnitTest {

	@Autowired
	ClienteService clienteService;
	
	
	@Autowired
	private ServiceFactory serviceFactory;
		
//	@Test
	public void registrar() {
		//En el mapeo hibernate mediante anotaciones esta id automatico, ERROR SI SE PONE
//		Long id = new Long(2);
		Cliente cliente = new Cliente("ART_08","juridica");
		clienteService.registrar(cliente);
		Assert.assertNotNull(cliente.getId());
	}
	
//	@Test
	public void actualizar() {
		Cliente cliente = new Cliente(7L, "ART_02", "LAPTOPss");
		clienteService.actualizar(cliente);
		Assert.assertNotNull(cliente.getId());
	}
	
//	@Test
	public void obtener() {
		Cliente cliente = clienteService.obtener(7L);
		Assert.assertNotNull(cliente);
		System.out.println(cliente.getNombre());
	}
	
//	@Test
	public void eliminar() {
		clienteService.eliminar(7L);
	}
	
	@Test
	public void listar() throws Exception {
		List<Cliente> clientes = clienteService.listar();
		
//		List<Cliente> clientes = serviceFactory.getClienteService().listar();
		Assert.assertNotNull(clientes);
		Assert.assertTrue(clientes.size() >= 0);
		Cliente c = clienteService.obtener(5L);
		if (c.getTipo().equals("juridica"))
			System.out.println(c.getTipo());
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNombre());
			
		}
	}

}
