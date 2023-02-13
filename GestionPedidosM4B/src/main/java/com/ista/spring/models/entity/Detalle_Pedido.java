package com.ista.spring.models.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="detalle_pedido")
public class Detalle_Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long deta_id;
	
	
	private int deta_cantidad;
	private String deta_descripcion;
	private double deta_precio_total;
	
	public long getDeta_id() {
		return deta_id;
	}
	public void setDeta_id(long deta_id) {
		this.deta_id = deta_id;
	}
	public int getDeta_cantidad() {
		return deta_cantidad;
	}
	public void setDeta_cantidad(int deta_cantidad) {
		this.deta_cantidad = deta_cantidad;
	}
	public String getDeta_descripcion() {
		return deta_descripcion;
	}
	public void setDeta_descripcion(String deta_descripcion) {
		this.deta_descripcion = deta_descripcion;
	}
	public double getDeta_precio_total() {
		return deta_precio_total;
	}
	public void setDeta_precio_total(double deta_precio_total) {
		this.deta_precio_total = deta_precio_total;
	}

	
}
