package com.ista.spring.models.services;

import java.util.List;

import com.ista.spring.models.entity.Pedido;


public interface IPedidoService {
	public List<Pedido> findAll();
	
	public Pedido save(Pedido Pedido);
	
	public Pedido findById(Long id);
	
	public void delete(Long id);
	
}
