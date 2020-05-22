package ca.usherbrooke.gegi.server.business;

public class Note {
    private String cip;
    private int statut_id;
    private String cours_id;
    private String donnee_par;
    private int note;
    private String commentaire;

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public int getStatut_id() {
        return statut_id;
    }

    public void setStatut_id(int statut_id) {
        this.statut_id = statut_id;
    }

    public String getCours_id() {
        return cours_id;
    }

    public void setCours_id(String cours_id) {
        this.cours_id = cours_id;
    }

    public String getDonnee_par() {
        return donnee_par;
    }

    public void setDonnee_par(String donnee_par) {
        this.donnee_par = donnee_par;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Note{" +
                "cip='" + cip + '\'' +
                ", statut_id=" + statut_id +
                ", cours_id='" + cours_id + '\'' +
                ", donnee_par='" + donnee_par + '\'' +
                ", note=" + note +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
