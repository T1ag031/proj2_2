package com.example.bd.DAL;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Encomenda {
    @Id
    @SequenceGenerator(name="encomenda_numencomenda_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="encomenda_numencomenda_seq")
    @Column(name = "numencomenda", nullable = false)
    private int numencomenda;
    @Basic
    @Column(name = "data", nullable = false)
    private Date data;
    @Basic
    @Column(name = "valortotal", nullable = false, precision = 2)
    private BigDecimal valortotal;
    @Basic
    @Column(name = "codfornecedor", nullable = true)
    private Integer codfornecedor;
    @Basic
    @Column(name = "est", nullable = false, length = 20)
    private String est;
    @ManyToOne
    @JoinColumn(name = "codfornecedor", referencedColumnName = "codfornecedor", nullable = false, insertable = false, updatable = false)
    private Fornecedor fornecedorByCodfornecedor;
    @ManyToOne
    @JoinColumn(name = "est", referencedColumnName = "estado", nullable = false, insertable = false, updatable = false)
    private Estadoencomenda estadoencomendaByEst;
    @OneToMany(mappedBy = "encomendaByNumenc")
    private Collection<Linhaencomenda> linhaencomendasByNumencomenda;

    public int getNumencomenda() {
        return numencomenda;
    }

    public void setNumencomenda(int numencomenda) {
        this.numencomenda = numencomenda;
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

    public Integer getCodfornecedor() {
        return codfornecedor;
    }

    public void setCodfornecedor(Integer codfornecedor) {
        this.codfornecedor = codfornecedor;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Encomenda encomenda = (Encomenda) o;

        if (numencomenda != encomenda.numencomenda) return false;
        if (data != null ? !data.equals(encomenda.data) : encomenda.data != null) return false;
        if (valortotal != null ? !valortotal.equals(encomenda.valortotal) : encomenda.valortotal != null) return false;
        if (codfornecedor != null ? !codfornecedor.equals(encomenda.codfornecedor) : encomenda.codfornecedor != null)
            return false;
        if (est != null ? !est.equals(encomenda.est) : encomenda.est != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numencomenda;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (valortotal != null ? valortotal.hashCode() : 0);
        result = 31 * result + (codfornecedor != null ? codfornecedor.hashCode() : 0);
        result = 31 * result + (est != null ? est.hashCode() : 0);
        return result;
    }

    public Fornecedor getFornecedorByCodfornecedor() {
        return fornecedorByCodfornecedor;
    }

    public void setFornecedorByCodfornecedor(Fornecedor fornecedorByCodfornecedor) {
        this.fornecedorByCodfornecedor = fornecedorByCodfornecedor;
    }

    public Estadoencomenda getEstadoencomendaByEst() {
        return estadoencomendaByEst;
    }

    public void setEstadoencomendaByEst(Estadoencomenda estadoencomendaByEst) {
        this.estadoencomendaByEst = estadoencomendaByEst;
    }

    public Collection<Linhaencomenda> getLinhaencomendasByNumencomenda() {
        return linhaencomendasByNumencomenda;
    }

    public void setLinhaencomendasByNumencomenda(Collection<Linhaencomenda> linhaencomendasByNumencomenda) {
        this.linhaencomendasByNumencomenda = linhaencomendasByNumencomenda;
    }
}
