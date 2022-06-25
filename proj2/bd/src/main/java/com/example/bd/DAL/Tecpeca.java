package com.example.bd.DAL;

import javax.persistence.*;

@Entity
@IdClass(TecpecaPK.class)
public class Tecpeca {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idtecido", nullable = false)
    private int idtecido;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpeca", nullable = false)
    private int idpeca;
    @ManyToOne
    @JoinColumn(name = "idtecido", referencedColumnName = "idtecido", nullable = false, insertable = false, updatable = false)
    private Tecido tecidoByIdtecido;
    @ManyToOne
    @JoinColumn(name = "idpeca", referencedColumnName = "idpeca", nullable = false, insertable = false, updatable = false)
    private Peca pecaByIdpeca;

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

        Tecpeca tecpeca = (Tecpeca) o;

        if (idtecido != tecpeca.idtecido) return false;
        if (idpeca != tecpeca.idpeca) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtecido;
        result = 31 * result + idpeca;
        return result;
    }

    public Tecido getTecidoByIdtecido() {
        return tecidoByIdtecido;
    }

    public void setTecidoByIdtecido(Tecido tecidoByIdtecido) {
        this.tecidoByIdtecido = tecidoByIdtecido;
    }

    public Peca getPecaByIdpeca() {
        return pecaByIdpeca;
    }

    public void setPecaByIdpeca(Peca pecaByIdpeca) {
        this.pecaByIdpeca = pecaByIdpeca;
    }
}
