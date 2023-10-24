package com.example.personne.Factory;

import com.example.personne.Interface.PersonneAbstractFactory;
import com.example.personne.Model.Personne;
import com.example.personne.Model.Vendeur;

import java.util.Date;

public class VendeurFactory implements PersonneAbstractFactory {
    private String nom;
    private String numeroSecu;
    private Date anciennete;
    private String nomDuStand;

    public VendeurFactory(String nom, String numeroSecu, Date anciennete, String nomDuStand) {
        this.nom = nom;
        this.numeroSecu = numeroSecu;
        this.anciennete = anciennete;
        this.nomDuStand = nomDuStand;
    }

    public Personne createPersonne() {
        return new Vendeur(nom, numeroSecu, anciennete, nomDuStand);
    }
}