package ca.usherbrooke.gegi.server.business;

public class Exercice {

    private int exercice_id;
    private String exercice_nom;
    private String exercice_lien;
    private Boolean exercice_est_approuve;

    public int getExercice_id() {
        return exercice_id;
    }

    public void setExercice_id(int exercice_id) {
        this.exercice_id = exercice_id;
    }

    public String getExercice_nom() {
        return exercice_nom;
    }

    public void setExercice_nom(String exercice_nom) {
        this.exercice_nom = exercice_nom;
    }

    public String getExercice_lien() {
        return exercice_lien;
    }

    public void setExercice_lien(String exercice_lien) {
        this.exercice_lien = exercice_lien;
    }

    public Boolean getExercice_est_approuve() {
        return exercice_est_approuve;
    }

    public void setExercice_est_approuve(Boolean exercice_est_approuve) {
        this.exercice_est_approuve = exercice_est_approuve;
    }

    @Override
    public String toString() {
        return "Exercice{" +
                "exercice_id=" + exercice_id +
                ", exercice_nom='" + exercice_nom + '\'' +
                ", exercice_lien='" + exercice_lien + '\'' +
                ", exercice_est_approuve=" + exercice_est_approuve +
                '}';
    }
}
