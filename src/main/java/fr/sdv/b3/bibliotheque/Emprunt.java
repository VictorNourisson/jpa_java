package fr.sdv.b3.bibliotheque;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="emprunt")
public class Emprunt implements Serializable {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="DATE_DEBUT")
    private LocalDateTime date_deb;
    @Column(name="DATE_FIN")
    private LocalDateTime date_fin;
    @Column(name="DELAI")
    private Integer delai;
    @ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;
    @ManyToMany
    @JoinTable(name="compo",
            joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID")
    )
    private Set<Livre> livres;


    public Emprunt() {
    }

    public Emprunt(LocalDateTime date_deb, LocalDateTime date_fin, Integer delai, Client client, Set<Livre> livres) {
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.delai = delai;
        this.client = client;
        this.livres = livres;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", date_deb=" + date_deb +
                ", date_fin=" + date_fin +
                ", delai=" + delai +
                ", client=" + client +
                '}';
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate_deb(LocalDateTime date_deb) {
        this.date_deb = date_deb;
    }

    public void setDate_fin(LocalDateTime date_fin) {
        this.date_fin = date_fin;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public LocalDateTime getDate_deb() {
        return date_deb;
    }

    public LocalDateTime getDate_fin() {
        return date_fin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprunt emprunt = (Emprunt) o;
        return Objects.equals(id, emprunt.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static void main(String[] args) {

    }
}
