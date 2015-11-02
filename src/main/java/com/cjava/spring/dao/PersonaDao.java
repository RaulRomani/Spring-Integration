package com.cjava.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cjava.spring.entity.Persona;

@SuppressWarnings("unchecked")
@Repository
public class PersonaDao  {

	DataSource dataSource;
	
	JdbcTemplate jdbcTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	
	public void registrar(Persona persona) {
		this.getCurrentSession().persist(persona);
	}

	
	public void actualizar(Persona persona) {
		this.getCurrentSession().update(persona);
	}

	
	public Persona obtener(Long id) {
		return (Persona) this.getCurrentSession().get(Persona.class, id);
	}

	
	public void eliminar(Long id) {
		this.getCurrentSession().delete(obtener(id));
	}

	
	public List<Persona> listar() {
		return this.getCurrentSession().createQuery("from Persona").list();
	}
	
	public List<Persona> listarJDBC(){
		String sql = "Select * from Persona";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Persona> personas = null;
		try{
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			personas = new ArrayList<Persona>();
			while(rs.next()){
				Persona persona = new Persona(Long.parseLong(rs.getString("id")), 
						                      rs.getString("nombres"), 
						                      rs.getString("apellidos"), 
						                      rs.getInt("edad"));
				personas.add(persona);
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			if(ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return personas;
	}
	


	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
