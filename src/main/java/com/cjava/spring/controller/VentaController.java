package com.cjava.spring.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cjava.spring.entity.Articulo;
import com.cjava.spring.entity.Cliente;
import com.cjava.spring.entity.Empleado;
import com.cjava.spring.service.Carrito;
import com.cjava.spring.entity.CarritoItem;
import com.cjava.spring.service.ServiceFactory;
import com.cjava.spring.util.Constantes;
import com.cjava.spring.util.WebUtil;

@Controller
@Scope("request")
public class VentaController implements Serializable {

	// Empleado
	// List<Empleado> empleados;
	
	@Autowired
	ServiceFactory serviceFactory;
	private FacesContext facesContext;
	private FacesMessage facesMessage;
	private String paginaResultado;

	Empleado empleado;
	// Venta
	private Long idCliente;
	private Long idArticulo;
	private Double precio = 0.0;
	private Long cant = 1L;
	private Double subtotal = 0.0;
	
	private List<SelectItem> articulos;
	private List<SelectItem> clientes;
	
	@Autowired
	Carrito carrito;
//	private Carrito carrito;

	public VentaController() {
		System.out.println("ventaController");
		facesContext = WebUtil.getFacesContextCurrentInstance();
		System.out.println(facesContext);
		empleado = new Empleado();
	}


	public Carrito getCarrito() {
		return carrito;
	}



	public Double getSubtotal() {
		return subtotal;
	}
	
	


	public Empleado getEmpleado() {
		if(carrito.getEmpleado() == null)
			return empleado;
		else
			return serviceFactory.getEmpleadoService().obtener(carrito.getEmpleado());
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public Long getCant() {
		return cant;
	}

	public void setCant(Long cant) {
		this.cant = cant;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Long idArticulo) {
		this.idArticulo = idArticulo;
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
			paginaResultado = "/paginas/modulos/principal/ventas"
					+ Constantes.REDIRECT_JSF;
			carrito.setEmpleado(empleado.getId());

		}

		facesContext.addMessage(null, facesMessage);
		return paginaResultado;
	}

	public List<SelectItem> getClientes() {
		if (clientes == null) {
			try {
				clientes = new ArrayList<SelectItem>();
				List<Cliente> lista = serviceFactory.getClienteService().listar();
				for (Cliente c : lista) {
					SelectItem op = new SelectItem();
					op.setValue(c.getId());
					op.setLabel(c.getNombre());
					clientes.add(op);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return clientes;
	}
	
	

	public List<SelectItem> getArticulos() {
		if (articulos == null) {
			try {
				articulos = new ArrayList<SelectItem>();
				List<Articulo> lista = serviceFactory.getArticuloService().listar();
				for (Articulo a : lista) {
					SelectItem op = new SelectItem();
					op.setValue(a.getId());
					op.setLabel(a.getNombre());
					articulos.add(op);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return articulos;
	}

	public void setArticulos(List<SelectItem> articulos) {
		this.articulos = articulos;
	}

	public void setClientes(List<SelectItem> clientes) {
		this.clientes = clientes;
	}



	public String doSalir() {
		carrito.clear();
		carrito.setEmpleado(null);
		return "/paginas/modulos/seguridad/login";
	}

	public void modificarPrecio(ValueChangeEvent event) {
		try {
			Long idArt = (Long) event.getNewValue();
//			VentaService srv = new VentaService();
//			Articulo a = srv.consultarArticulo(idArt);
			Articulo a = serviceFactory.getArticuloService().obtener(idArt);
			precio = a.getPrecio();
			subtotal = precio * cant;
		} catch (Exception e) {
			precio = 0.0;
		}
	}

	public void modificarCantidad(ValueChangeEvent event) {
		try {
			Long c = (Long) event.getNewValue();
			subtotal = precio * c;
		} catch (Exception e) {
			precio = 0.0;
		}
	}

	public String doAgregarItem(){
		try {
			
			Articulo a = serviceFactory.getArticuloService().obtener(idArticulo);
			CarritoItem item = new CarritoItem();
			item.setId(a.getId());
			item.setCodigo(a.getCodigo());
			item.setNombre(a.getNombre());
			item.setPrecio(a.getPrecio());
			item.setCant(cant);
			item.setSubtotal(item.getPrecio() * item.getCant());
			carrito.add(item);
		} catch (Exception e) {
		}
		return "ventas";
	}

	public String doEliminarItem( Long id ) {
		carrito.remove(id);
		return "ventas";
	}

	public String doGrabar(){
//		mensaje = "";
		try {
			carrito.setCliente(idCliente);
//			carrito.setEmpleado(empleado.getId());
//			carrito.setEmpleado();
//			VentaService srv = new VentaService();
//			srv.grabarVenta(carrito);
			serviceFactory.getVentaService().grabarVenta(carrito);
			carrito.clear();
//			mensaje = "Proceso ok.";
		} catch (Exception e) {
//			mensaje = e.getMessage();
			e.printStackTrace();
		}
		return "ventas";
	}

}
