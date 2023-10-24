package com.example.personne.Model;

public abstract class Personne {

    public abstract String getNom();
    public abstract String getNumeroSecu();

    @Override
    public String toString() {
        return "\nNom : " + getNom() + "\nNuméro sécurité : " + getNumeroSecu() + "\n";
    }

}