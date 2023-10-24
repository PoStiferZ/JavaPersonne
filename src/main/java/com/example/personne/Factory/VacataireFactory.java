package com.example.personne.Factory;

import com.example.personne.Interface.PersonneAbstractFactory;
import com.example.personne.Model.Personne;
import com.example.personne.Model.Vacataire;

public abstract class VacataireFactory implements PersonneAbstractFactory {
    private String nom;
    private String numeroSecu;
    private int nombreCours;
    private String specialite;
    private int nombreVacations;

    public VacataireFactory(String nom, String numeroSecu, int nombreCours, String specialite, int nombreVacations) {
        this.nom = nom;
        this.numeroSecu = numeroSecu;
        this.nombreCours = nombreCours;
        this.specialite = specialite;
        this.nombreVacations = nombreVacations;
    }

    public Personne createPersonne() {
        return new Vacataire(nom, numeroSecu, nombreCours, specialite, nombreVacations);
    }

}
