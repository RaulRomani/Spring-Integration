package com.cjava.spring.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.cjava.spring.entity.Empleado;
import com.cjava.spring.service.ServiceFactory;
import com.cjava.spring.util.Constantes;
import com.cjava.spring.util.WebUtil;

@Controller
@Scope("request")
public class LoginController {

	@Autowired
	private ServiceFactory serviceFactory;

	private FacesMessage facesMessage;

	private FacesContext facesContext;

	private String paginaResultado;

	private Empleado empleado;
		
	
	


	public LoginController() {
		System.out.println("loginController");
		facesContext = WebUtil.getFacesContextCurrentInstance();
		System.out.println(facesContext);
		empleado = new Empleado();
	}

	public String login() {
		empleado = serviceFactory.getEmpleadoService().buscarLogin(empleado);
		
		if (empleado == null) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					WebUtil.getMensaje("validacion.login.incorrecto"),
					Constantes.VACIO);
			paginaResultado = "login";
		} else {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					WebUtil.getMensaje("validacion.login.correcto",
							empleado.getNombre()), Constantes.VACIO);
			WebUtil.keepMessages();
			paginaResultado = "/paginas/modulos/principal/articulos"
					+ Constantes.REDIRECT_JSF;
		}

		facesContext.addMessage(null, facesMessage);
		return paginaResultado;
	}

	
	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


}
