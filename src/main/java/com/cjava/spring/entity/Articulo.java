package com.cjava.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity(name="")
public class Articulo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="art_id")
	private Long id;
	
	@NotNull(message = "no puede estar vacio")
	@Column(name="art_codigo")
	private String codigo;
	
	@NotNull(message = "no puede estar vacio")
	@Column(name="art_nombre")
	private String nombre;
	
	@NotNull(message = "no puede estar vacio")
	@Column(name="art_precio")
	private Double precio;
	
	@NotNull(message = "no puede estar vacio")
	@Column(name="art_stock")
	private Long stock;

	public Articulo() {
	}
	
	
	//Para crear objetos
	public Articulo(Long id, String codigo, String nombre, Double precio,
			Long stock) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}


	//Para Hibernate
	public Articulo(String codigo, String nombre, Double precio, Long stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	
}
