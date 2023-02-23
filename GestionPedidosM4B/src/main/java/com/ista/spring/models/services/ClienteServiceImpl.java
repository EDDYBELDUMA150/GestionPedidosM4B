package com.ista.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.spring.models.dao.IClienteDao;
import com.ista.spring.models.entity.Cliente;
@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao cliDao;
	
	@Override
	@Transactional(readOnly= true)
	public List<Cliente> findAll() {
		return (List<Cliente>) cliDao.findAll();
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return cliDao.save(cliente);
	}

	@Override
	@Transactional(readOnly= true)
	public Cliente findById(Long id) {
		return cliDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		cliDao.deleteById(id);
	}

}
