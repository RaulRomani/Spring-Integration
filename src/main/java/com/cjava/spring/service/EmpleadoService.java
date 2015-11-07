package com.cjava.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjava.spring.dao.EmpleadoDao;
import com.cjava.spring.entity.Empleado;

@Service
public class EmpleadoService {
	
	@Autowired
	private EmpleadoDao empleadoDao;

	public void registrar(Empleado empleado) {
		empleadoDao.registrar(empleado);
	}


	public void actualizar(Empleado empleado) {
		empleadoDao.actualizar(empleado);
	}


	public Empleado obtener(Long id) {
		return empleadoDao.obtener(id);
	}


	public void eliminar(Long id) {
		empleadoDao.eliminar(id);
	}


	public List<Empleado> listar() {
		return empleadoDao.listar();
	}
	
	public Empleado buscarLogin(Empleado empleado) {
		return empleadoDao.buscar(
				"from Empleado e where e.usuario = ? and e.clave = ?",
				empleado.getUsuario(), empleado.getClave());
	}

}
