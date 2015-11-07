package com.cjava.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cjava.spring.util.Properties;

@Service
public class ServiceFactory {

	@Autowired
	private Properties properties;
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private ArticuloService articuloService;
	@Autowired
	private ClienteService clienteService;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public EmpleadoService getEmpleadoService() {
		return empleadoService;
	}

	public void setEmpleadoService(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}

	public ArticuloService getArticuloService() {
		return articuloService;
	}

	public void setArticuloService(ArticuloService articuloService) {
		this.articuloService = articuloService;
	}

	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	

	

}
