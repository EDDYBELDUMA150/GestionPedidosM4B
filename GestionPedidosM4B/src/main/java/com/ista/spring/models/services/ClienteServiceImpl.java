package com.ista.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ista.spring.models.dao.IClienteDao;
import com.ista.spring.models.entity.Cliente;

public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao cliDao;
	
	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) cliDao.findAll();
	}

	@Override
	public Cliente save(Cliente cliente) {
		return cliDao.save(cliente);
	}

	@Override
	public Cliente findById(Long id) {
		return cliDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		cliDao.deleteById(id);
	}

}
