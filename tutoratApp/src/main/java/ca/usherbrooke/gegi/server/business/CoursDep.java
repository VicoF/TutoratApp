package ca.usherbrooke.gegi.server.business;

public class CoursDep {
    String ap_id;
    double credit_annuaire;
    String departement_id;
    String description;
    String groupe_id;
    String inscription;
    String trimestre_id;

    public String getAp_id() {
        return ap_id;
    }

    public void setAp_id(String ap_id) {
        this.ap_id = ap_id;
    }

    public double getCredit_annuaire() {
        return credit_annuaire;
    }

    public void setCredit_annuaire(double credit_annuaire) {
        this.credit_annuaire = credit_annuaire;
    }

    public String getDepartement_id() {
        return departement_id;
    }

    public void setDepartement_id(String departement_id) {
        this.departement_id = departement_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroupe_id() {
        return groupe_id;
    }

    public void setGroupe_id(String groupe_id) {
        this.groupe_id = groupe_id;
    }

    public String getInscription() {
        return inscription;
    }

    public void setInscription(String inscription) {
        this.inscription = inscription;
    }

    public String getTrimestre_id() {
        return trimestre_id;
    }

    public void setTrimestre_id(String trimestre_id) {
        this.trimestre_id = trimestre_id;
    }

    @Override
    public String toString() {
        return "CoursDep{" +
                "ap_id='" + ap_id + '\'' +
                ", departement_id='" + departement_id + '\'' +
                ", description='" + description + '\'' +
                ", trimestre_id='" + trimestre_id + '\'' +
                '}';
    }
}
