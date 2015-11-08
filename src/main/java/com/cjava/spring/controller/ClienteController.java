package com.cjava.spring.controller;

import java.util.List;
import javax.faces.context.FacesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.cjava.spring.entity.Cliente;
import com.cjava.spring.service.ServiceFactory;
import com.cjava.spring.util.WebUtil;

@Controller
@Scope("request")
public class ClienteController {

	@Autowired
	ServiceFactory serviceFactory;
	private FacesContext facesContext;
	List<Cliente> clientes;
	Cliente cliente; 

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteController() {
		System.out.println("clienteController");
		facesContext = WebUtil.getFacesContextCurrentInstance();
		System.out.println(facesContext);
		cliente = new Cliente();
	}
	
	public String eliminar(Cliente cliente) {
		Long id = cliente.getId();
		serviceFactory.getClienteService().eliminar(id);
		return "/paginas/modulos/principal/clientes";
	}
	public String cargar(Cliente cliente) {
		this.cliente = cliente;
		return "/paginas/modulos/principal/clientes";
	}
	
	public String grabar() {
		if(cliente.getId() == null){
			serviceFactory.getClienteService().registrar(cliente);
		}else{
			serviceFactory.getClienteService().actualizar(cliente);
		}
		cliente = new Cliente();
		

		return "/paginas/modulos/principal/clientes";
	}
	
	public List<Cliente> getClientes() {
		return  serviceFactory.getClienteService().listar();
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	} 
}