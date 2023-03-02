package com.ista.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.spring.models.entity.Usuario;
import com.ista.spring.models.services.IUsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins=("http://localhost:4200"))
public class UsuarioRestController {

	@Autowired
	public IUsuarioService usuarioService;
	
	//listar todos
	@GetMapping( "/usuarios")
	public List<Usuario> indext(){
		return usuarioService.findAll();
	}
	
	//buscar
	@GetMapping("/usuarios/{id}")
	public Usuario show(@PathVariable Long id) {
		return usuarioService.findById(id);
	}
	
	//guardar
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}
	
	// editar
	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id ) {
		Usuario usuarioActual = usuarioService.findById(id);
		usuarioActual.setUsu_identificacion(usuario.getUsu_identificacion());
		usuarioActual.setUsu_nombre(usuario.getUsu_nombre());
		usuarioActual.setUsu_direccion(usuario.getUsu_direccion());
		usuarioActual.setUsu_correo(usuario.getUsu_correo());
		usuarioActual.setUsu_clave(usuario.getUsu_clave());
		usuarioActual.setUsu_rol(usuario.getUsu_rol());
		return usuarioService.save(usuarioActual);	
	}
	
	//eliminar
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		usuarioService.delete(id);
	}
}
