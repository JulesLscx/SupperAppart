package Modele;

import java.sql.Date;

public class Regularisation {
    // CREATE TABLE REGULARISATION(
    // ID_CONTRAT VARCHAR2(50),
    // TYPEF VARCHAR2(50) NOT NULL,
    // DATER DATE,
    // MONTANT REAL,
    // PRIMARY KEY(ID_CONTRAT, DATER, TYPEF),
    // FOREIGN KEY(ID_CONTRAT) REFERENCES CONTRAT(ID_CONTRAT),
    // FOREIGN KEY(TYPEF) REFERENCES TYPE_FAC(TYPEF),
    // );
    private Contrat contrat;
    private Type_Fac typeF;
    private Date dateR;
    private float montant;

    public Regularisation(Contrat contrat, Type_Fac typeF, Date dateR, float montant) {
        if (contrat == null)
            throw new IllegalArgumentException("Le contrat est obligatoire");
        if (typeF == null)
            throw new IllegalArgumentException("Le type de facture est obligatoire");
        if (dateR == null)
            throw new IllegalArgumentException("La date est obligatoire, c'est pour éviter les doublons");
        this.contrat = contrat;
        this.typeF = typeF;
        this.dateR = dateR;
        this.montant = montant;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contrat == null) ? 0 : contrat.hashCode());
        result = prime * result + ((typeF == null) ? 0 : typeF.hashCode());
        result = prime * result + ((dateR == null) ? 0 : dateR.hashCode());
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
        Regularisation other = (Regularisation) obj;
        if (contrat == null) {
            if (other.contrat != null)
                return false;
        } else if (!contrat.equals(other.contrat))
            return false;
        if (typeF == null) {
            if (other.typeF != null)
                return false;
        } else if (!typeF.equals(other.typeF))
            return false;
        if (dateR == null) {
            if (other.dateR != null)
                return false;
        } else if (!dateR.equals(other.dateR))
            return false;
        return true;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public Type_Fac getTypeF() {
        return typeF;
    }

    public void setTypeF(Type_Fac typeF) {
        this.typeF = typeF;
    }

    public Date getDateR() {
        return dateR;
    }

    public void setDateR(Date dateR) {
        this.dateR = dateR;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Regularisation [contrat=" + contrat + ", typeF=" + typeF + ", dateR=" + dateR + ", montant=" + montant
                + "]";
    }
}
