package com.example.bd.BLL;

import com.example.bd.DAL.Encomenda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class EncomendaBLL implements Serializable {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    //ENCONTRAR ENCOMENDA POR NUM
    public static Encomenda findEncomendaNumEnc(int numencomenda) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Encomenda.class, numencomenda);
        } finally {
            em.close();
        }
    }

    public static List<Encomenda> findEncomendaEntities() {
        List<Encomenda> encs;
        EntityManager em = getEntityManager();
        CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Encomenda.class));
        Query q = em.createQuery(cq);
        encs=((List<Encomenda>) q.getResultList());
        em.close();
        return encs;
    }



    //CRIAR ENCOMENDAS

    public static void create(Encomenda encomenda) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(encomenda);
        em.getTransaction().commit();
        em.close();
    }


    //ELIMINAR ENCOMENDA POR ID

    public static void deleteEncomenda(int numenc){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        Encomenda encomenda;
        encomenda = em.getReference(Encomenda.class, numenc);
        encomenda.setNumencomenda(numenc);
        encomenda.getNumencomenda();
        em.remove(encomenda);
        em.getTransaction().commit();
        em.close();
    }

    //EDITAR ENCOMENDA

    public static void editValorEncomenda(int numenc, float valor){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Encomenda enc;
        em.getTransaction().begin();
        enc = em.find(Encomenda.class, numenc);
        enc.setValortotal(BigDecimal.valueOf(valor));
        em.persist(enc);
        em.getTransaction().commit();
        em.close();
    }

    public static void editDataEncomenda(int id, String text) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Encomenda enc;
        em.getTransaction().begin();
        enc = em.find(Encomenda.class, id);
        enc.setData(Date.valueOf(text));
        em.persist(enc);
        em.getTransaction().commit();
        em.close();
    }

    public static void editEstadoEncomenda(int id, String estado) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Encomenda enc;
        em.getTransaction().begin();
        enc = em.find(Encomenda.class, id);
        enc.setEst(estado);
        em.persist(enc);
        em.getTransaction().commit();
        em.close();
    }
}
