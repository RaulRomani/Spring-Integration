package com.cjava.spring.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cjava.spring.entity.Persona;
import com.cjava.spring.entity.Usuario;
import com.cjava.spring.service.PersonaService;
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

	private Usuario usuario;
		
	
	


	public LoginController() {
		System.out.println("loginController");
		facesContext = WebUtil.getFacesContextCurrentInstance();
		System.out.println(facesContext);
		usuario = new Usuario();
	}

	public String login() {
		usuario = serviceFactory.getUsuarioService().buscarLogin(usuario);
		
		if (usuario == null) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					WebUtil.getMensaje("validacion.login.incorrecto"),
					Constantes.VACIO);
			paginaResultado = "login";
		} else {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					WebUtil.getMensaje("validacion.login.correcto",
							usuario.getUsuario()), Constantes.VACIO);
			WebUtil.keepMessages();
			paginaResultado = "/paginas/modulos/principal/mantenimiento"
					+ Constantes.REDIRECT_JSF;
		}

		facesContext.addMessage(null, facesMessage);
		return paginaResultado;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
