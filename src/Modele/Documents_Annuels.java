package Modele;

public class Documents_Annuels {

    private String nLocataire, certificat, ramonage;
    private int annee;

    public Documents_Annuels(String nLocataire, String certificat, String ramonage, int annee) {
        if (nLocataire == null || (1800 > annee && annee > 3000))
            throw new IllegalArgumentException("nLocataire et l'annee sont obligatoires");
        this.nLocataire = nLocataire;
        this.certificat = certificat;
        this.ramonage = ramonage;
        this.annee = annee;
    }

    public String getnLocataire() {
        return nLocataire;
    }

    public void setnLocataire(String nLocataire) {
        this.nLocataire = nLocataire;
    }

    public String getCertificat() {
        return certificat;
    }

    public void setCertificat(String certificat) {
        this.certificat = certificat;
    }

    public String getRamonage() {
        return ramonage;
    }

    public void setRamonage(String ramonage) {
        this.ramonage = ramonage;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @Override
    public String toString() {
        return "Documents_Annuels [nLocataire=" + nLocataire + ", certificat=" + certificat + ", ramonage=" + ramonage
                + ", annee=" + annee + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nLocataire == null) ? 0 : nLocataire.hashCode());
        result = prime * result + annee;
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
        Documents_Annuels other = (Documents_Annuels) obj;
        if (nLocataire == null) {
            if (other.nLocataire != null)
                return false;
        } else if (!nLocataire.equals(other.nLocataire))
            return false;
        if (annee != other.annee)
            return false;
        return true;
    }

}
