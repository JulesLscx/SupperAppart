package Modele;

public class Type_Fac {
    private String typeF, periodicite, unite;

    public Type_Fac(String typeF, String periodicite, String unite) {
        this.typeF = typeF;
        this.periodicite = periodicite;
        this.unite = unite;
    }

    public String getTypeF() {
        return typeF;
    }

    public void setTypeF(String typeF) {
        this.typeF = typeF;
    }

    public String getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(String periodicite) {
        this.periodicite = periodicite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    @Override
    public String toString() {
        return "Type_Fac [typeF=" + typeF + ", periodicite=" + periodicite + ", unite=" + unite + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((typeF == null) ? 0 : typeF.hashCode());
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
        Type_Fac other = (Type_Fac) obj;
        if (typeF == null) {
            if (other.typeF != null)
                return false;
        } else if (!typeF.equals(other.typeF))
            return false;
        return true;
    }

}
