package com.cjava.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjava.spring.dao.ClienteDao;
import com.cjava.spring.entity.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteDao ClienteDao;

	public void registrar(Cliente Cliente) {
		ClienteDao.registrar(Cliente);
	}


	public void actualizar(Cliente Cliente) {
		ClienteDao.actualizar(Cliente);
	}


	public Cliente obtener(Long id) {
		return ClienteDao.obtener(id);
	}


	public void eliminar(Long id) {
		ClienteDao.eliminar(id);
	}


	public List<Cliente> listar() {
		return ClienteDao.listar();
	}

}
