package Modele.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import Modele.Regularisation;
import Modele.DAO.Requete.Requete;

public class DaoRegularisation extends DaoModele<Regularisation> {

    @Override
    public void create(Regularisation tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Regularisation tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Regularisation tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public Collection<Regularisation> findAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Regularisation creerInstance(ResultSet curseur) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int miseAJour(Requete<Regularisation> req, Regularisation donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Regularisation> find(Requete<Regularisation> req, Regularisation donnee) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Regularisation findById(Requete<Regularisation> req, String... id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
