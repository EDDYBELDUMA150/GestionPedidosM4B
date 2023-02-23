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

import com.ista.spring.models.entity.Producto;
import com.ista.spring.models.services.IProductosService;

@RestController
@RequestMapping("/api")
public class ProductoRestController {

	@Autowired
	public IProductosService productoService;
	
	//listar todos
	@GetMapping( "/productos")
	public List<Producto> indext(){
		return productoService.findAll();
	}
	
	//buscar
	@GetMapping("/productos/{id}")
	public Producto show(@PathVariable Long id) {
		return productoService.findById(id);
	}
	
	//guardar
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		return productoService.save(producto);
	}
	
	// editar
	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto, @PathVariable Long id ) {
		Producto productoActual = productoService.findById(id);
		productoActual.setProd_nombre(producto.getProd_nombre());
		productoActual.setProd_descripcion(producto.getProd_descripcion());
		productoActual.setProd_preciounitario(producto.getProd_preciounitario());
		productoActual.setProd_tipo(producto.getProd_tipo());
		return productoService.save(productoActual);	
	}
	
	//eliminar
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productoService.delete(id);
	}
}
