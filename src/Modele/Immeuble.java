package Modele;

public class Immeuble {
    private String id_immeuble, adresse, pde_constr, num_bat, cp, ville, access_com;
    private int copro;

    public Immeuble(String id_immeuble, String adresse, String pde_constr, String num_bat, String cp, String ville,
            String access_com, int copro) {
        if (id_immeuble == null || adresse == null || cp == null || ville == null)
            throw new IllegalArgumentException("Les champs id_immeuble, adresse, cp, ville sont obligatoires ");
        if (cp.length() != 5)
            throw new IllegalArgumentException(
                    "Le champ cp n'est pas valide regardez si il n'y a bien que des entiers et qu'il fait 5 caracteres ");
        this.id_immeuble = id_immeuble;
        this.adresse = adresse;
        this.pde_constr = pde_constr;
        this.num_bat = num_bat;
        this.cp = cp;
        this.ville = ville;
        this.access_com = access_com;
        this.copro = copro;
    }

    public String getId_immeuble() {
        return id_immeuble;
    }

    public void setId_immeuble(String id_immeuble) {
        this.id_immeuble = id_immeuble;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPde_constr() {
        return pde_constr;
    }

    public void setPde_constr(String pde_constr) {
        this.pde_constr = pde_constr;
    }

    public String getNum_bat() {
        return num_bat;
    }

    public void setNum_bat(String num_bat) {
        this.num_bat = num_bat;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAccess_com() {
        return access_com;
    }

    public void setAccess_com(String access_com) {
        this.access_com = access_com;
    }

    public int getCopro() {
        return copro;
    }

    public void setCopro(int copro) {
        this.copro = copro;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_immeuble == null) ? 0 : id_immeuble.hashCode());
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
        Immeuble other = (Immeuble) obj;
        if (id_immeuble == null) {
            if (other.id_immeuble != null)
                return false;
        } else if (!id_immeuble.equals(other.id_immeuble))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Immeuble [id_immeuble=" + id_immeuble + ", adresse=" + adresse + ", pde_constr=" + pde_constr
                + ", num_bat=" + num_bat + ", cp=" + cp + ", ville=" + ville + ", access_com=" + access_com + ", copro="
                + copro + "]";
    }

}
