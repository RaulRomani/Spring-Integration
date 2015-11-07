package com.cjava.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cjava.spring.entity.Empleado;
import com.cjava.spring.util.HibernateBaseDao;

@Repository
public class EmpleadoDao  {
	@Autowired
	private HibernateBaseDao hibernateBaseDao;

	
	public void registrar(Empleado empleado) {
		hibernateBaseDao.grabar(empleado);
	}

	
	public void actualizar(Empleado empleado) {
		hibernateBaseDao.modificar(empleado);
	}

	
	public Empleado obtener(Long id) {
		return (Empleado) hibernateBaseDao.buscarPorId(Empleado.class, id);
		
	}
	
	public void eliminar(Long id) {
		hibernateBaseDao.eliminarPorId(Empleado.class, id);
	}

	
	public List<Empleado> listar() {
		return hibernateBaseDao.buscarTodos(Empleado.class);
	}
	
	public Empleado buscar(String query, Object... parametros){
		return hibernateBaseDao.buscar(query,parametros);
	}
}
