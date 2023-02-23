package com.ista.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.spring.models.entity.Detalle_Pedido;
import com.ista.spring.models.services.IDetalle_PedidoService;

@RestController
@RequestMapping("/api")
public class DetaPedidoRestController {

	@Autowired
	public IDetalle_PedidoService detalleService;
	
	//listar todos
	@GetMapping( "/detalle_pedido")
	public List<Detalle_Pedido> indext(){
		return detalleService.findAll();
	}
	
	//buscar
	@GetMapping("/detalle_pedido/{id}")
	public Detalle_Pedido show(@PathVariable Long id) {
		return detalleService.findById(id);
	}
	
	//guardar
	@PostMapping("/detalle_pedido")
	@ResponseStatus(HttpStatus.CREATED)
	public Detalle_Pedido create(@RequestBody Detalle_Pedido detallepedido) {
		return detalleService.save(detallepedido);
	}
	
	// editar
	@PutMapping("/detalle_pedido/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Detalle_Pedido update(@RequestBody Detalle_Pedido detallepedido, @PathVariable Long id ) {
		Detalle_Pedido detalleActual = detalleService.findById(id);
		detalleActual.setDeta_cantidad(detallepedido.getDeta_cantidad());
		detalleActual.setDeta_descripcion(detallepedido.getDeta_descripcion());
		detalleActual.setDeta_precio_total(detallepedido.getDeta_precio_total());
		return detalleService.save(detalleActual);	
	}
	
	//eliminar
	@DeleteMapping("/detalle_pedido/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		detalleService.delete(id);
	}
}
