package Modele.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import Modele.Contrat;
import Modele.DAO.Requete.Requete;

public class DaoContrat extends DaoModele<Contrat> {

    @Override
    public void create(Contrat tupple) throws SQLException {
        // TODO Auto-generated method stub
    }

    @Override
    public void update(Contrat tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Contrat tupple) throws SQLException {
        // TODO Auto-generated method stub
    }

    @Override
    public Collection<Contrat> findAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Contrat creerInstance(ResultSet curseur) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int miseAJour(Requete<Contrat> req, Contrat donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Contrat> find(Requete<Contrat> req, Contrat donnee) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Contrat findById(Requete<Contrat> req, String... id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
