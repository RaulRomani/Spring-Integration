package com.cjava.spring.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjava.spring.entity.Articulo;
import com.cjava.spring.entity.CarritoItem;
import com.cjava.spring.entity.Cliente;
import com.cjava.spring.entity.Detalle;
import com.cjava.spring.entity.Venta;


@Service
public class VentaService {

	//consultar clientes,, articulos, articulo
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ServiceFactory service;
	
	public void grabarVenta(Carrito carrito) throws Exception{
		
//		HibernateBaseDao hibernate = new HibernateBaseDao();
//		Session session = hibernate.getCurrentSession();
		Session session = sessionFactory.getCurrentSession();
		
		//Testing transaction with AOP, It's works
//		Articulo articulo = new Articulo("ART_08","Microfono",  100D,20L);
//		session.persist(articulo);
//		Cliente cliente = new Cliente("ART_08","juridica");
//		session.persist(cliente);
		
		
		
		Venta venta = new Venta(carrito.getCliente(),
								carrito.getEmpleado(),
								new Date(),
								carrito.getImporte(), 
								carrito.getImpuesto(),
								carrito.getTotal());

//		new Venta(idCliente, idEmpleado, fecha, subTotal, impuesto, total);
		
		Detalle detalle;
		for (CarritoItem i : carrito.getItems()) {
			
			// Stock
			Articulo a = service.getArticuloService().obtener(i.getId());
			if( i.getCant() > a.getStock() ){
				throw new Exception("Stock no es sufientes en articulo " + i.getCodigo() + ".");
			}
			a.setStock(a.getStock()-i.getCant());
			
			service.getArticuloService().actualizar(a);
			
			// Grabar el detalle
			detalle = new Detalle(venta, i.getId(), i.getPrecio(), i.getCant(), i.getSubtotal() );
			venta.getDetalles().add(detalle);
//			query = "insert into detalle(ven_id,art_id,det_precio,det_cantidad,"
//					  + "det_subtotal) values(?,?,?,?,?)";
//			pstm = cn.prepareStatement(query);
//			pstm.setLong(1, idVenta);
//			pstm.setLong(2, i.getId());
//			pstm.setDouble(3, i.getPrecio());
//			pstm.setLong(4, i.getCant());
//			pstm.setDouble(5, i.getSubtotal());
//			pstm.executeUpdate();

			
		}
		
		session.persist(venta);
		
		

//			// Grabar los detalles y actualizar los stocks
//			for (CarritoItem i : carrito.getItems()) {

//				

//			}
		
	}
}
