package com.ista.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.spring.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long> {

}
