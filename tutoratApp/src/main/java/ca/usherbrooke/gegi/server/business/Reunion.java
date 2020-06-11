package ca.usherbrooke.gegi.server.business;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Reunion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reunion_id;
    private String mentore;
    private String mentor;
    private Date date_debut;
    private Date date_fin;
    private String numero_local;

    public int getReunion_id() {
        return reunion_id;
    }

    public void setReunion_id(int reunion_id) {
        this.reunion_id = reunion_id;
    }

    public String getMentore() {
        return mentore;
    }

    public void setMentore(String mentore) {
        this.mentore = mentore;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getNumero_local() {
        return numero_local;
    }

    public void setNumero_local(String numero_local) {
        this.numero_local = numero_local;
    }

    @Override
    public String toString() {
        return "Reunion{" +
                "reunion_id=" + reunion_id +
                ", mentore='" + mentore + '\'' +
                ", mentor='" + mentor + '\'' +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", numero_local='" + numero_local + '\'' +
                '}';
    }
}
