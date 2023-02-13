package com.ista.spring.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="productos", uniqueConstraints = {@UniqueConstraint(columnNames = { "id_pedido"})})
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long prod_id;
	
	private String prod_nombre;
	private String prod_tipo;
	private String prod_descripcion;
	private double prod_preciounitario;
	
	
	public long getProd_id() {
		return prod_id;
	}
	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_nombre() {
		return prod_nombre;
	}
	public void setProd_nombre(String prod_nombre) {
		this.prod_nombre = prod_nombre;
	}
	public String getProd_tipo() {
		return prod_tipo;
	}
	public void setProd_tipo(String prod_tipo) {
		this.prod_tipo = prod_tipo;
	}
	public String getProd_descripcion() {
		return prod_descripcion;
	}
	public void setProd_descripcion(String prod_descripcion) {
		this.prod_descripcion = prod_descripcion;
	}
	public double getProd_preciounitario() {
		return prod_preciounitario;
	}
	public void setProd_preciounitario(double prod_preciounitario) {
		this.prod_preciounitario = prod_preciounitario;
	}
	
	
}
