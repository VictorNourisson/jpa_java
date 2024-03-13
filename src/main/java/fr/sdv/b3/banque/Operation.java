package fr.sdv.b3.banque;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "operation")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Operation {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="DATE")
    private LocalDateTime date;
    @Column(name="MONTANT")
    private Double montant;
    @Column(name="MOTIF")
    private String motif;
    @OneToMany(mappedBy="operation")
    private Set<Compte> comptes;
    public Operation() {
        comptes = new HashSet<Compte>();
    }
}
