package com.ista.spring.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name = "pedidos",uniqueConstraints =  {@UniqueConstraint(columnNames= {"id_detalle_pedido", "persona_id"})})
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1914035439630943360L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ped_id")
	private long ped_id;

	@Column(name = "ped_fecha")
	@Temporal(TemporalType.DATE)
	private Date ped_fecha;

	private String ped_direccionenvio;
	private String ped_estado;
	private String ped_telefono;
	

	public Pedido() {
		
	}
	
	public Pedido(long ped_id, Date ped_fecha, String ped_direccionenvio, String ped_estado, String ped_telefono) {
		super();
		this.ped_id = ped_id;
		this.ped_fecha = ped_fecha;
		this.ped_direccionenvio = ped_direccionenvio;
		this.ped_estado = ped_estado;
		this.ped_telefono = ped_telefono;
	}


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

	public String getPed_telefono() {
		return ped_telefono;
	}

	public void setPed_telefono(String ped_telefono) {
		this.ped_telefono = ped_telefono;
	}
	
}