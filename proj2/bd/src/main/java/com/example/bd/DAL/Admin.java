package com.example.bd.DAL;

import javax.persistence.*;

@Entity
public class Admin {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @SequenceGenerator(name="admin_codadmin_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="admin_codadmin_seq")

    @Column(name = "codadmin", nullable = false)
    private int codadmin;
    @Basic
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Basic
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @Basic
    @Column(name = "nif", nullable = false)
    private int nif;

    public int getCodadmin() {
        return codadmin;
    }

    public void setCodadmin(int codadmin) {
        this.codadmin = codadmin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (codadmin != admin.codadmin) return false;
        if (nif != admin.nif) return false;
        if (nome != null ? !nome.equals(admin.nome) : admin.nome != null) return false;
        if (username != null ? !username.equals(admin.username) : admin.username != null) return false;
        if (password != null ? !password.equals(admin.password) : admin.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codadmin;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + nif;
        return result;
    }
}
