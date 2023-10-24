package com.example.personne.Model;

public class Vacataire extends Enseignant{

    private int nombreVacations;

    public Vacataire(String nom, String numeroSecu, int nombreCours, String specialite, int nombreVacations) {
        super(nom, numeroSecu, nombreCours, specialite);
        this.nombreVacations = nombreVacations;
    }

    public int getNombreVacations() {
        return nombreVacations;
    }

    public void setNombreVacations(int nombreVacations) {
        this.nombreVacations = nombreVacations;
    }

    @Override
    public String toString() {
        return super.toString() + "Nombre de vacations : " + nombreVacations;
    }
}
