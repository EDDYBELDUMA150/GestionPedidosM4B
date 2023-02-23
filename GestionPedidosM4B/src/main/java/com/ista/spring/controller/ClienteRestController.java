package com.ista.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.spring.models.entity.Cliente;
import com.ista.spring.models.services.IClienteService;

@RestController
@RequestMapping("/apitfc")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	
	//LISTAR TODOS LOS CLIENTES
	@GetMapping("/CLIENTES")
	public List<Cliente>indext(){
		return clienteService.findAll();
	}
	
	
	//LISTAR CLIENTE POR ID
	@GetMapping("/CLIENTES/{id}")
	public Cliente show(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	
	
	//CREAR CLIENTE
		@PostMapping("/CLIENTES")
		@ResponseStatus(HttpStatus.CREATED)
		public Cliente create(@RequestBody Cliente cliente) {
			return clienteService.save(cliente);
		}
		
		
		
		
	//EDITAR CLIENTE
		@PutMapping("/CLIENTES/{id}")
		@ResponseStatus(HttpStatus.CREATED)
		public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
			Cliente clienteActual=clienteService.findById(id);
			clienteActual.setCli_apellidos(cliente.getCli_apellidos());
			clienteActual.setCli_clave(cliente.getCli_clave());
			clienteActual.setCli_correo(cliente.getCli_correo());
			clienteActual.setCli_identificacion(cliente.getCli_identificacion());
			clienteActual.setCli_nombres(cliente.getCli_nombres());
			clienteActual.setCli_telefono(cliente.getCli_telefono());
			return clienteService.save(clienteActual);
		}
		
		
		
	//ELIMINAR UN CLIENTE
		@DeleteMapping("/CLIENTES/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			clienteService.delete(id);
		}
		
	
	
}
