package com.cjava.spring.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cjava.spring.entity.Cliente;
import com.cjava.spring.util.HibernateBaseDao;

@Repository
public class ClienteDao  {
	@Autowired
	private HibernateBaseDao hibernateBaseDao;

	
	public void registrar(Cliente cliente) {
		hibernateBaseDao.grabar(cliente);
	}

	
	public void actualizar(Cliente cliente) {
		hibernateBaseDao.modificar(cliente);
	}

	
	public Cliente obtener(Long id) {
		return (Cliente) hibernateBaseDao.buscarPorId(Cliente.class, id);
		
	}

	
	public void eliminar(Long id) {
		hibernateBaseDao.eliminarPorId(Cliente.class, id);
	}

	
	public List<Cliente> listar() {
		return hibernateBaseDao.buscarTodos(Cliente.class);
	}
}
