package com.cjava.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Detalle implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="det_id")
	private Long id;
	
	@ManyToOne( cascade=CascadeType.ALL)
	@JoinColumn(name="ven_id") // Columna que corresponde a la FK
	private Venta venta;
	
	@Column(name="art_id")
	private Long idArticulo;
	
	@Column(name="det_precio")
	private Double precio;
	
	@Column(name="det_cantidad")
	private Long cantidad;
	
	@Column(name="det_subtotal")
	private Double subTotal;
	
	public Detalle() {
		// TODO Auto-generated constructor stub
	}

	public Detalle( Venta venta, Long idArticulo, Double precio,
			Long cantidad, Double subTotal) {
		this.venta = venta;
		this.idArticulo = idArticulo;
		this.precio = precio;
		this.cantidad = cantidad;
		this.subTotal = subTotal;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Long getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Long idArticulo) {
		this.idArticulo = idArticulo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
