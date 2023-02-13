package com.ista.spring.models.services;

import java.util.List;

import com.ista.spring.models.entity.Producto;

public interface IProductosService {
public List<Producto> findAll();
	
	public Producto save(Producto producto);
	
	public Producto findById(Long id);
	
	public void delete(Long id);
	
}
