package com.ista.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.spring.models.dao.IProductoDao;
import com.ista.spring.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductosService{

	@Autowired
	private IProductoDao prodDao;
	
	@Override
	public List<Producto> findAll() {
		return (List<Producto>) prodDao.findAll();
	}

	@Override
	public Producto save(Producto producto) {
		return prodDao.save(producto);
	}

	@Override
	public Producto findById(Long id) {
		return prodDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		prodDao.deleteById(id);
	}

}
