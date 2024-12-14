package com.tienda.tienda.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Usuario {

    private Integer id;
    private String nombre;
    private String nombreUsuario;
    private String email;
    private String direccion;
    private String telefono;
    private String tipoUsuario;
    private String clave;

}
