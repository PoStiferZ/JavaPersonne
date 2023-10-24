package com.example.personne.Model;

public class Permanent extends Enseignant{
    private int numeroBureau;

    public Permanent(String nom, String numeroSecu, int nombreCours, String specialite, int numeroBureau) {
        super(nom, numeroSecu, nombreCours, specialite);
        this.numeroBureau = numeroBureau;
    }

    public int getNumeroBureau() {
        return numeroBureau;
    }

    public void setNumeroBureau(int numeroBureau) {
        this.numeroBureau = numeroBureau;
    }

    @Override
    public String toString() {
        return super.toString() + "Numéro de bureau : " + numeroBureau;
    }
}
