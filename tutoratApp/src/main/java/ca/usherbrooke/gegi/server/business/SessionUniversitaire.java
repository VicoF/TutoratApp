package ca.usherbrooke.gegi.server.business;
import java.util.Date;

public class SessionUniversitaire {

    private String session_id;
    private String session_nom;
    private Date date_debut;
    private Date date_fin;

    public String getSession_id() {return session_id; }
    public void setSession_id(String session_id) { this.session_id = session_id; }

    public String getSession() { return session_nom; }
    public void setSession(String session_nom) { this.session_nom = session_nom; }

    public Date getDebut() {
        return date_debut;
    }

    public void setDebut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getFin() {
        return date_fin;
    }

    public void setFin(Date date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return getSession_id() + " " + getSession() + " " + getDebut() + " " + getFin();
    }
}
