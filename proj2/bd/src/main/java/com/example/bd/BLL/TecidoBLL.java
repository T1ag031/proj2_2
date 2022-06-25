package com.example.bd.BLL;

import com.example.bd.DAL.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class TecidoBLL implements Serializable {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static Tecido findTecidoId(int idtecido) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tecido.class, idtecido);
        } finally {
            em.close();
        }
    }

    public static List<Tecido> findTecidoEntities() {
        List<Tecido> tecs;
        EntityManager em = getEntityManager();
        CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Tecido.class));
        Query q = em.createQuery(cq);
        tecs=((List<Tecido>) q.getResultList());
        em.close();
        return tecs;
    }

    public static void create(Tecido tecido) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(tecido);
        em.getTransaction().commit();
        em.close();
    }

    public static void deleteTecido(int idtecido){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        Tecido tecido;
        tecido = em.getReference(Tecido.class, idtecido);
        tecido.setIdtecido(idtecido);
        tecido.getIdtecido();
        em.remove(tecido);
        em.getTransaction().commit();
        em.close();
    }

    //EDITAR DADOS TECIDO

    public static void editDescTecido(int idtecido, String desc){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Tecido tecido;
        em.getTransaction().begin();
        tecido = em.find(Tecido.class, idtecido);
        tecido.setDescricao(desc);
        em.persist(tecido);
        em.getTransaction().commit();
        em.close();
    }

}
