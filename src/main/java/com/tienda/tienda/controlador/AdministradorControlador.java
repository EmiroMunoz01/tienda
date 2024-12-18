package com.tienda.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.tienda.modelo.Producto;
import com.tienda.tienda.servicio.ProductoServicio;

@Controller
@RequestMapping("/administrador")
public class AdministradorControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("")
    public String home(Model model) {
        
        List <Producto> productos = productoServicio.mostrarProductos();
        model.addAttribute("productos", productos);
        
        return "administrador/home";
    }

}
