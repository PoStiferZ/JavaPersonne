package com.example.personne.Model;

public class Avocat extends Personne {

    private String nom;
    private String numeroSecu;
    private int nombreAffaires;
    private String adresseCabinet;


    public Avocat(String nom, String numeroSecu, int nombreAffaires, String adresseCabinet) {
        this.nom = nom;
        this.numeroSecu = numeroSecu;
        this.nombreAffaires = nombreAffaires;
        this.adresseCabinet = adresseCabinet;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public String getNumeroSecu() {
        return this.numeroSecu;
    }
    public int getNombreAffaires() {
        return this.nombreAffaires;
    }

    public String getAdresseCabinet() {
        return this.adresseCabinet;
    }

    @Override
    public String toString() {
        return super.toString() + "Nombre d'affaires : " + nombreAffaires + "\nAdresse du cabinet : " + adresseCabinet;
    }


}