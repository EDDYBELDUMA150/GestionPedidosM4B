package com.ista.spring.models.services;

import java.util.List;

import com.ista.spring.models.entity.Detalle_Pedido;


public interface IDetalle_PedidoService {
	public List<Detalle_Pedido> findAll();
	
	public Detalle_Pedido save(Detalle_Pedido Detalle_Pedido);
	
	public Detalle_Pedido findById(Long id);
	
	public void delete(Long id);
	
}
