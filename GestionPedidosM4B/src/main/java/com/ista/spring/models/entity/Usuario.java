package com.ista.spring.models.entity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String usu_identificacion;
	private String usu_correo;
	private String usu_clave;
	private String usu_rol;
	private String usu_direccion;
	
	

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
	
}
