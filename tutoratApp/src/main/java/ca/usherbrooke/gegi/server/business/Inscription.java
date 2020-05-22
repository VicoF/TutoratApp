package ca.usherbrooke.gegi.server.business;

public class Inscription {
    private int statud_id;
    private String session_id;
    private String cip;
    private String cours_id;
    private int note;

    public int getStatud_id() {
        return statud_id;
    }

    public void setStatud_id(int statud_id) {
        this.statud_id = statud_id;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getCours_id() {
        return cours_id;
    }

    public void setCours_id(String cours_id) {
        this.cours_id = cours_id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Inscription{" +
                "statud_id=" + statud_id +
                ", session_id='" + session_id + '\'' +
                ", cip='" + cip + '\'' +
                ", cours_id='" + cours_id + '\'' +
                ", note=" + note +
                '}';
    }
}
