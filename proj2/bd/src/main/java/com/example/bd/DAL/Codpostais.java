package com.example.bd.DAL;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Codpostais {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codpostal", nullable = false, length = 10)
    private String codpostal;
    @Basic
    @Column(name = "localidade", nullable = false, length = 20)
    private String localidade;
    @OneToMany(mappedBy = "codpostaisByCodpostal")
    private Collection<Cliente> clientesByCodpostal;
    @OneToMany(mappedBy = "codpostaisByCodpostal")
    private Collection<Fornecedor> fornecedorsByCodpostal;

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Codpostais that = (Codpostais) o;

        if (codpostal != null ? !codpostal.equals(that.codpostal) : that.codpostal != null) return false;
        if (localidade != null ? !localidade.equals(that.localidade) : that.localidade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codpostal != null ? codpostal.hashCode() : 0;
        result = 31 * result + (localidade != null ? localidade.hashCode() : 0);
        return result;
    }

    public Collection<Cliente> getClientesByCodpostal() {
        return clientesByCodpostal;
    }

    public void setClientesByCodpostal(Collection<Cliente> clientesByCodpostal) {
        this.clientesByCodpostal = clientesByCodpostal;
    }

    public Collection<Fornecedor> getFornecedorsByCodpostal() {
        return fornecedorsByCodpostal;
    }

    public void setFornecedorsByCodpostal(Collection<Fornecedor> fornecedorsByCodpostal) {
        this.fornecedorsByCodpostal = fornecedorsByCodpostal;
    }
}
