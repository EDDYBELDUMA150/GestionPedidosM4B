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
	private long id;
	
	private String usu_nombre;
	private String usu_identificacion;
	private String usu_correo;
	private String usu_clave;
	private String rol;
	private String direccion;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
