package Modele;

import java.sql.Date;

public class Facture_Travaux_Logement {
    private String num_fac, nature, ordre_du_cheque, numero_du_cheque;
    private Date date_de_paiement;
    private float prix, montant_indeductible, reduction;
    private Entrepreneur entrepreneur;
    private Logement logement;

    public Facture_Travaux_Logement(String num_fac, String nature, float prix, float montant_indeductible,
            float reduction, String ordre_du_cheque, String numero_du_cheque, Date date_de_paiement, Logement logement,
            Entrepreneur entrepreneur) {
        if (logement == null)
            throw new IllegalArgumentException("L'immeuble doit être renseigné ");
        if (entrepreneur == null)
            throw new IllegalArgumentException("L'entrepreuneur doit être renseigné");
        if (montant_indeductible < 0 || prix < 0 || reduction < 0)
            throw new IllegalArgumentException("Toutes les valeurs numériques doivent être supérieurs ou égales à 0");
        this.num_fac = num_fac;
        this.nature = nature;
        this.ordre_du_cheque = ordre_du_cheque;
        this.numero_du_cheque = numero_du_cheque;
        this.prix = prix;
        this.montant_indeductible = montant_indeductible;
        this.reduction = reduction;
        this.entrepreneur = entrepreneur;
        this.logement = logement;
        this.date_de_paiement = date_de_paiement;
    }

    public String getNum_fac() {
        return num_fac;
    }

    public void setNum_fac(String num_fac) {
        this.num_fac = num_fac;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getOrdre_du_cheque() {
        return ordre_du_cheque;
    }

    public void setOrdre_du_cheque(String ordre_du_cheque) {
        this.ordre_du_cheque = ordre_du_cheque;
    }

    public String getNumero_du_cheque() {
        return numero_du_cheque;
    }

    public void setNumero_du_cheque(String numero_du_cheque) {
        this.numero_du_cheque = numero_du_cheque;
    }

    public Date getDate_de_paiement() {
        return date_de_paiement;
    }

    public void setDate_de_paiement(Date date_de_paiement) {
        this.date_de_paiement = date_de_paiement;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getMontant_indeductible() {
        return montant_indeductible;
    }

    public void setMontant_indeductible(float montant_indeductible) {
        this.montant_indeductible = montant_indeductible;
    }

    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

    public Entrepreneur getEntrepreneur() {
        return entrepreneur;
    }

    public void setEntrepreneur(Entrepreneur entrepreneur) {
        this.entrepreneur = entrepreneur;
    }

    public Logement getLogement() {
        return logement;
    }

    public void setImmeuble(Logement logement) {
        this.logement = logement;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((num_fac == null) ? 0 : num_fac.hashCode());
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
        Facture_Travaux_Logement other = (Facture_Travaux_Logement) obj;
        if (num_fac == null) {
            if (other.num_fac != null)
                return false;
        } else if (!num_fac.equals(other.num_fac))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Facture_Travaux_Logement [num_fac=" + num_fac + ", nature=" + nature + ", ordre_du_cheque="
                + ordre_du_cheque + ", numero_du_cheque=" + numero_du_cheque + ", date_de_paiement=" + date_de_paiement
                + ", prix=" + prix + ", montant_indeductible=" + montant_indeductible + ", reduction=" + reduction
                + ", entrepreneur=" + entrepreneur + ", immeuble=" + logement + "]";
    }
}
