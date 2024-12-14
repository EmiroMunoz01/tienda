package com.tienda.tienda.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private double precio;
    private int cantidad;

    // 2 relacionaremos este campo con la tabla de usuarios

    // 4 le diremos que este campo tiene una relacion con el campo usuario de muchos a uno, lo que hara internamente el framework es crear un campo en la tabla productos para enviar el id del usuario y que se mapee directamente en la clase en el atributo usuario que se ha declarado en esta clase

    // 5 de esta forma ya tenemos mapeada la entidad de Usuario y Producto, asi sabremos de que usuario es un producto y tambien ver cuantos productos son de un usuario al crear la lista que tenemos en la clase de Usuario con la declaracion de la lista
    @ManyToOne
    private Usuario usuario;

}
