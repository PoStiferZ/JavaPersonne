package com.example.personne.Model;

public class Enseignant extends Personne {
    private String nom;
    private String numeroSecu;
    private int nombreCours;
    private String specialite;

    public Enseignant(String nom, String numeroSecu, int nombreCours, String specialite) {
        this.nom = nom;
        this.numeroSecu = numeroSecu;
        this.nombreCours = nombreCours;
        this.specialite = specialite;
    }

    @Override
    public String getNom() {
        return this.nom;
    }
    @Override
    public String getNumeroSecu() {
        return this.numeroSecu;
    }
    public int getNombreCours() {
        return this.nombreCours;
    }
    public String getSpecialite() {
        return this.specialite;
    }

    @Override
    public String toString() {
        return super.toString() + "Nombre de cours : " + nombreCours + "\nSpécialité : " + specialite + "\n";
    }

}
