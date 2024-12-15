package com.tienda.tienda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.tienda.modelo.Producto;


//para poder inyectar esto en el servicio debemos usar la anotacion de repositorio, para que se entienda que sera un artefacto de spring que lo inyectarla hacia donde necesitemos usarlo
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

}
