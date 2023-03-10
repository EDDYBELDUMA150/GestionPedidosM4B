package com.ista.spring.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1914035439630943360L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ped_id")
	private long ped_id;

	// ola esta es una prueba gg
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "persona_id")
	private Usuario persona;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<Detalle_Pedido> detalle;

	public Pedido() {
		this.detalle = new ArrayList<>();
	}
	
	
	@Column(name = "ped_fecha")
	@Temporal(TemporalType.DATE)
	private Date ped_fecha;

	private String ped_descripcion;
	private String ped_direccionenvio;
	private String ped_estado;
	private String ped_telefono;
	private long ped_cli_id;

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

	public String getPed_telefono() {
		return ped_telefono;
	}

	public void setPed_telefono(String ped_telefono) {
		this.ped_telefono = ped_telefono;
	}

	public long getPed_cli_id() {
		return ped_cli_id;
	}

	public void setPed_cli_id(long ped_cli_id) {
		this.ped_cli_id = ped_cli_id;
	}

	public Usuario getPersona() {
		return persona;
	}

	public void setPersona(Usuario persona) {
		this.persona = persona;
	}

	public List<Detalle_Pedido> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<Detalle_Pedido> detalle) {
		this.detalle = detalle;
	}

}