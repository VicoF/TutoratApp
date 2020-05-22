package ca.usherbrooke.gegi.server.business;

public class ImpliquePrivilege {
    private int statut_id;
    private int privilege_id;

    public int getStatut_id() {
        return statut_id;
    }

    public void setStatut_id(int statut_id) {
        this.statut_id = statut_id;
    }

    public int getPrivilege_id() {
        return privilege_id;
    }

    public void setPrivilege_id(int privilege_id) {
        this.privilege_id = privilege_id;
    }

    @Override
    public String toString() {
        return "ImpliquePrivilege{" +
                "statut_id=" + statut_id +
                ", privilege_id=" + privilege_id +
                '}';
    }


}
