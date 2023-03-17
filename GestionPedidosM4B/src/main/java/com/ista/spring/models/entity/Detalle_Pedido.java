package com.ista.spring.models.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="detalle_pedido")
public class Detalle_Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deta_id;
	private Integer deta_cantidad;
	private Double deta_precio_total;
	
	public Detalle_Pedido() {
		
	}
	
	
	public Detalle_Pedido(Long deta_id, Integer deta_cantidad, Double deta_precio_total) {
		super();
		this.deta_id = deta_id;
		this.deta_cantidad = deta_cantidad;
		this.deta_precio_total = deta_precio_total;
	}

	//RELACION UNO A MUCHOS CON PEDIDOS
	@JsonIgnore
	@OneToMany(mappedBy = "ped_id")
	private List<Pedido> pedidos;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_producto")
	private Producto productop;
	
	

	public Long getDeta_id() {
		return deta_id;
	}

	public void setDeta_id(Long deta_id) {
		this.deta_id = deta_id;
	}

	public Integer getDeta_cantidad() {
		return deta_cantidad;
	}

	public void setDeta_cantidad(Integer deta_cantidad) {
		this.deta_cantidad = deta_cantidad;
	}

	public Double getDeta_precio_total() {
		return deta_precio_total;
	}

	public void setDeta_precio_total(Double deta_precio_total) {
		this.deta_precio_total = deta_precio_total;
	}


	public Producto getProductop() {
		return productop;
	}

	public void setProductop(Producto productop) {
		this.productop = productop;
	}


	public List<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	
	
	
}