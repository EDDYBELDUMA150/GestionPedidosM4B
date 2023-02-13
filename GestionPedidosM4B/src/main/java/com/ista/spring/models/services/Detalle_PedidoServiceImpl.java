package com.ista.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import com.ista.spring.models.dao.IDetalle_PedidoDao;
import com.ista.spring.models.entity.Detalle_Pedido;

@Service
public class Detalle_PedidoServiceImpl implements IDetalle_PedidoService {

	@Autowired
	private IDetalle_PedidoDao Detalle_PedidoDao;
	@Override
	@Transactional (readOnly= true)
	public List<Detalle_Pedido> findAll() {
		// TODO Auto-generated method stub
		return (List<Detalle_Pedido>) Detalle_PedidoDao.findAll();
	}
	@Override
	@Transactional
	public Detalle_Pedido save(Detalle_Pedido Detalle_Pedido) {
		// TODO Auto-generated method stub
		return Detalle_PedidoDao.save(Detalle_Pedido);
	}
	@Override
	@Transactional (readOnly= true)
	public Detalle_Pedido findById(Long id) {
		// TODO Auto-generated method stub
		return Detalle_PedidoDao.findById(id).orElse(null);
	}
	@Override
	
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Detalle_PedidoDao.deleteById(id);
		
	}

}
