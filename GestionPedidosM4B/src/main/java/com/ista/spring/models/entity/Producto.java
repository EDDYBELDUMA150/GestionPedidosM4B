package com.ista.spring.models.entity;

import java.io.Serializable;

import java.util.List;

import jakarta.persistence.*;



@Entity
@Table(name="productos")
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long prod_id;
	private String prod_codigo;
	private String prod_nombre;
	private String prod_tipo;
	private Integer prod_stock;
	private String prod_descripcion;
	private double prod_preciounitario;
	
	@Column(name= "prod_img", columnDefinition= "LONGBLOB")
	private String prod_img;
	
	
	public Producto(){
		
	}
	
	
	public Producto(long prod_id, String prod_codigo, String prod_nombre, String prod_tipo, Integer prod_stock,
			String prod_descripcion, double prod_preciounitario, String imagen, String prod_img) {
		super();
		this.prod_id = prod_id;
		this.prod_codigo = prod_codigo;
		this.prod_nombre = prod_nombre;
		this.prod_tipo = prod_tipo;
		this.prod_stock = prod_stock;
		this.prod_descripcion = prod_descripcion;
		this.prod_preciounitario = prod_preciounitario;
		this.prod_img = prod_img;
	}
	
	
	//RELACION UNO A UNO CON VEHICULO
	@OneToOne(mappedBy = "productop")
	private Detalle_Pedido detallePedido;
	
	public long getProd_id() {
		return prod_id;
	}	
	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}
	
	public String getProd_codigo() {
		return prod_codigo;
	}
	public void setProd_codigo(String prod_codigo) {
		this.prod_codigo = prod_codigo;
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

	public Integer getProd_stock() {
		return prod_stock;
	}
	public void setProd_stock(Integer prod_stock) {
		this.prod_stock = prod_stock;
	}
	public String getProd_img() {
		return prod_img;
	}
	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}
	
}