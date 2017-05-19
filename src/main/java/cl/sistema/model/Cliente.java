package cl.sistema.model;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import javax.persistence.*;
import java.util.*;

/**
 * Created by rodo on 07-05-17.
 */
@Entity
@Table (name = "cliente")
public class Cliente {

    @Id
    @Column (name = "rut")
    private int rut;
    @Column (name = "nombre")
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Set<Mascota> mascotas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Set<Consulta> consultas;

    public Cliente() {
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // comentario

}

