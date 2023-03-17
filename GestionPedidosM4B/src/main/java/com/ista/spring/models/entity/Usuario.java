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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long usu_id;
	private String usu_nombre;
	private String usu_apellido;
	private String usu_identificacion;
	private String usu_correo;
	private String usu_clave;
	private String usu_rol;
	private String usu_direccion;
	
	
	
	
	@OneToMany(fetch= FetchType.LAZY, mappedBy = "persona", cascade= CascadeType.ALL)
	@JsonIgnore
	private List<Pedido> pedido;
	
	
    
    public Usuario() {
		this.pedido = new ArrayList<>();
	}

	public long getUsu_id() {
		return usu_id;
	}
	public void setUsu_id(long usu_id) {
		this.usu_id = usu_id;
	}
	public String getUsu_rol() {
		return usu_rol;
	}
	public void setUsu_rol(String usu_rol) {
		this.usu_rol = usu_rol;
	}
	public String getUsu_direccion() {
		return usu_direccion;
	}
	public void setUsu_direccion(String usu_direccion) {
		this.usu_direccion = usu_direccion;
	}
	public String getUsu_nombre() {
		return usu_nombre;
	}
	public void setUsu_nombre(String usu_nombre) {
		this.usu_nombre = usu_nombre;
	}
	public String getUsu_identificacion() {
		return usu_identificacion;
	}
	public void setUsu_identificacion(String usu_identificacion) {
		this.usu_identificacion = usu_identificacion;
	}
	public String getUsu_correo() {
		return usu_correo;
	}
	public void setUsu_correo(String usu_correo) {
		this.usu_correo = usu_correo;
	}
	public String getUsu_clave() {
		return usu_clave;
	}
	public void setUsu_clave(String usu_clave) {
		this.usu_clave = usu_clave;
	}

	public String getUsu_apellido() {
		return usu_apellido;
	}

	public void setUsu_apellido(String usu_apellido) {
		this.usu_apellido = usu_apellido;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
	
}