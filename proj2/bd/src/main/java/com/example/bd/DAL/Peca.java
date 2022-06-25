package com.example.bd.DAL;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Peca {
    @Id
    @SequenceGenerator(name="peca_idpeca_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="peca_idpeca_seq")
    @Column(name = "idpeca", nullable = false)
    private int idpeca;
    @Basic
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Basic
    @Column(name = "qtd", nullable = false)
    private int qtd;
    @Basic
    @Column(name = "precopeca", nullable = false)
    private int precopeca;
    @OneToMany(mappedBy = "pecaByIdpeca")
    private Collection<Linhavenda> linhavendasByIdpeca;
    @OneToMany(mappedBy = "pecaByIdpeca")
    private Collection<Tecpeca> tecpecasByIdpeca;

    public int getIdpeca() {
        return idpeca;
    }

    public void setIdpeca(int idpeca) {
        this.idpeca = idpeca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getPrecopeca() {
        return precopeca;
    }

    public void setPrecopeca(int precopeca) {
        this.precopeca = precopeca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Peca peca = (Peca) o;

        if (idpeca != peca.idpeca) return false;
        if (qtd != peca.qtd) return false;
        if (precopeca != peca.precopeca) return false;
        if (nome != null ? !nome.equals(peca.nome) : peca.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpeca;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + qtd;
        result = 31 * result + precopeca;
        return result;
    }

    public Collection<Linhavenda> getLinhavendasByIdpeca() {
        return linhavendasByIdpeca;
    }

    public void setLinhavendasByIdpeca(Collection<Linhavenda> linhavendasByIdpeca) {
        this.linhavendasByIdpeca = linhavendasByIdpeca;
    }

    public Collection<Tecpeca> getTecpecasByIdpeca() {
        return tecpecasByIdpeca;
    }

    public void setTecpecasByIdpeca(Collection<Tecpeca> tecpecasByIdpeca) {
        this.tecpecasByIdpeca = tecpecasByIdpeca;
    }
}
