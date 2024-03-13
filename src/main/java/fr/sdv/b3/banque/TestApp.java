package fr.sdv.b3.banque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.Serializable;
import java.time.LocalDate;

public class TestApp implements Serializable {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Banque banque = new Banque();
        banque.setNom("Credit arboricole");
        em.persist(banque);

        Client client = new Client();
        client.setNom("Nourisson");
        client.setPrenom("Victor");
        client.setDateNaissance(LocalDate.of(2003, 1, 8));
        client.setAdresse(new Adresse(1,"13 chemin de la poelère", 79140,"Cirières" ));
        client.setBanque(banque);
        em.persist(client);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
