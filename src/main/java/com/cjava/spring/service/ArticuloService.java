package com.cjava.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjava.spring.dao.ArticuloDao;
import com.cjava.spring.entity.Articulo;

@Service
public class ArticuloService {
	
	@Autowired
	private ArticuloDao articuloDao;

	public void registrar(Articulo articulo) {
		articuloDao.registrar(articulo);
	}


	public void actualizar(Articulo articulo) {
		articuloDao.actualizar(articulo);
	}


	public Articulo obtener(Long id) {
		return articuloDao.obtener(id);
	}


	public void eliminar(Long id) {
		articuloDao.eliminar(id);
	}


	public List<Articulo> listar() {
		return articuloDao.listar();
	}

}
