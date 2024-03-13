package fr.sdv.b3.banque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Virement extends Operation{
    @Column(name = "BENEFICIAIRE")
    private String beneficiaire;
}
