package com.cjava.spring.controller;

import java.util.List;
import javax.faces.context.FacesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.cjava.spring.entity.Empleado;
import com.cjava.spring.service.ServiceFactory;
import com.cjava.spring.util.WebUtil;

@Controller
@Scope("request")
public class EmpleadoController {
	
	@Autowired
	ServiceFactory serviceFactory;
	private FacesContext facesContext;
	List<Empleado> empleados;
	Empleado empleado; 

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public EmpleadoController() {
		System.out.println("empleadoController");
		facesContext = WebUtil.getFacesContextCurrentInstance();
		System.out.println(facesContext);
		empleado = new Empleado();
	}
	
	public String eliminar(Empleado empleado) {
		Long id = empleado.getId();
		serviceFactory.getEmpleadoService().eliminar(id);
		return "/paginas/modulos/principal/empleados";
	}
	public String cargar(Empleado empleado) {
		this.empleado = empleado;
		return "/paginas/modulos/principal/empleados";
	}
	
	public String grabar() {
		if(empleado.getId() == null){
			serviceFactory.getEmpleadoService().registrar(empleado);
		}else{
			serviceFactory.getEmpleadoService().actualizar(empleado);
		}
		empleado = new Empleado();
		

		return "/paginas/modulos/principal/empleados";
	}
	
	public List<Empleado> getEmpleados() {
		return  serviceFactory.getEmpleadoService().listar();
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	} 
}