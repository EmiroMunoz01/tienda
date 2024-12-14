package com.tienda.tienda.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

// 10 indicaremos que es una entidad y que su id sera autoincremental
@Entity
@Table(name = "detalles")

public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // 11 crearemos un atributo de tipo Orden, le diremos que es una relacion de uno
    // a uno, tambien crearemos un atributo de tipo producto, ya que
    @OneToOne
    private Orden orden;

    // 12 hacemos la relacion con producto, pero esto no lo colocamos en Producto, porque no necesita saber el detalle de la Orden
    @OneToOne
    private Producto producto;

    private Integer id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;

}
