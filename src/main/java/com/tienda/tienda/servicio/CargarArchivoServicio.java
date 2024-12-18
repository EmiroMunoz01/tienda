package com.tienda.tienda.servicio;

import java.io.*;
import java.nio.file.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CargarArchivoServicio {

    private String carpeta = "imagenes//";

    public String guardarImagen(MultipartFile archivo) throws IOException {
        if (!archivo.isEmpty()) {
            byte[] bytes = archivo.getBytes();
            Path path = Paths.get(carpeta + archivo.getOriginalFilename());
            Files.write(path, bytes);
            return archivo.getOriginalFilename();
        }
        return "default.jpg";
    }

    public void eliminarImagen(String nombre) {
        String ruta = "imagenes//";
        File file = new File(ruta + nombre);
        file.delete();
    }

}
