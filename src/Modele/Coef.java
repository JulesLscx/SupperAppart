package Modele;

public class Coef {
    private Logement num;
    private Type_Fac tf;
    private Float coefficient;

    public Coef(Logement num, Type_Fac tf, Float coefficient) {
        if (num == null)
            throw new IllegalArgumentException("Le logement est nul");
        if (tf == null)
            throw new IllegalArgumentException("Le type de la facture est null");
        if (coefficient < 0)
            throw new IllegalArgumentException("Le coefficient est un pourcentage il doit être supérieur à 0");
        this.num = num;
        this.tf = tf;
        this.coefficient = coefficient;
    }

    public Logement getNum() {
        return num;
    }

    public void setNum(Logement num) {
        this.num = num;
    }

    public Type_Fac getTf() {
        return tf;
    }

    public void setTf(Type_Fac tf) {
        this.tf = tf;
    }

    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }
}
