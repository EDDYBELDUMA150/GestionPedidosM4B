package com.ista.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.spring.models.entity.Usuario;



public interface IUsuarioDao extends CrudRepository<Usuario,Long>{

}
