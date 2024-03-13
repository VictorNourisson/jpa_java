package fr.sdv.b3.banque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "LivretA")
public class LivretA extends Compte{
    @Column(name = "TAUX")
    private Double taux;
}
