package com.tienda.tienda.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tienda.tienda.modelo.Producto;
import com.tienda.tienda.repositorio.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(Integer id) {
        return productoRepositorio.findById(id);

    }

    @Override
    public void actualizarProducto(Producto producto) {
        productoRepositorio.save(producto);

    }

    @Override
    public void eliminarProducto(Integer id) {
        productoRepositorio.deleteById(id);
    }

    @Override
    public List<Producto> mostrarProductos() {
        return productoRepositorio.findAll();
    }


}
