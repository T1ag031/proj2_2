package com.example.bd.BLL;

import com.example.bd.DAL.Peca;
import com.example.bd.DAL.Venda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class LinhaVendaBLL implements Serializable {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    public static Peca findPecaId(int idpeca) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Peca.class, idpeca);
        } finally {
            em.close();
        }
    }

    public static List<Peca> findPecaEntities() {
        List<Peca> pecas;
        EntityManager em = getEntityManager();
        CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Peca.class));
        Query q = em.createQuery(cq);
        pecas=((List<Peca>) q.getResultList());
        em.close();
        return pecas;
    }

    //PROCURAR PECA PELO NOME

    public static Peca findByNome(String nome) throws Exception{
        for (Peca c : findPecaEntities()){
            if (c.getNome().equals(nome)){
                //System.out.println("Nome: " + c.getNome() + "\nNIF: " + c.getNif() + "\nE-Mail: " + c.getEmail() + "\nCódigo Postal: " + c.getCodpostal());
                return c;
            }
        }
        throw new Exception("Peca " + nome +" não encontrada!");
    }

    public static void create(Peca peca) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(peca);
        em.getTransaction().commit();
        em.close();
    }

    public static void editNomePeca(int idpeca, String nome){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Peca peca;
        em.getTransaction().begin();
        peca = em.find(Peca.class, idpeca);
        peca.setNome(nome);
        em.persist(peca);
        em.getTransaction().commit();
        em.close();
    }
    public static void editQtdPeca(int idpeca, int qtd){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Peca peca;
        em.getTransaction().begin();
        peca = em.find(Peca.class, idpeca);
        peca.setQtd(qtd);
        em.persist(peca);
        em.getTransaction().commit();
        em.close();
    }

    public static void editValorPeca(int idpeca, int preco){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Peca peca;
        em.getTransaction().begin();
        peca = em.find(Peca.class, idpeca);
        peca.setPrecopeca(preco);
        em.persist(peca);
        em.getTransaction().commit();
        em.close();
    }

    public static void editValorVenda(int numvenda, float valor){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Venda venda;
        em.getTransaction().begin();
        venda = em.find(Venda.class, numvenda);
        venda.setValortotal(BigDecimal.valueOf(valor));
        em.persist(venda);
        em.getTransaction().commit();
        em.close();
    }
    public static Venda findVendaNumvenda(int numvenda) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venda.class, numvenda);
        } finally {
            em.close();
        }
    }
    public static List<Venda> findVendaEntities() {
        List<Venda> vendas;
        EntityManager em = getEntityManager();
        CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Venda.class));
        Query q = em.createQuery(cq);
        vendas=((List<Venda>) q.getResultList());
        em.close();
        return vendas;
    }
    public static void create(Venda venda) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(venda);
        em.getTransaction().commit();
        em.close();
    }
}