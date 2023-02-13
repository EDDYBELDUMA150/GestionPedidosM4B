package com.ista.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import com.ista.spring.models.dao.IUsuarioDao;
import com.ista.spring.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao UsuarioDao;
	@Override
	@Transactional (readOnly= true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) UsuarioDao.findAll();
	}
	@Override
	@Transactional
	public Usuario save(Usuario Usuario) {
		// TODO Auto-generated method stub
		return UsuarioDao.save(Usuario);
	}
	@Override
	@Transactional (readOnly= true)
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return UsuarioDao.findById(id).orElse(null);
	}
	@Override
	
	public void delete(Long id) {
		// TODO Auto-generated method stub
		UsuarioDao.deleteById(id);
		
	}

}
