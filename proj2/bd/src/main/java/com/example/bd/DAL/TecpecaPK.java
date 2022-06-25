package com.example.bd.DAL;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class TecpecaPK implements Serializable {
    @Column(name = "idtecido", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtecido;
    @Column(name = "idpeca", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpeca;

    public int getIdtecido() {
        return idtecido;
    }

    public void setIdtecido(int idtecido) {
        this.idtecido = idtecido;
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

        TecpecaPK tecpecaPK = (TecpecaPK) o;

        if (idtecido != tecpecaPK.idtecido) return false;
        if (idpeca != tecpecaPK.idpeca) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtecido;
        result = 31 * result + idpeca;
        return result;
    }
}
