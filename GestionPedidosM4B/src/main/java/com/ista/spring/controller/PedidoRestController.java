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

import com.ista.spring.models.entity.Pedido;
import com.ista.spring.models.services.IPedidoService;

@RestController
@RequestMapping("/api")
public class PedidoRestController {

	@Autowired
	public IPedidoService pedidoService;
	
	//listar todos
	@GetMapping( "/pedidos")
	public List<Pedido> indext(){
		return pedidoService.findAll();
	}
	
	//buscar
	@GetMapping("/pedidos/{id}")
	public Pedido show(@PathVariable Long id) {
		return pedidoService.findById(id);
	}
	
	//guardar
	@PostMapping("/pedidos")
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido create(@RequestBody Pedido pedido) {
		return pedidoService.save(pedido);
	}
	
	// editar
	@PutMapping("/pedidos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido update(@RequestBody Pedido pedido, @PathVariable Long id ) {
		Pedido pedidoActual = pedidoService.findById(id);
		pedidoActual.setPed_descripcion(pedido.getPed_descripcion());
		pedidoActual.setPed_direccionenvio(pedido.getPed_direccionenvio());
		pedidoActual.setPed_estado(pedido.getPed_estado());
		pedidoActual.setPed_fecha(pedido.getPed_fecha());
		return pedidoService.save(pedidoActual);	
	}
	
	//eliminar
	@DeleteMapping("/pedidos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		pedidoService.delete(id);
	}
}
