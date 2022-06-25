package com.example.bd.BLL;



import com.example.bd.DAL.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class FuncionarioBLL implements Serializable {

    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static Funcionario findFuncionarioId(int codfunc) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Funcionario.class, codfunc);
        } finally {
            em.close();
        }
    }
    public static List<Funcionario> findFuncionarioEntities() {
        List<Funcionario> funcs;
        EntityManager em = getEntityManager();
        CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Funcionario.class));
        Query q = em.createQuery(cq);
        funcs=((List<Funcionario>) q.getResultList());
        em.close();
        return funcs;
    }

    public static void create(Funcionario funcionario) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
        em.close();
    }

    public static void editNomeFunc(int cod, String nome){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Funcionario cliente;
        em.getTransaction().begin();
        cliente = em.find(Funcionario.class, cod);
        cliente.setNome(nome);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static void editNifFunc(int cod, int nif){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Funcionario cliente;
        em.getTransaction().begin();
        cliente = em.find(Funcionario.class, cod);
        cliente.setNif(nif);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static void editPassFunc(int cod, String pass){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Funcionario cliente;
        em.getTransaction().begin();
        cliente = em.find(Funcionario.class, cod);
        cliente.setPassword(pass);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }
    public static void editUserFunc(int cod, String user){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Funcionario cliente;
        em.getTransaction().begin();
        cliente = em.find(Funcionario.class, cod);
        cliente.setUsername(user);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }
    public static void deleteFunc(int cod) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        Funcionario func;
        func = em.getReference(Funcionario.class, cod);
        func.setCodfuncionario(cod);
        em.remove(func);
        em.getTransaction().commit();
        em.close();
    }

}
