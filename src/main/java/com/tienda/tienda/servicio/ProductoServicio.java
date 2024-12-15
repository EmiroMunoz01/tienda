package com.tienda.tienda.servicio;

import java.util.List;
import java.util.Optional;

import com.tienda.tienda.modelo.Producto;

//aqui definiremos todos los metodos crud para nuestra clase producto
public interface ProductoServicio {

    public Producto guardarProducto(Producto producto);
    //se hace optional para saber si el producto existe o no, para asi determinar su estado
    public Optional <Producto> obtenerProductoPorId(Integer id);
    public void actualizarProducto(Producto producto);
    public void eliminarProducto(Integer id);
    public List<Producto> mostrarProductos();
    

}
