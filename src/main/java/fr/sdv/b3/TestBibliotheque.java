package fr.sdv.b3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TestBibliotheque {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // liste des livres associé à un emprunt
        TypedQuery<Livre> query = em.createQuery("select l from Emprunt e JOIN e.livres l where e.id=2", Livre.class);
        List <Livre> livre = query.getResultList();
        System.out.println(livre);

        // liste des emprunts associé à un client
        TypedQuery<Emprunt> query2 = em.createQuery("select e from Client c JOIN c.emprunts e where c.id=1", Emprunt.class);
        List <Emprunt> emprunt = query2.getResultList();
        System.out.println(emprunt);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
