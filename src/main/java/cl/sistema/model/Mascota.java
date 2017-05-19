package cl.sistema.model;

import cl.sistema.entity.BaseEntity;

import javax.persistence.*;

/**
 * Created by rodo on 07-05-17.
 */
@Entity
@Table (name = "mascota")
public class Mascota extends BaseEntity {

    @Column (name = "nombre")
    private String nombre;
    @Column (name = "rut")
    private int rut;

    public Mascota() {
    }

    @ManyToOne
    @JoinColumn (name = "rut", insertable = false, updatable = false)
    private Cliente cliente;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }
}
