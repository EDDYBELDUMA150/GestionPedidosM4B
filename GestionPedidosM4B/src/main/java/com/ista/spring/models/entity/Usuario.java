package com.ista.spring.models.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


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
	
	
	public Usuario() {
		
	}
	
	public Usuario(long usu_id, String usu_nombre, String usu_apellido, String usu_identificacion, String usu_correo,
			String usu_clave, String usu_rol, String usu_direccion) {
		super();
		this.usu_id = usu_id;
		this.usu_nombre = usu_nombre;
		this.usu_apellido = usu_apellido;
		this.usu_identificacion = usu_identificacion;
		this.usu_correo = usu_correo;
		this.usu_clave = usu_clave;
		this.usu_rol = usu_rol;
		this.usu_direccion = usu_direccion;
	}

	
	//RELACION UNO A MUCHOS CON PEDIDOS
		@JsonIgnore
		@OneToMany(mappedBy = "usuarios")
		private List<Pedido> pedidos;

	

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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}