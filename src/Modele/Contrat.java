package Modele;

import java.sql.Date;
import java.util.List;

public class Contrat {
    /**
     * CREATE TABLE Contrat(
     * Id_Contrat VARCHAR2(50), Prise_Effet DATE NOT NULL, Durée INT NOT NULL,
     * Charges DECIMAL(8, 2) NOT NULL, Loyer DECIMAL(8, 2) NOT NULL, Date_Revision
     * DATE, Périodicité VARCHAR2(50), Date_Paiement DATE, Paiement VARCHAR2(50),
     * Date_EDL DATE, Montant_Caution DECIMAL(8, 2), Fin_Contrat DATE,
     * Num VARCHAR2(50) NOT NULL, N_SIREN VARCHAR2(9), Id_Caution VARCHAR2(50),
     * PRIMARY KEY(Id_Contrat), FOREIGN KEY(Num) REFERENCES Logement(Num), FOREIGN
     * KEY(N_SIREN) REFERENCES Entrepreneur(N_SIREN), FOREIGN KEY(Id_Caution)
     * REFERENCES Caution(Id_Caution), CONSTRAINT CK_Contrat_Loyer CHECK (Loyer >
     * 0), CONSTRAINT CK_Contrat_Charges CHECK (Charges >= 0), CONSTRAINT
     * CK_Contrat_MontantCaution CHECK (Montant_Caution > 0), CONSTRAINT
     * CK_Contrat_Paiements CHECK (Paiement > 0)
     * );
     */
    private String id_contrat;
    private Date prise_effet;
    private int duree;
    private float charges;
    private float loyer;
    private Date date_revision;
    private String periodicite;
    private Date date_paiement;
    private float paiement;
    private Date date_edl;
    private float montant_caution;
    private Date fin_contrat;
    private Logement num;
    private Entrepreneur n_siren;
    private Caution id_caution;
    private List<Locataire> signer;

    public Contrat(String id_contrat, Date prise_effet, int duree, float charges, float loyer, Date date_revision,
            String periodicite, Date date_paiement, float paiement, Date date_edl, float montant_caution,
            Date fin_contrat, Logement num, Entrepreneur n_siren, Caution id_caution) {
        if (num == null)
            throw new IllegalArgumentException("Le logement est obligatoire pour le contrat");
        if (id_contrat == null)
            throw new IllegalArgumentException("Le champ id_contrat est obligatoire");
        if (prise_effet == null)
            throw new IllegalArgumentException("Le champ prise_effet est obligatoire");
        if (duree <= 0)
            throw new IllegalArgumentException("La duree doit etre strictement supérieur à 0");
        if (charges < 0)
            throw new IllegalArgumentException(
                    "Le montant des charges mensuels doit obligatoirement etre renseigné et supérieur à 0");
        if (loyer < 0)
            throw new IllegalArgumentException(
                    "Le montant du loyer mensuel doit obligatoirement etre renseigné et supérieur à 0");

        this.id_contrat = id_contrat;
        this.prise_effet = prise_effet;
        this.duree = duree;
        this.charges = charges;
        this.loyer = loyer;
        this.date_revision = date_revision;
        this.periodicite = periodicite;
        this.date_paiement = date_paiement;
        this.paiement = paiement;
        this.date_edl = date_edl;
        this.montant_caution = montant_caution;
        this.fin_contrat = fin_contrat;
        this.num = num;
        this.n_siren = n_siren;
        this.id_caution = id_caution;
    }

    public List<Locataire> getSigner() {
        return signer;
    }

    public void setSigner(List<Locataire> signer) {
        this.signer = signer;
    }

    public String getId_contrat() {
        return id_contrat;
    }

    public void setId_contrat(String id_contrat) {
        this.id_contrat = id_contrat;
    }

    public Date getPrise_effet() {
        return prise_effet;
    }

    public void setPrise_effet(Date prise_effet) {
        this.prise_effet = prise_effet;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public float getCharges() {
        return charges;
    }

    public void setCharges(float charges) {
        this.charges = charges;
    }

    public float getLoyer() {
        return loyer;
    }

    public void setLoyer(float loyer) {
        this.loyer = loyer;
    }

    public Date getDate_revision() {
        return date_revision;
    }

    public void setDate_revision(Date date_revision) {
        this.date_revision = date_revision;
    }

    public String getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(String periodicite) {
        this.periodicite = periodicite;
    }

    public Date getDate_paiement() {
        return date_paiement;
    }

    public void setDate_paiement(Date date_paiement) {
        this.date_paiement = date_paiement;
    }

    public float getPaiement() {
        return paiement;
    }

    public void setPaiement(float paiement) {
        this.paiement = paiement;
    }

    public Date getDate_edl() {
        return date_edl;
    }

    public void setDate_edl(Date date_edl) {
        this.date_edl = date_edl;
    }

    public float getMontant_caution() {
        return montant_caution;
    }

    public void setMontant_caution(float montant_caution) {
        this.montant_caution = montant_caution;
    }

    public Date getFin_contrat() {
        return fin_contrat;
    }

    public void setFin_contrat(Date fin_contrat) {
        this.fin_contrat = fin_contrat;
    }

    public Logement getNum() {
        return num;
    }

    public void setNum(Logement num) {
        this.num = num;
    }

    public Entrepreneur getN_siren() {
        return n_siren;
    }

    public void setN_siren(Entrepreneur n_siren) {
        this.n_siren = n_siren;
    }

    public Caution getId_caution() {
        return id_caution;
    }

    public void setId_caution(Caution id_caution) {
        this.id_caution = id_caution;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_contrat == null) ? 0 : id_contrat.hashCode());
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
        Contrat other = (Contrat) obj;
        if (id_contrat == null) {
            if (other.id_contrat != null)
                return false;
        } else if (!id_contrat.equals(other.id_contrat))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Contrat [id_contrat=" + id_contrat + ", prise_effet=" + prise_effet + ", duree=" + duree + ", charges="
                + charges + ", loyer=" + loyer + ", paiement=" + paiement + ", montant_caution=" + montant_caution
                + ", fin_contrat=" + fin_contrat + ", num=" + num + ", id_caution=" + id_caution + ", signer=" + signer
                + "]";
    }
}
