package com.cjava.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cjava.spring.entity.CarritoItem;

@Service
public class Carrito {

	private Long cliente;
	private Long empleado;
//	private Double consumo;
//	private Double descuento;
	private List<CarritoItem> items;

	public Carrito() {
		items = new ArrayList<CarritoItem>();
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public Long getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Long empleado) {
		this.empleado = empleado;
	}
	
	public Double getConsumo() {
		Double t = 0.0;
		for (CarritoItem i : items) {
			t += i.getSubtotal();
		}
		return t;
	}
	
	
	public List<CarritoItem> getItems() {
		return items;
	}

	public void add(CarritoItem item) {
		if (item == null) {
			return;
		}
		boolean encontro = false;
		for (CarritoItem i : items) {
			if( i.getId() == item.getId() ){
				i.setCant( i.getCant() + item.getCant());
				i.setSubtotal( i.getSubtotal() + item.getSubtotal());
				encontro = true;
			}
		}
		if (!encontro) {
			items.add(item);
		}
		int k = 0;
		while( k < items.size() ){
			if( items.get(k).getCant() <= 0 ){
				items.remove(k);
			} else {
				k++;
			}
		}
	}

	public Double getTotal() {		
		Double t = 0.0;
		for (CarritoItem i : items) {
			t += i.getSubtotal();
		}
		Double descuento = 0.0;
		Double importe = t / 1.18;
		Double total = t;
		
		if(importe >= 0 && importe <= 100)
			descuento = total * 0.00;
		if(importe >= 101 && importe <= 200)
			descuento = total * 0.03;
		if(importe >= 201 && importe <= 300)
			descuento = total * 0.05;
		if(importe >= 301 && importe <= 400)
			descuento = total * 0.07;
		if(importe >= 401 && importe <= 500)
			descuento = total * 0.10;
		if(importe >= 501)
			descuento = total * 0.15;
		return t - descuento;
	}
	public Double getDescuento() {		
		Double t = 0.0;
		for (CarritoItem i : items) {
			t += i.getSubtotal();
		}
		Double descuento = 0.0;
		Double importe = t / 1.18;
		Double total = t;
		
		if(importe >= 0 && importe <= 100)
			descuento = total * 0.00;
		if(importe >= 101 && importe <= 200)
			descuento = total * 0.03;
		if(importe >= 201 && importe <= 300)
			descuento = total * 0.05;
		if(importe >= 301 && importe <= 400)
			descuento = total * 0.07;
		if(importe >= 401 && importe <= 500)
			descuento = total * 0.10;
		if(importe >= 501 )
			descuento = total * 0.15;
		return descuento;
	}

	public Double getImporte() {
		Double i;
		i = getTotal() / 1.18;
		return i;
	}

	public Double getImpuesto() {
		Double imp;
		imp = getTotal() - getImporte();
		return imp;
	}

	public void remove( Long id ) {
		for (CarritoItem i : items) {
			if( i.getId() == id ){
				items.remove(i);
				break;
			}
		}
	}

	public void clear() {
		items.clear();
	}
}
