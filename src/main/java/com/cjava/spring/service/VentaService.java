//package com.cjava.spring.service;
//
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.cjava.spring.entity.Cliente;
//import com.cjava.spring.entity.Empleado;
//
//
//public class VentaService {
//
//	//consultar clientes,, articulos, articulo
//	
//	public void grabarVenta(Carrito carrito) throws Exception{
//		Connection cn = null;
//		try {
//			cn = AccesoDB.getConnection();
//			cn.setAutoCommit(false);
//			// Grabar la cabecera
//			String query = "insert into venta(cli_id,ven_fecha,ven_subtotal,"
//					  + "ven_impuesto,ven_total,emp_id) values(?,sysdate(),?,?,?,?)";
//			PreparedStatement pstm = cn.prepareStatement(query);
//			
//			pstm.setLong(1, carrito.getCliente());
//			pstm.setDouble(2, carrito.getImporte() );
//			pstm.setDouble(3, carrito.getImpuesto() );
//			pstm.setDouble(4, carrito.getTotal() );
//			pstm.setLong(5, carrito.getEmpleado());
//			
//			pstm.executeUpdate();
//			
//			// Obtener el id de venta
//			query = "select LAST_INSERT_ID() as id";
//			
//			pstm = cn.prepareStatement(query);
//			ResultSet rs = pstm.executeQuery();
//			rs.next();
//			
//			Long idVenta = rs.getLong("id");
//			// Grabar los detalles y actualizar los stocks
//			for (CarritoItem i : carrito.getItems()) {
//				// Stock
//				Articulo a = consultarArticulo(i.getId());
//				if( i.getCant() > a.getStock() ){
//					throw new Exception("Stock no es sufientes en articulo " + i.getCodigo() + ".");
//				}
//				query = "update articulo set art_stock = art_stock - ? where art_id = ?";
//				pstm = cn.prepareStatement(query);
//				pstm.setLong(1, i.getCant());
//				pstm.setLong(2, i.getId());
//				pstm.executeUpdate();
//				
//				// Grabar el detalle
//				query = "insert into detalle(ven_id,art_id,det_precio,det_cantidad,"
//						  + "det_subtotal) values(?,?,?,?,?)";
//				pstm = cn.prepareStatement(query);
//				pstm.setLong(1, idVenta);
//				pstm.setLong(2, i.getId());
//				pstm.setDouble(3, i.getPrecio());
//				pstm.setLong(4, i.getCant());
//				pstm.setDouble(5, i.getSubtotal());
//				pstm.executeUpdate();
//			}
//			
//			cn.commit();
//			pstm.close();
//		} catch (Exception e) {
//			try {
//				cn.rollback();
//			} catch (Exception e1) {
//			}
//			throw e;
//		} finally {
//			try {
//				cn.close();
//			} catch (Exception e2) {
//			}
//		}
//	}
//}
