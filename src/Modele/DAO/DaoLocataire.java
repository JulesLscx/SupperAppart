package Modele.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import Controlleur.CictOracleDataSource;
import Modele.Locataire;
import Modele.DAO.Requete.Requete;

public class DaoLocataire extends DaoModele<Locataire> {

    @Override
    public void create(Locataire tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Locataire tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Locataire tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public Collection<Locataire> findAll() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement("select * from locataire");
        return super.select(prSt);
    }

    @Override
    protected Locataire creerInstance(ResultSet curseur) throws SQLException {
        Locataire result = null;
        String nLocataire = curseur.getNString(1);
        String nom = curseur.getNString(2);
        String prenom = curseur.getNString(3);
        String email = curseur.getNString(4);
        String tel = curseur.getNString(5);
        String genre = curseur.getNString(6);
        result = new Locataire(nLocataire, nom, prenom, email, tel, genre.toCharArray()[0]);
        return result;
    }

    @Override
    public int miseAJour(Requete<Locataire> req, Locataire donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Locataire> find(Requete<Locataire> req, Locataire donnee) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Locataire findById(Requete<Locataire> req, String... id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public Collection<Locataire> findCurrentLoc() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection()
                .prepareStatement("select * from locataire_courants");
        return super.select(prSt);
    }

}
