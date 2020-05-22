package ca.usherbrooke.gegi.server.business;

public class UtilisateurCotes {

    private String etudiant_cip;
    private String cours_id;
    private String cotes;

    public String getEtudiant_cip() {
        return etudiant_cip;
    }

    public void setEtudiant_cip(String etudiant_cip) {
        this.etudiant_cip = etudiant_cip;
    }

    public String getCours_id() {
        return cours_id;
    }

    public void setCours_id(String cours_id) {
        this.cours_id = cours_id;
    }

    public String getCotes() {
        return cotes;
    }

    public void setCotes(String cotes) {
        this.cotes = cotes;
    }

    @Override
    public String toString() {
        return "utilisateurcotes{" +
                "etudiant_cip='" + etudiant_cip + '\'' +
                ", cours_id='" + cours_id + '\'' +
                ", cotes='" + cotes + '\'' +
                '}';
    }
}
