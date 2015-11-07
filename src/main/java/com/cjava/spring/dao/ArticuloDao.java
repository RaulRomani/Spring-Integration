package com.cjava.spring.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cjava.spring.entity.Articulo;
import com.cjava.spring.util.HibernateBaseDao;

@Repository
public class ArticuloDao  {
	@Autowired
	private HibernateBaseDao hibernateBaseDao;

	
	public void registrar(Articulo articulo) {
		hibernateBaseDao.grabar(articulo);
	}

	
	public void actualizar(Articulo articulo) {
		hibernateBaseDao.modificar(articulo);
	}

	
	public Articulo obtener(Long id) {
		return (Articulo) hibernateBaseDao.buscarPorId(Articulo.class, id);
		
	}

	
	public void eliminar(Long id) {
		hibernateBaseDao.eliminarPorId(Articulo.class, id);
	}

	
	public List<Articulo> listar() {
		return hibernateBaseDao.buscarTodos(Articulo.class);
	}
}
