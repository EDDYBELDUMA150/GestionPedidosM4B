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



@Entity
@Table(name="detalle_pedido")
public class Detalle_Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2408352983216568171L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long deta_id;
	
	
	private int deta_cantidad;
	
	private double deta_precio_total;
	//private long det_prod_id;
	
	//sadasdasdasdasdasdasdasdasdasdasdadasd
	@OneToOne(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	//comit prueba pillco
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "det_prod_id")
	private Producto producto;
	
	
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
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
	
	public double getDeta_precio_total() {
		return deta_precio_total;
	}
	public void setDeta_precio_total(double deta_precio_total) {
		this.deta_precio_total = deta_precio_total;
	}
	//public long getDet_prod_id() {
		//return det_prod_id;
	//}
	//public void setDet_prod_id(long det_prod_id) {
		//this.det_prod_id = det_prod_id;
	//}
	
	
	
}