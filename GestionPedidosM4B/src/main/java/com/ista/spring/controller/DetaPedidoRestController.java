package com.ista.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.spring.models.entity.Detalle_Pedido;
import com.ista.spring.models.services.IDetalle_PedidoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins=("http://localhost:4200"))
public class DetaPedidoRestController {

	@Autowired
	public IDetalle_PedidoService detalleService;
	
	//listar todos
	@GetMapping("/detalle/list")
	public ResponseEntity<List<Detalle_Pedido>> list() {
		try {
			return new ResponseEntity<>(detalleService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	//buscar
	@GetMapping("/detalle/search/{id}")
	public ResponseEntity<Detalle_Pedido> search(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(detalleService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//guardar
	@PostMapping("/detalle/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Detalle_Pedido> create(@RequestBody Detalle_Pedido detalle) {
		try {
			return new ResponseEntity<>(detalleService.save(detalle), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	// editar
	@PutMapping("/detalle/update/{id}")
	public ResponseEntity<Detalle_Pedido> update(@RequestBody Detalle_Pedido detalleRb, @PathVariable("id") Long id) {
		Detalle_Pedido det = detalleService.findById(id);

		if (det == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				det.setDeta_cantidad(detalleRb.getDeta_cantidad());
				
				det.setDeta_precio_total(detalleRb.getDeta_precio_total());
		return new ResponseEntity<>(detalleService.save(detalleRb), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
	
	//eliminar
	@DeleteMapping("/detalle/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		try {
			detalleService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar el Registro");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
