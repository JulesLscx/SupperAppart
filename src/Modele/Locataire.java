package Modele;

public class Locataire {
    // CREATE TABLE

    // Locataire(

    // nLocataire VARCHAR2(50),

    // nom VARCHAR2(50) NOT NULL, prenom VARCHAR2(50) NOT NULL, email VARCHAR2(50)
    // NOT NULL, tel CHAR(10) NOT NULL, Genre CHAR(1),

    private String nLocataire, nom, prenom, email, tel;
    private char genre;

    public Locataire(String nLocataire, String nom, String prenom, String email, String tel, char genre) {
        if (nLocataire == null || nom == null || prenom == null || tel == null) {
            throw new IllegalArgumentException("Les champs nLocataire, nom, prenom et tel sont obligatoires");
        }
        this.nLocataire = nLocataire;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.genre = genre;
    }

    public String getnLocataire() {
        return nLocataire;
    }

    public void setnLocataire(String nLocataire) {
        this.nLocataire = nLocataire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nLocataire == null) ? 0 : nLocataire.hashCode());
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
        Locataire other = (Locataire) obj;
        if (nLocataire == null) {
            if (other.nLocataire != null)
                return false;
        } else if (!nLocataire.equals(other.nLocataire))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Locataire [nLocataire=" + nLocataire + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
                + ", tel=" + tel + ", genre=" + genre + "]";
    }

}
