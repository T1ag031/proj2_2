package com.example.bd.BLL;



import com.example.bd.DAL.Admin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class AdminBLL implements Serializable {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static Admin findAdminId(int codadmin) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Admin.class, codadmin);
        } finally {
            em.close();
        }
    }


    public static List<Admin> findAdminEntities() {
        List<Admin> admins;
        EntityManager em = getEntityManager();
        CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Admin.class));
        Query q = em.createQuery(cq);
        admins=((List<Admin>) q.getResultList());
        em.close();
        return admins;
    }

    public static void create(Admin admin) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(admin);
        em.getTransaction().commit();
        em.close();
    }

    public static void editNomeAdmin(int cod, String nome){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Admin cliente;
        em.getTransaction().begin();
        cliente = em.find(Admin.class, cod);
        cliente.setNome(nome);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static void editNifAdmin(int cod, int nif){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Admin cliente;
        em.getTransaction().begin();
        cliente = em.find(Admin.class, cod);
        cliente.setNif(nif);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static void editPassAdmin(int cod, String pass){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Admin cliente;
        em.getTransaction().begin();
        cliente = em.find(Admin.class, cod);
        cliente.setPassword(pass);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static void editUserAdmin(int cod, String user){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Admin cliente;
        em.getTransaction().begin();
        cliente = em.find(Admin.class, cod);
        cliente.setUsername(user);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }


}
