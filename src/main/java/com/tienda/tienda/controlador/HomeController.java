package com.tienda.tienda.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.tienda.servicio.ProductoServicio;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("productos", productoServicio.mostrarProductos());
        return "usuario/home";
    }



}