package com.example.demo.taches;

import com.example.demo.employee.entity.Employe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder

@Entity
@Table(name = "taches")
public class Task {

    @Id
    @SequenceGenerator(
            name ="tache_sequence",
            sequenceName = "tache_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tache_sequence"
    )
    private Long id;

    @Column(name="NomTache")
    private String name;
    @Column(name="Description")
    private String description;
    @Column(name="Date_Debut")
    private Date dateDebut;
    @Column(name="Date_Fin")
    private Date dateFin;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employe employe;

    /**
     * 0- implementer recupererEmployerByID()
     * 1- concevoir un entity Tache: id, name, description, dateDebut, dateFin,statut: a_faire/en_cours/terminee/
     * 2- implementer selon l'architecture : ctrl/Service/repository
     * 3-Requests: Get/Put/Delete/....
     * 4-Tests
     *
     * Employer peut avoir une a plusieurs taches (@OnetoMany)
     *
     */
}
