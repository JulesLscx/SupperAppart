package Modele.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import Modele.Logement;
import Modele.DAO.Requete.Requete;

public class DaoLogement extends DaoModele<Logement> {

    @Override
    public void create(Logement tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Logement tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Logement tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public Collection<Logement> findAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Logement creerInstance(ResultSet curseur) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int miseAJour(Requete<Logement> req, Logement donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Logement> find(Requete<Logement> req, Logement donnee) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Logement findById(Requete<Logement> req, String... id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
