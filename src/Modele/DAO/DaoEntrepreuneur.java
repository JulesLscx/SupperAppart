package Modele.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import Controlleur.CictOracleDataSource;
import Modele.Entrepreneur;
import Modele.DAO.Requete.Requete;

public class DaoEntrepreuneur extends DaoModele<Entrepreneur> {

    @Override
    public void create(Entrepreneur tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Entrepreneur tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Entrepreneur tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public Collection<Entrepreneur> findAll() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement("select * from entrepreuneur");
        return super.select(prSt);
    }

    @Override
    protected Entrepreneur creerInstance(ResultSet curseur) throws SQLException {
        Entrepreneur result = null;
        String nSiren, adresse, nom, iban, secteur_activite;
        nSiren = curseur.getNString(1);
        adresse = curseur.getNString(2);
        nom = curseur.getNString(3);
        iban = curseur.getNString(4);
        secteur_activite = curseur.getNString(5);
        result = new Entrepreneur(nSiren, adresse, nom, iban, secteur_activite);
        return result;
    }

    @Override
    public int miseAJour(Requete<Entrepreneur> req, Entrepreneur donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Entrepreneur> find(Requete<Entrepreneur> req, Entrepreneur donnee) throws SQLException {
        PreparedStatement tmp = req.requete();
        req.setParametres(tmp, donnee);
        return super.select(tmp);
    }

    @Override
    public Entrepreneur findById(Requete<Entrepreneur> req, String... id) throws SQLException {
        PreparedStatement ps = req.requete();
        req.setParametres(ps, id);
        ResultSet rs = ps.getResultSet();
        return creerInstance(rs);
    }
}
