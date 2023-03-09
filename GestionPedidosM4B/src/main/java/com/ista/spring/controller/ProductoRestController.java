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

import com.ista.spring.models.entity.Producto;
import com.ista.spring.models.services.IProductosService;

@CrossOrigin(origins=("http://localhost:4200"))
@RestController
@RequestMapping("/api")
public class ProductoRestController {

	@Autowired
	public IProductosService productoService;
	
	//listar todos
	@GetMapping("/producto")
	public ResponseEntity<List<Producto>> list() {
		try {
			return new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	//buscar
	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> search(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<>(productoService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//guardar
	@PostMapping("/producto")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Producto> create(@RequestBody Producto producto) {
		try {
			return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	// editar
	@PutMapping("/producto/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Producto> update(@RequestBody Producto productoRb, @PathVariable("id") Long id) {
		Producto pro = productoService.findById(id);

		if (pro == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				pro.setProd_codigo(productoRb.getProd_codigo());
				pro.setProd_nombre(productoRb.getProd_nombre());
				pro.setProd_descripcion(productoRb.getProd_descripcion());
				pro.setProd_preciounitario(productoRb.getProd_preciounitario());
				pro.setProd_tipo(productoRb.getProd_tipo());
				pro.setStock(productoRb.getStock());
		return new ResponseEntity<>(productoService.save(productoRb), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
	
	//eliminar
	@DeleteMapping("/producto/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		try {
			productoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar el Registro");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
