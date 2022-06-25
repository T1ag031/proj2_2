package com.example.bd.DAL;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Venda {

    @Id
    @SequenceGenerator(name="venda_numvenda_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="venda_numvenda_seq")
    @Column(name = "numvenda", nullable = false)
    private int numvenda;
    @Basic
    @Column(name = "data", nullable = false)
    private Date data;
    @Basic
    @Column(name = "valortotal", nullable = false, precision = 2)
    private BigDecimal valortotal;
    @Basic
    @Column(name = "codcliente", nullable = false)
    private int codcliente;
    @OneToMany(mappedBy = "vendaByNumvenda")
    private Collection<Linhavenda> linhavendasByNumvenda;
    @ManyToOne
    @JoinColumn(name = "codcliente", referencedColumnName = "codcliente",nullable = false, insertable = false, updatable = false)
    private Cliente clienteByCodcliente;

    public int getNumvenda() {
        return numvenda;
    }

    public void setNumvenda(int numvenda) {
        this.numvenda = numvenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venda venda = (Venda) o;

        if (numvenda != venda.numvenda) return false;
        if (codcliente != venda.codcliente) return false;
        if (data != null ? !data.equals(venda.data) : venda.data != null) return false;
        if (valortotal != null ? !valortotal.equals(venda.valortotal) : venda.valortotal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numvenda;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (valortotal != null ? valortotal.hashCode() : 0);
        result = 31 * result + codcliente;
        return result;
    }

    public Collection<Linhavenda> getLinhavendasByNumvenda() {
        return linhavendasByNumvenda;
    }

    public void setLinhavendasByNumvenda(Collection<Linhavenda> linhavendasByNumvenda) {
        this.linhavendasByNumvenda = linhavendasByNumvenda;
    }

    public Cliente getClienteByCodcliente() {
        return clienteByCodcliente;
    }

    public void setClienteByCodcliente(Cliente clienteByCodcliente) {
        this.clienteByCodcliente = clienteByCodcliente;
    }
}
