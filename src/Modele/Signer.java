package Modele;

public class Signer {
    // CREATE TABLE SIGNER(
    // NLOCATAIRE VARCHAR2(50),
    // ID_CONTRAT VARCHAR2(50),
    // PRIMARY KEY(NLOCATAIRE, ID_CONTRAT),
    // FOREIGN KEY(NLOCATAIRE) REFERENCES LOCATAIRE(NLOCATAIRE),
    // FOREIGN KEY(ID_CONTRAT) REFERENCES CONTRAT(ID_CONTRAT)
    // );

    private Locataire locataire;
    private Contrat contrat;

    public Signer(Locataire locataire, Contrat contrat) {
        if (locataire == null)
            throw new IllegalArgumentException("Le locataire doit être renseigner");
        if (contrat == null)
            throw new IllegalArgumentException("Le contrat doit être renseigner");
        this.locataire = locataire;
        this.contrat = contrat;
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    @Override
    public String toString() {
        return "Signer [locataire=" + locataire + ", contrat=" + contrat + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((locataire == null) ? 0 : locataire.hashCode());
        result = prime * result + ((contrat == null) ? 0 : contrat.hashCode());
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
        Signer other = (Signer) obj;
        if (locataire == null) {
            if (other.locataire != null)
                return false;
        } else if (!locataire.equals(other.locataire))
            return false;
        if (contrat == null) {
            if (other.contrat != null)
                return false;
        } else if (!contrat.equals(other.contrat))
            return false;
        return true;
    }
}
