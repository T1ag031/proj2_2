package com.example.bd.DAL;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Tecido {
    @Id
    @SequenceGenerator(name="tecido_idtecido_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tecido_idtecido_seq")
    @Column(name = "idtecido", nullable = false)
    private int idtecido;
    @Basic
    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;
    @Basic
    @Column(name = "codfornecedor", nullable = false)
    private int codfornecedor;
    @OneToMany(mappedBy = "tecidoByIdtecido")
    private Collection<Linhaencomenda> linhaencomendasByIdtecido;
    @ManyToOne
    @JoinColumn(name = "codfornecedor", referencedColumnName = "codfornecedor", nullable = false, insertable = false, updatable = false)
    private Fornecedor fornecedorByCodfornecedor;
    @OneToMany(mappedBy = "tecidoByIdtecido")
    private Collection<Tecpeca> tecpecasByIdtecido;

    public int getIdtecido() {
        return idtecido;
    }

    public void setIdtecido(int idtecido) {
        this.idtecido = idtecido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodfornecedor() {
        return codfornecedor;
    }

    public void setCodfornecedor(int codfornecedor) {
        this.codfornecedor = codfornecedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tecido tecido = (Tecido) o;

        if (idtecido != tecido.idtecido) return false;
        if (codfornecedor != tecido.codfornecedor) return false;
        if (descricao != null ? !descricao.equals(tecido.descricao) : tecido.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtecido;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + codfornecedor;
        return result;
    }

    public Collection<Linhaencomenda> getLinhaencomendasByIdtecido() {
        return linhaencomendasByIdtecido;
    }

    public void setLinhaencomendasByIdtecido(Collection<Linhaencomenda> linhaencomendasByIdtecido) {
        this.linhaencomendasByIdtecido = linhaencomendasByIdtecido;
    }

    public Fornecedor getFornecedorByCodfornecedor() {
        return fornecedorByCodfornecedor;
    }

    public void setFornecedorByCodfornecedor(Fornecedor fornecedorByCodfornecedor) {
        this.fornecedorByCodfornecedor = fornecedorByCodfornecedor;
    }

    public Collection<Tecpeca> getTecpecasByIdtecido() {
        return tecpecasByIdtecido;
    }

    public void setTecpecasByIdtecido(Collection<Tecpeca> tecpecasByIdtecido) {
        this.tecpecasByIdtecido = tecpecasByIdtecido;
    }
}
