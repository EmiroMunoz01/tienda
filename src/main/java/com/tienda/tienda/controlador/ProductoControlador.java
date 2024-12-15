package com.tienda.tienda.controlador;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.tienda.modelo.Producto;
import com.tienda.tienda.modelo.Usuario;
import com.tienda.tienda.servicio.ProductoServicio;

@Controller
@RequestMapping("/productos")

public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

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
    public String guardar(Producto producto) {
        LOGGER.info("Este es el objeto producto de la vista {}", producto);

        Usuario u = new Usuario(1, "", "", "", "", "", "", "");
        producto.setUsuario(u);

        productoServicio.guardarProducto(producto);
        return "redirect:/productos";
    }

}