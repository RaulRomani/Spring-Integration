package com.cjava.spring.controller;

import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjava.spring.entity.Persona;
import com.cjava.spring.entity.Usuario;
import com.cjava.spring.service.PersonaService;
import com.cjava.spring.service.ServiceFactory;
import com.cjava.spring.util.WebUtil;

@Controller
@Scope("request")
public class PersonaController {
	
	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ServiceFactory serviceFactory;
	
//	private FacesMessage facesMessage;

	private FacesContext facesContext;

//	private String paginaResultado;

//	private Usuario usuario;
	
	List<Persona> personas;
	
	Persona persona; 

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public PersonaController() {
		System.out.println("personaController");
		facesContext = WebUtil.getFacesContextCurrentInstance();
		System.out.println(facesContext);
		persona = new Persona();
	}
	
	public String eliminar(Persona persona) {
		//logger.info("eliminar: " + id);
		Long id = persona.getId();
		serviceFactory.getPersonaService().eliminar(id);
		return "/paginas/modulos/principal/mantenimiento";
	}
	public String cargar(Persona persona) {
		//logger.info("eliminar: " + id);
		
//		Persona pers = serviceFactory.getPersonaService().obtener(persona.getId());
//		persona.setId(id);
		this.persona = persona;
//		model.addAttribute("persona", persona);
//		return "mantenimiento";
		
//		serviceFactory.getPersonaService().actualizar(persona);
		return "/paginas/modulos/principal/mantenimiento";
	}
	
	public String grabar() {
		//logger.info("eliminar: " + id);
		
		if(persona.getId() == null){
			//logger.info("registrar");
			serviceFactory.getPersonaService().registrar(persona);
		}else{
			//logger.info("actualizar");
			serviceFactory.getPersonaService().actualizar(persona);
		}
		persona = new Persona();
		

		return "/paginas/modulos/principal/mantenimiento";
	}
	
	public List<Persona> getPersonas() {
		return  serviceFactory.getPersonaService().listar();
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

//	@RequestMapping(method = RequestMethod.GET)
//	public String init(Model model) {
//		//logger.info("init 2");
//		personas = personaService.listar();
//		model.addAttribute("personas", personas);
//		return "mantenimiento";
//	}
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public String processSubmit(@Valid Persona persona, BindingResult result, Model model) {
//		//logger.info("processSubmit");
//		
//		if(result.hasErrors()){
//			logger.info("existen errores");
//			for(FieldError error : result.getFieldErrors()){
//				model.addAttribute("error" + error.getField(), error.getDefaultMessage());
//			}
//			return "mantenimiento";
//		}
//
//		logger.info("persona: " + persona);
//		
//		if(persona.getId() == null){
//			//logger.info("registrar");
//			personaService.registrar(persona);
//		}else{
//			//logger.info("actualizar");
//			personaService.actualizar(persona);	
//		}
//		
//		return "redirect:/mantenimiento";
//	}
//	
//	@ModelAttribute("personas")
//	public List<Persona> getPersonas() {
//		//logger.info("getPersonas");
//		return personas;
//	}
//	
//	@ModelAttribute("fecha")
//	public String getTime() {
//		//logger.info("getTime");
//		return Calendar.getInstance().getTime().toString();
//	}
//	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		//logger.info("initBinder");
//	}
//	
//	@RequestMapping(value="cargar", method = RequestMethod.GET)
//	public String cargar(@RequestParam("id") Long id, Model model) {
//		//logger.info("cargar: " + id);
//		Persona persona = personaService.obtener(id);
//		persona.setId(id);
//		model.addAttribute("persona", persona);
//		return "mantenimiento";
//	}
//
//	@RequestMapping(value="eliminar", method = RequestMethod.GET)
//	public String eliminar(@RequestParam("id") Long id) {
//		//logger.info("eliminar: " + id);
//		personaService.eliminar(id);
//		return "redirect:/mantenimiento";
//	}
 
}