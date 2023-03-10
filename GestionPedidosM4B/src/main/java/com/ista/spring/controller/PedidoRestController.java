package com.ista.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins=("http://localhost:4200"))
public class PedidoRestController {

	@Autowired
	public IPedidoService pedidoService;
	
	//listar todos
	@GetMapping("/pedido")
	public ResponseEntity<List<Pedido>> list() {
		try {
			return new ResponseEntity<>(pedidoService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	//buscar
	@GetMapping("/pedido/{id}")
	public ResponseEntity<Pedido> search(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(pedidoService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//guardar
	@PostMapping("/pedido")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pedido> create(@RequestBody Pedido pedido) {
		try {
			return new ResponseEntity<>(pedidoService.save(pedido), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	// editar
	@PutMapping("/pedido/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pedido> update(@RequestBody Pedido pedidoRb, @PathVariable("id") Long id) {
		Pedido ped = pedidoService.findById(id);

		if (ped == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
		ped.setPed_descripcion(pedidoRb.getPed_descripcion());
		ped.setPed_direccionenvio(pedidoRb.getPed_direccionenvio());
		ped.setPed_estado(pedidoRb.getPed_estado());
		ped.setPed_fecha(pedidoRb.getPed_fecha());
		return new ResponseEntity<>(pedidoService.save(pedidoRb), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
	
	//eliminar
	@DeleteMapping("/pedido/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		try {
			pedidoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar el Registro");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
