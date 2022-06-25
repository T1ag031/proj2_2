package com.example.bd.BLL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

import com.example.bd.DAL.*;

public class ClienteBLL implements Serializable {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    //PESQUISAR CLIENTE
    public static Cliente findClienteId(int codcliente) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, codcliente);
        } finally {
            em.close();
        }
    }


    public static List<Cliente> findClienteEntities() {
        List<Cliente> clis;
        EntityManager em = getEntityManager();
        CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Cliente.class));
        Query q = em.createQuery(cq);
        clis=((List<Cliente>) q.getResultList());
        em.close();
        return clis;
    }

    //LOGIN

    /*public static Cliente login(String username, String pass) throws Exception {
        for(Cliente c: findClienteEntities()) {
            if (c.getUsername().equals(username) && c.getPassword().equals(pass)) {
                System.out.println("Log In efetuado com Sucesso!");
                return c;
            } else {
                System.out.println("Password ou Username Errados");
            }
        }
        throw new Exception("Cliente não encontrado!");
    }*/


    //PROCURAR CLIENTE PELO NOME

    public static Cliente findByNome(String nome) throws Exception{
        for (Cliente c : findClienteEntities()){
            if (c.getNome().equals(nome)){
                //System.out.println("Nome: " + c.getNome() + "\nNIF: " + c.getNif() + "\nE-Mail: " + c.getEmail() + "\nCódigo Postal: " + c.getCodpostal());
                return c;
            }
        }
        throw new Exception("Cliente não encontrado!");
    }

    public static Cliente findByUser(String user){
        for (Cliente c : findClienteEntities()){
            if (c.getUsername().equals(user)){
                //System.out.println("Nome: " + c.getNome() + "\nNIF: " + c.getNif() + "\nE-Mail: " + c.getEmail() + "\nCódigo Postal: " + c.getCodpostal());
                return c;
            }
        }
        return null;
    }

    //PROCURAR CLIENTE PELO NIF

    public static Cliente findByNif(int nif) throws Exception{
        for (Cliente c : findClienteEntities()){
            if (c.getNif()==nif){
                //System.out.println("Nome: " + c.getNome() + "\nNIF: " + c.getNif() + "\nE-Mail: " + c.getEmail() + "\nCódigo Postal: " + c.getCodpostal());
                return c;
            }
        }
        throw new Exception("Cliente com o nif " + nif + " não encontrado!");
    }

    //CRIAR CLIENTE
    public static void create(Cliente cliente) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    //ELIMINAR CLIENTE
   /* public static void deleteCliente(int codcliente){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        Cliente cliente;
        cliente = em.getReference(Cliente.class, codcliente);
        cliente.setCodcliente(codcliente);
        cliente.getCodcliente();
        em.remove(cliente);
        em.getTransaction().commit();
        em.close();
    }*/

    //EDITAR CADA DADO DO CLIENTE
    public static void editNomeCliente(int cod, String nome){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Cliente cliente;
        em.getTransaction().begin();
        cliente = em.find(Cliente.class, cod);
        cliente.setNome(nome);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static void editNifCliente(int cod, int nif){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Cliente cliente;
        em.getTransaction().begin();
        cliente = em.find(Cliente.class, cod);
        cliente.setNif(nif);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static void editEmailCliente(int cod, String email){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Cliente cliente;
        em.getTransaction().begin();
        cliente = em.find(Cliente.class, cod);
        cliente.setEmail(email);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static void editCPostalCliente(int cod, String codpostal){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Cliente cliente;
        em.getTransaction().begin();
        cliente = em.find(Cliente.class, cod);
        cliente.setCodpostal(codpostal);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static void editRuaCliente(int cod, String rua){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Cliente cliente;
        em.getTransaction().begin();
        cliente = em.find(Cliente.class, cod);
        cliente.setRua(rua);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static void editNPortaCliente(int cod, int nporta){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Cliente cliente;
        em.getTransaction().begin();
        cliente = em.find(Cliente.class, cod);
        cliente.setNporta(nporta);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static void editPasswordCliente(int cod, String pass){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Cliente cliente;
        em.getTransaction().begin();
        cliente = em.find(Cliente.class, cod);
        cliente.setPassword(pass);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static void editUserCliente(int cod, String user){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Cliente cliente;
        em.getTransaction().begin();
        cliente = em.find(Cliente.class, cod);
        cliente.setUsername(user);
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    //OBTER O Nº DE CLIENTES

    public static int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
