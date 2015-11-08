package com.cjava.spring.controller;

import java.util.List;
import javax.faces.context.FacesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.cjava.spring.entity.Articulo;
import com.cjava.spring.service.ServiceFactory;
import com.cjava.spring.util.WebUtil;

@Controller
@Scope("request")
public class ArticuloController {

	@Autowired
	ServiceFactory serviceFactory;
	private FacesContext facesContext;
	List<Articulo> articulos;
	Articulo articulo; 

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public ArticuloController() {
		System.out.println("articuloController");
		facesContext = WebUtil.getFacesContextCurrentInstance();
		System.out.println(facesContext);
		articulo = new Articulo();
	}
	
	public String eliminar(Articulo articulo) {
		Long id = articulo.getId();
		serviceFactory.getArticuloService().eliminar(id);
		return "/paginas/modulos/principal/articulos";
	}
	public String cargar(Articulo articulo) {
		return "/paginas/modulos/principal/articulos";
	}
	
	public String grabar() {
		if(articulo.getId() == null){
			serviceFactory.getArticuloService().registrar(articulo);
		}else{
			serviceFactory.getArticuloService().actualizar(articulo);
		}
		articulo = new Articulo();
		return "/paginas/modulos/principal/articulos";
	}
	
	public List<Articulo> getArticulos() {
		return  serviceFactory.getArticuloService().listar();
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	} 
}