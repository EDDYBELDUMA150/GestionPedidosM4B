package com.ista.spring.models.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cli_id;
	
	private String cli_identificacion;
	private String cli_nombres;
	private String cli_apellidos;
	private String cli_correo;
	private String cli_clave;
	private String cli_telefono;
	
	public long getCli_id() {
		return cli_id;
	}
	public void setCli_id(long cli_id) {
		this.cli_id = cli_id;
	}
	public String getCli_identificacion() {
		return cli_identificacion;
	}
	public void setCli_identificacion(String cli_identificacion) {
		this.cli_identificacion = cli_identificacion;
	}
	public String getCli_nombres() {
		return cli_nombres;
	}
	public void setCli_nombres(String cli_nombres) {
		this.cli_nombres = cli_nombres;
	}
	public String getCli_apellidos() {
		return cli_apellidos;
	}
	public void setCli_apellidos(String cli_apellidos) {
		this.cli_apellidos = cli_apellidos;
	}
	public String getCli_correo() {
		return cli_correo;
	}
	public void setCli_correo(String cli_correo) {
		this.cli_correo = cli_correo;
	}
	public String getCli_clave() {
		return cli_clave;
	}
	public void setCli_clave(String cli_clave) {
		this.cli_clave = cli_clave;
	}
	public String getCli_telefono() {
		return cli_telefono;
	}
	public void setCli_telefono(String cli_telefono) {
		this.cli_telefono = cli_telefono;
	}
	
	
	
}