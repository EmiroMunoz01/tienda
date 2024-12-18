package com.tienda.tienda.controlador;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tienda.tienda.servicio.ProductoServicio;

@Controller
@RequestMapping("/")
public class HomeController {

    // crearemos la variable logger para saber que sucede dentro de la variable

    private final Logger log = org.slf4j.LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("productos", productoServicio.mostrarProductos());
        return "usuario/home";
    }

    // buscaremos el id del producto y lo enviaremos a otra vista con la informacion
    // del producto

    @GetMapping("productohome/{id}")
    public String productoHome(
            @PathVariable Integer id) {
        log.info("Id enviado como parametro {}", id);
        return "usuario/productohome";
    }

}
