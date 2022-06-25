package com.example.bd.DAL;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class LinhaencomendaPK implements Serializable {
    @Column(name = "numenc", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numenc;
    @Column(name = "idtecido", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtecido;

    public int getNumenc() {
        return numenc;
    }

    public void setNumenc(int numenc) {
        this.numenc = numenc;
    }

    public int getIdtecido() {
        return idtecido;
    }

    public void setIdtecido(int idtecido) {
        this.idtecido = idtecido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinhaencomendaPK that = (LinhaencomendaPK) o;

        if (numenc != that.numenc) return false;
        if (idtecido != that.idtecido) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numenc;
        result = 31 * result + idtecido;
        return result;
    }
}
