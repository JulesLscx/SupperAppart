package Modele.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import Modele.Facture_Travaux_Logement;
import Modele.DAO.Requete.Requete;

public class DaoFacture_Travaux_Logement extends DaoModele<Facture_Travaux_Logement> {

    @Override
    public void create(Facture_Travaux_Logement tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Facture_Travaux_Logement tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Facture_Travaux_Logement tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public Collection<Facture_Travaux_Logement> findAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Facture_Travaux_Logement creerInstance(ResultSet curseur) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int miseAJour(Requete<Facture_Travaux_Logement> req, Facture_Travaux_Logement donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Facture_Travaux_Logement> find(Requete<Facture_Travaux_Logement> req, Facture_Travaux_Logement donnee)
            throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Facture_Travaux_Logement findById(Requete<Facture_Travaux_Logement> req, String... id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
