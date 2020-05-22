package ca.usherbrooke.gegi.server.business;

public class VoteExercice {

    private String cip;
    private int exercice_id;

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public int getExercice_id() {
        return exercice_id;
    }

    public void setExercice_id(int exercice_id) {
        this.exercice_id = exercice_id;
    }

    @Override
    public String toString() {
        return "VoteExercice{" +
                "cip='" + cip + '\'' +
                ", exercice_id=" + exercice_id +
                '}';
    }
}
