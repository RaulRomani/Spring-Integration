package com.cjava.test;

import java.util.List;


//import junit.framework.Assert;
//import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cjava.spring.entity.Articulo;
import com.cjava.spring.service.ArticuloService;
import com.cjava.spring.service.ServiceFactory;

public class ArticuloTest extends AbstractBaseUnitTest {

	@Autowired
	ArticuloService articuloService;
	
	
	@Autowired
	private ServiceFactory serviceFactory;
		
	@Test
	public void registrar() {
		//En el mapeo hibernate mediante anotaciones esta id automatico, ERROR SI SE PONE
//		Long id = new Long(2);
		Articulo articulo = new Articulo("ART_10","Menu Familiar",  150D,20L);
		articuloService.registrar(articulo);
		Assert.assertNotNull(articulo.getId());
	}
	
//	@Test
	public void actualizar() {
		Articulo articulo = new Articulo(5L, "ART_02", "LAPTOP", 25D,30L);
		articuloService.actualizar(articulo);
		Assert.assertNotNull(articulo.getId());
	}
	
//	@Test
	public void obtener() {
		Articulo articulo = articuloService.obtener(5L);
		Assert.assertNotNull(articulo);
		System.out.println(articulo.getNombre());
	}
	
//	@Test
	public void eliminar() {
		articuloService.eliminar(5L);
	}
	
//	@Test
	public void listar() throws Exception {
		List<Articulo> articulos = articuloService.listar();
		
//		List<Articulo> articulos = serviceFactory.getArticuloService().listar();
		Assert.assertNotNull(articulos);
		Assert.assertTrue(articulos.size() >= 0);
		for (Articulo articulo : articulos) {
			System.out.println(articulo.getNombre());
			
		}
	}

}
