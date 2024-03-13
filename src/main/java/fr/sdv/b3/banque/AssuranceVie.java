package fr.sdv.b3.banque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "assuranceVie")
public class AssuranceVie extends Compte {
    @Column(name = "DATE_FIN")
    private LocalDate dateFin;
    @Column(name = "TAUX")
    private Double taux;
}
