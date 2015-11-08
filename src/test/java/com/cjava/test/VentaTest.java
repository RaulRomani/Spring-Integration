package com.cjava.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cjava.spring.service.Carrito;
//import com.cjava.spring.entity.Venta;
import com.cjava.spring.service.VentaService;
import com.cjava.spring.service.ServiceFactory;

public class VentaTest extends AbstractBaseUnitTest {

	@Autowired
	VentaService VentaService;
	
	
	@Autowired
	private ServiceFactory serviceFactory;
		
	@Test
	public void registrar() throws Exception {
		//En el mapeo hibernate mediante anotaciones esta id automatico, ERROR SI SE PONE
//		Long id = new Long(2);
//		Venta Venta = new Venta("Carlos","raul","romani");
		
		VentaService.grabarVenta(new Carrito());
//		Assert.assertNotNull(Venta.getId());
	}
	

}
