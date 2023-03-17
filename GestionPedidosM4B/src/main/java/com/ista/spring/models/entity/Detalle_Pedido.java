package com.ista.spring.models.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
	//private long det_prod_id;
	
	//sadasdasdasdasdasdasdasdasdasdasdadasd
	@ManyToOne(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="pedido_id")
	@JsonIgnore
	private Pedido pedido;
	
	//comit prueba pillco
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "det_prod_id")
	@JsonIgnore
	private Producto producto;

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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	//public long getDet_prod_id() {
		//return det_prod_id;
	//}
	//public void setDet_prod_id(long det_prod_id) {
		//this.det_prod_id = det_prod_id;
	//}
	
	
	
}