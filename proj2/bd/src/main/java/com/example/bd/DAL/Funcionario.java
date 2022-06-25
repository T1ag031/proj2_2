package com.example.bd.DAL;

import javax.persistence.*;

@Entity
public class Funcionario {
    @Id
    @SequenceGenerator(name="funcionario_codfuncionario_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="funcionario_codfuncionario_seq")
    @Column(name = "codfuncionario", nullable = false)
    private int codfuncionario;
    @Basic
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Basic
    @Column(name = "nif", nullable = false)
    private int nif;
    @Basic
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    public int getCodfuncionario() {
        return codfuncionario;
    }

    public void setCodfuncionario(int codfuncionario) {
        this.codfuncionario = codfuncionario;
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

        Funcionario that = (Funcionario) o;

        if (codfuncionario != that.codfuncionario) return false;
        if (nif != that.nif) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codfuncionario;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + nif;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
