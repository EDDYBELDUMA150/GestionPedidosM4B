package com.ista.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import com.ista.spring.models.dao.IPedidoDao;
import com.ista.spring.models.entity.Pedido;

@Service
public class PedidoServiceImpl implements IPedidoService {

	@Autowired
	private IPedidoDao PedidoDao;
	@Override
	@Transactional (readOnly= true)
	public List<Pedido> findAll() {
		// TODO Auto-generated method stub
		return (List<Pedido>) PedidoDao.findAll();
	}
	@Override
	@Transactional
	public Pedido save(Pedido Pedido) {
		// TODO Auto-generated method stub
		return PedidoDao.save(Pedido);
	}
	@Override
	@Transactional (readOnly= true)
	public Pedido findById(Long id) {
		// TODO Auto-generated method stub
		return PedidoDao.findById(id).orElse(null);
	}
	@Override
	
	public void delete(Long id) {
		// TODO Auto-generated method stub
		PedidoDao.deleteById(id);
		
	}

}
