package Modele;

import java.sql.Date;

public class Paiements {
    // CREATE TABLE PAIEMENTS(
    // ID_PAIEMENTS VARCHAR2(50),
    // MONTANT DECIMAL(15, 2) NOT NULL,
    // DATEP DATE,
    // MOYEN_PAIEMENT VARCHAR2(50),
    // ID_CONTRAT VARCHAR2(50) NOT NULL,
    // PRIMARY KEY(ID_PAIEMENTS),
    // FOREIGN KEY(ID_CONTRAT) REFERENCES CONTRAT(ID_CONTRAT),
    // CONSTRAINT CK_PAIEMENTS_MONTANT CHECK (MONTANT > 0)
    // );
    private String id_paiements;
    private float montant;
    private Date date;
    private String moyen_paiement;
    private Contrat contrat;

    public Paiements(String id_paiements, float montant, Date date, String moyen_paiement, Contrat contrat) {
        if (montant < 0)
            throw new IllegalArgumentException("Le montant d'un paiement ne peut être négatif");
        if (contrat == null)
            throw new IllegalArgumentException("Le contrat doit être renseigner, l'argent ne viens pas du ciel");
        this.id_paiements = id_paiements;
        this.montant = montant;
        this.date = date;
        this.moyen_paiement = moyen_paiement;
        this.contrat = contrat;
    }

    public String getId_paiements() {
        return id_paiements;
    }

    public void setId_paiements(String id_paiements) {
        this.id_paiements = id_paiements;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMoyen_paiement() {
        return moyen_paiement;
    }

    public void setMoyen_paiement(String moyen_paiement) {
        this.moyen_paiement = moyen_paiement;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    @Override
    public String toString() {
        return "Paiements [id_paiements=" + id_paiements + ", montant=" + montant + ", date=" + date
                + ", moyen_paiement=" + moyen_paiement + ", contrat=" + contrat + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_paiements == null) ? 0 : id_paiements.hashCode());
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
        Paiements other = (Paiements) obj;
        if (id_paiements == null) {
            if (other.id_paiements != null)
                return false;
        } else if (!id_paiements.equals(other.id_paiements))
            return false;
        return true;
    }

}
