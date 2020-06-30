package ca.usherbrooke.gegi.server.business;

public class Jumelage {

    private String cours_id;
    private String etudiant;
    private String mentore_par;
    private String session_id;

    public String getCours_id() {
        return cours_id;
    }

    public void setCours_id(String cours_id) {
        this.cours_id = cours_id;
    }

    public String getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(String mentor) {
        this.etudiant = mentor;
    }

    public String getMentore_par() {
        return mentore_par;
    }

    public void setMentore_par(String mentore_par) {
        this.mentore_par = mentore_par;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    @Override
    public String toString() {
        return "Jumelage{" +
                "cours_id='" + cours_id + '\'' +
                ", mentor='" + etudiant + '\'' +
                ", mentore_par='" + mentore_par + '\'' +
                ", session_id='" + session_id + '\'' +
                '}';
    }
}
