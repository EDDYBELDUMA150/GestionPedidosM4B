package com.ista.spring.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@PostMapping("/producto/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		
		Producto producto = productoService.findById(id);
		
		if(!archivo.isEmpty()) {
			String nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
			//log.info(rutaArchivo.toString());
			
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			}catch (IOException e){
				response.put("mensaje", "Error al subir la imagen del producto"+ nombreArchivo);
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nombreFotoAnterior = producto.getProd_img();
			
			if(nombreFotoAnterior !=null && nombreFotoAnterior.length()>0) {
				Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
				File archivoFotoAnterior = rutaFotoAnterior.toFile();
				if(archivoFotoAnterior.exists()&& archivoFotoAnterior.canRead()) {
					archivoFotoAnterior.delete();
				}
				
			}
			producto.setProd_img(nombreArchivo);
			productoService.save(producto);
			
			response.put("producto", producto);
			response.put("mensaje", "Has subido correctamente la imagen: "+ nombreArchivo);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	// ver foto
	
	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
		
		Path rutaArchivo = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
		
		Resource recurso = null;
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		}catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		if(!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error no se pudo cargar la imagen: "+nombreFoto);
		}
		return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; nombreFoto=\"" +recurso.getFilename()+"\"")
                .body(recurso);
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
