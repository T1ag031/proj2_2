package com.example.bd.BLL;
import com.example.bd.DAL.Encomenda;
import com.example.bd.DAL.Tecido;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class LinhaEncomendaBLL implements Serializable {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static Encomenda findEncomendaNumEnc(int numencomenda) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Encomenda.class, numencomenda);
        } finally {
            em.close();
        }
    }

    public static List<Encomenda> findEncomendaEntities(){
        List<Encomenda> encs;
        EntityManager em = getEntityManager();
        CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Encomenda.class));
        Query q = em.createQuery(cq);
        encs=((List<Encomenda>) q.getResultList());
        em.close();
        return encs;
    }
    public static void create(Encomenda encomenda) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(encomenda);
        em.getTransaction().commit();
        em.close();
    }

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

