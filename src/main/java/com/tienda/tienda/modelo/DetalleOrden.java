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

public class DetalleOrden {

    private Integer id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;

}
