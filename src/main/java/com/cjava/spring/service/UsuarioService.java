package com.cjava.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjava.spring.dao.UsuarioDao;
import com.cjava.spring.entity.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	public void grabar(Usuario usuario) {
		usuarioDao.grabar(usuario);
	}
	
	public void modificar(Usuario usuario){
		usuarioDao.modificar(usuario);
	}
	
	public void eliminar(Usuario usuario){
		usuarioDao.eliminar(usuario);
	}

	public Usuario buscarLogin(Usuario usuario) {
		return usuarioDao.buscar(
				"from Usuario u where u.usuario = ? and u.clave = ?",
				usuario.getUsuario(), usuario.getClave());
	}

}
