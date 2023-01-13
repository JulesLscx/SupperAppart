package Modele;

import java.sql.Date;

public class Factures_Charges {
    // CREATE TABLE FACTURES(
    // NUMF VARCHAR2(50),
    // DATEF DATE NOT NULL,
    // TOTAL DECIMAL(10, 2) NOT NULL,
    // CF NUMBER(10, 2) DEFAULT 0,
    // PRIX_UNITE_RELEVE NUMBER(10, 4),
    // PRIX_UNITE_CONSTATEE NUMBER(10, 4),
    // FACTURE BFILE,
    // TYPEF VARCHAR2(50) NOT NULL,
    // ID_IMMEUBLE VARCHAR2(50) NOT NULL,
    // PRIMARY KEY(NUMF),
    // FOREIGN KEY(TYPEF) REFERENCES TYPE_FAC(TYPEF),
    // FOREIGN KEY(ID_IMMEUBLE) REFERENCES IMMEUBLE(ID_IMMEUBLE),
    // CONSTRAINT CK_FACTURES_TOTAL CHECK (TOTAL > 0),
    // CONSTRAINT CK_FACTURES_CF CHECK (CF > 0),
    // CONSTRAINT CK_FACTURES_PRIX_UNITE_RELEVE CHECK (PRIX_UNITE_RELEVE > 0),
    // CONSTRAINT CK_FACTURES_PX_UNT_CONSTATEE CHECK (PRIX_UNITE_CONSTATEE > 0)
    // );
    private String numF;
    private Date dateF;
    private float total;
    private float cf;
    private float prix_unite_releve;
    private float prix_unite_constatee;
    private Type_Fac typeF;
    private Immeuble immeuble;

    public Factures_Charges(String numF, Date dateF, float total, float cf, float prix_unite_releve,
            float prix_unite_constatee, Type_Fac typeF, Immeuble immeuble) {
        if (numF == null)
            throw new IllegalArgumentException("Le numéro de facture doit être renseigne, c'est un champ obligatoire");
        if (dateF == null)
            throw new IllegalArgumentException("La date est un champ obligatoire");
        if (total < 0)
            throw new IllegalArgumentException("Le total doit être renseigner et doit être strictement supérieur à 0");
        if (typeF == null)
            throw new IllegalArgumentException("Le type de facture est obligatoire");
        if (immeuble == null)
            throw new IllegalArgumentException("L'immeuble doit être renseigner");
        this.numF = numF;
        this.dateF = dateF;
        this.total = total;
        this.cf = cf;
        this.prix_unite_releve = prix_unite_releve;
        this.prix_unite_constatee = prix_unite_constatee;
        this.typeF = typeF;
        this.immeuble = immeuble;
    }

    public String getNumF() {
        return numF;
    }

    public void setNumF(String numF) {
        this.numF = numF;
    }

    public Date getDateF() {
        return dateF;
    }

    public void setDateF(Date dateF) {
        this.dateF = dateF;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getCf() {
        return cf;
    }

    public void setCf(float cf) {
        this.cf = cf;
    }

    public float getPrix_unite_releve() {
        return prix_unite_releve;
    }

    public void setPrix_unite_releve(float prix_unite_releve) {
        this.prix_unite_releve = prix_unite_releve;
    }

    public float getPrix_unite_constatee() {
        return prix_unite_constatee;
    }

    public void setPrix_unite_constatee(float prix_unite_constatee) {
        this.prix_unite_constatee = prix_unite_constatee;
    }

    public Type_Fac getTypeF() {
        return typeF;
    }

    public void setTypeF(Type_Fac typeF) {
        this.typeF = typeF;
    }

    public Immeuble getImmeuble() {
        return immeuble;
    }

    public void setImmeuble(Immeuble immeuble) {
        this.immeuble = immeuble;
    }

}
