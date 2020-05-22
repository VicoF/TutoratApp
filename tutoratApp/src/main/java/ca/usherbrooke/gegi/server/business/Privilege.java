package ca.usherbrooke.gegi.server.business;

public class Privilege {

    private int privilege_id;
    private String privilege_nom;

    public int getPrivilege_id() {
        return privilege_id;
    }

    public void setPrivilege_id(int privilege_id) {
        this.privilege_id = privilege_id;
    }

    public String getPrivilege_nom() {
        return privilege_nom;
    }

    public void setPrivilege_nom(String privilege_nom) {
        this.privilege_nom = privilege_nom;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "privilege_id=" + privilege_id +
                ", privilege_nom='" + privilege_nom + '\'' +
                '}';
    }
}
