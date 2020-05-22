package ca.usherbrooke.gegi.server.business;


public class Cours {
    private String cours_id;
    private String cours_nom;

    public String getCours_id() {
        return cours_id;
    }

    public void setCours_id(String cours_id) {
        this.cours_id = cours_id;
    }

    public String getCours_nom() {
        return cours_nom;
    }

    public void setCours_nom(String cours_nom) {
        this.cours_nom = cours_nom;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "cours_id='" + cours_id + '\'' +
                ", cours_nom='" + cours_nom + '\'' +
                '}';
    }
}
