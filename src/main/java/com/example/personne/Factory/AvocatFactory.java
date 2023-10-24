package com.example.personne.Factory;

import com.example.personne.Interface.PersonneAbstractFactory;
import com.example.personne.Model.Avocat;
import com.example.personne.Model.Personne;

public class AvocatFactory implements PersonneAbstractFactory {
    private String nom;
    private String numeroSecu;
    private int nombreAffaires;
    private String adresseCabinet;


    public AvocatFactory(String nom, String numeroSecu, int nombreAffaires, String adresseCabinet) {
        this.nom = nom;
        this.numeroSecu = numeroSecu;
        this.nombreAffaires = nombreAffaires;
        this.adresseCabinet = adresseCabinet;
    }

    public Personne createPersonne() {
        return new Avocat(nom, numeroSecu, nombreAffaires, adresseCabinet);
    }
}
