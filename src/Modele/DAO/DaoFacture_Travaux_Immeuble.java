package Modele.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import Modele.Facture_Travaux_Immeuble;
import Modele.DAO.Requete.Requete;

public class DaoFacture_Travaux_Immeuble extends DaoModele<Facture_Travaux_Immeuble> {

    @Override
    public void create(Facture_Travaux_Immeuble tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Facture_Travaux_Immeuble tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Facture_Travaux_Immeuble tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public Collection<Facture_Travaux_Immeuble> findAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Facture_Travaux_Immeuble creerInstance(ResultSet curseur) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int miseAJour(Requete<Facture_Travaux_Immeuble> req, Facture_Travaux_Immeuble donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Facture_Travaux_Immeuble> find(Requete<Facture_Travaux_Immeuble> req, Facture_Travaux_Immeuble donnee)
            throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Facture_Travaux_Immeuble findById(Requete<Facture_Travaux_Immeuble> req, String... id) throws SQLException {
        PreparedStatement ps = req.requete();
        req.setParametres(ps, id);
        ResultSet rs = ps.getResultSet();
        return creerInstance(rs);
    }

}
