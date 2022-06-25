package com.example.bd.DAL;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Estadoencomenda {
    @Basic
    @Column(name = "idestado", nullable = false)
    private int idestado;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;
    @OneToMany(mappedBy = "estadoencomendaByEst")
    private Collection<Encomenda> encomendasByEstado;

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estadoencomenda that = (Estadoencomenda) o;

        if (idestado != that.idestado) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idestado;
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    public Collection<Encomenda> getEncomendasByEstado() {
        return encomendasByEstado;
    }

    public void setEncomendasByEstado(Collection<Encomenda> encomendasByEstado) {
        this.encomendasByEstado = encomendasByEstado;
    }
}
