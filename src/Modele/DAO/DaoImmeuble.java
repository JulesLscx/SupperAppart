package Modele.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import Controlleur.CictOracleDataSource;
import Modele.Immeuble;
import Modele.DAO.Requete.Requete;

public class DaoImmeuble extends DaoModele<Immeuble> {

    public DaoImmeuble() {
    }

    @Override
    public void create(Immeuble tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Immeuble tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Immeuble tupple) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public Collection<Immeuble> findAll() throws SQLException {
        PreparedStatement prSt = CictOracleDataSource.getLaConnection().prepareStatement("select * from immeuble");
        return super.select(prSt);
    }

    @Override
    protected Immeuble creerInstance(ResultSet curseur) throws SQLException {
        Immeuble result = null;
        String id_immeuble, adresse, pde_constr, num_bat, cp, ville, access_com;
        int copro;
        id_immeuble = curseur.getNString(1);
        adresse = curseur.getNString(2);
        pde_constr = curseur.getNString(3);
        num_bat = curseur.getNString(4);
        cp = curseur.getNString(5);
        ville = curseur.getNString(6);
        access_com = curseur.getNString(8);
        copro = curseur.getInt(7);
        result = new Immeuble(id_immeuble, adresse, pde_constr, num_bat, cp, ville, access_com, copro);
        return result;
    }

    @Override
    public int miseAJour(Requete<Immeuble> req, Immeuble donnee) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Immeuble> find(Requete<Immeuble> req, Immeuble donnee) throws SQLException {
        PreparedStatement prSt = req.requete();
        req.setParametres(prSt, donnee);
        return super.select(prSt);
    }

    @Override
    public Immeuble findById(Requete<Immeuble> req, String... id) throws SQLException {
        PreparedStatement prSt = req.requete();
        req.setParametres(prSt, id);
        prSt.execute();
        ResultSet rs = prSt.getResultSet();
        rs.next();
        return creerInstance(rs);
    }

}
