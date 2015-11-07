package com.cjava.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cjava.spring.entity.Empleado;
import com.cjava.spring.service.EmpleadoService;
import com.cjava.spring.service.ServiceFactory;

public class EmpleadoTest extends AbstractBaseUnitTest {

	@Autowired
	EmpleadoService empleadoService;
	
	
	@Autowired
	private ServiceFactory serviceFactory;
		
	@Test
	public void registrar() {
		//En el mapeo hibernate mediante anotaciones esta id automatico, ERROR SI SE PONE
//		Long id = new Long(2);
		Empleado empleado = new Empleado("Carlos","raul","romani");
		empleadoService.registrar(empleado);
		Assert.assertNotNull(empleado.getId());
	}
	
//	@Test
	public void actualizar() {
		Empleado empleado = new Empleado(3L,"Raul" ,"raul", "romani123");
		empleadoService.actualizar(empleado);
		Assert.assertNotNull(empleado.getId());
	}
	
//	@Test
	public void obtener() {
		Empleado empleado = empleadoService.obtener(3L);
		Assert.assertNotNull(empleado);
		System.out.println(empleado.getNombre());
	}
	
//	@Test
	public void eliminar() {
		empleadoService.eliminar(3L);
	}
	
//	@Test
	public void listar() throws Exception {
		List<Empleado> empleados = empleadoService.listar();
		
//		List<Empleado> empleados = serviceFactory.getEmpleadoService().listar();
		Assert.assertNotNull(empleados);
		Assert.assertTrue(empleados.size() >= 0);
		for (Empleado empleado : empleados) {
			System.out.println(empleado.getNombre());
			
		}
	}

}
