package com.example.bd.BLL;

import com.example.bd.DAL.Cliente;
import com.example.bd.DAL.Fornecedor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class FornecedorBLL implements Serializable {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static Fornecedor findFornecedorCod(int codfornecedor) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fornecedor.class, codfornecedor);
        } finally {
            em.close();
        }
    }

    public static List<Fornecedor> findFornecedorEntities() {
        List<Fornecedor> forns;
        EntityManager em = getEntityManager();
        CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Fornecedor.class));
        Query q = em.createQuery(cq);
        forns=((List<Fornecedor>) q.getResultList());
        em.close();
        return forns;
    }

    //PROCURAR FORNECEDOR PELO NOME

    public static Fornecedor findByNome(String nome) throws Exception{
        for (Fornecedor c : findFornecedorEntities()){
            if (c.getNome().equals(nome)){
                //System.out.println("Nome: " + c.getNome() + "\nNIF: " + c.getNif() + "\nE-Mail: " + c.getEmail() + "\nCódigo Postal: " + c.getCodpostal());
                return c;
            }
        }
        throw new Exception("Fornecedor "  +nome+" não encontrado!");
    }

    //PROCURAR FORNECEDOR PELO NIF

    public static Fornecedor findByNif(int nif) throws Exception{
        for (Fornecedor c : findFornecedorEntities()){
            if (c.getNif()==nif){
                //System.out.println("Nome: " + c.getNome() + "\nNIF: " + c.getNif() + "\nE-Mail: " + c.getEmail() + "\nCódigo Postal: " + c.getCodpostal());
                return c;
            }
        }
        throw new Exception("Fornecedor com o nif " + nif + " não encontrado!");
    }

    public static void create(Fornecedor fornecedor) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(fornecedor);
        em.getTransaction().commit();
        em.close();
    }
/*
    public static void deleteFornecedor(int codfornecedor){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        Fornecedor fornecedor;
        fornecedor = em.getReference(Fornecedor.class, codfornecedor);
        fornecedor.setCodfornecedor(codfornecedor);
        fornecedor.getCodfornecedor();
        em.remove(fornecedor);
        em.getTransaction().commit();
        em.close();
    }
*/
    //EDITAR DADOS FORNECEDOR

    public static void editNomeFornecedor(int codfornecedor, String nome){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Fornecedor fornecedor;
        em.getTransaction().begin();
        fornecedor = em.find(Fornecedor.class, codfornecedor);
        fornecedor.setNome(nome);
        em.persist(fornecedor);
        em.getTransaction().commit();
        em.close();
    }


    public static void editNifFornecedor(int codfornecedor, int nif){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Fornecedor fornecedor;
        em.getTransaction().begin();
        fornecedor = em.find(Fornecedor.class, codfornecedor);
        fornecedor.setNif(nif);
        em.persist(fornecedor);
        em.getTransaction().commit();
        em.close();
    }

    public static void editRuaFornecedor(int codfornecedor, String rua){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Fornecedor fornecedor;
        em.getTransaction().begin();
        fornecedor = em.find(Fornecedor.class, codfornecedor);
        fornecedor.setRua(rua);
        em.persist(fornecedor);
        em.getTransaction().commit();
        em.close();
    }

    public static void editNPortaFornecedor(int codfornecedor, int nporta){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Fornecedor fornecedor;
        em.getTransaction().begin();
        fornecedor = em.find(Fornecedor.class, codfornecedor);
        fornecedor.setNporta(nporta);
        em.persist(fornecedor);
        em.getTransaction().commit();
        em.close();
    }

    public static void editUsernameFornecedor(int codfornecedor, String user){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Fornecedor fornecedor;
        em.getTransaction().begin();
        fornecedor = em.find(Fornecedor.class, codfornecedor);
        fornecedor.setUsername(user);
        em.persist(fornecedor);
        em.getTransaction().commit();
        em.close();
    }

    public static void editPassFornecedor(int codfornecedor, String pass){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Fornecedor fornecedor;
        em.getTransaction().begin();
        fornecedor = em.find(Fornecedor.class, codfornecedor);
        fornecedor.setPassword(pass);
        em.persist(fornecedor);
        em.getTransaction().commit();
        em.close();
    }

    //OBTER O Nº DE FORNECEDORES


    public static int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Fornecedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
