package Modele;

import java.sql.Date;

public class Coef {
    private Contrat contrat;
    private Type_Fac type;
    private Date date;
    private float montant;

    public Coef(Contrat contrat, Type_Fac type, Date date, float montant) {
        if (contrat == null)
            throw new IllegalArgumentException("Le contrat est null");
        if (type == null)
            throw new IllegalArgumentException("Le type est null");
        if (date == null)
            throw new IllegalArgumentException("La date est null");
        this.contrat = contrat;
        this.type = type;
        this.date = date;
        this.montant = montant;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public Type_Fac getType() {
        return type;
    }

    public void setType(Type_Fac type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contrat == null) ? 0 : contrat.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
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
        Coef other = (Coef) obj;
        if (contrat == null) {
            if (other.contrat != null)
                return false;
        } else if (!contrat.equals(other.contrat))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Coef [contrat=" + contrat + ", type=" + type + ", date=" + date + ", montant=" + montant + "]";
    }
}
