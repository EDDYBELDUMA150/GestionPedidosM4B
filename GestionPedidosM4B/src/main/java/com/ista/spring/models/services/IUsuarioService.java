package com.ista.spring.models.services;

import java.util.List;

import com.ista.spring.models.entity.Usuario;


public interface IUsuarioService {
	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario);
	
	public Usuario findById(Long id);
	
	public void delete(Long id);
	
	public Usuario findByUserPass(String user, String pass);
}
