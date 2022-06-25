package com.example.bd.DAL;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@IdClass(LinhaencomendaPK.class)
public class Linhaencomenda {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numenc", nullable = false)
    private int numenc;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idtecido", nullable = false)
    private int idtecido;
    @Basic
    @Column(name = "precounid", nullable = false, precision = 2)
    private BigDecimal precounid;
    @Basic
    @Column(name = "qtd", nullable = false)
    private int qtd;
    @ManyToOne
    @JoinColumn(name = "numenc", referencedColumnName = "numencomenda", nullable = false, insertable = false, updatable = false)
    private Encomenda encomendaByNumenc;
    @ManyToOne
    @JoinColumn(name = "idtecido", referencedColumnName = "idtecido", nullable = false, insertable = false, updatable = false)
    private Tecido tecidoByIdtecido;

    public int getNumenc() {
        return numenc;
    }

    public void setNumenc(int numenc) {
        this.numenc = numenc;
    }

    public int getIdtecido() {
        return idtecido;
    }

    public void setIdtecido(int idtecido) {
        this.idtecido = idtecido;
    }

    public BigDecimal getPrecounid() {
        return precounid;
    }

    public void setPrecounid(BigDecimal precounid) {
        this.precounid = precounid;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Linhaencomenda that = (Linhaencomenda) o;

        if (numenc != that.numenc) return false;
        if (idtecido != that.idtecido) return false;
        if (qtd != that.qtd) return false;
        if (precounid != null ? !precounid.equals(that.precounid) : that.precounid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numenc;
        result = 31 * result + idtecido;
        result = 31 * result + (precounid != null ? precounid.hashCode() : 0);
        result = 31 * result + qtd;
        return result;
    }

    public Encomenda getEncomendaByNumenc() {
        return encomendaByNumenc;
    }

    public void setEncomendaByNumenc(Encomenda encomendaByNumenc) {
        this.encomendaByNumenc = encomendaByNumenc;
    }

    public Tecido getTecidoByIdtecido() {
        return tecidoByIdtecido;
    }

    public void setTecidoByIdtecido(Tecido tecidoByIdtecido) {
        this.tecidoByIdtecido = tecidoByIdtecido;
    }
}
