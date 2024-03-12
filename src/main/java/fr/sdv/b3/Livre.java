package fr.sdv.b3;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "livre")
public class Livre {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="TITRE")
    private String titre;
    @Column(name="AUTEUR")
    private String auteur;

    public Livre() {
    }

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Integer getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return Objects.equals(id, livre.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        // find
        Livre select = em.find(Livre.class, 3);
        System.out.println(select);

        // insertion
        Livre insert = new Livre("test", "test");
        em.persist(insert);

        // modifier
        Livre modif = em.find(Livre.class, 5);
        modif.setTitre("Du plaisir dans la cuisine");

        // requete JPQL : livre en fonction de son titre
        TypedQuery<Livre> query2 = em.createQuery("select l from Livre l where l.titre='test'", Livre.class);
        Livre livre2 = query2.getResultList().get(0);
        System.out.println(livre2);

        // requete JPQL : livre en fonction de son auteur
        TypedQuery<Livre> query3 = em.createQuery("select l from Livre l where l.auteur='test'", Livre.class);
        Livre livre3 = query3.getResultList().get(0);
        System.out.println(livre3);

        // supprimer des données
        Livre l = em.find(Livre.class, 7);
        if (l != null){
            em.remove(l);
        }

        // afficher la liste de tous les livres
        TypedQuery<Livre> query4 = em.createQuery("select l from Livre l", Livre.class);
        List<Livre> livre4 = query4.getResultList();
        System.out.println(livre4);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
