package com.tienda.tienda.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
// 6 colocaremos los mismos atributos para mapearla como una entidad, de acuerdo a nuestro diagrama un usuario puede tener una o varias ordenes, aqui haremos lo mismo que con producto
@Entity
@Table(name = "ordenes")

public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;
    private double total;

    //7 crearemos el atributo que nos permita identificar que usuario esta registrado con una orden

    @ManyToOne
    private Usuario usuario;
    //9 crearemos la relacion entre la orden y el detalle, se mapeara uno a uno. Ahora iremos a detalle Orden

    @OneToOne(mappedBy = "orden")
    private DetalleOrden detalle;
}
