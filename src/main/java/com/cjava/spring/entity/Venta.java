package com.cjava.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Venta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ven_id")
	private Long id;
	
	@Column(name="cli_id")
	private Long idCliente;
	
	@Column(name="emp_id")
	private Long idEmpleado;
	
	@Column(name="ven_fecha")
	private Date fecha;
	
	@Column(name="ven_subtotal")
	private Double subTotal;
	
	@Column(name="ven_impuesto")
	private Double impuesto;
	
	@Column(name="ven_total")
	private Double total;
	
	@OneToMany(mappedBy="venta", cascade=CascadeType.ALL)
	private Set<Detalle> detalles;
	
	public Venta() {
		// TODO Auto-generated constructor stub
	}
	

	public Venta(Long idCliente, Long idEmpleado, Date fecha, Double subTotal,
			Double impuesto, Double total) {
		this.idCliente = idCliente;
		this.idEmpleado = idEmpleado;
		this.fecha = fecha;
		this.subTotal = subTotal;
		this.impuesto = impuesto;
		this.total = total;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Set<Detalle> getDetalles() {
		if(detalles == null) detalles = new HashSet<Detalle>();
		return detalles;
	}

	public void setDetalles(Set<Detalle> detalles) {
		this.detalles = detalles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
