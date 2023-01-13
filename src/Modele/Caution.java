package Modele;

public class Caution {

    private String id_Caution, prenom, nom, adresse, email, telephone, profession;

    public Caution(String id_Caution, String prenom, String nom, String adresse, String email, String telephone,
            String profession) {
        if (id_Caution == null || prenom == null || nom == null || telephone == null)
            throw new IllegalArgumentException("Les champs id_caution, prenom, nom, tel sont obligatoires");
        this.id_Caution = id_Caution;
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.profession = profession;
    }

    public String getId_Caution() {
        return id_Caution;
    }

    public void setId_Caution(String id_Caution) {
        this.id_Caution = id_Caution;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Caution [id_Caution=" + id_Caution + ", prenom=" + prenom + ", nom=" + nom + ", adresse=" + adresse
                + ", email=" + email + ", telephone=" + telephone + ", profession=" + profession + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_Caution == null) ? 0 : id_Caution.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Caution other = (Caution) obj;
        if (id_Caution == null) {
            if (other.id_Caution != null)
                return false;
        } else if (!id_Caution.equals(other.id_Caution))
            return false;
        return true;
    }
}
