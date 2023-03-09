
package com.ista.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.spring.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}
