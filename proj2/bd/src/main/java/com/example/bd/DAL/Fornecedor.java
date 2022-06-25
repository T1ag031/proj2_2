package com.example.bd.DAL;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Fornecedor {
    @Id
    @SequenceGenerator(name="fornecedor_codfornecedor_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="fornecedor_codfornecedor_seq")
    @Column(name = "codfornecedor", nullable = false)
    private int codfornecedor;
    @Basic
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Basic
    @Column(name = "rua", nullable = false, length = 50)
    private String rua;
    @Basic
    @Column(name = "nporta", nullable = false)
    private int nporta;
    @Basic
    @Column(name = "nif", nullable = false)
    private int nif;
    @Basic
    @Column(name = "codpostal", nullable = false, length = 10)
    private String codpostal;
    @Basic
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @OneToMany(mappedBy = "fornecedorByCodfornecedor")
    private Collection<Encomenda> encomendasByCodfornecedor;
    @ManyToOne
    @JoinColumn(name = "codpostal", referencedColumnName = "codpostal",nullable = false, insertable = false, updatable = false)
    private Codpostais codpostaisByCodpostal;
    @OneToMany(mappedBy = "fornecedorByCodfornecedor")
    private Collection<Tecido> tecidosByCodfornecedor;

    public int getCodfornecedor() {
        return codfornecedor;
    }

    public void setCodfornecedor(int codfornecedor) {
        this.codfornecedor = codfornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNporta() {
        return nporta;
    }

    public void setNporta(int nporta) {
        this.nporta = nporta;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fornecedor that = (Fornecedor) o;

        if (codfornecedor != that.codfornecedor) return false;
        if (nporta != that.nporta) return false;
        if (nif != that.nif) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (rua != null ? !rua.equals(that.rua) : that.rua != null) return false;
        if (codpostal != null ? !codpostal.equals(that.codpostal) : that.codpostal != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codfornecedor;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + nporta;
        result = 31 * result + nif;
        result = 31 * result + (codpostal != null ? codpostal.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Collection<Encomenda> getEncomendasByCodfornecedor() {
        return encomendasByCodfornecedor;
    }

    public void setEncomendasByCodfornecedor(Collection<Encomenda> encomendasByCodfornecedor) {
        this.encomendasByCodfornecedor = encomendasByCodfornecedor;
    }

    public Codpostais getCodpostaisByCodpostal() {
        return codpostaisByCodpostal;
    }

    public void setCodpostaisByCodpostal(Codpostais codpostaisByCodpostal) {
        this.codpostaisByCodpostal = codpostaisByCodpostal;
    }

    public Collection<Tecido> getTecidosByCodfornecedor() {
        return tecidosByCodfornecedor;
    }

    public void setTecidosByCodfornecedor(Collection<Tecido> tecidosByCodfornecedor) {
        this.tecidosByCodfornecedor = tecidosByCodfornecedor;
    }
}
