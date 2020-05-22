package ca.usherbrooke.gegi.server.business;

public class Statut {

    private int statut_id;
    private String statut_nom;

    public int getStatut_id() {
        return statut_id;
    }

    public void setStatut_id(int statut_id) {
        this.statut_id = statut_id;
    }

    public String getStatut_nom() {
        return statut_nom;
    }

    public void setStatut_nom(String statut_nom) {
        this.statut_nom = statut_nom;
    }

    @Override
    public String toString() {
        return "Statut{" +
                "statut_id=" + statut_id +
                ", statut_nom='" + statut_nom + '\'' +
                '}';
    }
}
