package com.tienda.tienda.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Data

@Entity
@Table(name = "usuario")

public class Usuario {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String nombreusuario;
    private String email;
    private String direccion;
    private String telefono;
    private String tipousuario;
    private String clave;


    


    // 1 le diremos que en algun momento queremos obtener una lista de productos
    // crearemos la anotacion con JPA, le diremos que es una relacion de 1 a muchos,
    //3 y que estara mapeada con el capo de usuario, tambien tendremos que mapearlo con JPA



    
    public Usuario(Integer id, String nombre, String nombreusuario, String email, String direccion, String telefono,
            String tipousuario, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.nombreusuario = nombreusuario;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipousuario = tipousuario;
        this.clave = clave;
    }


    public Usuario() {
    }


    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos;

    //8 de la misma forma que podemos obtener una lsita de productos, generaremos una lista de ordenes, y se mapaera de uno a muchos, es decir que un usuario puede tener muchas ordenes, y le diremos que se va a mapear por el campo usuario

    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenes;

}
