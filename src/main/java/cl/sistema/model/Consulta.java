package cl.sistema.model;


import cl.sistema.entity.BaseEntity;

import javax.persistence.*;

/**
 * Created by rodo on 13-05-17.
 */
@Entity
@Table (name = "consulta")
public class Consulta extends BaseEntity{

    @Column (name = "rut_cliente")
    private int rut_cliente;
    @Column (name = "fecha")
    private int fecha;

    @ManyToOne
    @JoinColumn (name = "rut_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    public Consulta() {
    }

    public int getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(int rut_cliente) {
        this.rut_cliente = rut_cliente;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
