package com.tienda.tienda.controlador;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tienda.tienda.modelo.Producto;
import com.tienda.tienda.modelo.Usuario;
import com.tienda.tienda.servicio.CargarArchivoServicio;
import com.tienda.tienda.servicio.ProductoServicio;

@Controller
@RequestMapping("/productos")

public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private CargarArchivoServicio cargarArchivoServicio;

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoControlador.class);

    @GetMapping("")
    public String mostrarTodo(Model model) {
        model.addAttribute("productos", productoServicio.mostrarProductos());
        return "productos/mostrar";
    }

    @GetMapping("/crear")
    public String crear() {
        return "productos/crear";
    }

    @PostMapping("/guardar")
    public String guardar(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        LOGGER.info("Este es el objeto producto de la vista {}", producto);

        Usuario u = new Usuario(1, "", "", "", "", "", "", "");
        producto.setUsuario(u);

        // imagen
        if (producto.getId() == null) {
            // cuando se crea un producto
            String nombreImagen = cargarArchivoServicio.guardarImagen(file);
            producto.setImagen(nombreImagen);
        } else {

        }

        productoServicio.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Producto producto = new Producto();
        // es lo que nos devuelve cuando nos retorna la busqueda de un objeto de tipo
        // producto
        Optional<Producto> optionalProducto = productoServicio.obtenerProductoPorId(id);
        producto = optionalProducto.get();

        LOGGER.info("Producto buscado: {}", producto);
        model.addAttribute("producto", producto);
        return "productos/editar";
    }

    @PostMapping("/actualizar")
    public String actualizar(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            // cuando editamos el producto pero no cambiamos la imagen
            Producto p = new Producto();
            p = productoServicio.obtenerProductoPorId(producto.getId()).get();
            producto.setImagen(p.getImagen());
        } else {//
            // cambio de imagen cuando editamos el producto

            Producto p = new Producto();
            p = productoServicio.obtenerProductoPorId(producto.getId()).get();

            // eliminar cuando no sea la imagen por defecto
            if (!p.getImagen().equals("default.jpg")) {
                cargarArchivoServicio.eliminarImagen(p.getNombre());
            }
            String nombreImagen = cargarArchivoServicio.guardarImagen(file);
            producto.setImagen(nombreImagen);
        }

        productoServicio.actualizarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        Producto p = new Producto();
        p = productoServicio.obtenerProductoPorId(id).get();

        // eliminar cuando no sea la imagen por defecto
        if (!p.getImagen().equals("default.jpg")) {
            cargarArchivoServicio.eliminarImagen(p.getNombre());
        }

        productoServicio.eliminarProducto(id);

        return "redirect:/productos";
    }

}
