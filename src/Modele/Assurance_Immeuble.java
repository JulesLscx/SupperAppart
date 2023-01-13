package Modele;

public class Assurance_Immeuble {
    private String id_immeuble, certificat_bien, certificat_juridique, nSiren;
    private int annee;
    private float assurance_bien, assurance_juridique;

    public Assurance_Immeuble(String id_immeuble, String certificat_bien, String certificat_juridique, String nSiren,
            int annee, float assurance_bien, float assurance_juridique) {
        if (id_immeuble == null || nSiren == null || (1000 < annee && annee < 9999))
            throw new IllegalArgumentException("id_immeuble, nsiren et annee sont obligatoires");
        this.id_immeuble = id_immeuble;
        this.certificat_bien = certificat_bien;
        this.certificat_juridique = certificat_juridique;
        this.nSiren = nSiren;
        this.annee = annee;
        this.assurance_bien = assurance_bien;
        this.assurance_juridique = assurance_juridique;
    }

    public String getId_immeuble() {
        return id_immeuble;
    }

    public void setId_immeuble(String id_immeuble) {
        this.id_immeuble = id_immeuble;
    }

    public String getCertificat_bien() {
        return certificat_bien;
    }

    public void setCertificat_bien(String certificat_bien) {
        this.certificat_bien = certificat_bien;
    }

    public String getCertificat_juridique() {
        return certificat_juridique;
    }

    public void setCertificat_juridique(String certificat_juridique) {
        this.certificat_juridique = certificat_juridique;
    }

    public String getnSiren() {
        return nSiren;
    }

    public void setnSiren(String nSiren) {
        this.nSiren = nSiren;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public float getAssurance_bien() {
        return assurance_bien;
    }

    public void setAssurance_bien(float assurance_bien) {
        this.assurance_bien = assurance_bien;
    }

    public float getAssurance_juridique() {
        return assurance_juridique;
    }

    public void setAssurance_juridique(float assurance_juridique) {
        this.assurance_juridique = assurance_juridique;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_immeuble == null) ? 0 : id_immeuble.hashCode());
        result = prime * result + annee;
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
        Assurance_Immeuble other = (Assurance_Immeuble) obj;
        if (id_immeuble == null) {
            if (other.id_immeuble != null)
                return false;
        } else if (!id_immeuble.equals(other.id_immeuble))
            return false;
        if (annee != other.annee)
            return false;
        return true;
    }
}
