package com.example.bd.DAL;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class LinhavendaPK implements Serializable {
    @Column(name = "numvenda", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numvenda;
    @Column(name = "idpeca", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpeca;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinhavendaPK that = (LinhavendaPK) o;

        if (numvenda != that.numvenda) return false;
        if (idpeca != that.idpeca) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numvenda;
        result = 31 * result + idpeca;
        return result;
    }
}
