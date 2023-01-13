package Modele;

public class Entrepreneur {

    private String nSiren, adresse, nom, iban, secteur_activite;

    public Entrepreneur(String nSiren, String adresse, String nom, String iban, String secteur_activite) {
        if (nSiren == null)
            throw new IllegalArgumentException("Le NSiren est obligatoire");
        if (nSiren.length() != 9)
            throw new IllegalArgumentException("Le NSiren est defini sur 9 caracteres");
        if (iban != null && (iban.length() > 32 && iban.length() < 38))
            throw new IllegalArgumentException(
                    "L'IBAN doit avoir une taille comprise entre 32 et 38 caracteres verifiez que l'IBAN est correct");
        this.nSiren = nSiren;
        this.adresse = adresse;
        this.nom = nom;
        this.iban = iban;
        this.secteur_activite = secteur_activite;
    }

    public String getnSiren() {
        return nSiren;
    }

    public void setnSiren(String nSiren) {
        this.nSiren = nSiren;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getSecteur_activite() {
        return secteur_activite;
    }

    public void setSecteur_activite(String secteur_activite) {
        this.secteur_activite = secteur_activite;
    }

    @Override
    public String toString() {
        return "Entrepreneur [nSiren=" + nSiren + ", adresse=" + adresse + ", nom=" + nom + ", iban=" + iban
                + ", secteur_activite=" + secteur_activite + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nSiren == null) ? 0 : nSiren.hashCode());
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
        Entrepreneur other = (Entrepreneur) obj;
        if (nSiren == null) {
            if (other.nSiren != null)
                return false;
        } else if (!nSiren.equals(other.nSiren))
            return false;
        return true;
    }

}
