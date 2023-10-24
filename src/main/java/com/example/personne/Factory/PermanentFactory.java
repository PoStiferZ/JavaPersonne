package com.example.personne.Factory;

import com.example.personne.Interface.PersonneAbstractFactory;
import com.example.personne.Model.Personne;
import com.example.personne.Model.Permanent;

public abstract class PermanentFactory implements PersonneAbstractFactory {
    private String nom;
    private String numeroSecu;
    private int nombreCours;
    private String specialite;
    private int numeroBureau;

    public PermanentFactory(String nom, String numeroSecu, int nombreCours, String specialite, int numeroBureau) {
        this.nom = nom;
        this.numeroSecu = numeroSecu;
        this.nombreCours = nombreCours;
        this.specialite = specialite;
        this.numeroBureau = numeroBureau;
    }

    public Personne createPersonne() {
        return new Permanent(nom, numeroSecu, nombreCours, specialite, numeroBureau);
    }

}
