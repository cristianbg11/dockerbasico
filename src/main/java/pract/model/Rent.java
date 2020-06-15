package pract.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
public class Rent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate fechaRealizado;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Custom cliente;
    private LocalDate fechaEntrega;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Equip.class)
    @JoinTable(name = "alquiler_equipos", joinColumns = {@JoinColumn(name = "alquiler_id")}, inverseJoinColumns = {@JoinColumn(name = "equipo_id")})
    private Equip equipo;
    private double total;

    public Rent() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFechaRealizado() {
        return fechaRealizado;
    }

    public void setFechaRealizado(LocalDate fechaRealizado) {
        this.fechaRealizado = fechaRealizado;
    }

    public Custom getCliente() {
        return cliente;
    }

    public void setCliente(Custom cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Equip getEquipo() {
        return equipo;
    }

    public void setEquipo(Equip equipo) {
        this.equipo = equipo;
    }

    public double getTotal() {
        return equipo.getCostoAlquilerPorDia();
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
