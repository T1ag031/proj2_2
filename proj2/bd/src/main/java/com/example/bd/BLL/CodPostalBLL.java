package com.example.bd.BLL;

import com.example.bd.DAL.Cliente;
import com.example.bd.DAL.Codpostais;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class CodPostalBLL implements Serializable {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    //PESQUISAR CODIGO POSTAL
    public static Codpostais findCodpostal(String cpostal) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Codpostais.class, cpostal);
        } finally {
            em.close();
        }
    }

    public static List<Codpostais> findCodPostaisEntities() {
        List<Codpostais> cods;
        EntityManager em = getEntityManager();
        CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Codpostais.class));
        Query q = em.createQuery(cq);
        cods=((List<Codpostais>) q.getResultList());
        em.close();
        return cods;
    }

    //PROCURAR CODPOSTAL PELA LOCALIDADE

    public static Codpostais findByLocalidade(String localidade) throws Exception{
        for (Codpostais c : findCodPostaisEntities()){
            if (c.getLocalidade().equals(localidade)){
                //System.out.println("Nome: " + c.getNome() + "\nNIF: " + c.getNif() + "\nE-Mail: " + c.getEmail() + "\nCódigo Postal: " + c.getCodpostal());
                return c;
            }
        }
        throw new Exception("Código Postal a localidade " + localidade + " não encontrado!");
    }


    //CRIAR CODIGO POSTAL

    public static void create(Codpostais codpostais) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(codpostais);
        em.getTransaction().commit();
        em.close();
    }


    //ELIMINAR UM CODIGO POSTAL
/*
    public static void deleteCodPostal(String codpostal){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        Codpostais cPostal;
        cPostal = em.getReference(Codpostais.class, codpostal);
        cPostal.setCodpostal(codpostal);
        em.remove(codpostal);
        em.getTransaction().commit();
        em.close();
    }
*/

     //EDITAR LOCALIDADE

    public static void editLocalidadeCodPostal(String codPostal, String localidade){
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction();
        Codpostais cod;
        em.getTransaction().begin();
        cod = em.find(Codpostais.class, codPostal);
        cod.setLocalidade(localidade);
        em.persist(cod);
        em.getTransaction().commit();
        em.close();
    }

    //OBTER O Nº DE CODPOSTAIS

    public static int getCPostalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Codpostais.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
