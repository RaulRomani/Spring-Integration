package com.cjava.spring.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@SuppressWarnings({"unchecked","rawtypes"})
@Repository
public class HibernateBaseDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public <T> void grabar(T entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public <T> void grabarOModificar(T entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public <T> void modificar(T entity) {
		this.getCurrentSession().update(entity);
	}
	
	public <T> void eliminar(T entity) {
		this.getCurrentSession().delete(entity);
	}
	
	public <T> void eliminarPorId(Class entity, Object id) {
		this.eliminar(this.buscarPorId(entity, id));
	}
	
	public <T> T buscarPorId(Class entity, Object id) {
		return (T) this.getCurrentSession().get(entity, (Serializable) id);
	}
	
	public <T> List<T> buscarLista(String queryString) {
		return this.getCurrentSession().createQuery(queryString).list();
	}
	
	public <T> List<T> buscarLista(String queryString, Object... parametros) {
		Query query = this.getCurrentSession().createQuery(queryString);
		for (int i = 0; i < parametros.length; i++) {query.setParameter(i, parametros[i]);}			
		return query.list();
	}
	
	public <T> T buscar(String queryString) {
		return (T) this.getCurrentSession().createQuery(queryString).uniqueResult();
	}
	
	public <T> T buscar(String queryString, Object... parametros) {
		Query query = this.getCurrentSession().createQuery(queryString);
		for (int i = 0; i < parametros.length; i++) {query.setParameter(i, parametros[i]);}			
		return (T) query.uniqueResult();
	}
	
	public <T> List<T> buscarTodos(Class entity) {
		return this.getCurrentSession().createQuery("from " + entity.getName()).list();
	}
	
	public <T> List<T> buscarListaPorSQL(String queryString, Class entity) {
		return this.getCurrentSession().createSQLQuery(queryString).setResultTransformer(Transformers.aliasToBean(entity)).list();
	}
	
	public <T> T buscarPorSQL(String queryString, Class entity) {
		return (T) this.getCurrentSession().createSQLQuery(queryString).setResultTransformer(Transformers.aliasToBean(entity)).uniqueResult();
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
   }

}
