package Modele;

public class Logement {
    // CREATE TABLE
    // Logement(
    // Num VARCHAR2(50),
    // Type_Hab VARCHAR2(50) NOT NULL, Surface DECIMAL(5, 2) NOT NULL, NbPiece
    // SMALLINT,
    // id_immeuble VARCHAR2(50) NOT NULL, PRIMARY KEY(Num),
    // FOREIGN KEY(id_immeuble)
    // REFERENCES Immeuble(id_immeuble), CONSTRAINT CK_Logement_Surface CHECK
    // (Surface >= 0)
    // );
    private String num;
    private String type_hab;
    private float surface;
    private int nbpiece;
    private Immeuble immeuble;

    public Logement(String num, String type_hab, float surface, int nbpiece, Immeuble immeuble) {
        if (surface < 0)
            throw new IllegalArgumentException("La surface doit être supérieure à 0");
        this.num = num;
        this.type_hab = type_hab;
        this.surface = surface;
        this.nbpiece = nbpiece;
        this.immeuble = immeuble;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType_hab() {
        return type_hab;
    }

    public void setType_hab(String type_hab) {
        this.type_hab = type_hab;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public int getNbpiece() {
        return nbpiece;
    }

    public void setNbpiece(int nbpiece) {
        this.nbpiece = nbpiece;
    }

    public Immeuble getImmeuble() {
        return immeuble;
    }

    public void setImmeuble(Immeuble immeuble) {
        this.immeuble = immeuble;
    }

    @Override
    public String toString() {
        return "Logement [num=" + num + ", type_hab=" + type_hab + ", surface=" + surface + ", nbpiece=" + nbpiece
                + ", immeuble=" + immeuble + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((num == null) ? 0 : num.hashCode());
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
        Logement other = (Logement) obj;
        if (num == null) {
            if (other.num != null)
                return false;
        } else if (!num.equals(other.num))
            return false;
        return true;
    }

}
