package com.example.personne.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Vendeur extends Personne {
    private String nom;
    private String numeroSecu;
    private Date anciennete;
    private String nomDuStand;

    public Vendeur(String nom, String numeroSecu, Date anciennete, String nomDuStand) {
        this.nom = nom;
        this.numeroSecu = numeroSecu;
        this.anciennete = anciennete;
        this.nomDuStand = nomDuStand;
    }
    @Override
    public String getNom() {
        return this.nom;
    }
    @Override
    public String getNumeroSecu() {
        return this.numeroSecu;
    }

    public Date getAnciennete() {
        return this.anciennete;
    }

    public String getNomDuStand() {
        return this.nomDuStand;
    }

    @Override
    public String toString() {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yy");
        String stringDate= DateFor.format(anciennete);
        return super.toString() + "Ancienneté : " + stringDate + "\n Nom du stand : " + nomDuStand;
    }

}
