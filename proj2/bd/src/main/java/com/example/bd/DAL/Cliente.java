package com.example.bd.DAL;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Cliente {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @SequenceGenerator(name="cliente_codcliente_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_codcliente_seq")

    @Column(name = "codcliente", nullable = false)
    private int codcliente;
    @Basic
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Basic
    @Column(name = "nif", nullable = false)
    private int nif;
    @Basic
    @Column(name = "codpostal", nullable = false, length = 10)
    private String codpostal;
    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Basic
    @Column(name = "rua", nullable = false, length = 50)
    private String rua;
    @Basic
    @Column(name = "nporta", nullable = false)
    private int nporta;
    @Basic
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @Basic
    @Column(name = "username", nullable = false, length = 20)
    private String username;
    @ManyToOne
    @JoinColumn(name = "codpostal", referencedColumnName = "codpostal", nullable = false, insertable = false, updatable = false)
    private Codpostais codpostaisByCodpostal;
    @OneToMany(mappedBy = "clienteByCodcliente")
    private Collection<Venda> vendasByCodcliente;

    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (codcliente != cliente.codcliente) return false;
        if (nif != cliente.nif) return false;
        if (nporta != cliente.nporta) return false;
        if (nome != null ? !nome.equals(cliente.nome) : cliente.nome != null) return false;
        if (codpostal != null ? !codpostal.equals(cliente.codpostal) : cliente.codpostal != null) return false;
        if (email != null ? !email.equals(cliente.email) : cliente.email != null) return false;
        if (rua != null ? !rua.equals(cliente.rua) : cliente.rua != null) return false;
        if (password != null ? !password.equals(cliente.password) : cliente.password != null) return false;
        if (username != null ? !username.equals(cliente.username) : cliente.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codcliente;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + nif;
        result = 31 * result + (codpostal != null ? codpostal.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + nporta;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    public Codpostais getCodpostaisByCodpostal() {
        return codpostaisByCodpostal;
    }

    public void setCodpostaisByCodpostal(Codpostais codpostaisByCodpostal) {
        this.codpostaisByCodpostal = codpostaisByCodpostal;
    }

    public Collection<Venda> getVendasByCodcliente() {
        return vendasByCodcliente;
    }

    public void setVendasByCodcliente(Collection<Venda> vendasByCodcliente) {
        this.vendasByCodcliente = vendasByCodcliente;
    }
}
