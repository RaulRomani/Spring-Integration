package com.cjava.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Long id;
	
	@Column(name="emp_nombre")
	private String nombre;
	
	@Column(name="emp_usuario")
	private String usuario;
	
	@Column(name="emp_clave")
	private String clave;

	public Empleado() {
	}
	
	
	public Empleado(String nombre, String usuario, String clave) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.clave = clave;
	}

	public Empleado(Long id, String nombre, String usuario, String clave) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.clave = clave;
	}



	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


}
