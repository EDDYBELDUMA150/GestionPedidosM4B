package com.ista.spring.models.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.UniqueConstraint;

import javax.persistence.PrePersist;

@Entity
@Table(name="pedidos", uniqueConstraints = {@UniqueConstraint(columnNames = { "id_cliente","id_producto"})})
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ped_id;
	
	//ola esta es una prueba gg
	
	@Column(name = "ped_fecha")
	@Temporal(TemporalType.DATE)
	private Date ped_fecha;
	
	private String ped_descripcion;
	private String ped_direccionenvio;
	private String ped_estado;
	
	@OneToOne(mappedBy = "pedido")
	private Detalle_Pedido detalle_pedido;
	
	
	@PrePersist
	public void prePersist() {
		ped_fecha = new Date();
	}

	public long getPed_id() {
		return ped_id;
	}

	public void setPed_id(long ped_id) {
		this.ped_id = ped_id;
	}

	public Date getPed_fecha() {
		return ped_fecha;
	}

	public void setPed_fecha(Date ped_fecha) {
		this.ped_fecha = ped_fecha;
	}

	public String getPed_descripcion() {
		return ped_descripcion;
	}

	public void setPed_descripcion(String ped_descripcion) {
		this.ped_descripcion = ped_descripcion;
	}

	public String getPed_direccionenvio() {
		return ped_direccionenvio;
	}

	public void setPed_direccionenvio(String ped_direccionenvio) {
		this.ped_direccionenvio = ped_direccionenvio;
	}

	public String getPed_estado() {
		return ped_estado;
	}

	public void setPed_estado(String ped_estado) {
		this.ped_estado = ped_estado;
	}
	
	
}
