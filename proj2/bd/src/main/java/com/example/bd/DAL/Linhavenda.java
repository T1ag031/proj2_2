package com.example.bd.DAL;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@IdClass(LinhavendaPK.class)
public class Linhavenda {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numvenda", nullable = false)
    private int numvenda;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpeca", nullable = false)
    private int idpeca;
    @Basic
    @Column(name = "precounid", nullable = false, precision = 2)
    private BigDecimal precounid;
    @Basic
    @Column(name = "qtd", nullable = false)
    private int qtd;
    @ManyToOne
    @JoinColumn(name = "numvenda", referencedColumnName = "numvenda", nullable = false, insertable = false, updatable = false)
    private Venda vendaByNumvenda;
    @ManyToOne
    @JoinColumn(name = "idpeca", referencedColumnName = "idpeca", nullable = false, insertable = false, updatable = false)
    private Peca pecaByIdpeca;

    public int getNumvenda() {
        return numvenda;
    }

    public void setNumvenda(int numvenda) {
        this.numvenda = numvenda;
    }

    public int getIdpeca() {
        return idpeca;
    }

    public void setIdpeca(int idpeca) {
        this.idpeca = idpeca;
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

        Linhavenda that = (Linhavenda) o;

        if (numvenda != that.numvenda) return false;
        if (idpeca != that.idpeca) return false;
        if (qtd != that.qtd) return false;
        if (precounid != null ? !precounid.equals(that.precounid) : that.precounid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numvenda;
        result = 31 * result + idpeca;
        result = 31 * result + (precounid != null ? precounid.hashCode() : 0);
        result = 31 * result + qtd;
        return result;
    }

    public Venda getVendaByNumvenda() {
        return vendaByNumvenda;
    }

    public void setVendaByNumvenda(Venda vendaByNumvenda) {
        this.vendaByNumvenda = vendaByNumvenda;
    }

    public Peca getPecaByIdpeca() {
        return pecaByIdpeca;
    }

    public void setPecaByIdpeca(Peca pecaByIdpeca) {
        this.pecaByIdpeca = pecaByIdpeca;
    }
}
